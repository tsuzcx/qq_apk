package com.tencent.qqmini.sdk.report;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.AppBrandUtil;
import com.tencent.qqmini.sdk.entry.MiniAppExposureManager.BaseExposureReport;
import com.tencent.qqmini.sdk.entry.MiniAppExposureManager.MiniAppExposureData;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class SDKMiniProgramLpReportDC04239
{
  public static final String AD_ACTION = "ad";
  public static final String AD_RESERVES_CLICK = "click";
  public static final String AD_RESERVES_EXPO_CALL = "expo_call";
  public static final String AD_RESERVES_EXPO_SUCC = "expo_success";
  public static final String AD_RESERVES_PRELOAD_CALL = "preload_call";
  public static final String AD_RESERVES_PRELOAD_FAIL = "preload_fail";
  public static final String AD_RESERVES_PRELOAD_SUCC = "preload_success";
  public static final String AD_RESERVES_REQUEST_CALL_CNT = "request_call_cnt";
  public static final String AD_RESERVES_REQUEST_SUCC_OFFLINE = "request_success_offline";
  public static final String AD_RESERVES_REQUEST_SUCC_ONLINE = "request_success_online";
  public static final String AD_RESERVES_REQUEST_TIMEOUT = "request_timeout";
  public static final String AD_RESERVES_SKIP = "skip";
  public static final String AD_SUB_ACTION_LOADING_AD = "ad_loading";
  public static final String APP_TYPE_MINI_APP = "0";
  public static final String APP_TYPE_MINI_GAME = "1";
  public static final String ARK_ACTION = "ark";
  public static final String ARK_SUB_ACTION_BATTLE = "ark_battle";
  public static final String DESKTOP_ACTION = "desktop";
  public static final String DROP_DOWN_ACTION = "drop_down";
  public static final String DROP_DOWN_RESERVERS_DELETE = "delete";
  public static final String DROP_DOWN_RESERVERS_SETTOP_OFF = "settop_off";
  public static final String DROP_DOWN_RESERVERS_SETTOP_ON = "settop_on";
  public static final String DROP_DOWN_SUB_ACTION_CONTACT = "contact";
  public static final String DROP_DOWN_SUB_ACTION_MESSAGE = "message";
  public static final String DROP_DOWN_SUB_ACTION_MORE = "more";
  public static final String GAME_INNER_ACTION = "game_inner";
  public static final String INNER_SUB_ACTION_LOGIN = "login";
  public static final String INNER_SUB_ACTION_REGISTER = "regist";
  public static final String KEY_ACTION_TYPE = "actiontype";
  public static final String KEY_RESERVES_ACTION = "reserves_action";
  public static final String KEY_SUB_ACTION_TYPE = "sub_actiontype";
  public static final String MORE_ABOUT_RESERVERS_FEEDBACK = "feedback";
  public static final String MORE_ABOUT_RESERVERS_LAUNCH = "launch";
  public static final String MORE_ABOUT_RESERVERS_LIKE_OFF = "like_off";
  public static final String MORE_ABOUT_RESERVERS_LIKE_ON = "like_on";
  public static final String MORE_ABOUT_RESERVERS_PROFILE = "profile";
  public static final String MORE_ABOUT_RESERVERS_REPORT = "report";
  public static final String MORE_ABOUT_RESERVERS_SET = "set";
  public static final String MORE_ABOUT_RESERVERS_SETTOP_OFF = "settop_off";
  public static final String MORE_ABOUT_RESERVERS_SETTOP_ON = "settop_on";
  public static final String MORE_ABOUT_RESERVERS_SHARE = "share";
  public static final String MORE_BUTTON_RESERVERS_ABOUT = "about";
  public static final String MORE_BUTTON_RESERVERS_BACK_HOME = "back_home";
  public static final String MORE_BUTTON_RESERVERS_CANCEL = "cancel";
  public static final String MORE_BUTTON_RESERVERS_CANCEL_SYSTEM = "cancel_system";
  public static final String MORE_BUTTON_RESERVERS_MESSAGE = "message";
  public static final String MORE_BUTTON_RESERVERS_OPEN = "open";
  public static final String MORE_BUTTON_RESERVERS_SETTOP_OFF = "settop_off";
  public static final String MORE_BUTTON_RESERVERS_SETTOP_ON = "settop_on";
  public static final String MORE_BUTTON_RESERVERS_SHARE_Moments = "share_Moments";
  public static final String MORE_BUTTON_RESERVERS_SHARE_OTHER = "share_";
  public static final String MORE_BUTTON_RESERVERS_SHARE_QQ = "share_QQ";
  public static final String MORE_BUTTON_RESERVERS_SHARE_QZ = "share_QZ";
  public static final String MORE_BUTTON_RESERVERS_SHARE_WX = "share_WX";
  public static final String MORE_BUTTON_RESERVERS_SHORTCUT = "add_desktop";
  public static final String PAGE_VIEW_ACTION = "page_view";
  public static final String PAGE_VIEW_SUB_ACTION_CLICK = "click";
  public static final String PAGE_VIEW_SUB_ACTION_CLOSE = "close";
  public static final String PAGE_VIEW_SUB_ACTION_EXPO = "expo";
  public static final String PAGE_VIEW_SUB_ACTION_FINISHSHOW = "finishshow";
  public static final String PAGE_VIEW_SUB_ACTION_HIDE = "hide";
  public static final String PAGE_VIEW_SUB_ACTION_LOAD = "load";
  public static final String PAGE_VIEW_SUB_ACTION_LOAD_FAIL = "load_fail";
  public static final String PAGE_VIEW_SUB_ACTION_SHOW = "show";
  public static final String PAGE_VIEW_SUB_ACTION_SHOW_FAIL = "show_fail";
  public static final String PAGE_VIEW_SUB_ACTION_UNLOAD = "unload";
  public static final String SHARE_ALERT_RESERVERS_ACTION = "show";
  public static final String SYS_ALERT_ACTION = "sys_alert";
  private static final String TAG = "MiniProgramLpReportDC04239";
  public static final String USER_CLICK_ACTION = "user_click";
  public static final String USER_CLICK_SUB_ACTION_MORE_ABOUT = "more_about";
  public static final String USER_CLICK_SUB_ACTION_MORE_BUTTON = "more_button";
  public static final String USER_CLICK_SUB_ACTION_SHARE_ALERT = "share_alert";
  private static long mRecordDurationInterval = 5000L;
  private static Runnable recordDurationRunnable = new SDKMiniProgramLpReportDC04239.1();
  private static MiniAppInfo showMiniAppConfig;
  
  public static void deleteRecordDurationMsg()
  {
    if (((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).isDebugVersion()) {
      QMLog.i("MiniProgramLpReportDC04239", "deleteRecordDurationMsg");
    }
    MiniProgramReporter.getInstance().getReportHandler().removeCallbacks(recordDurationRunnable);
  }
  
  public static void exposureReport(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(MiniProgramReportHelper.newUserInfoEntries());
    String str = AppBrandUtil.getUrlWithoutParams(paramString2);
    if ((paramMiniAppInfo != null) && (paramMiniAppInfo.launchParam != null))
    {
      paramString2 = String.valueOf(paramMiniAppInfo.launchParam.scene);
      localArrayList.addAll(MiniProgramReportHelper.newBusinessEntries(paramMiniAppInfo, str, paramString2, paramString3, paramString4, paramString5, paramString6, null, null, null, null, paramString1, ""));
      localArrayList.addAll(MiniProgramReportHelper.newGenericEntries());
      if ((paramMiniAppInfo != null) && (paramMiniAppInfo.reportData != null) && (!TextUtils.isEmpty(paramMiniAppInfo.reportData))) {
        localArrayList.addAll(MiniProgramReportHelper.newReportEntries(paramMiniAppInfo.reportData));
      }
      if (!QUAUtil.isQQApp())
      {
        localArrayList.addAll(MiniProgramReportHelper.newThirdSourceEntries());
        localArrayList.add(MiniProgramReportHelper.newEntry("customInfo", paramMiniAppInfo.customInfo));
      }
      if ((!QUAUtil.isQQApp()) && (!QUAUtil.isMicroApp())) {
        break label197;
      }
    }
    label197:
    for (int i = 2;; i = 12)
    {
      paramMiniAppInfo = MiniProgramReportHelper.newSingleReportData(i, localArrayList, null);
      MiniProgramReporter.getInstance().addData(paramMiniAppInfo);
      return;
      paramString2 = null;
      break;
    }
  }
  
  private static void exposureReport(String paramString1, String paramString2, String paramString3)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(MiniProgramReportHelper.newUserInfoEntries());
    localArrayList.addAll(MiniProgramReportHelper.newBaseBusinessEntries(paramString1, paramString2, paramString3, null, null, null, null));
    localArrayList.addAll(MiniProgramReportHelper.newGenericEntries());
    if (!QUAUtil.isQQApp()) {
      localArrayList.addAll(MiniProgramReportHelper.newThirdSourceEntries());
    }
    if ((QUAUtil.isQQApp()) || (QUAUtil.isMicroApp())) {}
    for (int i = 2;; i = 12)
    {
      paramString1 = MiniProgramReportHelper.newSingleReportData(i, localArrayList, null);
      MiniProgramReporter.getInstance().addData(paramString1);
      MiniProgramReporter.getInstance().flush();
      return;
    }
  }
  
  public static void exposureReport(List<MiniAppExposureManager.BaseExposureReport> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return;
    }
    MiniProgramReporter.getInstance().getReportHandler().post(new SDKMiniProgramLpReportDC04239.14(paramList));
  }
  
  public static void gameInnerReport(MiniAppInfo paramMiniAppInfo, JSONObject paramJSONObject)
  {
    MiniProgramReporter.getInstance().getReportHandler().post(new SDKMiniProgramLpReportDC04239.8(paramJSONObject, paramMiniAppInfo));
  }
  
  private static String getAppId(MiniAppInfo paramMiniAppInfo)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramMiniAppInfo != null)
    {
      localObject1 = localObject2;
      if (paramMiniAppInfo.launchParam != null) {
        localObject1 = paramMiniAppInfo.launchParam.miniAppId;
      }
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = paramMiniAppInfo.appId;
    }
    return localObject2;
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
  
  private static String getDurationKey(String paramString1, String paramString2)
  {
    return paramString1 + "_" + paramString2 + "_duration";
  }
  
  private static SharedPreferences getDurationSp(String paramString1, String paramString2)
  {
    return AppLoaderFactory.g().getMiniAppEnv().getContext().getSharedPreferences(paramString1 + "_" + paramString2, 0);
  }
  
  public static boolean isLifeCycle(String paramString)
  {
    return ("click".equals(paramString)) || ("load".equals(paramString)) || ("load_fail".equals(paramString)) || ("show".equals(paramString)) || ("show_fail".equals(paramString)) || ("finishshow".equals(paramString)) || ("hide".equals(paramString)) || ("unload".equals(paramString)) || ("close".equals(paramString));
  }
  
  public static void recordDuration(MiniAppInfo paramMiniAppInfo, long paramLong)
  {
    ThreadManager.executeOnComputationThreadPool(new SDKMiniProgramLpReportDC04239.15(paramMiniAppInfo, paramLong));
  }
  
  private static void report(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(MiniProgramReportHelper.newUserInfoEntries());
    String str1 = "0";
    if (paramMiniAppInfo != null) {
      str1 = getAppType(paramMiniAppInfo);
    }
    String str2;
    if ((paramMiniAppInfo != null) && (paramMiniAppInfo.launchParam != null))
    {
      str2 = String.valueOf(paramMiniAppInfo.launchParam.scene);
      localArrayList.addAll(MiniProgramReportHelper.newBusinessEntries(paramMiniAppInfo, null, str2, paramString1, paramString2, paramString3, paramString4, null, null, null, null, str1, ""));
      localArrayList.addAll(MiniProgramReportHelper.newGenericEntries());
      if (!QUAUtil.isQQApp())
      {
        localArrayList.addAll(MiniProgramReportHelper.newThirdSourceEntries());
        localArrayList.add(MiniProgramReportHelper.newEntry("customInfo", paramMiniAppInfo.customInfo));
      }
      if ((!QUAUtil.isQQApp()) && (!QUAUtil.isMicroApp())) {
        break label176;
      }
    }
    label176:
    for (int i = 2;; i = 12)
    {
      paramMiniAppInfo = MiniProgramReportHelper.newSingleReportData(i, localArrayList, null);
      MiniProgramReporter.getInstance().addData(paramMiniAppInfo);
      MiniProgramReporter.getInstance().flush();
      return;
      str2 = null;
      break;
    }
  }
  
  private static void report(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    report(paramMiniAppInfo, paramString1, paramString2, paramString3, paramString4, paramString5, "", null, null, null, null);
  }
  
  public static void report(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
  {
    if ((isLifeCycle(paramString4)) && (!MiniAppReportManager2.isMainProcess))
    {
      MiniProgramReporter.getInstance().getReportHandler().post(new SDKMiniProgramLpReportDC04239.11(paramMiniAppInfo, paramString3, paramString4, paramString2, paramString5, paramString6, paramString1));
      if (("unload".equals(paramString4)) || ("close".equals(paramString4)) || ("hide".equals(paramString4)) || ("finishshow".equals(paramString4)) || ("sys_alert".equals(paramString3)))
      {
        MiniProgramReporter.getInstance().flush();
        if (((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).isDebugVersion()) {
          QMLog.d("MiniProgramLpReportDC04239", "reportPageView() called flush()");
        }
      }
      if (!"show".equals(paramString4)) {
        break label309;
      }
      showMiniAppConfig = paramMiniAppInfo;
      sendRecordDurationMsg();
    }
    label185:
    while ((!"unload".equals(paramString4)) && (!"hide".equals(paramString4)) && (!"close".equals(paramString4)))
    {
      return;
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(MiniProgramReportHelper.newUserInfoEntries());
      String str = AppBrandUtil.getUrlWithoutParams(paramString2);
      if ((paramMiniAppInfo != null) && (paramMiniAppInfo.launchParam != null))
      {
        paramString2 = String.valueOf(paramMiniAppInfo.launchParam.scene);
        localArrayList.addAll(MiniProgramReportHelper.newBusinessEntries(paramMiniAppInfo, str, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString1, null));
        localArrayList.addAll(MiniProgramReportHelper.newGenericEntries());
        if (!QUAUtil.isQQApp())
        {
          localArrayList.addAll(MiniProgramReportHelper.newThirdSourceEntries());
          localArrayList.add(MiniProgramReportHelper.newEntry("customInfo", paramMiniAppInfo.customInfo));
        }
        if ((!QUAUtil.isQQApp()) && (!QUAUtil.isMicroApp())) {
          break label302;
        }
      }
      for (int i = 2;; i = 12)
      {
        paramString1 = MiniProgramReportHelper.newSingleReportData(i, localArrayList, null);
        MiniProgramReporter.getInstance().addData(paramString1);
        break;
        paramString2 = null;
        break label185;
      }
    }
    label302:
    label309:
    deleteRecordDurationMsg();
  }
  
  private static void report(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    report(paramString1, paramString2, paramString3, paramString4, null, null);
  }
  
  private static void report(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(MiniProgramReportHelper.newUserInfoEntries());
    localArrayList.addAll(MiniProgramReportHelper.newBaseBusinessEntries(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, null));
    localArrayList.addAll(MiniProgramReportHelper.newGenericEntries());
    if (!QUAUtil.isQQApp()) {
      localArrayList.addAll(MiniProgramReportHelper.newThirdSourceEntries());
    }
    if ((QUAUtil.isQQApp()) || (QUAUtil.isMicroApp())) {}
    for (int i = 2;; i = 12)
    {
      paramString1 = MiniProgramReportHelper.newSingleReportData(i, localArrayList, null);
      MiniProgramReporter.getInstance().addData(paramString1);
      MiniProgramReporter.getInstance().flush();
      return;
    }
  }
  
  public static void report(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(MiniProgramReportHelper.newUserInfoEntries());
    localArrayList.addAll(MiniProgramReportHelper.newBaseBusinessEntries(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, null));
    localArrayList.addAll(MiniProgramReportHelper.newGenericEntries());
    if (!QUAUtil.isQQApp()) {
      localArrayList.addAll(MiniProgramReportHelper.newThirdSourceEntries());
    }
    if ((QUAUtil.isQQApp()) || (QUAUtil.isMicroApp())) {}
    for (int i = 2;; i = 12)
    {
      paramString1 = MiniProgramReportHelper.newSingleReportData(i, localArrayList, null);
      MiniProgramReporter.getInstance().addData(paramString1);
      if (paramBoolean) {
        MiniProgramReporter.getInstance().flush();
      }
      return;
    }
  }
  
  public static void reportApiInvoke(MiniAppInfo paramMiniAppInfo, String paramString)
  {
    MiniProgramReporter.getInstance().getReportHandler().post(new SDKMiniProgramLpReportDC04239.9(paramString, paramMiniAppInfo));
  }
  
  public static void reportAsync(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    MiniProgramReporter.getInstance().getReportHandler().post(new SDKMiniProgramLpReportDC04239.7(paramMiniAppInfo, paramString1, paramString2, paramString3, paramString4));
  }
  
  public static void reportAsync(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    reportAsync(paramString1, paramString2, paramString3, paramString4, null, null);
  }
  
  public static void reportAsync(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    MiniProgramReporter.getInstance().getReportHandler().post(new SDKMiniProgramLpReportDC04239.6(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6));
  }
  
  public static void reportByQQ(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(MiniProgramReportHelper.newUserInfoEntries());
    localArrayList.addAll(MiniProgramReportHelper.newBaseBusinessEntries(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7));
    localArrayList.addAll(MiniProgramReportHelper.newGenericEntries());
    if (!QUAUtil.isQQApp()) {
      localArrayList.addAll(MiniProgramReportHelper.newThirdSourceEntries());
    }
    if ((QUAUtil.isQQApp()) || (QUAUtil.isMicroApp())) {}
    for (int i = 2;; i = 12)
    {
      paramString1 = MiniProgramReportHelper.newSingleReportData(i, localArrayList, null);
      MiniProgramReporter.getInstance().addData(paramString1);
      MiniProgramReporter.getInstance().flush();
      return;
    }
  }
  
  public static void reportByQQqunInfo(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(MiniProgramReportHelper.newUserInfoEntries());
    localArrayList.addAll(MiniProgramReportHelper.newQQqunInfoBusinessEntries(paramString1, paramString2, paramString3, paramString4));
    localArrayList.addAll(MiniProgramReportHelper.newGenericEntries());
    if (!QUAUtil.isQQApp()) {
      localArrayList.addAll(MiniProgramReportHelper.newThirdSourceEntries());
    }
    if ((QUAUtil.isQQApp()) || (QUAUtil.isMicroApp())) {}
    for (int i = 2;; i = 12)
    {
      paramString1 = MiniProgramReportHelper.newSingleReportData(i, localArrayList, null);
      MiniProgramReporter.getInstance().addData(paramString1);
      MiniProgramReporter.getInstance().flush();
      return;
    }
  }
  
  public static void reportByQQqunInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    paramString1 = new ArrayList();
    paramString1.addAll(MiniProgramReportHelper.newUserInfoEntries());
    paramString1.addAll(MiniProgramReportHelper.newQQqunInfoBusinessEntries(paramString5, paramString6, paramString7, paramString8));
    paramString1.addAll(MiniProgramReportHelper.newGenericEntries());
    if (!QUAUtil.isQQApp()) {
      paramString1.addAll(MiniProgramReportHelper.newThirdSourceEntries());
    }
    if ((QUAUtil.isQQApp()) || (QUAUtil.isMicroApp())) {}
    for (int i = 2;; i = 12)
    {
      paramString1 = MiniProgramReportHelper.newSingleReportData(i, paramString1, null);
      MiniProgramReporter.getInstance().addData(paramString1);
      MiniProgramReporter.getInstance().flush();
      return;
    }
  }
  
  public static void reportDropDown(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2)
  {
    MiniProgramReporter.getInstance().getReportHandler().post(new SDKMiniProgramLpReportDC04239.12(paramMiniAppInfo, paramString1, paramString2));
  }
  
  public static void reportForSDK(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    MiniProgramReporter.getInstance().getReportHandler().post(new SDKMiniProgramLpReportDC04239.10(paramMiniAppInfo, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6));
  }
  
  public static void reportMiniAppEvent(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    reportMiniAppEvent(paramMiniAppInfo, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, null);
  }
  
  public static void reportMiniAppEvent(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    MiniProgramReporter.getInstance().getReportHandler().post(new SDKMiniProgramLpReportDC04239.3(paramString3, paramString4, paramString5, paramString1, paramMiniAppInfo, paramString2, paramString6, paramString7));
  }
  
  public static void reportPageView(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    MiniProgramReporter.getInstance().getReportHandler().post(new SDKMiniProgramLpReportDC04239.4(paramString3, paramString4, paramString1, paramMiniAppInfo, paramString2));
  }
  
  public static void reportPageView(String paramString1, String paramString2)
  {
    MiniProgramReporter.getInstance().getReportHandler().post(new SDKMiniProgramLpReportDC04239.5(paramString1, paramString2));
  }
  
  public static void reportPageView(List<MiniAppExposureManager.MiniAppExposureData> paramList, String paramString)
  {
    reportPageView(paramList, null, paramString, false);
  }
  
  private static void reportPageView(List<MiniAppExposureManager.MiniAppExposureData> paramList, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return;
    }
    MiniProgramReporter.getInstance().getReportHandler().post(new SDKMiniProgramLpReportDC04239.13(paramList, paramBoolean, paramString1, paramString2));
  }
  
  public static void reportPageView(List<MiniAppExposureManager.MiniAppExposureData> paramList, String paramString, boolean paramBoolean)
  {
    reportPageView(paramList, null, paramString, paramBoolean);
  }
  
  public static void reportUserClick(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    MiniProgramReporter.getInstance().getReportHandler().post(new SDKMiniProgramLpReportDC04239.2(paramString3, paramString4, paramString5, paramString1, paramMiniAppInfo, paramString2));
  }
  
  private static void sendRecordDurationMsg()
  {
    if (((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).isDebugVersion()) {
      QMLog.i("MiniProgramLpReportDC04239", "sendRecordDurationMsg");
    }
    MiniProgramReporter.getInstance().getReportHandler().removeCallbacks(recordDurationRunnable);
    MiniProgramReporter.getInstance().getReportHandler().postDelayed(recordDurationRunnable, mRecordDurationInterval);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239
 * JD-Core Version:    0.7.0.1
 */