package com.tencent.qqmini.sdk.manager;

import NS_MINI_AD.MiniAppAd.SpecifiedAdsItem;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.utils.AdUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MiniLoadingAdManager
{
  private static final String EXTRA_PRELOAD_INTERVAL_CHECK_PREFIX = "mini_loading_ad_extra_preload_interval_check_";
  public static final String KEY_APP_CONFIG = "app_config";
  public static final String KEY_UIN = "uin";
  private static final int LOADING_AD_LIMIT_TYPE_PRELOAD = 1;
  private static final int LOADING_AD_LIMIT_TYPE_SELECT = 0;
  private static final String PRELOAD_ADJSON_KEY_PREFEX = "mini_loading_ad_preload_adjson_key_";
  private static final String PRELOAD_PREFIX = "mini_loading_ad_preload_";
  private static final String SELECT_PREFIX = "mini_loading_ad_select_";
  public static final String TAG = "MiniLoadingAdManager";
  private static final String VIA_AD_PREFIX = "2054_";
  private static HashMap<Long, String> cachedAidFilePathMap = new HashMap();
  private static final String defaultViaListStr = "2054_1,2054_2,2054_3,2054_4,2054_5,2054_6,2054_7,2054_8,2054_9,2054_10,2054_11,2054_12,2054_13,2054_14,2054_15,2054_17,2054_18,2054_19";
  private static long maxAdCachedSize = 20971520L;
  private static volatile MiniLoadingAdManager sInstance;
  private int extraPreloadInterval = WnsConfig.getConfig("qqminiapp", "launch_adv_app_preload_interval", 0);
  private int maxPreloadCountForUin = WnsConfig.getConfig("qqminiapp", "launch_adv_user_preload_limit", 2147483647);
  private int maxPreloadCountForUinAndAppid = WnsConfig.getConfig("qqminiapp", "launch_adv_app_preload_limit", 2);
  private int maxSelectCountForUin = WnsConfig.getConfig("qqminiapp", "launch_adv_user_select_limit", 3);
  private int maxSelectCountForUinAndAppid = WnsConfig.getConfig("qqminiapp", "launch_adv_app_select_limit", 1);
  private String unsupportedViaList = WnsConfig.getConfig("qqminiapp", "launch_adv_unsupport_via_list", "2054_1,2054_2,2054_3,2054_4,2054_5,2054_6,2054_7,2054_8,2054_9,2054_10,2054_11,2054_12,2054_13,2054_14,2054_15,2054_17,2054_18,2054_19");
  
  private boolean checkHasLoadingAdCache(@NonNull String paramString1, @NonNull String paramString2)
  {
    paramString1 = getCurCachedAdsList(paramString1, paramString2);
    return (paramString1 != null) && (paramString1.size() > 0);
  }
  
  private boolean checkLoadingAdFrequencyLimitation(@NonNull String paramString1, @NonNull String paramString2, @MiniLoadingAdManager.CheckLoadingAdLimitType int paramInt)
  {
    String str1 = getPrefix(paramInt) + paramString2;
    String str2 = str1 + "_times";
    paramString1 = getPrefix(paramInt) + paramString2 + "_" + paramString1;
    paramString2 = paramString1 + "_times";
    long l1 = StorageUtil.getPreference().getLong(str1, 0L);
    int i = StorageUtil.getPreference().getInt(str2, 0);
    long l2 = StorageUtil.getPreference().getLong(paramString1, 0L);
    int j = StorageUtil.getPreference().getInt(paramString2, 0);
    QMLog.d("MiniLoadingAdManager", "lastTimestamp:" + l1 + " totalTimes:" + i + " lastTimestampForAppid:" + l2 + " totalTimesForAppid:" + j);
    if ((l1 != getCurZeroTimeMillis()) || (i < 1))
    {
      QMLog.d("MiniLoadingAdManager", "如果该uin记录的时间节点不在当天 或总次数没有记录 返回true lastTimestamp：" + l1 + " totalTimes:" + i);
      return true;
    }
    if (i >= getLimit(paramInt, false))
    {
      QMLog.d("MiniLoadingAdManager", "如果当日该uin超过规定次数 返回false totalTimes：" + i + " getLimit(mode, false):" + getLimit(paramInt, false));
      return false;
    }
    if ((l2 != getCurZeroTimeMillis()) || (j < 1))
    {
      QMLog.d("MiniLoadingAdManager", "如果该uin在当前appid没有今天记录的情况 或总次数没有记录 返回true lastTimestampForAppid：" + l2 + " Utils.getCurZeroTimeMillis():" + getCurZeroTimeMillis() + " totalTimesForAppid：" + j);
      return true;
    }
    if (j >= getLimit(paramInt, true))
    {
      QMLog.d("MiniLoadingAdManager", "如果该uin在当前appid超过规定次数 返回false totalTimesForAppid：" + j + " getLimit(mode, true):" + getLimit(paramInt, true));
      return false;
    }
    return true;
  }
  
  private boolean checkSelectAdNecessity(MiniAppInfo paramMiniAppInfo, String paramString)
  {
    if ((paramMiniAppInfo == null) || (TextUtils.isEmpty(paramString)))
    {
      QMLog.d("MiniLoadingAdManager", "checkSelectAdNecessity 参数不合法");
      return false;
    }
    if ((TextUtils.isEmpty(paramMiniAppInfo.appId)) || (!paramMiniAppInfo.enableLoadingAd))
    {
      QMLog.d("MiniLoadingAdManager", "checkSelectAdNecessity 没开广告位");
      return false;
    }
    if (isViaUnsupported(paramMiniAppInfo.via))
    {
      QMLog.d("MiniLoadingAdManager", "checkSelectAdNecessity via不支持");
      return false;
    }
    if (!checkHasLoadingAdCache(paramString, paramMiniAppInfo.appId))
    {
      QMLog.d("MiniLoadingAdManager", "checkSelectAdNecessity 本地没广告");
      return false;
    }
    if (!checkLoadingAdFrequencyLimitation(paramMiniAppInfo.appId, paramString, 0))
    {
      QMLog.d("MiniLoadingAdManager", "checkSelectAdNecessity 频控限制");
      return false;
    }
    return true;
  }
  
  private boolean extraPreloadIntervalCheck(String paramString1, String paramString2)
  {
    paramString1 = "mini_loading_ad_extra_preload_interval_check__" + paramString2 + "_" + paramString1;
    long l = StorageUtil.getPreference().getLong(paramString1, -1L);
    if ((l > 0L) && ((System.currentTimeMillis() - l) / 1000L <= this.extraPreloadInterval))
    {
      QMLog.d("MiniLoadingAdManager", "连续preload小于时间间隔 返回false (System.currentTimeMillis() - lastTimestamp) / 1000：" + (System.currentTimeMillis() - l) / 1000L + " extraPreloadInterval:" + this.extraPreloadInterval);
      return false;
    }
    return true;
  }
  
  private static void extraPreloadIntervalUpdate(String paramString1, String paramString2)
  {
    paramString1 = "mini_loading_ad_extra_preload_interval_check__" + paramString2 + "_" + paramString1;
    StorageUtil.getPreference().edit().putLong(paramString1, System.currentTimeMillis()).apply();
  }
  
  private static Bundle getAdReqBundle(Context paramContext, MiniAppInfo paramMiniAppInfo, String paramString, int paramInt)
  {
    String str1 = LoginManager.getInstance().getAccount();
    String str2 = paramMiniAppInfo.appId;
    int i;
    label33:
    String str3;
    label69:
    label84:
    Object localObject2;
    Object localObject1;
    if (paramMiniAppInfo.isEngineTypeMiniApp())
    {
      i = 0;
      if (i != 0) {
        break label265;
      }
      i = 14;
      str3 = AdUtil.getSpAdGdtCookie(i);
      if ((paramMiniAppInfo == null) || (paramMiniAppInfo.launchParam == null)) {
        break label293;
      }
      if (paramMiniAppInfo.launchParam.entryPath == null) {
        break label272;
      }
      paramContext = paramMiniAppInfo.launchParam.entryPath;
      if (paramMiniAppInfo.launchParam == null) {
        break label279;
      }
      paramString = paramMiniAppInfo.launchParam.reportData;
      int j = paramMiniAppInfo.launchParam.scene;
      localObject2 = String.valueOf(j);
      localObject1 = paramContext;
    }
    for (paramContext = (Context)localObject2;; paramContext = "")
    {
      if ((paramMiniAppInfo != null) && (paramMiniAppInfo.via != null)) {}
      for (paramMiniAppInfo = paramMiniAppInfo.via;; paramMiniAppInfo = "")
      {
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString(AdProxy.KEY_ACCOUNT, str1);
        ((Bundle)localObject2).putString(AdProxy.KEY_GDT_COOKIE, str3);
        ((Bundle)localObject2).putString(AdProxy.KEY_ENTRY_PATH, (String)localObject1);
        ((Bundle)localObject2).putString(AdProxy.KEY_REPORT_DATA, paramString);
        ((Bundle)localObject2).putString(AdProxy.KEY_REFER, paramContext);
        ((Bundle)localObject2).putString(AdProxy.KEY_VIA, paramMiniAppInfo);
        ((Bundle)localObject2).putString(AdProxy.KEY_POSID, "");
        ((Bundle)localObject2).putString(AdProxy.KEY_APPID, str2);
        ((Bundle)localObject2).putInt(AdProxy.KEY_AD_TYPE, i);
        ((Bundle)localObject2).putInt(AdProxy.KEY_ORIENTATION, 0);
        ((Bundle)localObject2).putInt(AdProxy.KEY_SHARE_RATE, 53);
        ((Bundle)localObject2).putInt(AdProxy.KEY_ADCOUNT, 1);
        ((Bundle)localObject2).putInt(AdProxy.KEY_MODE, paramInt);
        return localObject2;
        i = 1;
        break;
        label265:
        i = 15;
        break label33;
        label272:
        paramContext = "";
        break label69;
        label279:
        paramString = "";
        break label84;
      }
      label293:
      localObject1 = "";
      paramString = "";
    }
  }
  
  private static ArrayList<MiniAppAd.SpecifiedAdsItem> getCurCachedAdsList(String paramString1, String paramString2)
  {
    cachedAidFilePathMap.clear();
    paramString1 = "mini_loading_ad_preload_adjson_key_" + paramString1 + "_" + paramString2;
    paramString1 = StorageUtil.getPreference().getString(paramString1, new JSONObject().toString());
    try
    {
      paramString1 = new JSONObject(paramString1);
      if (paramString1 == null) {
        return null;
      }
      paramString1 = paramString1.optJSONArray("adArray");
      if ((paramString1 != null) && (paramString1.length() >= 1))
      {
        paramString2 = new ArrayList();
        int i = 0;
        while (i < paramString1.length())
        {
          MiniAppAd.SpecifiedAdsItem localSpecifiedAdsItem = new MiniAppAd.SpecifiedAdsItem();
          JSONObject localJSONObject = paramString1.getJSONObject(i);
          if (localJSONObject != null)
          {
            String str = localJSONObject.getString("filePath");
            if (new File(str).exists())
            {
              long l = localJSONObject.getLong("aid");
              cachedAidFilePathMap.put(Long.valueOf(l), str);
              localSpecifiedAdsItem.aid.set(l);
              localSpecifiedAdsItem.creative_id.set(localJSONObject.getLong("creativeId"));
              paramString2.add(localSpecifiedAdsItem);
            }
          }
          i += 1;
        }
        return paramString2;
      }
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  public static long getCurZeroTimeMillis()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(new Date());
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    return localCalendar.getTimeInMillis();
  }
  
  public static MiniLoadingAdManager getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new MiniLoadingAdManager();
      }
      return sInstance;
    }
    finally {}
  }
  
  private long getLimit(@MiniLoadingAdManager.CheckLoadingAdLimitType int paramInt, boolean paramBoolean)
  {
    switch (paramInt)
    {
    default: 
      return 0L;
    case 0: 
      if (paramBoolean) {
        return this.maxSelectCountForUinAndAppid;
      }
      return this.maxSelectCountForUin;
    }
    if (paramBoolean) {
      return this.maxPreloadCountForUinAndAppid;
    }
    return this.maxPreloadCountForUin;
  }
  
  private static String getPrefix(@MiniLoadingAdManager.CheckLoadingAdLimitType int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 0: 
      return "mini_loading_ad_select_";
    }
    return "mini_loading_ad_preload_";
  }
  
  private boolean isViaUnsupported(String paramString)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((TextUtils.isEmpty(this.unsupportedViaList)) || (TextUtils.isEmpty(paramString))) {
      bool1 = false;
    }
    for (;;)
    {
      return bool1;
      try
      {
        String[] arrayOfString = this.unsupportedViaList.split(",");
        if ((arrayOfString != null) && (arrayOfString.length >= 1))
        {
          int j = arrayOfString.length;
          int i = 0;
          for (;;)
          {
            if (i >= j) {
              break label119;
            }
            boolean bool3 = paramString.equals(arrayOfString[i]);
            bool1 = bool2;
            if (bool3) {
              break;
            }
            i += 1;
          }
          return false;
        }
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("MiniLoadingAdManager", "isViaUnsupported exception via:" + paramString, localThrowable);
      }
    }
    label119:
    return false;
  }
  
  public static void requestPreloadLoadingAd(Context paramContext, MiniAppInfo paramMiniAppInfo, String paramString)
  {
    if (paramMiniAppInfo == null) {
      return;
    }
    QMLog.d("MiniLoadingAdManager", "requestPreloadLoadingAd 开始");
    ThreadManager.getSubThreadHandler().post(new MiniLoadingAdManager.2(paramContext, paramMiniAppInfo, paramString));
  }
  
  private static void updateLoadingAdFrequencyLimitationRecord(@NonNull String paramString1, @NonNull String paramString2, @MiniLoadingAdManager.CheckLoadingAdLimitType int paramInt)
  {
    String str1 = getPrefix(paramInt) + paramString2;
    String str2 = str1 + "_times";
    paramString1 = getPrefix(paramInt) + paramString2 + "_" + paramString1;
    paramString2 = paramString1 + "_times";
    long l1 = StorageUtil.getPreference().getLong(str1, 0L);
    paramInt = StorageUtil.getPreference().getInt(str2, 0);
    long l2 = StorageUtil.getPreference().getLong(paramString1, 0L);
    int i = StorageUtil.getPreference().getInt(paramString2, 0);
    long l3 = getCurZeroTimeMillis();
    if (l1 != l3)
    {
      QMLog.d("MiniLoadingAdManager", "当天没有记录 或者从来都没有过记录 keyUinTimestamp todayTimestamp：" + l3 + " keyUinTimestamp：1");
      StorageUtil.getPreference().edit().putLong(str1, l3).apply();
      StorageUtil.getPreference().edit().putInt(str2, 1).apply();
    }
    while (l2 != l3)
    {
      QMLog.d("MiniLoadingAdManager", "当天没有记录 或者从来都没有过记录 keyUinAppidTimestamp todayTimestamp：" + l3 + " keyUinAppidTimes：1");
      StorageUtil.getPreference().edit().putLong(paramString1, l3).apply();
      StorageUtil.getPreference().edit().putInt(paramString2, 1).apply();
      return;
      QMLog.d("MiniLoadingAdManager", "当天有记录  keyUinTimes totalTimes + 1：" + (paramInt + 1));
      StorageUtil.getPreference().edit().putInt(str2, paramInt + 1).apply();
    }
    QMLog.d("MiniLoadingAdManager", "当天有记录  keyUinAppidTimes totalTimesForAppid + 1：" + (i + 1));
    StorageUtil.getPreference().edit().putInt(paramString2, i + 1).apply();
  }
  
  public void preloadLoadingAd(Context paramContext, MiniAppInfo paramMiniAppInfo)
  {
    String str = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAccount();
    QMLog.d("MiniLoadingAdManager", "preloadLoadingAd start");
    if ((paramMiniAppInfo == null) || (TextUtils.isEmpty(paramMiniAppInfo.appId)) || (!paramMiniAppInfo.enableLoadingAd))
    {
      QMLog.d("MiniLoadingAdManager", "preloadLoadingAd 没开广告位");
      return;
    }
    if (!checkLoadingAdFrequencyLimitation(paramMiniAppInfo.appId, str, 1))
    {
      QMLog.d("MiniLoadingAdManager", "preloadLoadingAd 频控限制");
      return;
    }
    if (!extraPreloadIntervalCheck(paramMiniAppInfo.appId, str))
    {
      QMLog.d("MiniLoadingAdManager", "preloadLoadingAd 频控限制");
      return;
    }
    requestPreloadLoadingAd(paramContext, paramMiniAppInfo, str);
  }
  
  public boolean selectAd(Context paramContext, MiniAppInfo paramMiniAppInfo, String paramString, @NonNull OnChooseAdEndListener paramOnChooseAdEndListener)
  {
    if (!checkSelectAdNecessity(paramMiniAppInfo, paramString))
    {
      QMLog.d("MiniLoadingAdManager", "checkSelectAdNecessity fail");
      return false;
    }
    ThreadManager.getSubThreadHandler().post(new MiniLoadingAdManager.1(this, paramContext, paramMiniAppInfo, paramString, paramOnChooseAdEndListener));
    return true;
  }
  
  public void updateLoadingAdLayoutAndShow(MiniAppInfo paramMiniAppInfo, Activity paramActivity, boolean paramBoolean, String paramString, long paramLong, OnDismissListener paramOnDismissListener)
  {
    if ((AdProxy)ProxyManager.get(AdProxy.class) == null) {
      QMLog.i("MiniLoadingAdManager", "start create, null");
    }
    String str;
    do
    {
      return;
      str = (String)cachedAidFilePathMap.get(Long.valueOf(paramLong));
    } while (TextUtils.isEmpty(str));
    SDKMiniProgramLpReportDC04239.reportMiniAppEvent(paramMiniAppInfo, SDKMiniProgramLpReportDC04239.getAppType(paramMiniAppInfo), null, "ad", "ad_loading", "expo_call", null);
    ((AdProxy)ProxyManager.get(AdProxy.class)).updateLoadingAdLayoutAndShow(paramActivity, paramBoolean, paramString, paramMiniAppInfo.name, paramMiniAppInfo.iconUrl, paramMiniAppInfo.developerDesc, str, new MiniLoadingAdManager.3(this, paramMiniAppInfo, paramOnDismissListener, paramActivity));
  }
  
  public static abstract interface OnChooseAdEndListener
  {
    public abstract void onChooseAdEnd(String paramString, long paramLong);
  }
  
  public static abstract interface OnDismissListener
  {
    public abstract void onDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.MiniLoadingAdManager
 * JD-Core Version:    0.7.0.1
 */