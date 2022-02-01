package com.tencent.qqmini.sdk.report;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.AppBrandUtil;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.manager.ApkgManager;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class MiniAppReportManager2
{
  public static final String APP_TYPE_MINI_APP = "0";
  public static final String APP_TYPE_MINI_GAME = "1";
  public static final String KEY_ACTION_TYPE = "action_type";
  public static final String KEY_ADD_DURATION_MS = "add_duration_ms";
  public static final String KEY_APP_CONFIG = "app_config";
  public static final String KEY_APP_TYPE = "app_type";
  public static final String KEY_PATH = "path";
  public static final String KEY_RESERVES = "reserves";
  public static final String KEY_RESERVES2 = "reserves2";
  public static final String KEY_SUB_ACTION = "sub_action";
  public static final String KEY_X5_ENABLE = "x5_enable";
  public static final long LAUNCH_TIME_OUT = ;
  public static final String PAGE_VIEW_ACTION = "page_view";
  public static final String TAG = "MiniAppReportManager2";
  private static boolean first;
  private static Handler handler;
  public static final boolean isMainProcess = AppLoaderFactory.g().isMainProcess();
  public static HashMap<String, Integer> lanchFailCode;
  public static HashMap<String, AppLaunchState> launchStateMap = new HashMap();
  private static Runnable launchTimeoutRunnable;
  private static boolean timerEnable;
  
  static
  {
    lanchFailCode = new HashMap();
    first = true;
    timerEnable = false;
    handler = null;
    launchTimeoutRunnable = new MiniAppReportManager2.1();
    lanchFailCode.put("load_baselib_fail", Integer.valueOf(402));
    lanchFailCode.put("download_url_fail", Integer.valueOf(403));
    lanchFailCode.put("download_apk_fail", Integer.valueOf(404));
    lanchFailCode.put("unpkg_fail", Integer.valueOf(405));
    lanchFailCode.put("load_pkg_fail", Integer.valueOf(406));
    lanchFailCode.put("system_version_limit_fail", Integer.valueOf(407));
    lanchFailCode.put("qq_version_limit_fail", Integer.valueOf(408));
    lanchFailCode.put("loading_page_kill", Integer.valueOf(409));
    lanchFailCode.put("baselib_task_fail", Integer.valueOf(410));
    lanchFailCode.put("pkg_task_fail", Integer.valueOf(411));
    lanchFailCode.put("start_no_intent", Integer.valueOf(412));
    lanchFailCode.put("appid_conflict", Integer.valueOf(413));
    lanchFailCode.put("init_data_fail", Integer.valueOf(414));
    lanchFailCode.put("not_foreground", Integer.valueOf(415));
    lanchFailCode.put("splash_exit_when_fail", Integer.valueOf(416));
    lanchFailCode.put("shotcut_request_fail", Integer.valueOf(417));
    lanchFailCode.put("offline_not_support", Integer.valueOf(418));
    lanchFailCode.put("offline_not_ready", Integer.valueOf(419));
    lanchFailCode.put("not_ready", Integer.valueOf(420));
    lanchFailCode.put("show_page_kill", Integer.valueOf(421));
  }
  
  private static String getAppType(MiniAppInfo paramMiniAppInfo)
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
  
  public static long getShowTimeout()
  {
    return WnsConfig.getConfig("qqtriton", "MiniShowTimeout", 45000L);
  }
  
  private static String getTimeOutCode(long paramLong)
  {
    if (paramLong < 0L) {
      return "timeout-1";
    }
    if (paramLong < 15000L) {
      return "timeout_" + Math.round((float)(paramLong / 1000L));
    }
    if (paramLong < 25000L) {
      return "timeout_25";
    }
    return "timeout";
  }
  
  private static void loadLaunchStates()
  {
    SharedPreferences localSharedPreferences = AppLoaderFactory.g().getMiniAppEnv().getContext().getSharedPreferences("MiniAppLaunshState", 4);
    Object localObject = localSharedPreferences.getString("appid", null);
    if (localObject != null)
    {
      localObject = ((String)localObject).split(",");
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        CharSequence localCharSequence = localObject[i];
        if (!TextUtils.isEmpty(localCharSequence))
        {
          String str = localSharedPreferences.getString(localCharSequence, null);
          if (str != null)
          {
            AppLaunchState localAppLaunchState = new AppLaunchState();
            localAppLaunchState.fromJson(str);
            if (!TextUtils.isEmpty(localAppLaunchState.appId)) {
              launchStateMap.put(localCharSequence, localAppLaunchState);
            }
          }
        }
        i += 1;
      }
      setTimeOutForLaunch();
    }
  }
  
  public static boolean needReportData(String paramString, MiniAppInfo paramMiniAppInfo)
  {
    return true;
  }
  
  public static void onEnterBackground()
  {
    QMLog.d("MiniAppReportManager2", "onEnterBackground");
    try
    {
      MiniProgramReporter.getInstance().getReportHandler().post(new MiniAppReportManager2.3());
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("MiniAppReportManager2", "onEnterBackground exception", localThrowable);
    }
  }
  
  private static void report(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, MiniAppInfo paramMiniAppInfo)
  {
    ArrayList localArrayList;
    if (QUAUtil.isQQApp())
    {
      if ("2click".equals(paramString2)) {
        report(paramString1, "click", paramString3, paramString4, paramString5, paramString6, paramString7, paramMiniAppInfo);
      }
    }
    else
    {
      String str1 = getAppType(paramMiniAppInfo);
      if (QMLog.isDebugEnabled()) {
        QMLog.d("MiniAppReportManager2", "reportPageViewInMainProcess  new report called with: [launchId = " + paramString3 + "], [subActionType = " + paramString2 + "], [appType = " + str1 + "], [reserves = " + paramString5 + "], [reserves2 = " + paramString6 + "], [reserves3 = " + paramString7 + "], [path =" + paramString4 + "]");
      }
      localArrayList = new ArrayList();
      localArrayList.addAll(MiniProgramReportHelper.newUserInfoEntries());
      String str2 = AppBrandUtil.getUrlWithoutParams(paramString4);
      if ((paramMiniAppInfo == null) || (paramMiniAppInfo.launchParam == null)) {
        break label604;
      }
      paramString4 = String.valueOf(paramMiniAppInfo.launchParam.scene);
      label192:
      localArrayList.addAll(MiniProgramReportHelper.newBusinessEntries(paramMiniAppInfo, str2, paramString4, paramString1, paramString2, paramString5, paramString6, paramString7, null, null, null, str1, paramString3));
      localArrayList.addAll(MiniProgramReportHelper.newGenericEntries());
      if (!QUAUtil.isQQApp())
      {
        localArrayList.addAll(MiniProgramReportHelper.newThirdSourceEntries());
        localArrayList.add(MiniProgramReportHelper.newEntry("customInfo", paramMiniAppInfo.customInfo));
      }
      if ((WnsConfig.getConfig("qqminiapp", "mini_app_report_first_frame_flush", 1) == 1) && (("2hide".equals(paramString2)) || (("2show".equals(paramString2)) && (("first_frame".equals(paramString5)) || ("click_resume".equals(paramString5)))))) {
        MiniProgramReporter.getInstance().setReportLaunchNeedflush(true);
      }
      if ((!QUAUtil.isQQApp()) && (!QUAUtil.isMicroApp())) {
        break label609;
      }
    }
    label604:
    label609:
    for (int i = 2;; i = 12)
    {
      paramString1 = MiniProgramReportHelper.newSingleReportData(i, localArrayList, null);
      MiniProgramReporter.getInstance().addDcData(paramString1);
      return;
      if ("2show".equals(paramString2))
      {
        report(paramString1, "show", paramString3, paramString4, paramString5, paramString6, paramString7, paramMiniAppInfo);
        break;
      }
      if ("2hide".equals(paramString2))
      {
        report(paramString1, "hide", paramString3, paramString4, paramString5, paramString6, paramString7, paramMiniAppInfo);
        break;
      }
      if ("2load".equals(paramString2))
      {
        report(paramString1, "load", paramString3, paramString4, paramString5, paramString6, paramString7, paramMiniAppInfo);
        break;
      }
      if ("2close".equals(paramString2))
      {
        report(paramString1, "close", paramString3, paramString4, paramString5, paramString6, paramString7, paramMiniAppInfo);
        break;
      }
      if ("2unload".equals(paramString2))
      {
        report(paramString1, "unload", paramString3, paramString4, paramString5, paramString6, paramString7, paramMiniAppInfo);
        break;
      }
      if ("2show_fail".equals(paramString2))
      {
        report(paramString1, "show_fail", paramString3, paramString4, paramString5, paramString6, paramString7, paramMiniAppInfo);
        break;
      }
      if ("2load_fail".equals(paramString2))
      {
        report(paramString1, "load_fail", paramString3, paramString4, paramString5, paramString6, paramString7, paramMiniAppInfo);
        break;
      }
      if (!"2finishshow".equals(paramString2)) {
        break;
      }
      report(paramString1, "finishshow", paramString3, paramString4, paramString5, paramString6, paramString7, paramMiniAppInfo);
      break;
      paramString4 = null;
      break label192;
    }
  }
  
  public static void reportLaunchPiecewise(int paramInt, String paramString, MiniAppInfo paramMiniAppInfo)
  {
    AppLaunchState localAppLaunchState = (AppLaunchState)launchStateMap.get(paramMiniAppInfo.appId);
    String str = "";
    if (localAppLaunchState != null)
    {
      if (!localAppLaunchState.flutterMode) {
        break label97;
      }
      paramString = "" + "flutter";
    }
    for (;;)
    {
      str = paramString;
      if (localAppLaunchState.hasPkg) {
        str = paramString + "_hasPkg";
      }
      MiniReportManager.reportEventType(paramMiniAppInfo, paramInt, str, MiniReportManager.getAppType(paramMiniAppInfo));
      return;
      label97:
      if (AppLaunchState.hasX5) {
        paramString = "" + "_webview_x5";
      } else {
        paramString = "" + "_webview_system";
      }
    }
  }
  
  public static void reportPageView(String paramString1, String paramString2, String paramString3, MiniAppInfo paramMiniAppInfo)
  {
    String str1;
    Object localObject;
    int i;
    String str2;
    label199:
    label252:
    do
    {
      do
      {
        String str3;
        for (;;)
        {
          try
          {
            if (isMainProcess)
            {
              reportPageViewInMainProcess(paramString1, paramString2, paramString3, paramMiniAppInfo);
              return;
            }
            MiniProgramReporter.getInstance().getReportHandler().post(new MiniAppReportManager2.2(paramMiniAppInfo, paramString1, paramString3, paramString2));
            if ((paramMiniAppInfo == null) || (TextUtils.isEmpty(paramMiniAppInfo.appId))) {
              break label512;
            }
            str1 = paramMiniAppInfo.appId;
            if (!"2launch_fail".equals(paramString1)) {
              break;
            }
            localObject = (Integer)lanchFailCode.get(paramString2);
            paramString2 = (String)localObject;
            if (localObject == null) {
              paramString2 = Integer.valueOf(401);
            }
            i = paramString2.intValue();
            if (paramMiniAppInfo.isReportTypeMiniGame())
            {
              paramString2 = "1";
              str2 = MiniAppStartState.getBaseLibDownloadDesc(str1);
              str3 = MiniAppStartState.getApkgDownloadDesc(str1);
              if (!paramMiniAppInfo.isReportTypeMiniGame()) {
                break label199;
              }
              localObject = MiniAppStartState.getProcessLoadDesc(str1);
              MiniReportManager.reportEventType(paramMiniAppInfo, 2, paramString3, null, null, i, paramString2, 0L, null, str2, str3, (String)localObject, MiniAppStartState.getPageSwitchDesc(str1));
              if ((!"2unload".equals(paramString1)) || (paramMiniAppInfo == null)) {
                break label520;
              }
              MiniAppStartState.removeState(paramMiniAppInfo.appId);
              return;
            }
          }
          catch (Throwable paramString1)
          {
            QMLog.e("MiniAppReportManager2", "", paramString1);
            return;
          }
          paramString2 = "0";
          continue;
          localObject = MiniAppStartState.getBaselibLoadDesc(str1);
        }
        if (("2launch".equals(paramString1)) && ("first_frame".equals(paramString2)))
        {
          MiniAppStartState.updateState(str1, true);
          if ((!paramMiniAppInfo.isEngineTypeMiniApp()) || (!paramMiniAppInfo.supportNativeRenderMode())) {
            break label521;
          }
          i = 1;
          if ((i != 0) && (!MiniAppPrelaunchRecorder.get().isCheckinColdStart())) {
            break label520;
          }
          boolean bool = MiniAppPrelaunchRecorder.get().isPrelaunchSuccess();
          localObject = MiniAppStartState.getApkgDownloadDesc(str1);
          paramString2 = (String)localObject;
          if (i != 0)
          {
            paramString2 = (String)localObject;
            if (bool) {
              paramString2 = "apkg_download_preloaded";
            }
          }
          if (!paramMiniAppInfo.isReportTypeMiniGame()) {
            break label527;
          }
          localObject = "1";
          str3 = MiniAppStartState.getBaseLibDownloadDesc(str1);
          if (paramMiniAppInfo.isReportTypeMiniGame()) {}
          for (str2 = MiniAppStartState.getProcessLoadDesc(str1);; str2 = MiniAppStartState.getBaselibLoadDesc(str1))
          {
            MiniReportManager.reportEventType(paramMiniAppInfo, 2, paramString3, null, null, 0, (String)localObject, 0L, null, str3, paramString2, str2, "cold_start");
            if (i == 0) {
              break;
            }
            MiniAppStartState.reset(str1, true);
            break;
          }
        }
      } while ((!"2launch".equals(paramString1)) || (!"click_resume".equals(paramString2)));
      if ((!paramMiniAppInfo.isEngineTypeMiniApp()) || (!paramMiniAppInfo.supportNativeRenderMode())) {
        break label534;
      }
      i = 1;
      if (i == 0) {
        MiniAppStartState.reset(str1, true);
      }
    } while ((MiniAppStartState.getPageSwitch(str1) == 1) || (i != 0));
    label312:
    if (paramMiniAppInfo.isReportTypeMiniGame()) {}
    label415:
    for (paramString2 = "1";; paramString2 = "0")
    {
      localObject = MiniAppStartState.getBaseLibDownloadDesc(str1);
      str2 = MiniAppStartState.getApkgDownloadDesc(str1);
      if (paramMiniAppInfo.isReportTypeMiniGame()) {}
      for (str1 = MiniAppStartState.getProcessLoadDesc(str1);; str1 = MiniAppStartState.getBaselibLoadDesc(str1))
      {
        MiniReportManager.reportEventType(paramMiniAppInfo, 2, paramString3, null, null, 0, paramString2, 0L, null, (String)localObject, str2, str1, "hot_start");
        break;
      }
      str1 = "";
      break;
      return;
      i = 0;
      break label252;
      localObject = "0";
      break label312;
      i = 0;
      break label415;
    }
  }
  
  private static void reportPageViewInMainProcess(String paramString1, String paramString2, String paramString3, MiniAppInfo paramMiniAppInfo)
  {
    AppLaunchState localAppLaunchState = updateLaunchState(paramString1, paramString2, paramString3, paramMiniAppInfo);
    if (localAppLaunchState == null) {
      QMLog.d("MiniAppReportManager2", "new report (launchState is not exist): [subActionType = " + paramString1 + "], [reserves = " + paramString2 + "], [path = " + paramString3 + "]");
    }
    long l1;
    long l4;
    long l5;
    long l6;
    long l7;
    do
    {
      do
      {
        return;
        if (QMLog.isDebugEnabled()) {
          QMLog.d("MiniAppReportManager2", "reportPageViewInMainProcess called with: launchId = [" + localAppLaunchState.launchId + "], subActionType = [" + paramString1 + "], reserves = [" + paramString2 + "], path = [" + paramString3 + "]");
        }
        l1 = localAppLaunchState.launchTime - localAppLaunchState.clickTime;
        long l2 = localAppLaunchState.hideTime;
        long l3 = localAppLaunchState.showTime;
        l4 = localAppLaunchState.loadTime;
        l5 = localAppLaunchState.clickTime;
        l6 = localAppLaunchState.loadEndTime;
        l7 = localAppLaunchState.clickTime;
        if (("2back_key".equals(paramString1)) && (localAppLaunchState.needReportLaunchResult))
        {
          report("page_view", "2show_fail", localAppLaunchState.launchId, null, "back_cancel", String.valueOf(l1), localAppLaunchState.hasPkgAndX5(), paramMiniAppInfo);
          localAppLaunchState.needReportLaunchResult = false;
        }
        if (("2close".equals(paramString1)) && (localAppLaunchState.needReportLaunchResult))
        {
          report("page_view", "2show_fail", localAppLaunchState.launchId, null, "close_cancel", String.valueOf(l1), localAppLaunchState.hasPkgAndX5(), paramMiniAppInfo);
          localAppLaunchState.needReportLaunchResult = false;
        }
        if ("2hide".equals(paramString1))
        {
          if (localAppLaunchState.needReportLaunchResult)
          {
            report("page_view", "2show_fail", localAppLaunchState.launchId, null, "home_cancel", String.valueOf(l1), localAppLaunchState.hasPkgAndX5(), paramMiniAppInfo);
            localAppLaunchState.needReportLaunchResult = false;
          }
          report("page_view", paramString1, localAppLaunchState.launchId, paramString3, null, paramString2, String.valueOf(l2 - l3), paramMiniAppInfo);
          return;
        }
        if (!"2launch_fail".equals(paramString1)) {
          break;
        }
      } while (!localAppLaunchState.needReportLaunchResult);
      report("page_view", "2show_fail", localAppLaunchState.launchId, null, paramString2, String.valueOf(l1), localAppLaunchState.hasPkgAndX5(), paramMiniAppInfo);
      localAppLaunchState.needReportLaunchResult = false;
      return;
      if (!"2launch".equals(paramString1)) {
        break;
      }
      if (localAppLaunchState.needReportLaunchResult)
      {
        report("page_view", "2show", localAppLaunchState.launchId, paramString3, paramString2, String.valueOf(l1), localAppLaunchState.hasPkgAndX5(), paramMiniAppInfo);
        localAppLaunchState.needReportLaunchResult = false;
      }
    } while (!"first_frame".equals(paramString2));
    report("page_view", "2show", localAppLaunchState.launchId, paramString3, "first_frame_extend", String.valueOf(l1), localAppLaunchState.hasPkgAndX5(), paramMiniAppInfo);
    return;
    if ("2load".equals(paramString1))
    {
      report("page_view", paramString1, localAppLaunchState.launchId, paramString3, paramString2, String.valueOf(l4 - l5), localAppLaunchState.hasPkgAndX5(), paramMiniAppInfo);
      return;
    }
    if ("2load_end".equals(paramString1))
    {
      report("page_view", paramString1, localAppLaunchState.launchId, paramString3, paramString2, String.valueOf(l6 - l7), localAppLaunchState.hasPkgAndX5(), paramMiniAppInfo);
      return;
    }
    report("page_view", paramString1, localAppLaunchState.launchId, paramString3, paramString2, null, localAppLaunchState.hasPkgAndX5(), paramMiniAppInfo);
  }
  
  private static void reportTimeout(AppLaunchState paramAppLaunchState)
  {
    paramAppLaunchState.launchResult = 2;
    long l = paramAppLaunchState.hideTime - paramAppLaunchState.clickTime;
    if (l <= 0L) {
      l = paramAppLaunchState.clickTime - System.currentTimeMillis();
    }
    for (;;)
    {
      String str2 = getTimeOutCode(l);
      MiniAppInfo localMiniAppInfo;
      if (paramAppLaunchState.needReportLaunchResult)
      {
        localMiniAppInfo = new MiniAppInfo();
        localMiniAppInfo.appId = paramAppLaunchState.appId;
      }
      try
      {
        localMiniAppInfo.verType = paramAppLaunchState.verType;
        localMiniAppInfo.setEngineType(paramAppLaunchState.engineType);
        localMiniAppInfo.setReportType(paramAppLaunchState.reportType);
        label88:
        if (paramAppLaunchState.loadTime == 0L) {}
        for (String str1 = "2load_fail";; str1 = "2show_fail")
        {
          report("page_view", str1, paramAppLaunchState.launchId, null, str2, String.valueOf(l), paramAppLaunchState.hasPkgAndX5(), localMiniAppInfo);
          paramAppLaunchState.needReportLaunchResult = false;
          paramAppLaunchState.launchResult = 2;
          saveLaunchStates();
          return;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        break label88;
      }
    }
  }
  
  private static void saveLaunchStates()
  {
    SharedPreferences.Editor localEditor = AppLoaderFactory.g().getMiniAppEnv().getContext().getSharedPreferences("MiniAppLaunshState", 4).edit();
    localEditor.clear();
    Iterator localIterator = launchStateMap.entrySet().iterator();
    StringBuilder localStringBuilder = new StringBuilder();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (AppLaunchState)((Map.Entry)localObject).getValue();
      if (((AppLaunchState)localObject).launchResult == 0)
      {
        localStringBuilder.append(str);
        localStringBuilder.append(',');
        localEditor.putString(str, ((AppLaunchState)localObject).toJson());
      }
    }
    localEditor.putString("appid", localStringBuilder.toString());
    localEditor.commit();
  }
  
  private static void setTimeOutForLaunch()
  {
    if (handler == null) {
      handler = new Handler(Looper.getMainLooper());
    }
    if ((handler != null) && (!timerEnable))
    {
      handler.postDelayed(launchTimeoutRunnable, LAUNCH_TIME_OUT);
      timerEnable = true;
    }
  }
  
  public static void stopTimeOutForLaunch()
  {
    timerEnable = false;
    if (handler != null) {
      handler.removeCallbacks(launchTimeoutRunnable);
    }
  }
  
  private static AppLaunchState updateLaunchState(String paramString1, String paramString2, String paramString3, MiniAppInfo paramMiniAppInfo)
  {
    if ((paramMiniAppInfo == null) || (TextUtils.isEmpty(paramMiniAppInfo.appId)))
    {
      QMLog.d("MiniAppReportManager2", "new report (appId is null)");
      paramString1 = null;
      return paramString1;
    }
    long l = System.currentTimeMillis();
    if (first)
    {
      first = false;
      loadLaunchStates();
      launchTimeoutRunnable.run();
    }
    paramString3 = (AppLaunchState)launchStateMap.get(paramMiniAppInfo.appId);
    if (paramString3 == null)
    {
      paramString3 = new AppLaunchState();
      paramString3.launchId = String.valueOf(l);
      launchStateMap.put(paramMiniAppInfo.appId, paramString3);
    }
    for (;;)
    {
      paramString3.appId = paramMiniAppInfo.appId;
      paramString3.engineType = paramMiniAppInfo.getEngineType();
      paramString3.reportType = paramMiniAppInfo.getReportType();
      paramString3.verType = paramMiniAppInfo.verType;
      paramString3.activeTime = l;
      if ("2click".equals(paramString1))
      {
        if (paramString3.launchResult != 0) {
          break label556;
        }
        label154:
        paramString3.reset();
        setTimeOutForLaunch();
        paramString3.clickTime = l;
        if (!AppLaunchState.hasX5) {
          if (((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getTbsVersion() <= 0) {
            break label568;
          }
        }
      }
      label556:
      label568:
      for (boolean bool = true;; bool = false)
      {
        AppLaunchState.hasX5 = bool;
        paramString3.hasPkg = ApkgManager.pkgExists(paramMiniAppInfo);
        paramString3.flutterMode = true;
        saveLaunchStates();
        if ((paramString3.launchResult != 0) && ("2show".equals(paramString1)) && ("bring_to_front".equals(paramString2)))
        {
          paramString3.reset();
          setTimeOutForLaunch();
          paramString3.clickTime = l;
          saveLaunchStates();
        }
        if ("2load".equals(paramString1)) {
          paramString3.loadTime = l;
        }
        if ("2load_end".equals(paramString1)) {
          paramString3.loadEndTime = l;
        }
        if ((paramString3.launchResult == 0) && ("2launch".equals(paramString1)))
        {
          paramString3.launchTime = l;
          paramString3.launchResult = 1;
          paramString3.needReportLaunchResult = true;
          saveLaunchStates();
        }
        if ((paramString3.launchResult == 0) && (("2launch_fail".equals(paramString1)) || ("2close".equals(paramString1)) || ("2back_key".equals(paramString1)) || ("2hide".equals(paramString1))))
        {
          paramString3.launchTime = l;
          paramString3.launchResult = 2;
          paramString3.needReportLaunchResult = true;
          saveLaunchStates();
        }
        if ("2show".equals(paramString1))
        {
          paramString3.showTime = l;
          paramString3.hideTime = 0L;
        }
        if ("2hide".equals(paramString1)) {
          paramString3.hideTime = l;
        }
        if ("2unload".equals(paramString1)) {
          launchStateMap.remove(paramMiniAppInfo.appId);
        }
        paramString1 = paramString3;
        if (!QMLog.isDebugEnabled()) {
          break;
        }
        QMLog.d("MiniAppReportManager2", "launchState: launchId = [" + paramString3.launchId + "], launchResult = [" + paramString3.launchResult + "], clickTime = [" + paramString3.clickTime + "], launchTime = [" + paramString3.launchTime + "], showTime = [" + paramString3.showTime + "], hideTime = [" + paramString3.hideTime + "]");
        return paramString3;
        paramString3.launchId = String.valueOf(l);
        break label154;
      }
    }
  }
  
  public static class AppLaunchState
  {
    public static final int LAUNCHING = 0;
    public static final int LAUNCH_FAIL = 2;
    public static final int LAUNCH_SUCESS = 1;
    public static boolean hasX5 = false;
    public long activeTime;
    public String appId;
    public long clickTime;
    public int engineType;
    public boolean flutterMode = false;
    public boolean hasPkg = false;
    public long hideTime;
    public String jsError;
    public String launchId;
    public int launchResult = 0;
    public long launchTime;
    public long loadEndTime;
    public long loadTime;
    public boolean needReportLaunchResult;
    public int reportType;
    public long showTime;
    public int verType;
    
    public void fromJson(String paramString)
    {
      try
      {
        paramString = new JSONObject(paramString);
        this.appId = paramString.getString("appid");
        this.engineType = paramString.getInt("engineType");
        this.reportType = paramString.getInt("reportType");
        this.verType = paramString.getInt("verType");
        this.launchId = paramString.getString("launchId");
        this.clickTime = paramString.getLong("clickTime");
        this.loadTime = paramString.getLong("loadTime");
        this.launchTime = paramString.getLong("launchTime");
        this.launchResult = paramString.getInt("launchResult");
        this.activeTime = paramString.getLong("activeTime");
        this.showTime = paramString.getLong("showTime");
        this.hideTime = paramString.getLong("hideTime");
        this.jsError = paramString.getString("jsError");
        this.needReportLaunchResult = paramString.getBoolean("needReportLaunchResult");
        this.hasPkg = paramString.getBoolean("hasPkg");
        this.flutterMode = paramString.optBoolean("flutterMode");
        this.loadEndTime = paramString.optLong("loadEndTime");
        return;
      }
      catch (Throwable paramString) {}
    }
    
    public String hasPkgAndX5()
    {
      StringBuilder localStringBuilder = new StringBuilder().append("SDK_");
      if (hasX5)
      {
        str = "hasX5";
        localStringBuilder = localStringBuilder.append(str);
        if (!this.hasPkg) {
          break label53;
        }
      }
      label53:
      for (String str = "_hasPkg";; str = "")
      {
        return str;
        str = "";
        break;
      }
    }
    
    public void reset()
    {
      this.loadTime = 0L;
      this.launchTime = 0L;
      this.launchResult = 0;
      this.showTime = 0L;
      this.hideTime = 0L;
      this.needReportLaunchResult = true;
      this.jsError = null;
      this.hasPkg = false;
      this.loadEndTime = 0L;
    }
    
    public String toJson()
    {
      try
      {
        Object localObject = new JSONObject();
        ((JSONObject)localObject).put("appid", this.appId);
        ((JSONObject)localObject).put("engineType", this.engineType);
        ((JSONObject)localObject).put("reportType", this.reportType);
        ((JSONObject)localObject).put("verType", this.verType);
        ((JSONObject)localObject).put("launchId", this.launchId);
        ((JSONObject)localObject).put("clickTime", this.clickTime);
        ((JSONObject)localObject).put("loadTime", this.loadTime);
        ((JSONObject)localObject).put("launchTime", this.launchTime);
        ((JSONObject)localObject).put("launchResult", this.launchResult);
        ((JSONObject)localObject).put("activeTime", this.activeTime);
        ((JSONObject)localObject).put("showTime", this.showTime);
        ((JSONObject)localObject).put("hideTime", this.hideTime);
        ((JSONObject)localObject).put("jsError", this.jsError);
        ((JSONObject)localObject).put("needReportLaunchResult", this.needReportLaunchResult);
        ((JSONObject)localObject).put("hasPkg", this.hasPkg);
        ((JSONObject)localObject).put("flutterMode", this.flutterMode);
        ((JSONObject)localObject).put("loadEndTime", this.loadEndTime);
        localObject = ((JSONObject)localObject).toString();
        return localObject;
      }
      catch (Throwable localThrowable) {}
      return null;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("launchId: ").append(this.launchId).append(", appId: ").append(0);
      return localStringBuilder.toString();
    }
  }
  
  public static class FailCode
  {
    public static final String APPID_CONFLICT_FAIL = "appid_conflict";
    public static final String BASE_LIB_TASK_FAIL = "baselib_task_fail";
    public static final String CACHE_HIT = "hit";
    public static final String CACHE_UNHIT = "unhit";
    public static final String DOWNLOAD_PKG_FAIL = "download_apk_fail";
    public static final String DOWNLOAD_URL_FAIL = "download_url_fail";
    public static final String FLUTTER_SDK_FAIL = "flutter_sdk_fail";
    public static final String INIT_DATA_FAIL = "init_data_fail";
    public static final String IS_X5_JSCORE = "is_x5_jscore";
    public static final String JS_ERROR = "jsError";
    public static final String LOADING_PAGE_KILL = "loading_page_kill";
    public static final String LOAD_BASE_LIB_FAIL = "load_baselib_fail";
    public static final String LOAD_PKG_FAIL = "load_pkg_fail";
    public static final String NOT_FOREGROUND_FAIL = "not_foreground";
    public static final String NOT_READY_FAIL = "not_ready";
    public static final String OFFLINE_NOT_READY_FAIL = "offline_not_ready";
    public static final String OFFLINE_NOT_SUPPORT_FAIL = "offline_not_support";
    public static final String PKG_IS_DOWNLOADED = "pkg_is_downloaded";
    public static final String PKG_TASK_FAIL = "pkg_task_fail";
    public static final String QQ_VERSION_LIMIT_FAIL = "qq_version_limit_fail";
    public static final String SHORTCUT_REQUEST_FAIL = "shotcut_request_fail";
    public static final String SHOW_PAGE_KILL = "show_page_kill";
    public static final String SPLASH_EXIT_WHEN_FAIL = "splash_exit_when_fail";
    public static final String START_NO_INTENT_FAIL = "start_no_intent";
    public static final String SYSTEM_VERSION_LIMIT_FAIL = "system_version_limit_fail";
    public static final String TIME_OUT_CODE = "timeout";
    public static final String TIME_OUT_CODE_25 = "timeout_25";
    public static final String UNPKG_PKG_FAIL = "unpkg_fail";
    public static final String USER_CANCEL_BACK_KEY = "cancel_by_backkey";
    public static final String USER_CANCEL_CLOSE = "cancel_by_close";
  }
  
  public static class PageViewSubAction
  {
    public static final String APKG_CACHE = "cache_apkg_hit";
    public static final String BACK_KEY = "2back_key";
    public static final String CLICK = "2click";
    public static final String CLOSE = "2close";
    public static final String CREATE = "2create";
    public static final String FINISHSHOW = "2finishshow";
    public static final String HIDE = "2hide";
    public static final String LAUNCH = "2launch";
    public static final String LAUNCH_FAIL = "2launch_fail";
    public static final String LOAD = "2load";
    public static final String LOAD_END = "2load_end";
    public static final String PAGE_HIDE = "2page_hide";
    public static final String PAGE_SHOW = "2page_show";
    public static final String SHOW = "2show";
    public static final String UNLOAD = "2unload";
  }
  
  public static class ReportBackKeyReserve
  {
    public static final String CODE_INNER_PAGE = "inner_page";
    public static final String CODE_LOADING_PAGE = "loading_page";
  }
  
  public static class ReportCloseReserve
  {
    public static final String CODE_INNER_PAGE = "inner_page";
    public static final String CODE_LOADING_PAGE = "loading_page";
  }
  
  public static class ReportShowReserve
  {
    public static final String CODE_BRING_TO_FRONT = "bring_to_front";
    public static final String CODE_CHANGE_PAGE = "switch_page";
    public static final String CODE_CLICK_RESUME = "click_resume";
    public static final String CODE_FIRST_FRAME = "first_frame";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniAppReportManager2
 * JD-Core Version:    0.7.0.1
 */