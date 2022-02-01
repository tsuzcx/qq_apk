package com.tencent.ad.tangram.protocol;

import android.support.annotation.Keep;

@Keep
public final class gdt_analysis_event
{
  public static final int ACTIVITY_STATUS_UNKNOWN = 0;
  public static final int EVENT_ACTIVITY_ACTIVITY_STATUS_CHANGED = 1102;
  public static final int EVENT_APP_INSATLLED = 1062;
  public static final int EVENT_CLICK_END = 1017;
  public static final int EVENT_CLICK_START = 1016;
  public static final int EVENT_CLICK_UNSUPPORTED = 1006;
  public static final int EVENT_CLOSE_INTERSTITIAL_END = 1093;
  public static final int EVENT_CLOSE_INTERSTITIAL_END_AT_FIRST = 1096;
  public static final int EVENT_CLOSE_INTERSTITIAL_INVOKED = 1091;
  public static final int EVENT_CLOSE_INTERSTITIAL_START = 1092;
  public static final int EVENT_CONSISTENCY_BETWEEN_DEVICE_ID_AND_IMEI = 1074;
  public static final int EVENT_EXPOSURE_API_INVOKE = 1103;
  public static final int EVENT_EXPOSURE_CALL_BACK = 1104;
  public static final int EVENT_GET_DEVICE_AID_TICKET = 1049;
  public static final int EVENT_GET_DEVICE_ANDROID_ID = 1042;
  public static final int EVENT_GET_DEVICE_CARRIER = 1039;
  public static final int EVENT_GET_DEVICE_ID = 1040;
  public static final int EVENT_GET_DEVICE_IDFA = 1043;
  public static final int EVENT_GET_DEVICE_IMEI = 1073;
  public static final int EVENT_GET_DEVICE_INFO_END = 1037;
  public static final int EVENT_GET_DEVICE_INFO_START = 1036;
  public static final int EVENT_GET_DEVICE_IPV4 = 1045;
  public static final int EVENT_GET_DEVICE_IPV4_FAILED = 1048;
  public static final int EVENT_GET_DEVICE_IPV4_START = 1046;
  public static final int EVENT_GET_DEVICE_IPV4_SUCCESS = 1047;
  public static final int EVENT_GET_DEVICE_LOCATION = 1038;
  public static final int EVENT_GET_DEVICE_MAC_ADDRESS = 1041;
  public static final int EVENT_GET_DEVICE_QADID = 1044;
  public static final int EVENT_GET_DEVICE_TAID_TICKET = 1050;
  public static final int EVENT_INTERSTITIAL_ACTIVITY_STATUS_CHANGED = 1094;
  public static final int EVENT_INTERSTITIAL_ACTIVITY_STATUS_CHANGED_AT_FIRST = 1095;
  public static final int EVENT_LAUNCH_APP_MARKET = 1061;
  public static final int EVENT_LAUNCH_APP_WITH_DEEPLINK_FAILED = 1005;
  public static final int EVENT_LAUNCH_APP_WITH_DEEPLINK_START = 1003;
  public static final int EVENT_LAUNCH_APP_WITH_DEEPLINK_SUCCESS = 1004;
  public static final int EVENT_LAUNCH_QQ_MINI_PROGRM_FAILED = 1015;
  public static final int EVENT_LAUNCH_QQ_MINI_PROGRM_START = 1013;
  public static final int EVENT_LAUNCH_QQ_MINI_PROGRM_SUCCESS = 1014;
  public static final int EVENT_LOAD_AD = 1053;
  public static final int EVENT_LOAD_AD_FAILED = 1002;
  public static final int EVENT_LOAD_AD_START = 1000;
  public static final int EVENT_LOAD_AD_SUCCESS = 1001;
  public static final int EVENT_METHOD_ARK_RECEIVE_NOTIFICATION = 1071;
  public static final int EVENT_METHOD_ARK_SEND_NOTIFICATION = 1072;
  public static final int EVENT_METHOD_INVOKE = 1051;
  public static final int EVENT_METHOD_JSBRIDGE = 1052;
  public static final int EVENT_MUID_SOURCE_TYPE = 1075;
  public static final int EVENT_OFFLINE = 1106;
  public static final int EVENT_PRELOAD = 1105;
  public static final int EVENT_PRELOAD_INTERSTITIAL_END = 1082;
  public static final int EVENT_PRELOAD_INTERSTITIAL_START = 1081;
  public static final int EVENT_PRELOAD_INTERSTITIAL_STATUS_CHANGED = 1083;
  public static final int EVENT_PRELOAD_QQ_MINI_PROGRM_FAILED = 1012;
  public static final int EVENT_PRELOAD_QQ_MINI_PROGRM_START = 1010;
  public static final int EVENT_PRELOAD_QQ_MINI_PROGRM_SUCCESS = 1011;
  public static final int EVENT_SHOW_BANNER = 1054;
  public static final int EVENT_SHOW_INTERSTITIAL_ARK_SCRIPT_LOADED = 1088;
  public static final int EVENT_SHOW_INTERSTITIAL_ARK_VIEW_LOAD_END = 1087;
  public static final int EVENT_SHOW_INTERSTITIAL_ARK_VIEW_LOAD_START = 1086;
  public static final int EVENT_SHOW_INTERSTITIAL_CLICKED = 1090;
  public static final int EVENT_SHOW_INTERSTITIAL_IMPRESSION = 1089;
  public static final int EVENT_SHOW_INTERSTITIAL_ON_CREATE_VIEW = 1085;
  public static final int EVENT_SHOW_INTERSTITIAL_START = 1084;
  public static final int EVENT_SHOW_REWARDED_VIDEO = 1055;
  public static final int EVENT_START_ACTIVITY = 1101;
  public static final int EVENT_STATISTICS_END = 1057;
  public static final int EVENT_STATISTICS_START = 1056;
  public static final int EVENT_THIRD_PARTY_MONITOR_STATISTICS_HTTP = 1060;
  public static final int EVENT_THIRD_PARTY_MONITOR_STATISTICS_LOCAL_VALIDATION = 1058;
  public static final int EVENT_THIRD_PARTY_MONITOR_STATISTICS_QBOSS_VALICATION = 1059;
  public static final int FRAGMENT_STATUS_BEFORE_FINISH = 4;
  public static final int FRAGMENT_STATUS_ON_ACTIVITY_CREATED = 6;
  public static final int FRAGMENT_STATUS_ON_ATTACH = 7;
  public static final int FRAGMENT_STATUS_ON_CREATE = 8;
  public static final int FRAGMENT_STATUS_ON_CREATE_VIEW = 1;
  public static final int FRAGMENT_STATUS_ON_DESTORY = 12;
  public static final int FRAGMENT_STATUS_ON_DESTORY_VIEW = 11;
  public static final int FRAGMENT_STATUS_ON_DETACH = 13;
  public static final int FRAGMENT_STATUS_ON_FINISH = 5;
  public static final int FRAGMENT_STATUS_ON_PAUSE = 3;
  public static final int FRAGMENT_STATUS_ON_RESUME = 2;
  public static final int FRAGMENT_STATUS_ON_START = 9;
  public static final int FRAGMENT_STATUS_ON_STOP = 10;
  public static final int ORIENTATION_LANDSCAPE = 1;
  public static final int ORIENTATION_PORTRAIT = 0;
  public static final int ORIENTATION_REVERSE_LANDSCAPE = 2;
  public static final int STATISTICS_ACTION = 4;
  public static final int STATISTICS_CLICK = 2;
  public static final int STATISTICS_EFFECT = 3;
  public static final int STATISTICS_IMPESSION = 1;
  public static final int STATISTICS_SDK_MSG = 6;
  public static final int STATISTICS_VIDEO_PLAY = 5;
  public static final int THIRD_PARTY_MONITOR_STATISTICS_CLICK = 102;
  public static final int THIRD_PARTY_MONITOR_STATISTICS_IMPESSION = 101;
  public static final int THIRD_PARTY_MONITOR_STATISTICS_VIDEO_PLAY = 105;
  public static final int VIDEO_STATUS_ENDED = 5;
  public static final int VIDEO_STATUS_ERROR = 6;
  public static final int VIDEO_STATUS_LOADED = 2;
  public static final int VIDEO_STATUS_LOADING = 1;
  public static final int VIDEO_STATUS_PAUSED = 4;
  public static final int VIDEO_STATUS_PLAYING = 3;
  public static final int VIDEO_STATUS_UNKNOWN = 0;
  public int actionId = -2147483648;
  public int activityStatus = -2147483648;
  public String aid;
  public String androidActivityName;
  public int androidAppInstalled = -2147483648;
  public String androidAppMarketPackageName;
  public String androidCurrentProcessName;
  public int androidDeeplinkDelayed = -2147483648;
  public String androidFromProcessName;
  public String androidPackageName;
  public int androidSimState = -2147483648;
  public String androidToProcessName;
  public String api;
  public String businessId;
  public int cached = -2147483648;
  public String carrierCode;
  public int creativeSize = -2147483648;
  public long currentTime = -2147483648L;
  public long duration = -2147483648L;
  public long duration2 = -2147483648L;
  public int errorCode1 = -2147483648;
  public int errorCode2 = -2147483648;
  public int errorCode3 = -2147483648;
  public int errorHandled = -2147483648;
  public String eventId;
  public String hostName;
  public int httpErrorCode = -2147483648;
  public int internalErrorCode = -2147483648;
  public long interval = -2147483648L;
  public int ipType = -2147483648;
  public int isSupplement = -2147483648;
  public int muidSourceType = -2147483648;
  public int netType = -2147483648;
  public int networkType = -2147483648;
  public String offlineVersion;
  public int orientation = -2147483648;
  public int phoneType = -2147483648;
  public String posId;
  public int reason = -2147483648;
  public int statisticsType = -2147483648;
  public int status1 = -2147483648;
  public int status2 = -2147483648;
  public int status3 = -2147483648;
  public int status4 = -2147483648;
  public int status5 = -2147483648;
  public String url;
  public int urlType = -2147483648;
  public long videoPositionMillis = -2147483648L;
  public int videoStatus = -2147483648;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.protocol.gdt_analysis_event
 * JD-Core Version:    0.7.0.1
 */