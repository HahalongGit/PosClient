package com.lll.posclientaidl.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.lll.posserviceaidl.PosPrinterCallback;
import com.lll.posserviceaidl.PsoPrinterManager;
import com.lll.posserviceaidl.bean.PosInfo;
import com.lll.posserviceaidl.bean.PrinterParams;

import java.util.List;

/**
 * pos Printer Servide
 *
 * @author runningDigua
 * @date 2019/11/27
 */
public class PosPrinterService extends Service {

    private static final String TAG = "PosPrinterService";

    /**
     *
     */
    private String posInfo = "我是pos机器，我的型号是XZ20191120";

    private PosPrinterBinder mPosPrinterBinder = new PosPrinterBinder();

    @Override
    public IBinder onBind(Intent intent) {
        return mPosPrinterBinder;
    }



    /**
     * pos 打印实现
     */
    private class PosPrinterBinder extends PsoPrinterManager.Stub {

        @Override
        public String queryPosInfo(String psoId) throws RemoteException {
            return posInfo;
        }

        @Override
        public void spitPaper(int distance) throws RemoteException {
            Log.e(TAG, "走纸的距离是-distance：" + distance);
        }

        @Override
        public void setPostInfo(PosInfo posInfo) throws RemoteException {

        }

        @Override
        public int printData(List<PrinterParams> list) throws RemoteException {
            return 0;
        }

        @Override
        public void printOther(List<PrinterParams> list, PosPrinterCallback bc) throws RemoteException {

        }
    }

}
