package com.tech.newland;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private ScanBroadcastReceiver receiver;
    private EditText edRequestId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        EventBus.getDefault().register(this);
        edRequestId=findViewById(R.id.ed_request_id);

    }

    @Override
    protected void onResume() {
        super.onResume();
        receiver = new ScanBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("nlscan.action.SCANNER_RESULT");
        registerReceiver(receiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(MessageEvent event) {
        onScaned(event);
    }
    private void onScaned(MessageEvent event){
        Log.d(TAG, "onReceive: 扫码");
        String message =event.getBarcode1()+ ":"+event.getBarcode2();
        //String message= String.format("%s %s %d %s",event.getBarcode1(),event.getBarcode2(),event.getBarcodeType(),event.getScanStatus());
        edRequestId.setText(message);
    }

    private void init(){
        Intent intent = new Intent ("ACTION_BAR_SCANCFG");
        intent.putExtra("EXTRA_SCAN_MODE", 3);
        intent.putExtra("EXTRA_SCAN_AUTOENT", 1);
        getBaseContext().sendBroadcast(intent);

    }
}