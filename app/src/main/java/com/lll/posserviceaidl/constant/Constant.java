package com.lll.posserviceaidl.constant;

/**
 * TODO:describe what the class or interface does.
 *
 * @author runningDigua
 * @date 2019/11/28
 */
public interface Constant {

    public interface BarCodeFormat {
        int AZTEC = 0;
        int CODABAR = 1;
        int CODE_128 = 2;
        int CODE_39 = 3;
        int CODE_93 = 4;
        int DATA_MATRIX = 5;
        int EAN_13 = 6;
        int EAN_8 = 7;
        int ITF = 8;
        int PDF_417 = 9;
        int QR_CODE = 10;
        int UPC_A = 11;
        int UPC_E = 12;
    }

    public interface VOICE_TYPE {
        int SWIPE_CARD = 0;
        int INSERT_CARD = 1;
        int WAVE_CARD = 2;
        int SWIPE_WAVE_CARD = 3;
        int SWIPE_INSERT_CARD = 4;
        int SWIPE_INSERT_WAVE_CARD = 5;
        int TRANSACTION_DONT_LEAVE_CARD = 6;
        int TRANSACTION_OK_LEAVE_CARD = 7;
        int INPUT_AMOUNT = 8;
        int INPUT_PASSWORD = 9;
        int PASSWORD_LENGTH_NO_ENOUGH = 10;
        int CONFIRM_CARDNO_AMOUNT = 11;
        int TRANSACTION_WAIT_PLEASE = 12;
        int PRINTTING_WAIT_PLEASE = 13;
        int PASSWORD_WRONG_RETRANSACTION = 14;
        int PRINTER_LACK_PAPER = 15;
        int LOW_POWER_NO_PRINT = 16;
        int TRANSACTION_SUCCESS = 17;
        int COMMUNICATION_BREAKDOWN = 18;
        int SIGN_PLEASE = 19;
        int BALANCE_PLEASE = 20;
        int AUTOMATIC_SUCCESS = 21;
        int ACTIVATION_SUCCESS = 22;
        int NUM_ZERO = 23;
        int NUM_ONE = 24;
        int NUM_TWO = 25;
        int NUM_THREE = 26;
        int NUM_FOUR = 27;
        int NUM_FIVE = 28;
        int NUM_SIX = 29;
        int NUM_SEVEN = 30;
        int NUM_EIGHT = 31;
        int NUM_NINE = 32;
        int NUM_TEN = 33;
        int NUM_HUNDRED = 34;
        int NUM_THOUSAND = 35;
        int NUM_TEN_THOUSAND = 36;
        int NUM_TEN_MILLION = 37;
        int NUM_ZHAO = 38;
        int POINT = 39;
        int YUAN = 40;
        int JIAO = 41;
        int FEN = 42;
        int WAVE_INSERT_CARD = 43;
    }

    public interface HSM_NATIVE {
        int HSM_OBJECT_DATA_TYPE_pem = 0;
        int HSM_OBJECT_DATA_TYPE_der = 1;
        int HSM_OBJECT_DATA_TYPE_p7b = 2;
        int HSM_OBJECT_DATA_TYPE_pfx = 3;
    }

    public interface HSM_OBJECT {
        int HSM_OBJECT_TYPE_private_key = 0;
        int HSM_OBJECT_TYPE_public_key = 1;
        int HSM_OBJECT_TYPE_cert = 2;
    }

    public interface PBOC {
        String result = "result";
        String info = "info";
    }

    public interface PSAM_DEV_ID {
        byte ID_1 = 1;
        byte ID_2 = 2;
        byte ID_3 = 3;
    }

    public interface LEDTYPE {
        int LED_OFF = 0;
        int LED_PRICE = 1;
        int LED_TOTAL = 2;
        int LED_CHARGE = 3;
        int LED_BALANCE = 4;
    }

