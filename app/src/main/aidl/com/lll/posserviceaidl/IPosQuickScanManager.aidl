// IPosQuickScanManager.aidl
package com.lll.posserviceaidl;
import com.lll.posserviceaidl.bean.DecodeResult;
import com.lll.posserviceaidl.bean.CameraBeanZbar;
import com.lll.posserviceaidl.AidlScanCallback;
import android.os.Bundle;
// Declare any non-default types here with import statements

interface IPosQuickScanManager {

   /** 快速扫码初始化
    * @deprecated
    */
   int init(String packageName);

    /**
     *
     * 取消扫描
     */
   void cancelQRscan();
    /**
     *@param cameraType 摄像头类型：1前置 ，2后置
     * @param mode 扫描模式 1扫码效果，2正常效果
     * 取消扫描
     */
   void switchCameraDisplayEffect(int cameraType,int mode);

    /**
     *@param width 图像宽
     *@param height 图像高
     *@param data 调用摄像头预览时返回的数据
     * 取消扫描
     */
    DecodeResult decodeBarCode(int width,int height,in byte[] data);

     /**
      *@param cameraBeanZbar
      *@param cb 扫码回调
      * 开始扫码
      */
    void scanQrCode(in CameraBeanZbar cameraBeanZbar,AidlScanCallback cb);
    /**
    * @param bundle 参数
    * @param cb 回调
    * */
//    void scanQrCode(in Bundle bundle,AidlScanCallback cb);

   /**
    * 是否需要自定义界面
    * */
    void setNeedCaptureView(boolean needCaptureView);

    /**
    * 设置界面布局CaptureView
    * */
    void setCaptureView(in byte[]view); //不能传递View

}
