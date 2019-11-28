package com.lll.posserviceaidl.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * pos info
 *
 * @author runningDigua
 * @date 2019/11/27
 */
public class PosInfo implements Parcelable {

    private String posName;

    private String model;

    private String manufacturers;

    public String getPosName() {
        return posName;
    }

    public void setPosName(String posName) {
        this.posName = posName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturers() {
        return manufacturers;
    }

    public void setManufacturers(String manufacturers) {
        this.manufacturers = manufacturers;
    }

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.posName);
        dest.writeString(this.model);
        dest.writeString(this.manufacturers);
    }

    public PosInfo() {}

    protected PosInfo(Parcel in) {
        this.posName = in.readString();
        this.model = in.readString();
        this.manufacturers = in.readString();
    }

    public static final Parcelable.Creator<PosInfo> CREATOR = new Parcelable.Creator<PosInfo>() {
        @Override
        public PosInfo createFromParcel(Parcel source) {return new PosInfo(source);}

        @Override
        public PosInfo[] newArray(int size) {return new PosInfo[size];}
    };
}
