package com.lll.posclientaidl;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.lll.posserviceaidl.AidlDeviceManager;
import com.lll.posserviceaidl.PosPrinterCallback;
import com.lll.posserviceaidl.PsoPrinterManager;
import com.lll.posserviceaidl.bean.PosInfo;
import com.lll.posserviceaidl.bean.PrinterParams;
import com.lll.posserviceaidl.constant.Constant;

import java.util.ArrayList;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";

    private TextView mTextView;

    private Button mButton;

    private Button mBtnObtainData;

    private Button mBtnUnbindService;

    private Button mBtnPushPosInfo;

    private Button mBtnPrintCallback;

    private PsoPrinterManager mPsoPrinterManager;

    /**
     * 自定义的远程回调接口
     */
    private PosPrinterCallback mPosPrinterCallback = new PosPrinterCallback.Stub() {//服务端的Stub对象
        @Override
        public void onPrintSuccess(int code, String message) throws RemoteException {
            Log.e(TAG, "onPrintSuccess: " + Thread.currentThread().getName());// main
            Log.e(TAG, "onPrintSuccess-message: " + message);
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onPrintFailed(String message) throws RemoteException {
            Log.e(TAG, "onPrintFailed: " + Thread.currentThread().getName());
            Log.e(TAG, "onPrintFailed-message: " + message);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.tv_obtainData);
        mButton = findViewById(R.id.btn_bindService);
        mBtnObtainData = findViewById(R.id.btn_obtainData);
        mBtnUnbindService = findViewById(R.id.btn_unbindService);
        mBtnPushPosInfo = findViewById(R.id.btn_pushPosInfo);
        mBtnPrintCallback = findViewById(R.id.btn_printCallback);
        mButton.setOnClickListener(this);
        mBtnObtainData.setOnClickListener(this);
        mBtnUnbindService.setOnClickListener(this);
        mBtnPushPosInfo.setOnClickListener(this);
        mBtnPrintCallback.setOnClickListener(this);

    }

    @Override
    public void onConnected(AidlDeviceManager deviceManager) {
        try {
            IBinder device = deviceManager.getDevice(Constant.DEVICE_TYPE.DEVICE_TYPE_PRINTERDEV);
            mPsoPrinterManager = PsoPrinterManager.Stub.asInterface(device);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Toast.makeText(MainActivity.this, "服务链接成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_obtainData: {
                if (mPsoPrinterManager != null) {
                    try {
                        String posInfo = mPsoPrinterManager.queryPosInfo("20191127");
                        mTextView.setText("服务端参数：" + posInfo);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                break;
            }
            case R.id.btn_pushPosInfo: {
                if (mPsoPrinterManager != null) {
                    PosInfo posInfo = new PosInfo();
                    posInfo.setManufacturers("福建升腾资讯有限公司");
                    posInfo.setModel("ZH2020_001");
                    posInfo.setPosName("小灵通");
                    try {
                        mPsoPrinterManager.setPostInfo(posInfo);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                break;
            }
            case R.id.btn_printCallback: {
                if (mPsoPrinterManager != null) {
                    try {
                        ArrayList<PrinterParams> printerParams = new ArrayList<>();
                        PrinterParams params = new PrinterParams();
                        params.setText("需要打印的数据是~~");
                        printerParams.add(params);
                        mPsoPrinterManager.printOther(printerParams, mPosPrinterCallback);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                break;
            }
        }

    }

}
