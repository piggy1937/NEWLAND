package com.tech.newland;

/**
 * @author zhushubin
 * @date 2021-09-22.
 * GitHub：
 * email： 604580436@qq.com
 * description：
 */

public  class MessageEvent {
    /***
     * Extra扫描结果1参数
     */
    private String barcode1;
    /***
     * Extra扫描结果2参数
     */
    private String barcode2;
    /***
     * 码制类型
     */
    private Integer barcodeType;
    /***
     * 扫码状态参数 fail ok
     */
    private String scanStatus;

    public String getBarcode1() {
        return barcode1;
    }

    public void setBarcode1(String barcode1) {
        this.barcode1 = barcode1;
    }

    public String getBarcode2() {
        return barcode2;
    }

    public void setBarcode2(String barcode2) {
        this.barcode2 = barcode2;
    }

    public Integer getBarcodeType() {
        return barcodeType;
    }

    public void setBarcodeType(Integer barcodeType) {
        this.barcodeType = barcodeType;
    }

    public String getScanStatus() {
        return scanStatus;
    }

    public void setScanStatus(String scanStatus) {
        this.scanStatus = scanStatus;
    }
     public MessageEvent(){}
    public MessageEvent(String barcode1, String barcode2, Integer barcodeType, String scanStatus) {
        this.barcode1 = barcode1;
        this.barcode2 = barcode2;
        this.barcodeType = barcodeType;
        this.scanStatus = scanStatus;
    }
}
