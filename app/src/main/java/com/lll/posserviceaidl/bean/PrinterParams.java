package com.lll.posserviceaidl.bean;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * 打印参数
 *
 * @author runningDigua
 * @date 2019/11/27
 */
public class PrinterParams implements Parcelable {

    // 对齐方式
    enum ALIGN {
        LEFT, CENTER, RIGHT
    }

    enum DATATYPE {
        //文本
        TEXT,
        // 走纸
        FEED_LINE,
        // 一维码
        BARCODE,
        // 二维码
        QRCODE,
        //图片
        IMAGE
    }

    /**
     * 待打数据布局
     *
     */
    ALIGN align = ALIGN.LEFT;
    /*** * 待打数据类型 */
    DATATYPE dataType = DATATYPE.TEXT;
    /*** * 待打印文字、条码内容 */
    String text = "";//最大 2K
    // /*** 打印文本字体大小 */
    int textSize = 24;//矢量字体
    // /*** 打印文本是否斜体 */
    boolean isItalic = false;
    /*** 打印文本是否有中划线 */
    boolean isStrikeThruText = false;
    /*** 打印文本行间隔 */
    int lineSpace = 0;
    /*** 打印文本是否加粗 */
    boolean bold = false;
    /*** 打印文本是否有下划线 */
    boolean underLine = false;
    /**
     * 打印一维码宽
     */
    int barcodeWidth = 200;//200~600
    /*** 打印一维码高 */
    int barcodeHeight = 50;//50~600
    /*** 打印二维码宽度 */
    int qrcodeWidth = 250;

    /*** 打印图片的 biamap */
    Bitmap bitmap;
    /*** 待打印图片宽度 */
    int imgWidth;//0~384
    /*** 待打印图片高度 */
    int imgHeigth;
    /*** 走纸行数，0~255 */
    int feedlineNum;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getTextSize() {
        return textSize;
    }

    public void setTextSize(int textSize) {
        this.textSize = textSize;
    }

    public boolean isItalic() {
        return isItalic;
    }

    public void setItalic(boolean italic) {
        isItalic = italic;
    }

    public boolean isStrikeThruText() {
        return isStrikeThruText;
    }

    public void setStrikeThruText(boolean strikeThruText) {
        isStrikeThruText = strikeThruText;
    }

    public int getLineSpace() {
        return lineSpace;
    }

    public void setLineSpace(int lineSpace) {
        this.lineSpace = lineSpace;
    }

    public boolean isBold() {
        return bold;
    }

    public void setBold(boolean bold) {
        this.bold = bold;
    }

    public boolean isUnderLine() {
        return underLine;
    }

    public void setUnderLine(boolean underLine) {
        this.underLine = underLine;
    }

    public int getBarcodeWidth() {
        return barcodeWidth;
    }

    public void setBarcodeWidth(int barcodeWidth) {
        this.barcodeWidth = barcodeWidth;
    }

    public int getBarcodeHeight() {
        return barcodeHeight;
    }

    public void setBarcodeHeight(int barcodeHeight) {
        this.barcodeHeight = barcodeHeight;
    }

    public int getQrcodeWidth() {
        return qrcodeWidth;
    }

    public void setQrcodeWidth(int qrcodeWidth) {
        this.qrcodeWidth = qrcodeWidth;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public int getImgWidth() {
        return imgWidth;
    }

    public void setImgWidth(int imgWidth) {
        this.imgWidth = imgWidth;
    }

    public int getImgHeigth() {
        return imgHeigth;
    }

    public void setImgHeigth(int imgHeigth) {
        this.imgHeigth = imgHeigth;
    }

    public int getFeedlineNum() {
        return feedlineNum;
    }

    public void setFeedlineNum(int feedlineNum) {
        this.feedlineNum = feedlineNum;
    }

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.align == null ? -1 : this.align.ordinal());
        dest.writeInt(this.dataType == null ? -1 : this.dataType.ordinal());
        dest.writeString(this.text);
        dest.writeInt(this.textSize);
        dest.writeByte(this.isItalic ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isStrikeThruText ? (byte) 1 : (byte) 0);
        dest.writeInt(this.lineSpace);
        dest.writeByte(this.bold ? (byte) 1 : (byte) 0);
        dest.writeByte(this.underLine ? (byte) 1 : (byte) 0);
        dest.writeInt(this.barcodeWidth);
        dest.writeInt(this.barcodeHeight);
        dest.writeInt(this.qrcodeWidth);
        dest.writeParcelable(this.bitmap, flags);
        dest.writeInt(this.imgWidth);
        dest.writeInt(this.imgHeigth);
        dest.writeInt(this.feedlineNum);
    }

    public PrinterParams() {}

    protected PrinterParams(Parcel in) {
        int tmpAlign = in.readInt();
        this.align = tmpAlign == -1 ? null : ALIGN.values()[tmpAlign];
        int tmpDataType = in.readInt();
        this.dataType = tmpDataType == -1 ? null : DATATYPE.values()[tmpDataType];
        this.text = in.readString();
        this.textSize = in.readInt();
        this.isItalic = in.readByte() != 0;
        this.isStrikeThruText = in.readByte() != 0;
        this.lineSpace = in.readInt();
        this.bold = in.readByte() != 0;
        this.underLine = in.readByte() != 0;
        this.barcodeWidth = in.readInt();
        this.barcodeHeight = in.readInt();
        this.qrcodeWidth = in.readInt();
        this.bitmap = in.readParcelable(Bitmap.class.getClassLoader());
        this.imgWidth = in.readInt();
        this.imgHeigth = in.readInt();
        this.feedlineNum = in.readInt();
    }

    public static final Creator<PrinterParams> CREATOR = new Creator<PrinterParams>() {
        @Override
        public PrinterParams createFromParcel(Parcel source) {return new PrinterParams(source);}

        @Override
        public PrinterParams[] newArray(int size) {return new PrinterParams[size];}
    };
}
