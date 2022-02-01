package com.tencent.mobileqq.mini.report;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.ApkgManager;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandUtil;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class MiniAppReportManager2
{
  public static final String KEY_ACTION_TYPE = "action_type";
  public static final String KEY_APP_CONFIG = "app_config";
  public static final String KEY_APP_TYPE = "app_type";
  public static final String KEY_PATH = "path";
  public static final String KEY_RESERVES = "reserves";
  public static final String KEY_SUB_ACTION = "sub_action";
  public static final long LAUNCH_TIME_OUT = ;
  public static final String PAGE_VIEW_ACTION = "page_view";
  public static final String TAG = "MiniAppReportManager2";
  private static boolean first;
  private static Handler handler;
  public static final boolean isMainProcess;
  public static HashMap<String, Integer> lanchFailCode;
  public static HashMap<String, AppLaunchState> launchStateMap = new HashMap();
  private static Runnable launchTimeoutRunnable;
  private static boolean timerEnable;
  
  static
  {
    if (BaseApplicationImpl.sProcessId == 1) {}
    for (boolean bool = true;; bool = false)
    {
      isMainProcess = bool;
      lanchFailCode = new HashMap();
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
      first = true;
      launchTimeoutRunnable = new MiniAppReportManager2.2();
      return;
    }
  }
  
  private static String getAppType(MiniAppConfig paramMiniAppConfig)
  {
    if (paramMiniAppConfig != null)
    {
      if (paramMiniAppConfig.isReportTypeMiniGame()) {
        return "1";
      }
      return "0";
    }
    return "0";
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
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("MiniAppLaunshState", 4);
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
  
  public static boolean needReportData(String paramString, MiniAppConfig paramMiniAppConfig)
  {
    return true;
  }
  
  private static void report(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, MiniAppConfig paramMiniAppConfig)
  {
    String str1 = getAppType(paramMiniAppConfig);
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppReportManager2", 2, "reportPageViewInMainProcess  new report called with: [launchId = " + paramString3 + "], [subActionType = " + paramString2 + "], [appType = " + str1 + "], [reserves = " + paramString5 + "], [reserves2 = " + paramString6 + "], [reserves3 = " + paramString7 + "], [path =" + paramString4 + "]");
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(MiniProgramReportHelper.newUserInfoEntries());
    String str2 = AppBrandUtil.getUrlWithoutParams(paramString4);
    if ((paramMiniAppConfig != null) && (paramMiniAppConfig.launchParam != null)) {}
    for (paramString4 = String.valueOf(paramMiniAppConfig.launchParam.scene);; paramString4 = null)
    {
      localArrayList.addAll(MiniProgramReportHelper.newBusinessEntries(paramMiniAppConfig, str2, paramString4, paramString1, paramString2, paramString5, paramString6, paramString7, null, null, null, str1, paramString3));
      localArrayList.addAll(MiniProgramReportHelper.newGenericEntries());
      paramString1 = MiniProgramReportHelper.newSingleReportData(2, localArrayList, null);
      MiniProgramReporter.getInstance().addDcData(paramString1);
      if ((QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_report_first_frame_flush", 1) == 1) && ("2show".equals(paramString2)) && ("first_frame".equals(paramString5))) {
        MiniProgramReporter.getInstance().setReportLaunchNeedflush(true);
      }
      return;
    }
  }
  
  public static void reportPageView(String paramString1, String paramString2, String paramString3, MiniAppConfig paramMiniAppConfig)
  {
    String str1;
    Object localObject;
    String str2;
    label212:
    do
    {
      do
      {
        for (;;)
        {
          try
          {
            if (isMainProcess)
            {
              reportPageViewInMainProcess(paramString1, paramString2, paramString3, paramMiniAppConfig);
              return;
            }
            MiniProgramReporter.getInstance().getReportHandler().post(new MiniAppReportManager2.1(paramMiniAppConfig, paramString1, paramString3, paramString2));
            if ((paramMiniAppConfig == null) || (paramMiniAppConfig.config == null) || (TextUtils.isEmpty(paramMiniAppConfig.config.appId))) {
              break label427;
            }
            str1 = paramMiniAppConfig.config.appId;
            if (!"2launch_fail".equals(paramString1)) {
              break;
            }
            localObject = (Integer)lanchFailCode.get(paramString2);
            paramString2 = (String)localObject;
            if (localObject == null) {
              paramString2 = Integer.valueOf(401);
            }
            int i = paramString2.intValue();
            if (paramMiniAppConfig.isReportTypeMiniGame())
            {
              paramString2 = "1";
              str2 = MiniAppStartState.getBaseLibDownloadDesc(str1);
              String str3 = MiniAppStartState.getApkgDownloadDesc(str1);
              if (!paramMiniAppConfig.isReportTypeMiniGame()) {
                break label212;
              }
              localObject = MiniAppStartState.getProcessLoadDesc(str1);
              MiniReportManager.reportEventType(paramMiniAppConfig, 2, paramString3, null, null, i, paramString2, 0L, null, str2, str3, (String)localObject, MiniAppStartState.getPageSwitchDesc(str1));
              if (!"2unload".equals(paramString1)) {
                break label435;
              }
              MiniAppStartState.removeState(paramMiniAppConfig.config.appId);
              return;
            }
          }
          catch (Throwable paramString1)
          {
            QLog.e("MiniAppReportManager2", 2, paramString1.getStackTrace());
            return;
          }
          paramString2 = "0";
          continue;
          localObject = MiniAppStartState.getBaselibLoadDesc(str1);
        }
        if (("2launch".equals(paramString1)) && ("first_frame".equals(paramString2)))
        {
          MiniAppStartState.updateState(str1, true);
          if (!paramMiniAppConfig.isReportTypeMiniGame()) {
            break label436;
          }
          paramString2 = "1";
          localObject = MiniAppStartState.getBaseLibDownloadDesc(str1);
          str2 = MiniAppStartState.getApkgDownloadDesc(str1);
          if (paramMiniAppConfig.isReportTypeMiniGame()) {}
          for (str1 = MiniAppStartState.getProcessLoadDesc(str1);; str1 = MiniAppStartState.getBaselibLoadDesc(str1))
          {
            MiniReportManager.reportEventType(paramMiniAppConfig, 2, paramString3, null, null, 0, paramString2, 0L, null, (String)localObject, str2, str1, "cold_start");
            break;
          }
        }
      } while ((!"2launch".equals(paramString1)) || (!"click_resume".equals(paramString2)));
      MiniAppStartState.reset(str1, true);
    } while (MiniAppStartState.getPageSwitch(str1) == 1);
    label258:
    if (paramMiniAppConfig.isReportTypeMiniGame()) {}
    for (paramString2 = "1";; paramString2 = "0")
    {
      localObject = MiniAppStartState.getBaseLibDownloadDesc(str1);
      str2 = MiniAppStartState.getApkgDownloadDesc(str1);
      if (paramMiniAppConfig.isReportTypeMiniGame()) {}
      for (str1 = MiniAppStartState.getProcessLoadDesc(str1);; str1 = MiniAppStartState.getBaselibLoadDesc(str1))
      {
        MiniReportManager.reportEventType(paramMiniAppConfig, 2, paramString3, null, null, 0, paramString2, 0L, null, (String)localObject, str2, str1, "hot_start");
        break;
      }
      label427:
      str1 = "";
      break;
      label435:
      return;
      label436:
      paramString2 = "0";
      break label258;
    }
  }
  
  private static void reportPageViewInMainProcess(String paramString1, String paramString2, String paramString3, MiniAppConfig paramMiniAppConfig)
  {
    AppLaunchState localAppLaunchState = updateLaunchState(paramString1, paramString2, paramString3, paramMiniAppConfig);
    if (localAppLaunchState == null) {
      QLog.d("MiniAppReportManager2", 2, "new report (launchState is not exist): [subActionType = " + paramString1 + "], [reserves = " + paramString2 + "], [path = " + paramString3 + "]");
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
        if (QLog.isColorLevel()) {
          QLog.d("MiniAppReportManager2", 2, "reportPageViewInMainProcess called with: launchId = [" + localAppLaunchState.launchId + "], subActionType = [" + paramString1 + "], reserves = [" + paramString2 + "], path = [" + paramString3 + "]");
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
          report("page_view", "2show_fail", localAppLaunchState.launchId, null, "back_cancel", String.valueOf(l1), localAppLaunchState.hasPkgAndX5(), paramMiniAppConfig);
          localAppLaunchState.needReportLaunchResult = false;
        }
        if (("2close".equals(paramString1)) && (localAppLaunchState.needReportLaunchResult))
        {
          report("page_view", "2show_fail", localAppLaunchState.launchId, null, "close_cancel", String.valueOf(l1), localAppLaunchState.hasPkgAndX5(), paramMiniAppConfig);
          localAppLaunchState.needReportLaunchResult = false;
        }
        if ("2hide".equals(paramString1))
        {
          if (localAppLaunchState.needReportLaunchResult)
          {
            report("page_view", "2show_fail", localAppLaunchState.launchId, null, "home_cancel", String.valueOf(l1), localAppLaunchState.hasPkgAndX5(), paramMiniAppConfig);
            localAppLaunchState.needReportLaunchResult = false;
          }
          report("page_view", paramString1, localAppLaunchState.launchId, paramString3, paramString2, String.valueOf(l2 - l3), null, paramMiniAppConfig);
          return;
        }
        if (!"2launch_fail".equals(paramString1)) {
          break;
        }
      } while (!localAppLaunchState.needReportLaunchResult);
      report("page_view", "2show_fail", localAppLaunchState.launchId, null, paramString2, String.valueOf(l1), localAppLaunchState.hasPkgAndX5(), paramMiniAppConfig);
      localAppLaunchState.needReportLaunchResult = false;
      return;
      if (!"2launch".equals(paramString1)) {
        break;
      }
      if (localAppLaunchState.needReportLaunchResult)
      {
        report("page_view", "2show", localAppLaunchState.launchId, paramString3, paramString2, String.valueOf(l1), localAppLaunchState.hasPkgAndX5(), paramMiniAppConfig);
        localAppLaunchState.needReportLaunchResult = false;
      }
    } while (!"first_frame".equals(paramString2));
    report("page_view", "2show", localAppLaunchState.launchId, paramString3, "first_frame_extend", String.valueOf(l1), localAppLaunchState.hasPkgAndX5(), paramMiniAppConfig);
    return;
    if ("2load".equals(paramString1))
    {
      report("page_view", paramString1, localAppLaunchState.launchId, paramString3, paramString2, String.valueOf(l4 - l5), localAppLaunchState.hasPkgAndX5(), paramMiniAppConfig);
      return;
    }
    if ("2load_end".equals(paramString1))
    {
      report("page_view", paramString1, localAppLaunchState.launchId, paramString3, paramString2, String.valueOf(l6 - l7), localAppLaunchState.hasPkgAndX5(), paramMiniAppConfig);
      return;
    }
    report("page_view", paramString1, localAppLaunchState.launchId, paramString3, paramString2, null, localAppLaunchState.hasPkgAndX5(), paramMiniAppConfig);
  }
  
  private static void reportTimeout(AppLaunchState paramAppLaunchState)
  {
    paramAppLaunchState.launchResult = 2;
    long l = paramAppLaunchState.hideTime - paramAppLaunchState.clickTime;
    if (l <= 0L) {
      l = paramAppLaunchState.clickTime - NetConnInfoCenter.getServerTimeMillis();
    }
    for (;;)
    {
      String str = getTimeOutCode(l);
      Object localObject;
      if (paramAppLaunchState.needReportLaunchResult)
      {
        localObject = new MiniAppInfo();
        ((MiniAppInfo)localObject).appId = paramAppLaunchState.appId;
      }
      try
      {
        ((MiniAppInfo)localObject).verType = paramAppLaunchState.verType;
        ((MiniAppInfo)localObject).setEngineType(paramAppLaunchState.engineType);
        ((MiniAppInfo)localObject).setReportType(paramAppLaunchState.reportType);
        label83:
        MiniAppConfig localMiniAppConfig = new MiniAppConfig((MiniAppInfo)localObject);
        if (paramAppLaunchState.loadTime == 0L) {}
        for (localObject = "2load_fail";; localObject = "2show_fail")
        {
          report("page_view", (String)localObject, paramAppLaunchState.launchId, null, str, String.valueOf(l), paramAppLaunchState.hasPkgAndX5(), localMiniAppConfig);
          paramAppLaunchState.needReportLaunchResult = false;
          paramAppLaunchState.launchResult = 2;
          saveLaunchStates();
          return;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        break label83;
      }
    }
  }
  
  private static void saveLaunchStates()
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("MiniAppLaunshState", 4).edit();
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
    if (QLog.isColorLevel()) {
      QLog.i("MiniAppReportManager2", 2, "setTimeOut for launch");
    }
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
    if (QLog.isColorLevel()) {
      QLog.i("MiniAppReportManager2", 2, "stopTimeOut for report timeout");
    }
    timerEnable = false;
    if (handler != null) {
      handler.removeCallbacks(launchTimeoutRunnable);
    }
  }
  
  private static AppLaunchState updateLaunchState(String paramString1, String paramString2, String paramString3, MiniAppConfig paramMiniAppConfig)
  {
    boolean bool = false;
    if ((paramMiniAppConfig == null) || (paramMiniAppConfig.config == null) || (TextUtils.isEmpty(paramMiniAppConfig.config.appId)))
    {
      QLog.d("MiniAppReportManager2", 2, "new report (appId is null)");
      paramString1 = null;
      return paramString1;
    }
    long l = NetConnInfoCenter.getServerTimeMillis();
    if (first)
    {
      first = false;
      loadLaunchStates();
      launchTimeoutRunnable.run();
    }
    AppLaunchState localAppLaunchState = (AppLaunchState)launchStateMap.get(paramMiniAppConfig.config.appId);
    paramString3 = localAppLaunchState;
    if (localAppLaunchState == null)
    {
      paramString3 = new AppLaunchState();
      paramString3.launchId = String.valueOf(l);
      launchStateMap.put(paramMiniAppConfig.config.appId, paramString3);
    }
    paramString3.appId = paramMiniAppConfig.config.appId;
    paramString3.engineType = paramMiniAppConfig.config.getEngineType();
    paramString3.reportType = paramMiniAppConfig.config.getReportType();
    paramString3.verType = paramMiniAppConfig.config.verType;
    paramString3.activeTime = l;
    if ("2click".equals(paramString1)) {
      if (paramString3.launchResult != 0) {
        break label614;
      }
    }
    for (;;)
    {
      paramString3.reset();
      setTimeOutForLaunch();
      paramString3.clickTime = l;
      if (!AppLaunchState.hasX5)
      {
        int i = QbSdk.getTbsVersion(BaseApplicationImpl.getContext());
        int j = QbSdk.getTmpDirTbsVersion(BaseApplicationImpl.getContext());
        if ((i > 0) || (j > 0)) {
          bool = true;
        }
        AppLaunchState.hasX5 = bool;
      }
      paramString3.hasPkg = ApkgManager.pkgExists(paramMiniAppConfig.config);
      paramString3.flutterMode = paramMiniAppConfig.isSdkMode;
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
        launchStateMap.remove(paramMiniAppConfig.config.appId);
      }
      paramString1 = paramString3;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("MiniAppReportManager2", 2, "launchState: launchId = [" + paramString3.launchId + "], launchResult = [" + paramString3.launchResult + "], clickTime = [" + paramString3.clickTime + "], launchTime = [" + paramString3.launchTime + "], showTime = [" + paramString3.showTime + "], hideTime = [" + paramString3.hideTime + "]");
      return paramString3;
      label614:
      paramString3.launchId = String.valueOf(l);
    }
  }
  
  public static class AppLaunchState
  {
    public static final int LAUNCHING = 0;
    public static final int LAUNCH_FAIL = 2;
    public static final int LAUNCH_SUCESS = 1;
    public static boolean hasX5;
    public long activeTime;
    public String appId;
    public long clickTime;
    public int engineType;
    public boolean flutterMode;
    public boolean hasPkg;
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
      StringBuilder localStringBuilder = new StringBuilder();
      if (this.flutterMode)
      {
        str = "flutterMode_";
        localStringBuilder = localStringBuilder.append(str);
        if (!hasX5) {
          break label64;
        }
        str = "hasX5";
        label33:
        localStringBuilder = localStringBuilder.append(str);
        if (!this.hasPkg) {
          break label70;
        }
      }
      label64:
      label70:
      for (String str = "_hasPkg";; str = "")
      {
        return str;
        str = "";
        break;
        str = "";
        break label33;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniAppReportManager2
 * JD-Core Version:    0.7.0.1
 */