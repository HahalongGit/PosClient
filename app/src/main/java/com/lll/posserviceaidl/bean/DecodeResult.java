package com.lll.posserviceaidl.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * TODO:describe what the class or interface does.
 *
 * @author runningDigua
 * @date 2019/11/28
 */
public class DecodeResult implements Parcelable {

    private int ret = -1;
    private int decodeFormat = -1;
    private byte[] decodeData;

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public int getDecodeFormat() {
        return decodeFormat;
    }

    public void setDecodeFormat(int decodeFormat) {
        this.decodeFormat = decodeFormat;
    }

    public byte[] getDecodeData() {
        return decodeData;
    }

    public void setDecodeData(byte[] decodeData) {
        this.decodeData = decodeData;
    }

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.ret);
        dest.writeInt(this.decodeFormat);
        dest.writeByteArray(this.decodeData);
    }

    public DecodeResult() {}

    protected DecodeResult(Parcel in) {
        this.ret = in.readInt();
        this.decodeFormat = in.readInt();
        this.decodeData = in.createByteArray();
    }

    public static final Creator<DecodeResult> CREATOR = new Creator<DecodeResult>() {
        @Override
        public DecodeResult createFromParcel(Parcel source) {return new DecodeResult(source);}

        @Override
        public DecodeResult[] newArray(int size) {return new DecodeResult[size];}
    };
}
