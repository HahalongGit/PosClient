package com.lll.posclientaidl;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.lll.posserviceaidl.AidlDeviceManager;
import com.lll.posserviceaidl.IPosQuickScanManager;
import com.lll.posserviceaidl.PsoPrinterManager;
import com.lll.posserviceaidl.constant.Constant;

public abstract class BaseActivity extends AppCompatActivity {

    private static final String TAG = "BaseActivity";

    private PsoPrinterConnection mPsoPrinterConnection = new PsoPrinterConnection();

    /**
     * 不同的设备功能管理器（返回不同的Manager）
     */
    private AidlDeviceManager mAidlDeviceManager;

    /**
     * baseActivity 中设置 死亡代理
     */
    private IBinder.DeathRecipient mDeathRecipient = new IBinder.DeathRecipient() {
        @Override
        public void binderDied() {
            if (mAidlDeviceManager == null) {
                return;
            }
            mAidlDeviceManager.asBinder().unlinkToDeath(mDeathRecipient, 0);
            mAidlDeviceManager = null;
            Log.e(TAG, "binderDied: ");
            // TODO: [runningDigua create at 2019/11/28] 重新开启
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (this.getClass().getName().equals(MainActivity.class.getName())) {
            // 绑定Service
            Intent service = new Intent("com.lll.posserviceaidl.PosPrinterService");
            service.setPackage("com.lll.posserviceaidl");//服务端的包名
            bindService(service, mPsoPrinterConnection, BIND_AUTO_CREATE);
        }
    }

    /**
     * 链接Connection
     */
    private class PsoPrinterConnection implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.e(TAG, "onServiceConnected: " + name.getPackageName());
            mAidlDeviceManager = AidlDeviceManager.Stub.asInterface(service);
            onConnected(mAidlDeviceManager);
            try {
                service.linkToDeath(mDeathRecipient, 0);//设置死亡代理
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.e(TAG, "onServiceDisconnected: " + name.getPackageName());
        }
    }

    /**
     * 链接成功服务
     * @param deviceManager
     */
    public abstract void onConnected(AidlDeviceManager deviceManager);

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(mPsoPrinterConnection);
    }
}
