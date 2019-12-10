package com.lll.posclientaidl.bean;

import java.util.HashMap;

/**
 * TODO:describe what the class or interface does.
 *
 * @author runningDigua
 * @date 2019/11/29
 */
public class PrintEntity {

    public PrintType printType;
    public HashMap<String, String> printValue;

    public static final class PrintType {
        public byte[] topImg;
        public String topMsg;
        public int topStringSize;
        public int middleStringType;
        public int middleStringSize;
        public String bottomMsg;
        public int bottomStringSize;
        public byte[] bottomImg;
        public int contentStringSize;
    }

}
