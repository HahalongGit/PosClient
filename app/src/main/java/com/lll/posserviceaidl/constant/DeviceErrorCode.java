package com.lll.posserviceaidl.constant;

/**
 * TODO:describe what the class or interface does.
 *
 * @author runningDigua
 * @date 2019/11/28
 */
public interface DeviceErrorCode {
    public interface PBOC_CHECKCARD {
        int INVALID_PARAMETER = 1;
        int ERROR_OTHER = 7;
    }

    public interface NFCIDCARD {
        int RECEIVE_TIMEOUT = -1;
        int READ_FAILED = -2;
        int NOT_FOUND_SERVER = -3;
        int SERVER_BUSY = -4;
        int NOT_SUPPORT_NFC = -5;
        int NETWORK_NOT_AVAILABLE = -6;
        int ERROR_OTHER = -7;
    }

    public interface QUICKSCAN {
        int LIVE_SUCCESS = 1;
        int ERROR_SO_FILE_NOT_EXIST = 2;
        int ERROR_AUTH_FILE_NOT_EXIST = 3;
        int ERROR_SYSTEM_CONFIG_IS_WRONG = 4;
        int ERROR_AUTH_FILE_NOT_COPY = 5;
        int ERROR_AUTH_FILE_NOT_SAME = 6;
    }

    public interface IDCARD {
        int ERROR_DEVICE_IS_BUSY = 0;
        int ERROR_TIMEOUT = 1;
        int ERROR_DEV = 2;
        int ERROR_CANCELED = 4;
        int NFCERROR = -1;
        int SOCKETERROR = -2;
        int READERROR = -3;
        int DEVICEERROR = -4;
        int APPERROR = -5;
        int CARDERROR = -6;
        int CLINETERROR = -7;
        int STATESERROR = -8;
        int OUTMONEYERROR = -9;
        int VERFIYERROR = -10;
        int RESOURCEERROR = -11;
        int NOSIMERROR = -12;
        int ALREADYREGISTER = 11;
        int REGISTEROK = 12;
        int REGISTERFAIL = 13;
    }

    public interface MODEM {
        int ERROR_DEV_NOTOPEN = -3;
        int ERROR_DEV = -1;
        int ERROR_RECEIVEDATA = -2;
    }

    public interface MIFARE {
        int ERROR_KEY_TYPE = -1;
        int ERROR_KEY_LENTH = -2;
        int ERROR_RESET_DATA = -3;
        int ERROR_UNKNOWN = -4;
        int ERROR_AUTH_FAIL = -5;
        int ERROR_READ_FAIL = -6;
        int ERROR_WRITE_FAIL = -7;
        int ERROR_SELECT_FAIL = -8;
        int ERROR_ADD_FAIL = -9;
        int ERROR_REDUCE_FAIL = -10;
        int ERROR_DELIVERY_FAIL = -11;
        int ERROR_DEVICE_NOTOPEN = -12;
        int ERROR_FORCE_M1STYLE = -13;
    }

    public interface CUSTOMERDISPLAY {
        int ERROR_DEV_IS_NOT_OPEN = -1;
        int ERROR_DEV_DISPLAY = -2;
        int ERROR_DEV_CLEAR = -3;
        int ERROR_DEV_LED_CTRL = -4;
    }

    public interface DEVICE_PBOC {
        int DEVICE_OK = 12288;
        int DEVICE_OPEN_OK = 12289;
        int DEVICE_NOT_OPEN = 12290;
        int DEVICE_BUSY = 12291;
        int DEVICE_SEARCH_CARD_TIME_OUT = 12292;
        int DEVICE_SEARCH_CARD_ERROR = 12293;
        int DEVICE_STARTEMVPRO_ERROR = 12294;
        int DEVICE_ENDEMV_ERROR = 12295;
        int DEVICE_PBOC_ERROR = 12296;
    }

    public interface DEVICE_PINPAD {
        int DEVICE_OK = 0;
        int DEVICE_OPEN_OK = 8193;
        int DEVICE_NOT_OPEN = 8194;
        int DEVICE_BUSY = 8195;
        int DEVICE_MAC_ERROR = 8196;
        int DEVICE_DATA_ENCRYPT_ERROR = 8197;
        int DEVICE_DISPERSEWKEY_ERROR = 8198;
        int DEVICE_DISPERSEMKEY_ERROR = 8199;
        int DEVICE_INPUT_PIN_ERROR = 8200;
        int DEVICE_INPUT_PIN_CANCLE = 8203;
        int DEVICE_INPUT_PIN_TIMEOUT_ERROR = 8202;
        int DEVICE_DISPLAY_ERROR = 8201;
        int GET_PIN_ERROR_PASSWORD_NOT_SAME = 14;
        int GET_PIN_ENCRYPT_FAILED = 15;
        int GET_PIN_OTHER_ERROR = 16;
    }

    public interface DEVICE_PRINTER {
        int DEVICE_OK = 0;
        int DEVICE_OPEN_OK = 4097;
        int DEVICE_NOT_OPEN = 4098;
        int DEVICE_BUSY = 4099;
        int DEVICE_NORESPONSE = 4100;
        int DEVICE_PRINT_DATA_ERROR = 4101;
        int DEVICE_PRINTER_OVER_HEATER = 4102;
        int DEVICE_PRINTER_HEAD_OVER_HEIGH = 4103;
        int DEVICE_PRINTER_OUT_OF_PAPER = 4104;
        int DEVICE_PRINTER_CMD_ERROR = 4105;
        int DEVICE_PRINTER_LOWMEMORY = 4112;
        int DEVICE_PRINTER_UNKNOW_EXCEPTION = 4113;
        int DEVICE_PRINTER_LISTENER_NULL = 4114;
        int DEVICE_PRINTER_LOW_POWER = 4115;
    }

    public interface DEVICE_MAGCARD {
        int DEVICE_OPEN_OK = 0;
        int DEVICE_NOT_OPEN = 1;
        int DEVICE_BUSY = 2;
        int DEVICE_TIMEOUT = 3;
        int DEVICE_SWIPE_FAIL = 4;
        int DEVICE_SWIPE_EXCEPTION = 5;
        int DEVICE_SWIPE_SUCCESS = 6;
        int DEVICE_TIMEOUT_INVALID = 7;
    }
}
