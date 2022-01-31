package com.tencent.kingkong;

public abstract class Constant
{
  public static final boolean ENABLE_DEBUG_LOG = true;
  public static final boolean ENABLE_DEBUG_PACKAGE_NAME = true;
  public static final boolean ENABLE_DPC_STATUS_CONTROL = false;
  public static final boolean ENABLE_ERROR_LOG = false;
  public static final boolean ENABLE_MIN_UPDATE_INTERVAL = true;
  public static final boolean ENABLE_OFFLINE_TEST = false;
  public static final boolean ENABLE_RSA_DECRYPT = false;
  public static final boolean ENABLE_TEST_ENVIRONMENT = false;
  public static final int LOG_POINT_DO_PATCH = 300;
  public static final int LOG_POINT_INSTALL = 200;
  public static final int LOG_POINT_UPDATE = 100;
  public static final String LOG_TAG = "KingKong";
  public static int LogPoint = 0;
  public static String MAIN_CONFIG_URL = "http://zyjc.sec.qq.com/config?b=";
  public static String MAIN_CONFIG_URL_OFFLINE;
  public static final long MAX_FORCE_REUPDATE_TIME = 900000L;
  public static final long MAX_UPDATE_INTERVAL = 180000L;
  public static final int NOTIFICATION_TYPE_DELETE = 2084;
  public static final int NOTIFICATION_TYPE_DO_PATCH = 2081;
  public static final int NOTIFICATION_TYPE_EVIL_CATCHED = 2082;
  public static final int NOTIFICATION_TYPE_KINGKONG_PATCH = 2080;
  public static final int NOTIFICATION_TYPE_NATIVE_ERROR = 2083;
  public static final int NOTIFICATION_TYPE_REPORT_FINGERPRINT = 2086;
  public static final int NOTIFICATION_TYPE_REPORT_LOGIN = 2088;
  public static final int NOTIFICATION_TYPE_REPORT_POINT_LOG = 2087;
  public static final int NOTIFICATION_TYPE_UPDATE = 2085;
  public static final String PATCH_DRIVER_VERSION = "2.0";
  public static final int PATCH_HOOKPOINT_MAX = 15;
  public static final int PATCH_LIB_SHA1_MAX = 15;
  public static final boolean RELEASE_TO_MOBILE_QQ = false;
  public static String REPORT_CGI_URL = "http://zyjc.sec.qq.com/reportFixer.php";
  public static final int REPORT_DO_PATCH_FAIL_CALC_HOOKPIONT = 7;
  public static final int REPORT_DO_PATCH_FAIL_CALC_JUMPERPIONT = 8;
  public static final int REPORT_DO_PATCH_FAIL_CONTEXT_NULL = 1;
  public static final int REPORT_DO_PATCH_FAIL_GET_PARAMETERS = 6;
  public static final int REPORT_DO_PATCH_FAIL_INIT_NATIVE = 4;
  public static final int REPORT_DO_PATCH_FAIL_INVALID_PATCH = 11;
  public static final int REPORT_DO_PATCH_FAIL_LOAD_CLASS = 5;
  public static final int REPORT_DO_PATCH_FAIL_LOAD_SO = 3;
  public static final int REPORT_DO_PATCH_FAIL_NATIVE_DO_PATCH = 10;
  public static final int REPORT_DO_PATCH_FAIL_NOT_SUPPORT = 12;
  public static final int REPORT_DO_PATCH_FAIL_VALUE_EMPTY = 2;
  public static final int REPORT_DO_PATCH_FAIL_VERIFY_PARAMETERS = 9;
  public static final int REPORT_DO_PATCH_MAX = 13;
  public static final int REPORT_DO_PATCH_OK = 0;
  public static final int REPORT_INIT_PATCHMANAGER_FAIL_CONTEXT_NULL = 1;
  public static final int REPORT_INIT_PATCHMANAGER_FAIL_INIT_PATCH_FILES = 2;
  public static final int REPORT_INIT_PATCHMANAGER_FAIL_LOAD_SO = 3;
  public static final int REPORT_INIT_PATCHMANAGER_OK = 0;
  
  static
  {
    MAIN_CONFIG_URL_OFFLINE = "/sdcard/";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.kingkong.Constant
 * JD-Core Version:    0.7.0.1
 */