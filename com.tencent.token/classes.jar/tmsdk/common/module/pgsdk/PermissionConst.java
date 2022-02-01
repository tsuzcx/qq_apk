package tmsdk.common.module.pgsdk;

public class PermissionConst
{
  public static abstract interface PermID
  {
    public static final int ACCESS_MEDIA_PROVIDER = 44;
    public static final int APP_AUTO_START = 4;
    public static final int APP_BRING_UP = 40;
    public static final int APP_LOCK = 38;
    public static final int APP_TRUST = 39;
    public static final int APP_WHITE_LIST = 3;
    public static final int BACKGROUND_START_ACTIVITY = 48;
    public static final int BLUETOOTH = 35;
    public static final int CALL_PHONE = 10;
    public static final int CAMERA = 29;
    public static final int CANCEL_SYSTEM_LOCKER = 41;
    public static final int DEFAULT_PHONE_SERVICE = 46;
    public static final int DELETE_CALL_LOG = 13;
    public static final int DELETE_CONTACTS = 23;
    public static final int EXTERNAL_STORAGE = 2;
    public static final int FLOAT_WINDOW = 5;
    public static final int GET_ACCOUNTS = 32;
    public static final int GET_INSTALLED_PACKAGES = 7;
    public static final int GPS_SWITCH = 49;
    public static final int INSTALL_PACKAGE = 47;
    public static final int INSTALL_SHORTCUT = 26;
    public static final int LOCATION = 24;
    public static final int LOCK_SCREEN = 36;
    public static final int LOCK_SHOW = 42;
    public static final int MANAGE_NOTIFICATION = 25;
    public static final int MOBILE_NETWORK = 33;
    public static final int POST_NOTIFICATION = 8;
    public static final int PROCESS_OUTGOING_CALLS = 9;
    public static final int READ_CALENDAR = 27;
    public static final int READ_CALL_LOG = 11;
    public static final int READ_CONTACTS = 21;
    public static final int READ_MMS = 18;
    public static final int READ_PHONE_STATE = 1;
    public static final int READ_SMS = 14;
    public static final int RECORD_AUDIO = 30;
    public static final int SEND_MMS = 20;
    public static final int SEND_SMS = 16;
    public static final int SMS_NOTIFICATION = 17;
    public static final int TYPE_TOAST_WINDOW = 37;
    public static final int USAGE_ACCESS = 6;
    public static final int USAGE_STATS = 45;
    public static final int VPN = 43;
    public static final int WIFI_NETWORK = 34;
    public static final int WRITE_CALENDAR = 28;
    public static final int WRITE_CALL_LOG = 12;
    public static final int WRITE_CONTACTS = 22;
    public static final int WRITE_MMS = 19;
    public static final int WRITE_SETTINGS = 31;
    public static final int WRITE_SMS = 15;
  }
  
  public static abstract interface PermState
  {
    public static final int STATE_ASKED = 1;
    public static final int STATE_DENIED = -1;
    public static final int STATE_GRANTED = 0;
    public static final int STATE_UNKNOWN = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.module.pgsdk.PermissionConst
 * JD-Core Version:    0.7.0.1
 */