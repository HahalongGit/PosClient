// PosPrinterCallback.aidl
package com.lll.posserviceaidl;

// Declare any non-default types here with import statements

interface PosPrinterCallback {

    /**
     * 打印成功
     *
     */
   void onPrintSuccess(int code,String message);

   /**
    * 打印失败
    *
    */
   void onPrintFailed(String message);

}
