// AidlScanCallback.aidl
package com.lll.posserviceaidl;

// 扫码结果回调

interface AidlScanCallback {

   /**
    * 扫码成功
    * 扫码成功
    * @param result 扫码结果
    * @param paramInt 预留
    **/
    void onCaptured(String result, int paramInt);

    /**
    * 扫码失败
    * @param errorCode 错误码
    **/
    void onFailed(int errorCode);

}
