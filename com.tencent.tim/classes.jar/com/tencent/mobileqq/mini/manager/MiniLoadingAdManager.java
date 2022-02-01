package com.tencent.mobileqq.mini.manager;

import NS_MINI_AD.MiniAppAd.SpecifiedAdsItem;
import NS_MINI_AD.MiniAppAd.StGetAdReq;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import aqft;
import aqhq;
import arxa;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.appbrand.utils.ThreadPools;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.util.AdUtils;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.mobileqq.mini.widget.MiniLoadingAdLayout;
import com.tencent.mobileqq.mini.widget.MiniLoadingAdLayout.OnDismissListener;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.io.File;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;

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
  private static long maxAdCachedSize = 20971520L;
  private static volatile MiniLoadingAdManager sInstance;
  private int extraPreloadInterval = QzoneConfig.getInstance().getConfig("qqminiapp", "launch_adv_app_preload_interval", 0);
  private int maxPreloadCountForUin = QzoneConfig.getInstance().getConfig("qqminiapp", "launch_adv_user_preload_limit", 2147483647);
  private int maxPreloadCountForUinAndAppid = QzoneConfig.getInstance().getConfig("qqminiapp", "launch_adv_app_preload_limit", 2);
  private int maxSelectCountForUin = QzoneConfig.getInstance().getConfig("qqminiapp", "launch_adv_user_select_limit", 3);
  private int maxSelectCountForUinAndAppid = QzoneConfig.getInstance().getConfig("qqminiapp", "launch_adv_app_select_limit", 1);
  
  private static void checkCacheFolder()
  {
    if (aqhq.getFileOrFolderSize(MiniAppFileManager.getLoadingAdCacheFolder()) > maxAdCachedSize)
    {
      QLog.d("MiniLoadingAdManager", 1, "yuki checkCacheFolder size > maxAdCachedSize ");
      aqhq.cm(MiniAppFileManager.getLoadingAdCacheFolder());
    }
  }
  
  private boolean checkHasLoadingAdCache(@NonNull String paramString1, @NonNull String paramString2)
  {
    paramString1 = getCurCachedAdsList(paramString1, paramString2);
    return (paramString1 != null) && (paramString1.size() > 0);
  }
  
  private boolean checkLoadingAdFrequencyLimitation(@NonNull String paramString1, @NonNull String paramString2, @CheckLoadingAdLimitType int paramInt)
  {
    String str1 = getPrefix(paramInt) + paramString2;
    String str2 = str1 + "_times";
    paramString1 = getPrefix(paramInt) + paramString2 + "_" + paramString1;
    paramString2 = paramString1 + "_times";
    long l1 = StorageUtil.getPreference().getLong(str1, 0L);
    int i = StorageUtil.getPreference().getInt(str2, 0);
    long l2 = StorageUtil.getPreference().getLong(paramString1, 0L);
    int j = StorageUtil.getPreference().getInt(paramString2, 0);
    QLog.d("MiniLoadingAdManager", 1, "yuki lastTimestamp:" + l1 + " totalTimes:" + i + " lastTimestampForAppid:" + l2 + " totalTimesForAppid:" + j);
    if ((l1 != aqft.getCurZeroTimeMillis()) || (i < 1))
    {
      QLog.d("MiniLoadingAdManager", 1, "yuki 如果该uin记录的时间节点不在当天 或总次数没有记录 返回true lastTimestamp：" + l1 + " totalTimes:" + i);
      return true;
    }
    if (i >= getLimit(paramInt, false))
    {
      QLog.d("MiniLoadingAdManager", 1, "yuki 如果当日该uin超过规定次数 返回false totalTimes：" + i + " getLimit(mode, false):" + getLimit(paramInt, false));
      arxa.a().showToast("mode:" + paramInt + " 频控 总次数超限");
      return false;
    }
    if ((l2 != aqft.getCurZeroTimeMillis()) || (j < 1))
    {
      QLog.d("MiniLoadingAdManager", 1, "yuki 如果该uin在当前appid没有今天记录的情况 或总次数没有记录 返回true lastTimestampForAppid：" + l2 + " Utils.getCurZeroTimeMillis():" + aqft.getCurZeroTimeMillis() + " totalTimesForAppid：" + j);
      return true;
    }
    if (j >= getLimit(paramInt, true))
    {
      QLog.d("MiniLoadingAdManager", 1, "yuki 如果该uin在当前appid超过规定次数 返回false totalTimesForAppid：" + j + " getLimit(mode, true):" + getLimit(paramInt, true));
      arxa.a().showToast("mode:" + paramInt + " 频控 appid次数超限");
      return false;
    }
    return true;
  }
  
  private boolean checkSelectAdNecessity(MiniAppConfig paramMiniAppConfig, String paramString)
  {
    if ((paramMiniAppConfig == null) || (TextUtils.isEmpty(paramString)))
    {
      QLog.d("MiniLoadingAdManager", 1, "yuki checkSelectAdNecessity 参数不合法");
      return false;
    }
    if ((paramMiniAppConfig.launchParam == null) || (paramMiniAppConfig.launchParam.scene == 2054))
    {
      QLog.d("MiniLoadingAdManager", 1, "yuki checkSelectAdNecessity 来源于广告scene");
      arxa.a().showToast("select 来源于广告scene");
      return false;
    }
    if ((paramMiniAppConfig.config == null) || ((paramMiniAppConfig.config.via.startsWith("2054_")) && (!paramMiniAppConfig.config.via.equals("2054_16"))))
    {
      QLog.d("MiniLoadingAdManager", 1, "yuki checkSelectAdNecessity 来源于广告via");
      arxa.a().showToast("select 来源于广告via");
      return false;
    }
    if ((TextUtils.isEmpty(paramMiniAppConfig.config.appId)) || (!paramMiniAppConfig.config.enableLoadingAd))
    {
      QLog.d("MiniLoadingAdManager", 1, "yuki checkSelectAdNecessity 没开广告位");
      arxa.a().showToast("select 没开广告位");
      return false;
    }
    if (!checkHasLoadingAdCache(paramString, paramMiniAppConfig.config.appId))
    {
      QLog.d("MiniLoadingAdManager", 1, "yuki checkSelectAdNecessity 本地没广告");
      arxa.a().showToast("select 本地没广告");
      return false;
    }
    if (!checkLoadingAdFrequencyLimitation(paramMiniAppConfig.config.appId, paramString, 0))
    {
      QLog.d("MiniLoadingAdManager", 1, "yuki checkSelectAdNecessity 频控限制");
      return false;
    }
    return true;
  }
  
  public static void downloadAndSaveLoadingAd(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = "mini_loading_ad_preload_adjson_key_" + paramString2 + "_" + paramString3;
    StorageUtil.getPreference().edit().putString((String)localObject, new JSONObject().toString()).apply();
    checkCacheFolder();
    paramString1 = AdUtils.convertJson2GdtAds(paramString1);
    if ((paramString1 == null) || (paramString1.isEmpty())) {}
    for (;;)
    {
      return;
      paramString1 = paramString1.iterator();
      while (paramString1.hasNext())
      {
        localObject = new CachedAdInfo((GdtAd)paramString1.next(), paramString2, paramString3);
        if (((CachedAdInfo)localObject).isValid()) {
          ThreadPools.getNetworkIOThreadPool().execute(new MiniLoadingAdManager.3((CachedAdInfo)localObject));
        }
      }
    }
  }
  
  private boolean extraPreloadIntervalCheck(String paramString1, String paramString2)
  {
    boolean bool2 = true;
    paramString1 = "mini_loading_ad_extra_preload_interval_check__" + paramString2 + "_" + paramString1;
    long l = StorageUtil.getPreference().getLong(paramString1, -1L);
    boolean bool1 = bool2;
    if (l > 0L)
    {
      bool1 = bool2;
      if ((System.currentTimeMillis() - l) / 1000L <= this.extraPreloadInterval)
      {
        QLog.d("MiniLoadingAdManager", 1, "yuki 连续preload小于时间间隔 返回false (System.currentTimeMillis() - lastTimestamp) / 1000：" + (System.currentTimeMillis() - l) / 1000L + " extraPreloadInterval:" + this.extraPreloadInterval);
        arxa.a().showToast("连续preload小于时间间隔");
        bool1 = false;
      }
    }
    return bool1;
  }
  
  private static void extraPreloadIntervalUpdate(String paramString1, String paramString2)
  {
    paramString1 = "mini_loading_ad_extra_preload_interval_check__" + paramString2 + "_" + paramString1;
    StorageUtil.getPreference().edit().putLong(paramString1, System.currentTimeMillis()).apply();
  }
  
  private static MiniAppAd.StGetAdReq getAdReq(MiniAppConfig paramMiniAppConfig, String paramString, int paramInt)
  {
    if ((paramMiniAppConfig != null) && (paramMiniAppConfig.isEngineTypeMiniGame()))
    {
      i = 1;
      if (i != 0) {
        break label222;
      }
    }
    Object localObject3;
    Object localObject4;
    Object localObject2;
    Object localObject1;
    String str1;
    int j;
    label222:
    for (int i = 14;; i = 15)
    {
      localObject3 = "";
      localObject4 = "";
      String str4 = "";
      String str2 = "";
      String str3 = "";
      localObject2 = localObject3;
      localObject1 = localObject4;
      str1 = str4;
      if (paramMiniAppConfig != null)
      {
        localObject2 = localObject3;
        localObject1 = localObject4;
        str1 = str4;
        if (paramMiniAppConfig.launchParam != null)
        {
          localObject2 = paramMiniAppConfig.launchParam.entryPath;
          localObject1 = paramMiniAppConfig.launchParam.reportData;
          str1 = String.valueOf(paramMiniAppConfig.launchParam.scene);
        }
      }
      localObject4 = str3;
      localObject3 = str2;
      if (paramMiniAppConfig != null)
      {
        localObject4 = str3;
        localObject3 = str2;
        if (paramMiniAppConfig.config != null)
        {
          localObject3 = paramMiniAppConfig.config.via;
          localObject4 = paramMiniAppConfig.config.appId;
        }
      }
      paramMiniAppConfig = AdUtils.getSpAdGdtCookie(i);
      j = QzoneConfig.getInstance().getConfig("QZoneSetting", "MiniGameShareRate", 53);
      if (paramInt != 0) {
        break label228;
      }
      return AdUtils.createAdRequest(BaseApplicationImpl.getContext(), Long.parseLong(paramString), "", (String)localObject4, j, i, 0, paramMiniAppConfig, (String)localObject2, (String)localObject1, str1, (String)localObject3, 1, 2, getCurCachedAdsList(paramString, (String)localObject4));
      i = 0;
      break;
    }
    label228:
    if (paramInt == 1) {
      return AdUtils.createAdRequest(BaseApplicationImpl.getContext(), Long.parseLong(paramString), "", (String)localObject4, j, i, 0, paramMiniAppConfig, (String)localObject2, (String)localObject1, str1, (String)localObject3, 1, 1, null);
    }
    return null;
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
  
  private long getLimit(@CheckLoadingAdLimitType int paramInt, boolean paramBoolean)
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
  
  private static String getPrefix(@CheckLoadingAdLimitType int paramInt)
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
  
  public static void requestPreloadLoadingAd(MiniAppConfig paramMiniAppConfig, String paramString)
  {
    if ((paramMiniAppConfig == null) || (paramMiniAppConfig.config == null)) {
      return;
    }
    QLog.d("MiniLoadingAdManager", 1, "yuki requestPreloadLoadingAd 开始");
    MiniAppAd.StGetAdReq localStGetAdReq = getAdReq(paramMiniAppConfig, paramString, 1);
    MiniAppCmdUtil.getInstance().getRewardedVideoADInfo(localStGetAdReq, new MiniLoadingAdManager.2(paramString, paramMiniAppConfig));
  }
  
  private static void updateLoadingAdFrequencyLimitationRecord(@NonNull String paramString1, @NonNull String paramString2, @CheckLoadingAdLimitType int paramInt)
  {
    String str1 = getPrefix(paramInt) + paramString2;
    String str2 = str1 + "_times";
    paramString1 = getPrefix(paramInt) + paramString2 + "_" + paramString1;
    paramString2 = paramString1 + "_times";
    long l1 = StorageUtil.getPreference().getLong(str1, 0L);
    paramInt = StorageUtil.getPreference().getInt(str2, 0);
    long l2 = StorageUtil.getPreference().getLong(paramString1, 0L);
    int i = StorageUtil.getPreference().getInt(paramString2, 0);
    long l3 = aqft.getCurZeroTimeMillis();
    if (l1 != l3)
    {
      QLog.d("MiniLoadingAdManager", 1, "yuki 当天没有记录 或者从来都没有过记录 keyUinTimestamp todayTimestamp：" + l3 + " keyUinTimestamp：1");
      StorageUtil.getPreference().edit().putLong(str1, l3).apply();
      StorageUtil.getPreference().edit().putInt(str2, 1).apply();
    }
    while (l2 != l3)
    {
      QLog.d("MiniLoadingAdManager", 1, "yuki 当天没有记录 或者从来都没有过记录 keyUinAppidTimestamp todayTimestamp：" + l3 + " keyUinAppidTimes：1");
      StorageUtil.getPreference().edit().putLong(paramString1, l3).apply();
      StorageUtil.getPreference().edit().putInt(paramString2, 1).apply();
      return;
      QLog.d("MiniLoadingAdManager", 1, "yuki 当天有记录  keyUinTimes totalTimes + 1：" + (paramInt + 1));
      StorageUtil.getPreference().edit().putInt(str2, paramInt + 1).apply();
    }
    QLog.d("MiniLoadingAdManager", 1, "yuki 当天有记录  keyUinAppidTimes totalTimesForAppid + 1：" + (i + 1));
    StorageUtil.getPreference().edit().putInt(paramString2, i + 1).apply();
  }
  
  public MiniLoadingAdLayout getLoadingAdLayout(MiniAppConfig paramMiniAppConfig, Context paramContext, boolean paramBoolean, String paramString, GdtAd paramGdtAd)
  {
    paramContext = new MiniLoadingAdLayout(paramContext);
    paramContext.setupUI(paramMiniAppConfig, paramBoolean, paramString, paramGdtAd);
    QLog.d("MiniLoadingAdManager", 1, "yuki getLoadingAdLayout filePath " + paramString);
    return paramContext;
  }
  
  public void preloadLoadingAd(MiniAppConfig paramMiniAppConfig, String paramString)
  {
    QLog.d("MiniLoadingAdManager", 1, "yuki preloadLoadingAd start");
    if ((paramMiniAppConfig.config == null) || (TextUtils.isEmpty(paramMiniAppConfig.config.appId)) || (!paramMiniAppConfig.config.enableLoadingAd))
    {
      QLog.d("MiniLoadingAdManager", 1, "yuki preloadLoadingAd 没开广告位");
      arxa.a().showToast("预加载 没开广告位");
      return;
    }
    if (!checkLoadingAdFrequencyLimitation(paramMiniAppConfig.config.appId, paramString, 1))
    {
      QLog.d("MiniLoadingAdManager", 1, "yuki preloadLoadingAd 频控限制");
      return;
    }
    if (!extraPreloadIntervalCheck(paramMiniAppConfig.config.appId, paramString))
    {
      QLog.d("MiniLoadingAdManager", 1, "yuki preloadLoadingAd 频控限制");
      return;
    }
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("uin", paramString);
      localBundle.putParcelable("app_config", paramMiniAppConfig);
      QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", "preload_loading_ad", localBundle, null);
      return;
    }
    catch (Exception paramMiniAppConfig)
    {
      QLog.e("MiniLoadingAdManager", 1, paramMiniAppConfig, new Object[0]);
    }
  }
  
  public boolean selectAd(MiniAppConfig paramMiniAppConfig, String paramString, @NonNull OnChooseAdEndListener paramOnChooseAdEndListener)
  {
    if (!checkSelectAdNecessity(paramMiniAppConfig, paramString))
    {
      QLog.d("MiniLoadingAdManager", 1, "yuki checkSelectAdNecessity fail");
      return false;
    }
    ThreadManager.getSubThreadHandler().post(new MiniLoadingAdManager.1(this, paramMiniAppConfig, paramString, paramOnChooseAdEndListener));
    return true;
  }
  
  public void show(MiniLoadingAdLayout paramMiniLoadingAdLayout, String paramString1, String paramString2, MiniLoadingAdLayout.OnDismissListener paramOnDismissListener)
  {
    paramMiniLoadingAdLayout.show(paramOnDismissListener);
    updateLoadingAdFrequencyLimitationRecord(paramString1, paramString2, 0);
  }
  
  static class CachedAdInfo
  {
    private long aid;
    private long creativeId;
    private String filePath;
    private Downloader.DownloadListener listener = new MiniLoadingAdManager.CachedAdInfo.1(this);
    private String saveKey;
    private String url;
    
    public CachedAdInfo(GdtAd paramGdtAd, String paramString1, String paramString2)
    {
      if ((paramGdtAd != null) && (paramGdtAd.info != null) && (paramGdtAd.info.display_info != null))
      {
        if ((paramGdtAd.info.display_info.basic_info != null) && (paramGdtAd.info.display_info.basic_info.img != null) && (!TextUtils.isEmpty(paramGdtAd.info.display_info.basic_info.img.get()))) {
          this.url = paramGdtAd.info.display_info.basic_info.img.get();
        }
        if ((paramGdtAd.info.report_info != null) && (paramGdtAd.info.report_info.trace_info != null))
        {
          this.aid = paramGdtAd.info.report_info.trace_info.aid.get();
          this.creativeId = paramGdtAd.info.report_info.trace_info.creative_id.get();
        }
        if (!TextUtils.isEmpty(this.url)) {
          this.filePath = MiniAppFileManager.getLoadingAdCacheFilePath(this.url, paramString1);
        }
      }
      this.saveKey = ("mini_loading_ad_preload_adjson_key_" + paramString1 + "_" + paramString2);
    }
    
    public boolean isValid()
    {
      return (!TextUtils.isEmpty(this.url)) && (!TextUtils.isEmpty(this.filePath)) && (this.aid != 0L) && (this.creativeId != 0L);
    }
  }
  
  static @interface CheckLoadingAdLimitType {}
  
  public static abstract interface OnChooseAdEndListener
  {
    public abstract void onChooseAdEnd(String paramString, GdtAd paramGdtAd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.manager.MiniLoadingAdManager
 * JD-Core Version:    0.7.0.1
 */