package com.tencent.smtt.sdk;

public abstract interface TbsListener
{
  public static final String tag_load_error = "loaderror";
  
  public abstract void onDownloadFinish(int paramInt);
  
  public abstract void onDownloadProgress(int paramInt);
  
  public abstract void onInstallFinish(int paramInt);
  
  public static abstract interface ErrorCode
  {
    public static final int APK_INVALID = 204;
    public static final int APK_PATH_ERROR = 202;
    public static final int APK_VERSION_ERROR = 203;
    public static final int COPY_EXCEPTION = 215;
    public static final int COPY_FAIL = 212;
    public static final int COPY_INSTALL_SUCCESS = 220;
    public static final int COPY_SRCDIR_ERROR = 213;
    public static final int COPY_TMPDIR_ERROR = 214;
    public static final int DEXOPT_EXCEPTION = 209;
    public static final String DISABLE_X5 = "forbiden by server add 469936079 report it";
    public static final int DISK_FULL = 105;
    public static final int DOWNLOAD_FILE_CONTENTLENGTH_NOT_MATCH = 113;
    public static final int DOWNLOAD_HAS_LOCAL_TBS_ERROR = 120;
    public static final int DOWNLOAD_INSTALL_SUCCESS = 200;
    public static final int DOWNLOAD_OVER_FLOW = 112;
    public static final int DOWNLOAD_SUCCESS = 100;
    public static final int ERROR_AUTHENTICATION = 317;
    public static final int ERROR_CANLOADVIDEO_RETURN_FALSE = 313;
    public static final int ERROR_CANLOADVIDEO_RETURN_NULL = 314;
    public static final int ERROR_CANLOADX5_RETURN_FALSE = 307;
    public static final int ERROR_CANLOADX5_RETURN_NULL = 308;
    public static final int ERROR_CODE_COMMON_BASE = 0;
    public static final int ERROR_CODE_DOWNLOAD_BASE = 100;
    public static final int ERROR_CODE_INSTALL_BASE = 200;
    public static final int ERROR_CODE_LOAD_BASE = 300;
    public static final int ERROR_COREVERSION_CHANGED = 1005;
    public static final int ERROR_COREVERSION_TOOLOW = 1006;
    public static final int ERROR_FORCE_SYSTEM_WEBVIEW_INNER_FAILED_TO_CREATE = 301;
    public static final int ERROR_FORCE_SYSWEBVIEW = 1002;
    public static final int ERROR_HOSTAPP_UNAVAILABLE = 1001;
    public static final int ERROR_HOST_UNAVAILABLE = 304;
    public static final int ERROR_LESS_THAN_MIN_SUPPORT_VER = 309;
    public static final int ERROR_NOMATCH_COREVERSION = 1003;
    public static final int ERROR_NOMATCH_CPU = 1000;
    public static final int ERROR_QBSDK_INIT = 315;
    public static final int ERROR_QBSDK_INIT_CANLOADX5 = 319;
    public static final int ERROR_QBSDK_INIT_END = 316;
    public static final int ERROR_QBSDK_INIT_ISSUPPORT = 318;
    public static final int ERROR_SDKENGINE_CANLOADTBS = 324;
    public static final int ERROR_SDKENGINE_ISCOMPATIBLE = 320;
    public static final int ERROR_TBSCORE_DEXOPT_DIR = 311;
    public static final int ERROR_TBSCORE_SHARE_DIR = 312;
    public static final int ERROR_TBSINSTALLER_ISTBSCORELEGAL_01 = 321;
    public static final int ERROR_TBSINSTALLER_ISTBSCORELEGAL_02 = 322;
    public static final int ERROR_TBSINSTALLER_ISTBSCORELEGAL_03 = 323;
    public static final int ERROR_UNMATCH_TBSCORE_VER = 303;
    public static final int ERROR_UNMATCH_TBSCORE_VER_THIRDPARTY = 302;
    public static final int EXCEED_COPY_RETRY_NUM = 211;
    public static final int EXCEED_DEXOPT_RETRY_NUM = 208;
    public static final int EXCEED_UNZIP_RETRY_NUM = 201;
    public static final int EXCEPTION_QBSDK_INIT = 305;
    public static final int FILE_DELETED = 106;
    public static final int FILE_RENAME_ERROR = 109;
    public static final String FORCE_SYSTEM_WEBVIEW_INNER = "some error happened anlysis the other errcodes ^_^";
    public static final String FORCE_SYSTEM_WEBVIEW_OUTER = "APP lead to force system webview";
    public static final int INCRUPDATE_INSTALL_SUCCESS = 221;
    public static final int INCR_UPDATE_ERROR = 216;
    public static final int INCR_UPDATE_EXCEPTION = 218;
    public static final int INCR_UPDATE_FAIL = 217;
    public static final int INFO_CAN_LOAD_TBS = 406;
    public static final int INFO_CAN_NOT_LOAD_TBS = 405;
    public static final int INFO_CODE_BASE = 400;
    public static final int INFO_DISABLE_X5 = 404;
    public static final String INFO_ERROR_AUTHENTICATION = "Authentication fail, use sys webview, please refer to the document of anthentication strictly";
    public static final String INFO_ERROR_CANLOADX5_RETURN_FALSE = "sdkextension return false maybe your phone TotalRAM is less 170M ";
    public static final String INFO_ERROR_CANLOADX5_RETURN_NULL = "sdkextension return null try to update X5 in wechat/qq/qzone ";
    public static final String INFO_ERROR_COREVERSION_CHANGED = "Maybe the coreversion of X5 in wechat/qq/qzone is changed please check it";
    public static final String INFO_ERROR_COREVERSION_TOOLOW = "The coreversion of x5 in wechat/qq/qzone is lowwer than 25438";
    public static final String INFO_ERROR_FORCE_SYSTEM_WEBVIEW_INNER_FAILED_TO_CREATE = "Fail to create createSDKWebview please restart you app try again";
    public static final String INFO_ERROR_FORCE_SYSWEBVIEW = "debug.conf force syswebview";
    public static final String INFO_ERROR_HOSTAPP_UNAVAILABLE = "if the errocode is the only first time so ignore it. but if always occur then host app unavalilable try to update the x5 in wechat/qq/qzone (isShareTbsCoreAvailable=false in initForX5DisableConfig())";
    public static final String INFO_ERROR_HOST_UNAVAILABLE = "if the errocode is the only first time so ignore it. but if always occur then host app unavalilable try to update the x5 in wechat/qq/qzone (isShareTbsCoreAvailable=false in init())";
    public static final String INFO_ERROR_NOMATCH_COREVERSION = "Are you sure have installed wechat or mobileqq or qzone? if yes maybe there is no X5 in them  ";
    public static final String INFO_ERROR_NOMATCH_CPU = "your CPU is i686|mips|x86_64? sorry X5 is not support them";
    public static final String INFO_ERROR_QBSDK_INIT = "SDK init failed,you need analysis the other errcodes";
    public static final String INFO_ERROR_QBSDK_INIT_CANLOADX5 = "sdkextension return false maybe your phone TotalRAM is less 170M or X5 is closed by server ";
    public static final String INFO_ERROR_SDKENGINE_ISCOMPATIBLE = "min support api 7";
    public static final String INFO_ERROR_TBSCORE_DEXOPT_DIR = "DEXOPT path is null  make sure x5 in wechat/qq/qzone is normal";
    public static final String INFO_EXCEPTION_QBSDK_INIT = "exception in init analysis other errcode or try to restart app again ";
    public static final int INFO_FORCE_SYSTEM_WEBVIEW_INNER = 401;
    public static final int INFO_FORCE_SYSTEM_WEBVIEW_OUTER = 402;
    public static final int INFO_MISS_SDKEXTENSION_JAR = 403;
    public static final String INFO_SDKENGINE_CANLOADTBS = "if the errocode is the only first time so ignore it. take care the other codes beside it. The first time of open appwebview,it is nomal because it takes some time to share X5.if always happen then make sure app current web process restart or look up other errcodes ^_^";
    public static final String INFO_THROWABLE_LOAD_TBS = "throw a exception when load x5,try to restart your app or anlysis other errcodes";
    public static final String METHOD_MISS_SDKEXTENSION_JAR = "miss tbs_sdk_extension_dex.jar make sure X5 is normal in wechat/qq/qzone ";
    public static final int NETWORK_NOT_WIFI_ERROR = 111;
    public static final int NETWORK_UNAVAILABLE = 101;
    public static final int NONEEDTODOWN_ERROR = 110;
    public static final int READ_RESPONSE_ERROR = 103;
    public static final int RENAME_EXCEPTION = 219;
    public static final int ROM_NOT_ENOUGH = 210;
    public static final int SERVER_ERROR = 102;
    public static final int THROWABLE_LOAD_TBS = 310;
    public static final int THROWABLE_QBSDK_INIT = 306;
    public static final int UNKNOWN_ERROR = 107;
    public static final int UNZIP_DIR_ERROR = 205;
    public static final int UNZIP_IO_ERROR = 206;
    public static final int UNZIP_OTHER_ERROR = 207;
    public static final int VERIFY_ERROR = 108;
    public static final int WRITE_DISK_ERROR = 104;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsListener
 * JD-Core Version:    0.7.0.1
 */