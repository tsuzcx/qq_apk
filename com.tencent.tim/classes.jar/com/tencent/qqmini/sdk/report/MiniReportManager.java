package com.tencent.qqmini.sdk.report;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class MiniReportManager
{
  private static final Map<String, List<String>> APPID_JS_ERROR_MAP;
  public static final String APP_TYPE_MINI_APP = "0";
  public static final String APP_TYPE_MINI_GAME = "1";
  static final int MAX_TIME_COST = WnsConfig.getConfig("qqminiapp", "mini_app_report_max_time_cost", 120000);
  private static final String TAG = "MiniReportManager";
  private static SparseArray<CostTimeRecord> eventCostTimeSparseArray;
  private static SparseArray<String> eventNameSparseArray;
  private static ArrayList<String> eventNameToDC5332;
  private static ArrayList<Integer> eventNeedRecordTime;
  public static HashMap<String, MiniAppLaunchState> launchStateMap;
  
  static
  {
    APPID_JS_ERROR_MAP = new HashMap();
    launchStateMap = new HashMap();
    eventNameSparseArray = new SparseArray();
    eventNeedRecordTime = new ArrayList();
    eventCostTimeSparseArray = new SparseArray();
    eventNameToDC5332 = new ArrayList();
    eventNameSparseArray.put(1, "onlaunch");
    eventNameSparseArray.put(4, "basejsdownloadstart");
    eventNameSparseArray.put(5, "basejsdownloadend");
    eventNameSparseArray.put(6, "basejsunzipstart");
    eventNameSparseArray.put(7, "basejsunzipend");
    eventNameSparseArray.put(8, "basejsreadstart");
    eventNameSparseArray.put(9, "basejsreadend");
    eventNameSparseArray.put(10, "basejsreadstart");
    eventNameSparseArray.put(11, "basejsreadend");
    eventNameSparseArray.put(12, "appconfigreadstart");
    eventNameSparseArray.put(13, "appconfigreadend");
    eventNameSparseArray.put(14, "servicejsstart");
    eventNameSparseArray.put(15, "servicejsend");
    eventNameSparseArray.put(16, "basejsstart");
    eventNameSparseArray.put(17, "basejsready");
    eventNameSparseArray.put(18, "webviewjsstart");
    eventNameSparseArray.put(19, "webviewjsready");
    eventNameSparseArray.put(2, "apponloaded");
    eventNameSparseArray.put(20, "apponhide");
    eventNameSparseArray.put(21, "apponshow");
    eventNameSparseArray.put(22, "apponunload");
    eventNameSparseArray.put(23, "jsonerror");
    eventNameSparseArray.put(24, "appcreate");
    eventNameSparseArray.put(100, "service_start");
    eventNameSparseArray.put(101, "service_end");
    eventNameSparseArray.put(102, "webview_start");
    eventNameSparseArray.put(103, "webview_end");
    eventNameSparseArray.put(104, "app_load_start");
    eventNameSparseArray.put(105, "app_load_end");
    eventNameSparseArray.put(104, "service_app_start");
    eventNameSparseArray.put(105, "service_app_end");
    eventNameSparseArray.put(106, "webview_app_start");
    eventNameSparseArray.put(107, "webview_app_end");
    eventNameSparseArray.put(200, "runtimecreatetaskstart");
    eventNameSparseArray.put(201, "runtimecreatetaskend");
    eventNameSparseArray.put(202, "runtimeinittaskstart");
    eventNameSparseArray.put(203, "runtimeinittaskend");
    eventNameSparseArray.put(204, "baselibloadasynctaskstart");
    eventNameSparseArray.put(205, "baselibloadasynctaskend");
    eventNameSparseArray.put(206, "apkgloadasynctaskstart");
    eventNameSparseArray.put(207, "apkgloadasynctaskend");
    eventNameSparseArray.put(208, "serviceinittaskstart");
    eventNameSparseArray.put(209, "serviceinittaskend");
    eventNameSparseArray.put(210, "preloadflagtaskstart");
    eventNameSparseArray.put(211, "preloadflagtaskend");
    eventNameSparseArray.put(212, "flutterviewinitstart");
    eventNameSparseArray.put(213, "flutterviewcreateend");
    eventNameSparseArray.put(214, "flutterviewchannelinitend");
    eventNameSparseArray.put(215, "flutterlaunchappstart");
    eventNameSparseArray.put(216, "flutterlaunchappend");
    eventNameSparseArray.put(217, "fluttermatchtimecost");
    eventNameSparseArray.put(218, "fluttersetdatatimecost");
    eventNameSparseArray.put(219, "flutterrendertimecost");
    eventNameSparseArray.put(220, "fluttertotaltimecost");
    eventNameSparseArray.put(221, "runtimecreatetaskstartrealtime");
    eventNameSparseArray.put(222, "runtimeinittaskstartrealtime");
    eventNameSparseArray.put(600, "ssocmdstart");
    eventNameSparseArray.put(601, "ssocmdend");
    eventNameSparseArray.put(602, "x5installsuccess");
    eventNameSparseArray.put(603, "x5installfail");
    eventNameSparseArray.put(604, "x5installtimeout");
    eventNameSparseArray.put(605, "preloadprocess");
    eventNameSparseArray.put(606, "pageshow");
    eventNameSparseArray.put(607, "pagehide");
    eventNameSparseArray.put(612, "pageclick");
    eventNameSparseArray.put(608, "onlaunchsucc");
    eventNameSparseArray.put(609, "onlaunchfail");
    eventNameSparseArray.put(610, "onlaunchtimeout");
    eventNameSparseArray.put(619, "appdownloadstart");
    eventNameSparseArray.put(620, "appdownloadend");
    eventNameSparseArray.put(621, "appunzipstart");
    eventNameSparseArray.put(622, "appunzipend");
    eventNameSparseArray.put(611, "domready");
    eventNameSparseArray.put(613, "subpkgdownloadstart");
    eventNameSparseArray.put(614, "subpkgdownloadend");
    eventNameSparseArray.put(615, "subpkgunpackstart");
    eventNameSparseArray.put(616, "subpkgunpackend");
    eventNameSparseArray.put(617, "basejsdownloadfailed");
    eventNameSparseArray.put(618, "basejsunzipfailed");
    eventNameSparseArray.put(623, "pageframeloadstart");
    eventNameSparseArray.put(624, "pageframeloadend");
    eventNameSparseArray.put(626, "preload_process_start");
    eventNameSparseArray.put(627, "preload_process_end");
    eventNameSparseArray.put(628, "http_request_result");
    eventNameSparseArray.put(629, "cpuPerformance");
    eventNameSparseArray.put(630, "fpsPerformance");
    eventNameSparseArray.put(631, "memoryPerformance");
    eventNameSparseArray.put(632, "web_socket_open");
    eventNameSparseArray.put(633, "web_socket_close");
    eventNameSparseArray.put(634, "web_socket_failure");
    eventNameSparseArray.put(642, "fpsVariance");
    eventNameSparseArray.put(643, "memoryGrowth");
    eventNameSparseArray.put(644, "miniappstaytime");
    eventNameSparseArray.put(636, "first_render_result");
    eventNameSparseArray.put(637, "re_render_result");
    eventNameSparseArray.put(638, "newpage_result");
    eventNameSparseArray.put(639, "storage_usage");
    eventNameSparseArray.put(640, "http_download");
    eventNameSparseArray.put(641, "http_upload");
    eventNameSparseArray.put(1001, "minigamebaselibloadso");
    eventNameSparseArray.put(1002, "minigamebaselibloadsoend");
    eventNameSparseArray.put(1003, "minigamebaselibloadjar");
    eventNameSparseArray.put(1004, "minigamebaselibloadjarend");
    eventNameSparseArray.put(1005, "minigamebaselibloadjs");
    eventNameSparseArray.put(1006, "minigamebaselibloadjsend");
    eventNameSparseArray.put(1007, "minigameloadmainpkg");
    eventNameSparseArray.put(1008, "minigameloadmainpkgend");
    eventNameSparseArray.put(1009, "minigameloadsubpkg");
    eventNameSparseArray.put(1010, "minigameloadsubpkgend");
    eventNameSparseArray.put(1011, "minigameprogresserror");
    eventNameSparseArray.put(1012, "minigamebaselibinstallskip");
    eventNameSparseArray.put(1013, "minigameenterloadingpage");
    eventNameSparseArray.put(1014, "minigameloadbaselib");
    eventNameSparseArray.put(1015, "minigameloadbaselibend");
    eventNameSparseArray.put(1016, "minigamefirsthide");
    eventNameSparseArray.put(1017, "minigamesurvival");
    eventNameSparseArray.put(1018, "minigameblackscreen");
    eventNameSparseArray.put(1019, "minigamenorefresh");
    eventNameSparseArray.put(1020, "minigamefirststaytime");
    eventNameSparseArray.put(1021, "minigamestaytime");
    eventNameSparseArray.put(1022, "minigamefirstlaunch");
    eventNameSparseArray.put(1023, "minigametwicelaunch");
    eventNameSparseArray.put(1024, "minigameerrordialog");
    eventNameSparseArray.put(1025, "capsulebuttoncloseclick");
    eventNameSparseArray.put(1026, "loadingpagecloseclick");
    eventNameSparseArray.put(1027, "minigameimagedownload");
    eventNameSparseArray.put(1028, "miniappstartbycache");
    eventNameSparseArray.put(1030, "stepstartactivity");
    eventNameSparseArray.put(1031, "steponcreate");
    eventNameSparseArray.put(1032, "stepinitdatamustonresume");
    eventNameSparseArray.put(1033, "steploadbaselibtimecost");
    eventNameSparseArray.put(1034, "stepinitjspluginlist");
    eventNameSparseArray.put(1035, "steponresume");
    eventNameSparseArray.put(1036, "steploadgpkg");
    eventNameSparseArray.put(1037, "stepinitruntime");
    eventNameSparseArray.put(1038, "stepinitjspluginengine");
    eventNameSparseArray.put(1039, "stepcreatesurfaceview");
    eventNameSparseArray.put(1040, "steplaunchgame");
    eventNameSparseArray.put(1042, "stepfirstframefromgamelaunched");
    eventNameSparseArray.put(1043, "stepfirstframefromcreate");
    eventNameSparseArray.put(1044, "download_with_cache");
    eventNeedRecordTime.add(Integer.valueOf(1));
    eventNeedRecordTime.add(Integer.valueOf(4));
    eventNeedRecordTime.add(Integer.valueOf(6));
    eventNeedRecordTime.add(Integer.valueOf(619));
    eventNeedRecordTime.add(Integer.valueOf(613));
    eventNeedRecordTime.add(Integer.valueOf(621));
    eventNeedRecordTime.add(Integer.valueOf(626));
    eventNeedRecordTime.add(Integer.valueOf(100));
    eventNeedRecordTime.add(Integer.valueOf(101));
    eventNeedRecordTime.add(Integer.valueOf(102));
    eventNeedRecordTime.add(Integer.valueOf(103));
    eventNeedRecordTime.add(Integer.valueOf(619));
    eventNeedRecordTime.add(Integer.valueOf(620));
    eventNeedRecordTime.add(Integer.valueOf(4));
    eventNeedRecordTime.add(Integer.valueOf(5));
    eventNeedRecordTime.add(Integer.valueOf(14));
    eventNeedRecordTime.add(Integer.valueOf(15));
    eventNeedRecordTime.add(Integer.valueOf(18));
    eventNeedRecordTime.add(Integer.valueOf(19));
    eventNeedRecordTime.add(Integer.valueOf(104));
    eventNeedRecordTime.add(Integer.valueOf(105));
    eventNeedRecordTime.add(Integer.valueOf(106));
    eventNeedRecordTime.add(Integer.valueOf(107));
    eventNeedRecordTime.add(Integer.valueOf(2));
    eventNeedRecordTime.add(Integer.valueOf(5));
    eventNeedRecordTime.add(Integer.valueOf(617));
    eventNeedRecordTime.add(Integer.valueOf(7));
    eventNeedRecordTime.add(Integer.valueOf(618));
    eventNeedRecordTime.add(Integer.valueOf(620));
    eventNeedRecordTime.add(Integer.valueOf(614));
    eventNeedRecordTime.add(Integer.valueOf(622));
    eventNeedRecordTime.add(Integer.valueOf(627));
    eventNeedRecordTime.add(Integer.valueOf(1022));
    eventNeedRecordTime.add(Integer.valueOf(1023));
    eventNeedRecordTime.add(Integer.valueOf(200));
    eventNeedRecordTime.add(Integer.valueOf(202));
    eventNeedRecordTime.add(Integer.valueOf(204));
    eventNeedRecordTime.add(Integer.valueOf(206));
    eventNeedRecordTime.add(Integer.valueOf(208));
    eventNeedRecordTime.add(Integer.valueOf(210));
    eventNeedRecordTime.add(Integer.valueOf(212));
    eventNeedRecordTime.add(Integer.valueOf(212));
    eventNeedRecordTime.add(Integer.valueOf(215));
    eventCostTimeSparseArray.put(2, new CostTimeRecord("launch_result", 1));
    eventCostTimeSparseArray.put(5, new CostTimeRecord("basejs_download_result", 4));
    eventCostTimeSparseArray.put(617, new CostTimeRecord("basejs_download_result", 4));
    eventCostTimeSparseArray.put(7, new CostTimeRecord("basejs_unzip_result", 6));
    eventCostTimeSparseArray.put(618, new CostTimeRecord("basejs_unzip_result", 6));
    eventCostTimeSparseArray.put(620, new CostTimeRecord("app_download_result", 619));
    eventCostTimeSparseArray.put(614, new CostTimeRecord("sub_download_result", 613));
    eventCostTimeSparseArray.put(622, new CostTimeRecord("app_unzip_result", 621));
    eventCostTimeSparseArray.put(627, new CostTimeRecord("preload_result", 626));
    eventCostTimeSparseArray.put(1022, new CostTimeRecord("game_first_launch_result", 1));
    eventCostTimeSparseArray.put(1023, new CostTimeRecord("game_twice_launch_result", 1));
    eventCostTimeSparseArray.put(201, new CostTimeRecord("runtime_create_task", 200));
    eventCostTimeSparseArray.put(203, new CostTimeRecord("runtime_init_task", 202));
    eventCostTimeSparseArray.put(205, new CostTimeRecord("base_lib_load_async_task", 204));
    eventCostTimeSparseArray.put(207, new CostTimeRecord("apkg_load_async_task", 206));
    eventCostTimeSparseArray.put(209, new CostTimeRecord("service_init_task", 208));
    eventCostTimeSparseArray.put(211, new CostTimeRecord("preload_flag_task", 210));
    eventCostTimeSparseArray.put(213, new CostTimeRecord("flutter_view_create", 212));
    eventCostTimeSparseArray.put(214, new CostTimeRecord("flutter_view_channel_init", 212));
    eventCostTimeSparseArray.put(216, new CostTimeRecord("flutter_launch_app", 215));
    eventNameToDC5332.add("launch_result");
    eventNameToDC5332.add("app_download_result");
    eventNameToDC5332.add("stepstartactivity");
    eventNameToDC5332.add("steponcreate");
    eventNameToDC5332.add("stepinitdatamustonresume");
    eventNameToDC5332.add("steploadbaselibtimecost");
    eventNameToDC5332.add("stepinitjspluginlist");
    eventNameToDC5332.add("steponresume");
    eventNameToDC5332.add("steploadgpkg");
    eventNameToDC5332.add("stepinitruntime");
    eventNameToDC5332.add("stepinitjspluginengine");
    eventNameToDC5332.add("stepcreatesurfaceview");
    eventNameToDC5332.add("stepfirstframefromgamelaunched");
    eventNameToDC5332.add("stepfirstframefromcreate");
    eventNameToDC5332.add("steplaunchgame");
  }
  
  public static void addCostTimeEventAttachInfo(MiniAppInfo paramMiniAppInfo, int paramInt, String paramString)
  {
    String str = "0000000000";
    if (paramMiniAppInfo != null) {
      str = paramMiniAppInfo.appId;
    }
    getLaunchState(str).attachInfo.put(Integer.valueOf(paramInt), paramString);
    QMLog.d("MiniReportManager", "addCostTimeEventAttachInfo:  mileStoneEventKey:" + paramInt + "   attachInfo:" + paramString);
  }
  
  private static void appendJsErrorToReportedList(MiniAppInfo paramMiniAppInfo, String paramString)
  {
    if ((paramMiniAppInfo != null) && (!TextUtils.isEmpty(paramMiniAppInfo.appId)) && (!TextUtils.isEmpty(paramString)))
    {
      if (APPID_JS_ERROR_MAP.get(paramMiniAppInfo.appId) == null) {
        APPID_JS_ERROR_MAP.put(paramMiniAppInfo.appId, new ArrayList());
      }
      ((List)APPID_JS_ERROR_MAP.get(paramMiniAppInfo.appId)).add(paramString);
    }
  }
  
  public static String getAppType(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo != null)
    {
      if (paramMiniAppInfo.isReportTypeMiniGame()) {
        return "1";
      }
      return "0";
    }
    return "0";
  }
  
  public static String getEventName(int paramInt)
  {
    return (String)eventNameSparseArray.get(paramInt);
  }
  
  public static JSONArray getLaunchPerformance(String paramString)
  {
    MiniAppLaunchState localMiniAppLaunchState = getLaunchState(paramString);
    paramString = new JSONArray();
    try
    {
      JSONObject localJSONObject;
      if (localMiniAppLaunchState.eventTime_first.size() > 0)
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("navigationStart", localMiniAppLaunchState.eventTime_first.get(Integer.valueOf(1)));
        localJSONObject.put("serviceStart", localMiniAppLaunchState.eventTime_first.get(Integer.valueOf(100)));
        localJSONObject.put("serviceEnd", localMiniAppLaunchState.eventTime_first.get(Integer.valueOf(101)));
        localJSONObject.put("viewStart", localMiniAppLaunchState.eventTime_first.get(Integer.valueOf(102)));
        localJSONObject.put("viewEnd", localMiniAppLaunchState.eventTime_first.get(Integer.valueOf(103)));
        localJSONObject.put("fetchPkgStart", localMiniAppLaunchState.eventTime_first.get(Integer.valueOf(619)));
        localJSONObject.put("fetchPkgEnd", localMiniAppLaunchState.eventTime_first.get(Integer.valueOf(620)));
        localJSONObject.put("fetchSdkStart", localMiniAppLaunchState.eventTime_first.get(Integer.valueOf(4)));
        localJSONObject.put("fetchSdkEnd", localMiniAppLaunchState.eventTime_first.get(Integer.valueOf(5)));
        localJSONObject.put("loadSdkServiceStart", localMiniAppLaunchState.eventTime_first.get(Integer.valueOf(14)));
        localJSONObject.put("loadSdkServiceEnd", localMiniAppLaunchState.eventTime_first.get(Integer.valueOf(15)));
        localJSONObject.put("loadSdkViewStart", localMiniAppLaunchState.eventTime_first.get(Integer.valueOf(18)));
        localJSONObject.put("loadSdkViewEnd", localMiniAppLaunchState.eventTime_first.get(Integer.valueOf(19)));
        localJSONObject.put("loadAppServiceStart", localMiniAppLaunchState.eventTime_first.get(Integer.valueOf(104)));
        localJSONObject.put("loadAppServiceEnd", localMiniAppLaunchState.eventTime_first.get(Integer.valueOf(105)));
        localJSONObject.put("loadAppViewStart", localMiniAppLaunchState.eventTime_first.get(Integer.valueOf(106)));
        localJSONObject.put("loadAppViewEnd", localMiniAppLaunchState.eventTime_first.get(Integer.valueOf(107)));
        paramString.put(localJSONObject);
      }
      if (localMiniAppLaunchState.eventTime.size() > 0)
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("navigationStart", localMiniAppLaunchState.eventTime.get(Integer.valueOf(1)));
        localJSONObject.put("serviceStart", localMiniAppLaunchState.eventTime.get(Integer.valueOf(100)));
        localJSONObject.put("serviceEnd", localMiniAppLaunchState.eventTime.get(Integer.valueOf(101)));
        localJSONObject.put("viewStart", localMiniAppLaunchState.eventTime.get(Integer.valueOf(102)));
        localJSONObject.put("viewEnd", localMiniAppLaunchState.eventTime.get(Integer.valueOf(103)));
        localJSONObject.put("fetchPkgStart", localMiniAppLaunchState.eventTime.get(Integer.valueOf(619)));
        localJSONObject.put("fetchPkgEnd", localMiniAppLaunchState.eventTime.get(Integer.valueOf(620)));
        localJSONObject.put("fetchSdkStart", localMiniAppLaunchState.eventTime.get(Integer.valueOf(4)));
        localJSONObject.put("fetchSdkEnd", localMiniAppLaunchState.eventTime.get(Integer.valueOf(5)));
        localJSONObject.put("loadSdkServiceStart", localMiniAppLaunchState.eventTime.get(Integer.valueOf(14)));
        localJSONObject.put("loadSdkServiceEnd", localMiniAppLaunchState.eventTime.get(Integer.valueOf(15)));
        localJSONObject.put("loadSdkViewStart", localMiniAppLaunchState.eventTime.get(Integer.valueOf(18)));
        localJSONObject.put("loadSdkViewEnd", localMiniAppLaunchState.eventTime.get(Integer.valueOf(19)));
        localJSONObject.put("loadAppServiceStart", localMiniAppLaunchState.eventTime.get(Integer.valueOf(104)));
        localJSONObject.put("loadAppServiceEnd", localMiniAppLaunchState.eventTime.get(Integer.valueOf(105)));
        localJSONObject.put("loadAppViewStart", localMiniAppLaunchState.eventTime.get(Integer.valueOf(106)));
        localJSONObject.put("loadAppViewEnd", localMiniAppLaunchState.eventTime.get(Integer.valueOf(107)));
        paramString.put(localJSONObject);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QMLog.e("MiniReportManager", "create performance result failed", localException);
      }
    }
    QMLog.e("MiniReportManager", "wesley: getformance: " + paramString.toString());
    return paramString;
  }
  
  public static MiniAppLaunchState getLaunchState(String paramString)
  {
    MiniAppLaunchState localMiniAppLaunchState2 = (MiniAppLaunchState)launchStateMap.get(paramString);
    MiniAppLaunchState localMiniAppLaunchState1 = localMiniAppLaunchState2;
    if (localMiniAppLaunchState2 == null)
    {
      localMiniAppLaunchState1 = new MiniAppLaunchState();
      localMiniAppLaunchState1.appId = paramString;
      launchStateMap.put(paramString, localMiniAppLaunchState1);
    }
    return localMiniAppLaunchState1;
  }
  
  private static boolean isJsErrorReported(MiniAppInfo paramMiniAppInfo, String paramString)
  {
    if ((paramMiniAppInfo == null) || (TextUtils.isEmpty(paramString))) {
      return true;
    }
    paramMiniAppInfo = (List)APPID_JS_ERROR_MAP.get(paramMiniAppInfo.appId);
    if (paramMiniAppInfo != null)
    {
      paramMiniAppInfo = paramMiniAppInfo.iterator();
      while (paramMiniAppInfo.hasNext()) {
        if (paramString.equals((String)paramMiniAppInfo.next())) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean needReportToDC5332(String paramString1, String paramString2, String paramString3)
  {
    if ((QUAUtil.isQQApp()) && ("1".equals(paramString1)) && (!"hot_start".equals(paramString3))) {
      return eventNameToDC5332.contains(paramString2);
    }
    return false;
  }
  
  public static void reportEventType(MiniAppInfo paramMiniAppInfo, int paramInt, String paramString)
  {
    reportEventType(paramMiniAppInfo, paramInt, null, null, null, 0, paramString, 0L, null, "", "", "", "");
  }
  
  public static void reportEventType(MiniAppInfo paramMiniAppInfo, int paramInt, String paramString, long paramLong)
  {
    reportEventType(paramMiniAppInfo, paramInt, null, null, null, 0, paramString, paramLong, null, "", "", "", "");
  }
  
  public static void reportEventType(MiniAppInfo paramMiniAppInfo, int paramInt, String paramString1, String paramString2)
  {
    reportEventType(paramMiniAppInfo, paramInt, null, paramString1, null, 0, paramString2, 0L, null, "", "", "", "");
  }
  
  public static void reportEventType(MiniAppInfo paramMiniAppInfo, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    reportEventType(paramMiniAppInfo, paramInt1, paramString1, paramString2, paramString3, paramInt2, getAppType(paramMiniAppInfo), 0L, null);
  }
  
  public static void reportEventType(MiniAppInfo paramMiniAppInfo, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, String paramString4, long paramLong, String paramString5)
  {
    reportEventType(paramMiniAppInfo, paramInt1, paramString1, paramString2, paramString3, paramInt2, paramString4, paramLong, paramString5, "", "", "", "");
  }
  
  public static void reportEventType(MiniAppInfo paramMiniAppInfo, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, String paramString4, long paramLong, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    long l2 = System.currentTimeMillis();
    Object localObject = "0000000000";
    if (paramMiniAppInfo != null) {
      localObject = paramMiniAppInfo.appId;
    }
    MiniAppLaunchState localMiniAppLaunchState = getLaunchState((String)localObject);
    int i;
    long l1;
    if (paramInt1 == 1) {
      if ((paramMiniAppInfo.isEngineTypeMiniApp()) && (paramMiniAppInfo.supportNativeRenderMode()))
      {
        i = 1;
        if (i == 0) {
          MiniAppStartState.reset((String)localObject);
        }
        if ((paramMiniAppInfo == null) || (paramMiniAppInfo.launchParam == null) || (paramMiniAppInfo.launchParam.launchClickTimeMillis == 0L)) {
          break label626;
        }
        l1 = paramMiniAppInfo.launchParam.launchClickTimeMillis;
        QMLog.d("MiniReportManager", "reportEventType: fix onlaunch timestamp to " + paramMiniAppInfo.launchParam.launchClickTimeMillis);
        label122:
        localMiniAppLaunchState.hasOnloaded = false;
        if (localMiniAppLaunchState.firstRender) {
          break label232;
        }
        localObject = getLaunchState("0000000000");
        if ((localObject != null) && (((MiniAppLaunchState)localObject).eventTime.size() > 0))
        {
          localMiniAppLaunchState.eventTime.putAll(((MiniAppLaunchState)localObject).eventTime);
          ((MiniAppLaunchState)localObject).eventTime.clear();
        }
      }
    }
    for (;;)
    {
      label187:
      if ((paramInt1 == 611) && (!localMiniAppLaunchState.hasOnloaded)) {
        paramInt1 = 2;
      }
      label588:
      label594:
      for (;;)
      {
        if (paramInt1 == 2) {
          if (localMiniAppLaunchState.hasOnloaded) {
            QMLog.d("MiniReportManager", "has report apponloaded. ignore apponloaed ");
          }
        }
        label232:
        label621:
        for (;;)
        {
          return;
          i = 0;
          break;
          if (localMiniAppLaunchState.eventTime_first.size() == 0) {
            localMiniAppLaunchState.eventTime_first.putAll(localMiniAppLaunchState.eventTime);
          }
          break label187;
          localMiniAppLaunchState.hasOnloaded = true;
          localMiniAppLaunchState.firstRender = true;
          if (eventNeedRecordTime.contains(Integer.valueOf(paramInt1))) {
            localMiniAppLaunchState.eventTime.put(Integer.valueOf(paramInt1), Long.valueOf(l1));
          }
          localObject = "";
          if (paramMiniAppInfo != null) {
            localObject = String.valueOf(paramMiniAppInfo.renderMode);
          }
          MiniProgramLpReportDC04266.report(paramMiniAppInfo, paramInt1, paramString1, paramString2, paramString3, paramInt2, paramString4, paramLong, paramString5, l1, paramString6, paramString7, paramString8, paramString9, (String)localObject);
          paramString2 = (CostTimeRecord)eventCostTimeSparseArray.get(paramInt1);
          if (paramString2 != null)
          {
            paramString3 = (Long)localMiniAppLaunchState.eventTime.get(Integer.valueOf(paramString2.eventStart));
            if (paramString3 == null) {
              break label588;
            }
            paramLong = paramString3.longValue();
            if (paramLong > 0L)
            {
              l2 -= paramLong;
              paramString2 = paramString2.eventName;
              paramString3 = (String)localMiniAppLaunchState.attachInfo.get(Integer.valueOf(paramInt1));
              if (l2 < 0L) {
                break label594;
              }
              paramLong = l2;
              if (l2 > MAX_TIME_COST) {
                paramLong = MAX_TIME_COST;
              }
              if (QMLog.isColorLevel()) {
                QMLog.e("MiniReportManager", "timeCostEvent;eventId:" + paramInt1 + ";costTime:" + paramLong + "ms");
              }
              MiniProgramLpReportDC04266.reportCostTimeEvent(paramMiniAppInfo, paramString2, paramString3, paramInt2, paramLong, l1, paramString6, paramString7, paramString8, paramString9, (String)localObject);
            }
          }
          for (;;)
          {
            if ((paramInt1 != 2) || (!"0".equals(paramString4))) {
              break label621;
            }
            MiniProgramLpReportDC04266.report(paramMiniAppInfo, 630, paramString1, "0", null, 0, paramString4, 0L, null, l1, "", "", "", "", (String)localObject);
            return;
            paramLong = 0L;
            break;
            QMLog.e("MiniReportManager", "costTime < 0 " + l2);
          }
        }
      }
      label626:
      l1 = l2;
      break label122;
      l1 = l2;
    }
  }
  
  public static void reportEventType(MiniAppInfo paramMiniAppInfo, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    reportEventType(paramMiniAppInfo, paramInt1, paramString1, paramString2, paramString3, paramInt2, getAppType(paramMiniAppInfo), 0L, null, paramString4, paramString5, paramString6, paramString7);
  }
  
  public static void reportEventType(MiniAppInfo paramMiniAppInfo, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    reportEventType(paramMiniAppInfo, paramInt, null, null, null, 0, paramString1, 0L, null, paramString2, paramString3, paramString4, paramString5);
  }
  
  public static void reportJsError(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    while (isJsErrorReported(paramMiniAppInfo, paramString2)) {
      return;
    }
    reportEventType(paramMiniAppInfo, 23, paramString1, paramString2, null, 0);
    appendJsErrorToReportedList(paramMiniAppInfo, paramString2);
  }
  
  static class CostTimeRecord
  {
    public String eventName;
    public int eventStart;
    
    public CostTimeRecord(String paramString, int paramInt)
    {
      this.eventName = paramString;
      this.eventStart = paramInt;
    }
  }
  
  public static class EventId
  {
    public static final int APKG_LOAD_ASYNC_TASK_END = 207;
    public static final int APKG_LOAD_ASYNC_TASK_START = 206;
    public static final int APP_CREATE = 24;
    public static final int APP_DOWNLOAD_END = 620;
    public static final int APP_DOWNLOAD_START = 619;
    public static final int APP_EXIT = 22;
    public static final int APP_FIRST_NEWPAGE_RESULT = 638;
    public static final int APP_FIRST_RENDER_RESULT = 636;
    public static final int APP_FIRST_RE_RENDER_RESULT = 637;
    public static final int APP_FIRST_STORAGE_USAGE = 639;
    public static final int APP_LOAD_END = 105;
    public static final int APP_LOAD_FAIL = 609;
    public static final int APP_LOAD_START = 104;
    public static final int APP_LOAD_SUCC = 608;
    public static final int APP_LOAD_TIMEOUT = 610;
    public static final int APP_STAY_DURATION = 644;
    public static final int APP_UNZIP_END = 622;
    public static final int APP_UNZIP_START = 621;
    public static final int BASE_JS_DOWNLOAD_END = 5;
    public static final int BASE_JS_DOWNLOAD_FAILED = 617;
    public static final int BASE_JS_DOWNLOAD_START = 4;
    public static final int BASE_JS_LOAD_END = 17;
    public static final int BASE_JS_LOAD_START = 16;
    public static final int BASE_JS_READ_END = 9;
    public static final int BASE_JS_READ_START = 8;
    public static final int BASE_JS_UNZIP_END = 7;
    public static final int BASE_JS_UNZIP_FAILED = 618;
    public static final int BASE_JS_UNZIP_START = 6;
    public static final int BASE_LIB_LOAD_ASYNC_TASK_END = 205;
    public static final int BASE_LIB_LOAD_ASYNC_TASK_START = 204;
    public static final int CAPSULE_BUTTON_CLOSE_CLICK = 1025;
    public static final int CPU_PERFORMANCE = 629;
    public static final int DOM_READY = 611;
    public static final int FLUTTER_LAUNCH_APP_END = 216;
    public static final int FLUTTER_LAUNCH_APP_START = 215;
    public static final int FLUTTER_MATCH_TIME_COST = 217;
    public static final int FLUTTER_RENDER_TIME_COST = 219;
    public static final int FLUTTER_SET_DATA_TIME_COST = 218;
    public static final int FLUTTER_TOTAL_TIME_COST = 220;
    public static final int FLUTTER_VIEW_CHANNEL_INIT_END = 214;
    public static final int FLUTTER_VIEW_CREATE_END = 213;
    public static final int FLUTTER_VIEW_INIT_START = 212;
    public static final int FPS_PERFORMANCE = 630;
    public static final int FPS_VARIANCE = 642;
    public static final int GET_APKG_INFO_END = 13;
    public static final int GET_APKG_INFO_START = 12;
    public static final int HIDE = 20;
    public static final int HTTP_DOWNLOAD = 640;
    public static final int HTTP_REQUEST_RESULT = 628;
    public static final int HTTP_UPLOAD = 641;
    public static final int JS_ERROR = 23;
    public static final int LAUNCH_END = 2;
    public static final int LAUNCH_START = 1;
    public static final int LOADING_PAGE_CLOSE_CLICK = 1026;
    public static final int MEMORY_GROWTH = 643;
    public static final int MEMORY_PERFORMANCE = 631;
    public static final int MINI_APP_DOWNLOAD_WITH_CACHE = 1044;
    public static final int MINI_APP_START_BY_CACHE = 1028;
    public static final int MINI_GAME_BASE_LIB_INSTALL_SKIP = 1012;
    public static final int MINI_GAME_BASE_LIB_LOAD_JAR = 1003;
    public static final int MINI_GAME_BASE_LIB_LOAD_JAR_END = 1004;
    public static final int MINI_GAME_BASE_LIB_LOAD_JS = 1005;
    public static final int MINI_GAME_BASE_LIB_LOAD_JS_END = 1006;
    public static final int MINI_GAME_BASE_LIB_LOAD_SO = 1001;
    public static final int MINI_GAME_BASE_LIB_LOAD_SO_END = 1002;
    public static final int MINI_GAME_BLACK_SCREEN = 1018;
    public static final int MINI_GAME_ENTER_LOADING_PAGE = 1013;
    public static final int MINI_GAME_ERROR_DIALOG = 1024;
    public static final int MINI_GAME_FIRST_LAUNCH = 1022;
    public static final int MINI_GAME_FIRST_STAY_DURATION = 1020;
    public static final int MINI_GAME_IMAGE_DOWNLOAD = 1027;
    public static final int MINI_GAME_LOAD_BASE_LIB = 1014;
    public static final int MINI_GAME_LOAD_BASE_LIB_END = 1015;
    public static final int MINI_GAME_LOAD_MAIN_PKG = 1007;
    public static final int MINI_GAME_LOAD_MAIN_PKG_END = 1008;
    public static final int MINI_GAME_LOAD_SUB_PKG = 1009;
    public static final int MINI_GAME_LOAD_SUB_PKG_END = 1010;
    public static final int MINI_GAME_NO_REFRESH = 1019;
    public static final int MINI_GAME_ON_FIRST_HIDE = 1016;
    public static final int MINI_GAME_PROGRESS_ERROR = 1011;
    public static final int MINI_GAME_STAY_DURATION = 1021;
    public static final int MINI_GAME_SURVIVAL = 1017;
    public static final int MINI_GAME_TWICE_LAUNCH = 1023;
    public static final int PAGE_CLICK = 612;
    public static final int PAGE_FRAME_LOAD_END = 624;
    public static final int PAGE_FRAME_LOAD_START = 623;
    public static final int PAGE_HIDE = 607;
    public static final int PAGE_SHOW = 606;
    public static final int PRELOAD_FLAG_TASK_END = 211;
    public static final int PRELOAD_FLAG_TASK_START = 210;
    public static final int PRELOAD_PROCESS = 605;
    public static final int PRELOAD_PROCESS_END = 627;
    public static final int PRELOAD_PROCESS_START = 626;
    public static final int RUNTIME_CREATE_TASK_END = 201;
    public static final int RUNTIME_CREATE_TASK_START = 200;
    public static final int RUNTIME_CREATE_TASK_START_REAL_TIME = 221;
    public static final int RUNTIME_INIT_TASK_END = 203;
    public static final int RUNTIME_INIT_TASK_START = 202;
    public static final int RUNTIME_INIT_TASK_START_REAL_TIME = 222;
    public static final int SERVICE_APP_END = 105;
    public static final int SERVICE_APP_START = 104;
    public static final int SERVICE_CREATE_END = 101;
    public static final int SERVICE_CREATE_START = 100;
    public static final int SERVICE_INIT_TASK_END = 209;
    public static final int SERVICE_INIT_TASK_START = 208;
    public static final int SERVICE_JS_LOAD_END = 15;
    public static final int SERVICE_JS_LOAD_START = 14;
    public static final int SERVICE_JS_READ_END = 11;
    public static final int SERVICE_JS_READ_START = 10;
    public static final int SHOW = 21;
    public static final int SSO_CMD_END = 601;
    public static final int SSO_CMD_START = 600;
    public static final int STEP_CREATE_SURFACEVIEW = 1039;
    public static final int STEP_FIRST_FRAME_FROM_CREATE = 1043;
    public static final int STEP_FIRST_FRAME_FROM_GAME_LAUNCHED = 1042;
    public static final int STEP_INIT_DATA_MUST_ONRESUME = 1032;
    public static final int STEP_INIT_JS_PLUGINLIST = 1034;
    public static final int STEP_INIT_JS_PLUGIN_ENGINE = 1038;
    public static final int STEP_INIT_RUNTIME = 1037;
    public static final int STEP_LAUNCH_GAME = 1040;
    public static final int STEP_LOAD_BASELIB = 1033;
    public static final int STEP_LOAD_GPKG = 1036;
    public static final int STEP_ONCREATE = 1031;
    public static final int STEP_ONRESUME = 1035;
    public static final int STEP_START_ACTIVITY = 1030;
    public static final int SUB_PACKAGE_DOWNLOAD_END = 614;
    public static final int SUB_PACKAGE_DOWNLOAD_START = 613;
    public static final int SUB_PACKAGE_UNPACK_END = 616;
    public static final int SUB_PACKAGE_UNPACK_START = 615;
    public static final int WEBVIEW_APP_END = 107;
    public static final int WEBVIEW_APP_START = 106;
    public static final int WEBVIEW_CREATE_END = 103;
    public static final int WEBVIEW_CREATE_START = 102;
    public static final int WEBVIEW_INIT = 625;
    public static final int WEBVIEW_JS_LOAD_END = 19;
    public static final int WEBVIEW_JS_LOAD_START = 18;
    public static final int WEB_SOCKET_CLOSE = 633;
    public static final int WEB_SOCKET_FAILURE = 634;
    public static final int WEB_SOCKET_OPEN = 632;
    public static final int X5_INSTALL_FAIL = 603;
    public static final int X5_INSTALL_SUCCESS = 602;
    public static final int X5_INSTALL_TIMEOUT = 604;
  }
  
  public static class EventName
  {
    public static final String APKG_DOWNLOAD_PIPELINE_END = "apkg_download_pipeline_end";
    public static final String APKG_DOWNLOAD_PIPELINE_RESULT = "apkg_download_pipeline_result";
    public static final String APKG_DOWNLOAD_PIPELINE_START = "apkg_download_pipeline_start";
    public static final String APP_CREATE = "appcreate";
    public static final String APP_DOWNLOAD_END = "appdownloadend";
    public static final String APP_DOWNLOAD_RESULT = "app_download_result";
    public static final String APP_DOWNLOAD_START = "appdownloadstart";
    public static final String APP_EMBEDDED_VIDEO = "miniappembeddedvideo";
    public static final String APP_EXIT = "apponunload";
    public static final String APP_FIRST_NEWPAGE_RESULT = "newpage_result";
    public static final String APP_FIRST_RENDER_RESULT = "first_render_result";
    public static final String APP_FIRST_RE_RENDER_RESULT = "re_render_result";
    public static final String APP_FIRST_STORAGE_USAGE = "storage_usage";
    public static final String APP_LOAD_END = "app_load_end";
    public static final String APP_LOAD_FAIL = "onlaunchfail";
    public static final String APP_LOAD_START = "app_load_start";
    public static final String APP_LOAD_SUCC = "onlaunchsucc";
    public static final String APP_LOAD_TIMEOUT = "onlaunchtimeout";
    public static final String APP_ROUTE_DONE = "app_route_done";
    public static final String APP_STAY_DURATION = "miniappstaytime";
    public static final String APP_UNZIP_END = "appunzipend";
    public static final String APP_UNZIP_RESULT = "app_unzip_result";
    public static final String APP_UNZIP_START = "appunzipstart";
    public static final String BASEJS_DOWNLOAD_RESULT = "basejs_download_result";
    public static final String BASEJS_UNZIP_RESULT = "basejs_unzip_result";
    public static final String BASE_JS_DOWNLOAD_END = "basejsdownloadend";
    public static final String BASE_JS_DOWNLOAD_FAILED = "basejsdownloadfailed";
    public static final String BASE_JS_DOWNLOAD_START = "basejsdownloadstart";
    public static final String BASE_JS_LOAD_END = "basejsready";
    public static final String BASE_JS_LOAD_START = "basejsstart";
    public static final String BASE_JS_READ_END = "basejsreadend";
    public static final String BASE_JS_READ_START = "basejsreadstart";
    public static final String BASE_JS_UNZIP_END = "basejsunzipend";
    public static final String BASE_JS_UNZIP_FAILED = "basejsunzipfailed";
    public static final String BASE_JS_UNZIP_START = "basejsunzipstart";
    public static final String CAPSULE_BUTTON_CLOSE_CLICK = "capsulebuttoncloseclick";
    public static final String CPU_PERFORMANCE = "cpuPerformance";
    public static final String DOM_READY = "domready";
    public static final String FPS_PERFORMANCE = "fpsPerformance";
    public static final String FPS_VARIANCE = "fpsVariance";
    public static final String GAME_AFTER_LAUNCH_TIME_COST = "game_after_launch_time_cost";
    public static final String GAME_FIRST_LAUNCH_RESULT = "game_first_launch_result";
    public static final String GAME_TWICE_LAUNCH_RESULT = "game_twice_launch_result";
    public static final String GET_APKG_INFO_END = "appconfigreadend";
    public static final String GET_APKG_INFO_START = "appconfigreadstart";
    public static final String HIDE = "apponhide";
    public static final String HTTP_DOWNLOAD = "http_download";
    public static final String HTTP_REQUEST_RESULT = "http_request_result";
    public static final String HTTP_UPLOAD = "http_upload";
    public static final String JS_ERROR = "jsonerror";
    public static final String LAUNCH_END = "apponloaded";
    public static final String LAUNCH_RESULT = "launch_result";
    public static final String LAUNCH_START = "onlaunch";
    public static final String LOADING_PAGE_CLOSE_CLICK = "loadingpagecloseclick";
    public static final String MEMORY_GROWTH = "memoryGrowth";
    public static final String MEMORY_PERFORMANCE = "memoryPerformance";
    public static final String MINI_APP_DOWNLOAD_WITH_CACHE = "download_with_cache";
    public static final String MINI_APP_START_BY_CACHE = "miniappstartbycache";
    public static final String MINI_GAME_BASE_LIB_INSTALL_SKIP = "minigamebaselibinstallskip";
    public static final String MINI_GAME_BASE_LIB_LOAD_JAR = "minigamebaselibloadjar";
    public static final String MINI_GAME_BASE_LIB_LOAD_JAR_END = "minigamebaselibloadjarend";
    public static final String MINI_GAME_BASE_LIB_LOAD_JS = "minigamebaselibloadjs";
    public static final String MINI_GAME_BASE_LIB_LOAD_JS_END = "minigamebaselibloadjsend";
    public static final String MINI_GAME_BASE_LIB_LOAD_SO = "minigamebaselibloadso";
    public static final String MINI_GAME_BASE_LIB_LOAD_SO_END = "minigamebaselibloadsoend";
    public static final String MINI_GAME_BLACK_SCREEN = "minigameblackscreen";
    public static final String MINI_GAME_ENTER_LOADING_PAGE = "minigameenterloadingpage";
    public static final String MINI_GAME_ERROR_DIALOG = "minigameerrordialog";
    public static final String MINI_GAME_FIRST_LAUNCH = "minigamefirstlaunch";
    public static final String MINI_GAME_FIRST_STAY_DURATION = "minigamefirststaytime";
    public static final String MINI_GAME_IMAGE_DOWNLOAD = "minigameimagedownload";
    public static final String MINI_GAME_LOADSUBPACKAGE_IMPOSSIBLE = "minigameloadsubpack_impossible";
    public static final String MINI_GAME_LOAD_BASE_LIB = "minigameloadbaselib";
    public static final String MINI_GAME_LOAD_BASE_LIB_END = "minigameloadbaselibend";
    public static final String MINI_GAME_LOAD_MAIN_PKG = "minigameloadmainpkg";
    public static final String MINI_GAME_LOAD_MAIN_PKG_END = "minigameloadmainpkgend";
    public static final String MINI_GAME_LOAD_SUB_PKG = "minigameloadsubpkg";
    public static final String MINI_GAME_LOAD_SUB_PKG_END = "minigameloadsubpkgend";
    public static final String MINI_GAME_NO_REFRESH = "minigamenorefresh";
    public static final String MINI_GAME_ON_FIRST_HIDE = "minigamefirsthide";
    public static final String MINI_GAME_PROGRESS_ERROR = "minigameprogresserror";
    public static final String MINI_GAME_STAY_DURATION = "minigamestaytime";
    public static final String MINI_GAME_SURVIVAL = "minigamesurvival";
    public static final String MINI_GAME_TWICE_LAUNCH = "minigametwicelaunch";
    public static final String PAGE_CLICK = "pageclick";
    public static final String PAGE_FRAME_LOAD_END = "pageframeloadend";
    public static final String PAGE_FRAME_LOAD_START = "pageframeloadstart";
    public static final String PAGE_HIDE = "pagehide";
    public static final String PAGE_JS_END = "page_js_end";
    public static final String PAGE_JS_START = "page_js_start";
    public static final String PAGE_SHOW = "pageshow";
    public static final String PRELOAD_PROCESS = "preloadprocess";
    public static final String PRELOAD_PROCESS_END = "preload_process_end";
    public static final String PRELOAD_PROCESS_START = "preload_process_start";
    public static final String PRELOAD_RESULT = "preload_result";
    public static final String SERVICE_APP_END = "service_app_end";
    public static final String SERVICE_APP_START = "service_app_start";
    public static final String SERVICE_END = "service_end";
    public static final String SERVICE_JS_LOAD_END = "servicejsend";
    public static final String SERVICE_JS_LOAD_START = "servicejsstart";
    public static final String SERVICE_START = "service_start";
    public static final String SHOW = "apponshow";
    public static final String SSO_CMD_END = "ssocmdend";
    public static final String SSO_CMD_START = "ssocmdstart";
    public static final String STEP_CREATE_SURFACEVIEW = "stepcreatesurfaceview";
    public static final String STEP_FIRST_FRAME_FROM_CREATE = "stepfirstframefromcreate";
    public static final String STEP_FIRST_FRAME_FROM_GAME_LAUNCHED = "stepfirstframefromgamelaunched";
    public static final String STEP_INIT_DATA_MUST_ONRESUME = "stepinitdatamustonresume";
    public static final String STEP_INIT_JS_PLUGINLIST = "stepinitjspluginlist";
    public static final String STEP_INIT_JS_PLUGIN_ENGINE = "stepinitjspluginengine";
    public static final String STEP_INIT_RUNTIME = "stepinitruntime";
    public static final String STEP_LAUNCH_GAME = "steplaunchgame";
    public static final String STEP_LOAD_BASELIB = "steploadbaselibtimecost";
    public static final String STEP_LOAD_GPKG = "steploadgpkg";
    public static final String STEP_ONCREATE = "steponcreate";
    public static final String STEP_ONRESUME = "steponresume";
    public static final String STEP_START_ACTIVITY = "stepstartactivity";
    public static final String SUB_DOWNLOAD_RESULT = "sub_download_result";
    public static final String SUB_PACKAGE_DOWNLOAD_END = "subpkgdownloadend";
    public static final String SUB_PACKAGE_DOWNLOAD_START = "subpkgdownloadstart";
    public static final String SUB_PACKAGE_UNPACK_END = "subpkgunpackend";
    public static final String SUB_PACKAGE_UNPACK_START = "subpkgunpackstart";
    public static final String WEBVIEW_APP_END = "webview_app_end";
    public static final String WEBVIEW_APP_START = "webview_app_start";
    public static final String WEBVIEW_CREATE_END = "webview_end";
    public static final String WEBVIEW_JS_LOAD_END = "webviewjsready";
    public static final String WEBVIEW_JS_LOAD_START = "webviewjsstart";
    public static final String WEBVIEW_START = "webview_start";
    public static final String WEB_SOCKET_CLOSE = "web_socket_close";
    public static final String WEB_SOCKET_FAILURE = "web_socket_failure";
    public static final String WEB_SOCKET_OPEN = "web_socket_open";
    public static final String X5_INSTALL_FAIL = "x5installfail";
    public static final String X5_INSTALL_SUCCESS = "x5installsuccess";
    public static final String X5_INSTALL_TIMEOUT = "x5installtimeout";
  }
  
  public static class MiniAppLaunchState
  {
    public String appId;
    public Map<Integer, String> attachInfo = new HashMap();
    public Map<Integer, Long> eventTime = new HashMap();
    public Map<Integer, Long> eventTime_first = new HashMap();
    public boolean firstRender = false;
    public boolean hasOnloaded = false;
  }
  
  public static class RESERVES4
  {
    public static final String COLD_START = "cold_start";
    public static final String HOT_START = "hot_start";
  }
  
  public static class Value
  {
    public static final String MINI_APP_START_BY_ID_CACHE = "id_cache";
    public static final String MINI_APP_START_BY_LINK_CACHE = "link_cache";
    public static final String MINI_APP_START_BY_SHOW_CACHE = "show_cache";
    public static final String MINI_APP_START_IN_MAIN_LOADING = "main_loading";
    public static final String PKG_DOWNLOAD = "1";
    public static final String PKG_NO_DOWNLOAD = "0";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniReportManager
 * JD-Core Version:    0.7.0.1
 */