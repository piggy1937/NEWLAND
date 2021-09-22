package com.tech.newland;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;

/**
 * @author zhushubin
 * @email 604580436@qq.com
 * @date 2021/8/28 0028 上午 11:49
 * 条形码二维码扫描 广播事件
 */
public class ScanBroadcastReceiver extends BroadcastReceiver {

    private static final String TAG = "ScanBroadcastReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        //**判断当前的扫码状态是否可用*/
        Log.d(TAG, "onReceive: 扫码");
        final String barcode1=intent.getStringExtra("SCAN_BARCODE1");
        final String barcode2=intent.getStringExtra("SCAN_BARCODE2");
        final int barcodeType = intent.getIntExtra("SCAN_BARCODE_TYPE", -1); // -1:unknown
        final String scanStatus=intent.getStringExtra("SCAN_STATE");
        MessageEvent messageEvent = new  MessageEvent(barcode1,
                barcode2,
                barcodeType,
                scanStatus);
        EventBus.getDefault().post(messageEvent);
    }


}