// PsoPrinterManager.aidl  aidl 文件的包名和服务端的包名相同，不一定需要和客户端主包名 相同
package com.lll.posserviceaidl;
import com.lll.posserviceaidl.bean.PosInfo;
import com.lll.posserviceaidl.bean.PrinterParams;
import com.lll.posserviceaidl.PosPrinterCallback;
import com.lll.posserviceaidl.OnPrintResultListener;
// Declare any non-default types here with import statements

interface PsoPrinterManager {

    // 查询pos信息
    String queryPosInfo(String psoId);


    // 走纸
    void spitPaper(int distance);


    // 设置posInfo 传递参数自定义的实体
    void setPostInfo(in PosInfo posInfo);

    // 打印数据
    int printData(in List<PrinterParams> list,OnPrintResultListener listener);

    /**
     * 打印其他
     *
     */
    void printOther(in List<PrinterParams> list,PosPrinterCallback bc);

    /**
     *设置系统
     **/
    void setSystemFunction(in Bundle bundle);

}
