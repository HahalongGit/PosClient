// IPosQuickScanManager.aidl
package com.lll.posserviceaidl;
import com.lll.posserviceaidl.bean.DecodeResult;

// Declare any non-default types here with import statements

interface IPosQuickScanManager {
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


}
