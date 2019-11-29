package com.lll.posserviceaidl.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashMap;

/**
 * TODO:describe what the class or interface does.
 *
 * @author runningDigua
 * @date 2019/11/29
 */
public class CameraBeanZbar implements Parcelable {

    /**
     * 是否使用后置摄像头（0后置，1前置）
     */
    private int cameraId;
    /**
     * 分辨率宽高（1280*720 或者 640*480）
     */
    private int width;
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
     * Persist:是否连续扫码，true连续扫码，false不连续
     * ShowPreview :是否显示扫码界面，true显示，false不显示
     * ScanEffect：扫码效果
     */
    private HashMap<String, Object> externalMap = new HashMap();

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