    public interface INPUT_METHOD_MANAGER {
        int INPUTMETHOD_TYPE_123 = 0;
        int INPUTMETHOD_TYPE_123_ABC = 4;
        int INPUTMETHOD_TYPE_123_ABC_CAP = 16;
        int INPUTMETHOD_TYPE_123_ABC_NOSYM = 5;
        int INPUTMETHOD_TYPE_123_ABC_NOSYM_CAP = 17;
        int INPUTMETHOD_TYPE_ABC = 3;
        int INPUTMETHOD_TYPE_ABC_123 = 8;
        int INPUTMETHOD_TYPE_ABC_123_CAP = 19;
        int INPUTMETHOD_TYPE_ABC_123_NOSYM = 9;
        int INPUTMETHOD_TYPE_ABC_123_NOSYM_CAP = 20;
        int INPUTMETHOD_TYPE_ABC_CAP = 15;
        int INPUTMETHOD_TYPE_ABC_NOSYM = 7;
        int INPUTMETHOD_TYPE_ABC_NOSYM_CAP = 18;
        int INPUTMETHOD_TYPE_HANDWRITING = 2;
        int INPUTMETHOD_TYPE_HANDWRITING_NOSYM = 10;
        int INPUTMETHOD_TYPE_HANDWRITING_PINYIN_123 = 21;
        int INPUTMETHOD_TYPE_PINYIN = 1;
        int INPUTMETHOD_TYPE_PINYIN_HANDWRITING = 11;
        int INPUTMETHOD_TYPE_PINYIN_HANDWRITING_123 = 13;
        int INPUTMETHOD_TYPE_PINYIN_HANDWRITING_123_NOSYM = 14;
        int INPUTMETHOD_TYPE_PINYIN_HANDWRITING_NOSYM = 12;
        int INPUTMETHOD_TYPE_PINYIN_NOSYM = 6;
    }

    public interface COLOR_DEPTH {
        int DEPTH_1 = 0;
        int DEPTH_2 = 1;
        int DEPTH_3 = 2;
        int DEPTH_4 = 3;
    }

    public interface ALIGN {
        int LEFT = 0;
        int CENTER = 1;
        int RIGHT = 2;
    }

    public interface DEVICE_ERR_CODE {
        int ERROR_CODE_OK = 0;
        int ERROR_CODE_UNDEINE_ERROR = -1;
        int ERROR_CODE_DEVICE_OCCUPIED = -2;
        int ERROR_CODE_DEVICE_NOT_EXIST = -3;
        int ERROR_CODE_DEVICE_CLOSED = -4;
    }

    public interface DEVICE_TYPE {
        int OFFSET = 8192;
        int DEVICE_TYPE_PBOC = 8193;
        int DEVICE_TYPE_MAGCARD = 8194;
        int DEVICE_TYPE_PRINTERDEV = 8195;
        int DEVICE_TYPE_ICCARD = 8196;
        int DEVICE_TYPE_PINPAD = 8197;
        int DEVICE_TYPE_EXPINPAD = 8198;
        int DEVICE_TYPE_RFCARD = 8199;
        int DEVICE_TYPE_SERIALPORT1 = 8200;
        int DEVICE_TYPE_SERIALPORT2 = 8201;
        int DEVICE_TYPE_INPUTMETHOD = 8202;
        int DEVICE_TYPE_SYS = 8203;
        int DEVICE_TYPE_CASHBOX = 8204;
        int DEVICE_TYPE_CUSTOMDISPLAY = 8205;
        int DEVICE_TYPE_MIFARE = 8206;
        int DEVICE_TYPE_MODEM = 8207;
        int DEVICE_TYPE_PSAM1 = 8208;
        int DEVICE_TYPE_PSAM2 = 8209;
        int DEVICE_TYPE_PSAM3 = 8210;
        int DEVICE_TYPE_OLED = 8211;
        int DEVICE_TYPE_IDCARD = 8212;
        int DEVICE_TYPE_PBOC2 = 8213;
        int DEVICE_TYPE_METAL = 8214;
        int DEVICE_TYPE_VERTICAL_ICCARD = 8215;
        int DEVICE_TYPE_LCD = 8216;
        int DEVICE_TYPE_HSM = 8217;
        int DEVICE_TYPE_MEM4442 = 8218;
        int DEVICE_TYPE_MEM102 = 8219;
        int DEVICE_TYPE_MEM1608 = 8220;
        int DEVICE_TYPE_MEMAT24C02 = 8221;
        int DEVICE_TYPE_VERSION_HELPER = 8222;
        int DEVICE_TYPE_BARCODE = 8223;
        int DEVICE_TYPE_VERTICAL_MEM4442 = 8224;
        int DEVICE_TYPE_VERTICAL_MEM102 = 8225;
        int DEVICE_TYPE_VERTICAL_MEM1608 = 8226;
        int DEVICE_TYPE_VERTICAL_MEMAT24C02 = 8227;
        int DEVICE_TYPE_SOUNDPLAYER = 8228;
        int DEVICE_TYPE_PBOC3 = 8229;
        int DEVICE_TYPE_QUICKSCAN = 8230;
        int DEVICE_TYPE_IDCARD2 = 8231;
        int DEVICE_TYPE_MEM4428 = 8232;
        int DEVICE_TYPE_VERTICAL_MEM4428 = 8233;
        int DEVICE_TYPE_SIGN = 8234;
        int DEVICE_TYPE_RF_IDCARD = 8235;
        int DEVICE_TYPE_WIFIPROBE = 8236;
        int DEVICE_TYPE_FACE_RECOG = 8237;
        int DEVICE_TYPE_SM_KEYPAIRS = 8238;
    }

}
