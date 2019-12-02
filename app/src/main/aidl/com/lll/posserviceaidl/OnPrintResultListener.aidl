// OnPrintResultListener.aidl
package com.lll.posserviceaidl;

// Declare any non-default types here with import statements

interface OnPrintResultListener {
    /**
     * @param result 预留 打印结果
     *
     */
    void onSuccess(String result);
    /**
     * @param errorCode 错误码
     * @param message 错误信息
     *
     */
    void onError(int errorCode,String message);
}
