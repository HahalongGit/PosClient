package com.lll.posserviceaidl.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashMap;

/**
 * 扫码参数
 *
 * @author runningDigua
 * @date 2019/11/29
 */
public class CameraBeanZbar implements Parcelable {

    /**
     * 扫码参数Flag
     */
    public static final String CAMERA_PARAM_FALG = "scannerParamFlag";

    /**
     * 是否显示扫码预览界面
     */
    private boolean isShowPreview;

    /**
     * 是否连续扫码
     */
    private boolean isPersist;

    /**
     * true：打开，false关闭
     */
    private boolean isScanEffect;

    /**
     * 是否使用后置摄像头（0后置，1前置）
     */
    private int cameraId;
    /**
     * 分辨率宽高（1280*720 或者 640*480）
     */
    private int width;
    /**
     * 分辨率高
     */
    private int height;
    /**
     * 闪光灯模式 0关闭，1打开
     */
    private int lightMode;
    /**
     * 扫描时间 0-60000ms
     */
    private long time;
    /**
     * 旋转角度 0，90，180，270
     */
    private int spinDegree;
    /**
     * 蜂鸣 0不蜂鸣，1蜂鸣
     */
    private int beep;
    /**
     * 扩展参数集，可以设置的key-value
     */
    private HashMap<String, Object> externalMap = new HashMap();

    public boolean isShowPreview() {
        return isShowPreview;
    }

    public void setShowPreview(boolean showPreview) {
        isShowPreview = showPreview;
    }

    public boolean isPersist() {
        return isPersist;
    }

    public void setPersist(boolean persist) {
        isPersist = persist;
    }

    public boolean isScanEffect() {
        return isScanEffect;
    }

    public void setScanEffect(boolean scanEffect) {
        isScanEffect = scanEffect;
    }

    public int getCameraId() {
        return cameraId;
    }

    public void setCameraId(int cameraId) {
        this.cameraId = cameraId;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLightMode() {
        return lightMode;
    }

    public void setLightMode(int lightMode) {
        this.lightMode = lightMode;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getSpinDegree() {
        return spinDegree;
    }

    public void setSpinDegree(int spinDegree) {
        this.spinDegree = spinDegree;
    }

    public int getBeep() {
        return beep;
    }

    public void setBeep(int beep) {
        this.beep = beep;
    }

    public HashMap<String, Object> getExternalMap() {
        return externalMap;
    }

    public void setExternalMap(HashMap<String, Object> externalMap) {
        this.externalMap = externalMap;
    }

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.cameraId);
        dest.writeInt(this.width);
        dest.writeInt(this.height);
        dest.writeInt(this.lightMode);
        dest.writeLong(this.time);
        dest.writeInt(this.spinDegree);
        dest.writeInt(this.beep);
        dest.writeSerializable(this.externalMap);
    }

    public CameraBeanZbar() {}

    protected CameraBeanZbar(Parcel in) {
        this.cameraId = in.readInt();
        this.width = in.readInt();
        this.height = in.readInt();
        this.lightMode = in.readInt();
        this.time = in.readLong();
        this.spinDegree = in.readInt();
        this.beep = in.readInt();
        this.externalMap = (HashMap<String, Object>) in.readSerializable();
    }

    public static final Creator<CameraBeanZbar> CREATOR = new Creator<CameraBeanZbar>() {
        @Override
        public CameraBeanZbar createFromParcel(Parcel source) {return new CameraBeanZbar(source);}

        @Override
        public CameraBeanZbar[] newArray(int size) {return new CameraBeanZbar[size];}
    };
}
