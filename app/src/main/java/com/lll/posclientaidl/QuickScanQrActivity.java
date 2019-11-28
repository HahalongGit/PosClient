package com.lll.posclientaidl;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.lll.posserviceaidl.AidlDeviceManager;
import com.lll.posserviceaidl.IPosQuickScanManager;
import com.lll.posserviceaidl.constant.Constant;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 扫码模块
 */
public class QuickScanQrActivity extends BaseActivity implements CompoundButton.OnCheckedChangeListener {

    @BindView(R.id.checkboxFlashlight)
    CheckBox mCheckboxFlashlight;
    @BindView(R.id.checkboxCameraDirecation)
    CheckBox mCheckboxCameraDirecation;
    @BindView(R.id.btn_scannQrCode)
    Button mBtnScannQrCode;

    /**
     * 摄像头id，前置还是后置1
     */
    private int cameraId;

    /**
     * 闪光灯开关 2 开
     */
    private int lightMode;

    private IPosQuickScanManager mIPosQuickScanManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_scan_qr);
        ButterKnife.bind(this);
        mCheckboxCameraDirecation.setOnCheckedChangeListener(this);
        mCheckboxFlashlight.setOnCheckedChangeListener(this);
    }

    @OnClick({R.id.btn_scannQrCode})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_scannQrCode: {
                if (mIPosQuickScanManager != null) {
                    try {
                        mIPosQuickScanManager.decodeBarCode(680, 420, new byte[1024]);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                break;
            }
        }
    }

    @Override
    public void onConnected(AidlDeviceManager deviceManager) {
        try {
            IBinder device = deviceManager.getDevice(Constant.DEVICE_TYPE.DEVICE_TYPE_QUICKSCAN);
            mIPosQuickScanManager = IPosQuickScanManager.Stub.asInterface(device);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    //cameraID           int     摄像头ID
    //width              int     预览宽
    //height             int     预览高
    //lightMode          int     闪光灯模式
    //time               int     扫描时间（ms）
    //spindegree         int     旋转角度（ScanQRCode接口无效）
    //beep               int     蜂鸣次数（ScanQRCode接口无效）
    //ExternalMap Key：
    //Persist            boolean 是否需要持续扫码
    //ShowPreview        boolean 是否需要前置预览
    //ScanEffect         boolean 是否需要扫码模式
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.checkboxCameraDirecation: {
                // 摄像头方向
                if (isChecked) {
                    cameraId = 0;
                } else {
                    cameraId = 1;
                }
                break;
            }
            case R.id.checkboxFlashlight: {
                // 闪光灯开关
                if (isChecked) {
                    lightMode = 2;
                }
                break;
            }
        }
    }
}
