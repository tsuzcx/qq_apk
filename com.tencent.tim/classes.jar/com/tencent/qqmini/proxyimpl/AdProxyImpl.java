package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.View;
import astm;
import astn;
import asto;
import astq;
import astr;
import asts;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Options;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.api.motivebrowsing.RewardedBrowsingCallbackReceiver;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoFragment;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoPageData;
import com.tencent.gdtad.statistics.GdtDwellTimeStatisticsAfterClick;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst.AdConst;
import com.tencent.mobileqq.minigame.data.BlockAdInfo;
import com.tencent.mobileqq.minigame.ui.GameBannerAdFragment;
import com.tencent.mobileqq.minigame.widget.BlockAdView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.AppRuntimeLoaderManager;
import com.tencent.qqmini.sdk.launcher.BaseRuntimeLoader;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsBannerAdView;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsBlockAdView;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsBoxAdView;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsInterstitialAdView;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsRewardVideoAdView;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IBannerAdListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IBlockAdListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IBoxADLisener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ICmdListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IRewardVideoAdListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.InterstitialADLisener;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.model.LoginInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tgo;
import thd;
import the;
import thf;
import thm;
import tkv;

@ProxyService(proxy=AdProxy.class)
public class AdProxyImpl
  extends AdProxy
{
  private static HashMap<String, a> rewardedCallbackData;
  private final String TAG = "AdProxyImpl";
  private GdtAppReceiver mGgtAppReceiver;
  private RewardedBrowsingCallbackReceiver mRewardedBrowsingCallbackReceiver;
  
  public AdProxyImpl()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdProxyImpl", 2, "AdProxyImpl constructor");
    }
    esh();
  }
  
  private GdtHandler.Params a(Activity paramActivity, qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, IMiniAppContext paramIMiniAppContext)
  {
    if ((paramActivity == null) || (paramAdInfo == null)) {
      paramActivity = null;
    }
    GdtHandler.Params localParams;
    do
    {
      return paramActivity;
      if (this.mGgtAppReceiver == null)
      {
        this.mGgtAppReceiver = new GdtAppReceiver();
        this.mGgtAppReceiver.register(paramActivity);
      }
      localParams = new GdtHandler.Params();
      localParams.processId = 11;
      localParams.activity = new WeakReference(paramActivity);
      localParams.ad = new GdtAd(paramAdInfo);
      localParams.reportForClick = true;
      localParams.aOV = true;
      localParams.appReceiver = new WeakReference(this.mGgtAppReceiver);
      localParams.p = GameBannerAdFragment.class;
      paramActivity = new Bundle();
      paramActivity.putString("big_brother_ref_source_key", "biz_src_miniapp");
      localParams.extra = paramActivity;
      paramActivity = localParams;
    } while (paramAdInfo.report_info == null);
    localParams.aO = asts.a(paramIMiniAppContext, paramAdInfo.report_info.click_url.get());
    return localParams;
  }
  
  private qq_ad_get.QQAdGetRsp.AdInfo a(String paramString)
  {
    try
    {
      qq_ad_get.QQAdGetRsp.AdInfo localAdInfo = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(tkv.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo(), new JSONObject(paramString)));
      return localAdInfo;
    }
    catch (Exception localException)
    {
      QLog.i("AdProxyImpl", 2, "parseJson2AdInfo error" + paramString, localException);
    }
    return null;
  }
  
  private the a(Activity paramActivity, qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, int paramInt1, int paramInt2, IMiniAppContext paramIMiniAppContext)
  {
    QLog.i("AdProxyImpl", 1, "createBannerAdView width = " + paramInt1 + ", height = " + paramInt2);
    if (paramAdInfo == null) {
      return null;
    }
    try
    {
      QLog.i("AdProxyImpl", 1, "createBannerAd");
      thd localthd = new thd();
      localthd.c = a(paramActivity, paramAdInfo, paramIMiniAppContext);
      localthd.style = 0;
      localthd.width = paramInt1;
      localthd.height = paramInt2;
      paramActivity = thf.a(localthd);
      if (paramActivity != null) {
        localthd.a = new GdtDwellTimeStatisticsAfterClick(new GdtAd(paramAdInfo), new WeakReference(paramActivity.getView()));
      } else {
        QLog.e("AdProxyImpl", 1, "build Ad error");
      }
    }
    catch (Exception paramActivity)
    {
      QLog.e("AdProxyImpl", 1, "createBannerAd, error", paramActivity);
      paramActivity = null;
    }
    return paramActivity;
  }
  
  private void a(IMiniAppContext paramIMiniAppContext, qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo)
  {
    if ((paramAdInfo == null) || (paramAdInfo.report_info == null)) {
      return;
    }
    asts.a(paramIMiniAppContext, paramAdInfo.report_info.click_url.get());
  }
  
  private void esh()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("AD_PROXY_ACTION_MOTIVE_BROWSING_END");
    if (QLog.isColorLevel()) {
      QLog.d("AdProxyImpl", 2, "onCreate registerReceiver mRewardedBrowsingCallbackReceiver");
    }
    this.mRewardedBrowsingCallbackReceiver = new RewardedBrowsingCallbackReceiver(null, this);
    BaseApplicationImpl.getApplication().registerReceiver(this.mRewardedBrowsingCallbackReceiver, localIntentFilter);
  }
  
  private String rj(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      int i = paramString.optInt("ret", -1);
      if ((i != 0) && (i == 102006))
      {
        QLog.e("AdProxyImpl", 1, "mockAdJson failed ret == 102006");
        return null;
      }
      paramString = ((JSONObject)((JSONObject)paramString.getJSONArray("pos_ads_info").get(0)).getJSONArray("ads_info").get(0)).toString();
      return paramString;
    }
    catch (Exception paramString)
    {
      QLog.e("AdProxyImpl", 1, "mockAdJson failed e:", paramString);
    }
    return null;
  }
  
  private void saveAdCookie(String paramString, int paramInt)
  {
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramString);
        if (!((JSONObject)localObject).has("gdt_cookie")) {
          break;
        }
        String str2 = ((JSONObject)localObject).getString("gdt_cookie");
        if (TextUtils.isEmpty(str2)) {
          return;
        }
        localObject = (MiniAppProxy)AppLoaderFactory.g().getProxyManager().get(MiniAppProxy.class);
        if ((localObject != null) && (((MiniAppProxy)localObject).getAccount() == null) && (AppLoaderFactory.g().getMiniAppEnv().getLoginInfo() != null))
        {
          localObject = AppLoaderFactory.g().getMiniAppEnv().getLoginInfo().getAccount();
          localObject = "gdt_cookie_" + (String)localObject + "_" + paramInt;
          StorageUtil.getPreference().edit().putString((String)localObject, str2).apply();
          QLog.i("AdProxyImpl", 1, "parseAndSaveCookie save key success, adType = " + paramInt + ", value = " + str2);
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.i("AdProxyImpl", 1, "parseAndSaveCookie error" + paramString, localException);
        return;
      }
      String str1;
      if (localException != null) {
        str1 = localException.getAccount();
      } else {
        str1 = "";
      }
    }
  }
  
  public boolean adClick(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramContext == null) || (!(paramContext instanceof Activity)) || (TextUtils.isEmpty(paramString1))) {
      return false;
    }
    Activity localActivity = (Activity)paramContext;
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString1);
        paramContext = "";
        paramString2 = new JSONObject();
        paramString1 = paramContext;
        if (localJSONObject.has("data"))
        {
          localJSONObject = localJSONObject.optJSONObject("data");
          paramString1 = paramContext;
          if (localJSONObject != null)
          {
            paramString1 = paramContext;
            if (localJSONObject.has("data"))
            {
              localJSONObject = localJSONObject.optJSONObject("data");
              paramString1 = paramContext;
              if (localJSONObject != null)
              {
                if (localJSONObject.has("ads_info")) {
                  paramContext = localJSONObject.optString("ads_info");
                }
                paramString1 = paramContext;
                if (localJSONObject.has("extraReportData"))
                {
                  paramString2 = localJSONObject.optJSONObject("extraReportData");
                  paramString1 = paramContext;
                  paramContext = paramString2;
                  paramString1 = new JSONObject(paramString1);
                  paramString2 = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(tkv.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo(), paramString1));
                  if (this.mGgtAppReceiver == null)
                  {
                    this.mGgtAppReceiver = new GdtAppReceiver();
                    this.mGgtAppReceiver.register(localActivity);
                  }
                  paramString1 = new GdtHandler.Params();
                  paramString1.processId = 11;
                  paramString1.activity = new WeakReference(localActivity);
                  paramString1.ad = new GdtAd(paramString2);
                  paramString1.reportForClick = true;
                  paramString1.aOV = true;
                  paramString1.appReceiver = new WeakReference(this.mGgtAppReceiver);
                  paramString1.p = GameBannerAdFragment.class;
                  paramString2 = new Bundle();
                  paramString2.putString("big_brother_ref_source_key", "biz_src_miniappD");
                  paramString1.extra = paramString2;
                  paramString1.aO = paramContext;
                  GdtHandler.a(paramString1);
                  return true;
                }
              }
            }
          }
        }
      }
      catch (JSONException paramContext)
      {
        return false;
      }
      paramContext = paramString2;
    }
  }
  
  public boolean adExposure(Context paramContext, String paramString1, String paramString2)
  {
    return super.adExposure(paramContext, paramString1, paramString2);
  }
  
  public AdProxy.AbsBannerAdView createBannerAdView(Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2, AdProxy.IBannerAdListener paramIBannerAdListener, Bundle paramBundle, IMiniAppContext paramIMiniAppContext)
  {
    if ((paramActivity == null) || (paramBundle == null)) {
      return null;
    }
    return new b(paramActivity, paramString1, paramString2, paramBundle.getString(AdProxy.KEY_ACCOUNT), paramBundle.getInt(AdProxy.KEY_AD_TYPE), paramBundle.getInt(AdProxy.KEY_ORIENTATION), paramBundle.getString(AdProxy.KEY_GDT_COOKIE), paramBundle.getString(AdProxy.KEY_ENTRY_PATH), paramBundle.getString(AdProxy.KEY_REPORT_DATA), paramBundle.getString(AdProxy.KEY_REFER), paramBundle.getString(AdProxy.KEY_VIA), paramInt1, paramInt2, paramIBannerAdListener, paramIMiniAppContext);
  }
  
  public AdProxy.AbsBlockAdView createBlockAdView(Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, AdProxy.IBlockAdListener paramIBlockAdListener, Bundle paramBundle)
  {
    if ((paramActivity == null) || (paramBundle == null)) {
      return null;
    }
    return new c(paramActivity, paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramBundle.getString(AdProxy.KEY_ACCOUNT), paramBundle.getInt(AdProxy.KEY_AD_TYPE), paramBundle.getInt(AdProxy.KEY_ORIENTATION), paramBundle.getString(AdProxy.KEY_GDT_COOKIE), paramBundle.getString(AdProxy.KEY_ENTRY_PATH), paramBundle.getString(AdProxy.KEY_REPORT_DATA), paramBundle.getString(AdProxy.KEY_REFER), paramBundle.getString(AdProxy.KEY_VIA), paramIBlockAdListener);
  }
  
  public AdProxy.AbsBoxAdView createBoxAdView(Activity paramActivity, String paramString1, String paramString2, AdProxy.IBoxADLisener paramIBoxADLisener, Bundle paramBundle)
  {
    if ((paramActivity == null) || (paramBundle == null)) {
      return null;
    }
    return new d(paramActivity, paramString1, paramString2, paramBundle.getString(AdProxy.KEY_ACCOUNT), paramBundle.getInt(AdProxy.KEY_AD_TYPE), paramBundle.getInt(AdProxy.KEY_ORIENTATION), paramBundle.getString(AdProxy.KEY_GDT_COOKIE), paramBundle.getString(AdProxy.KEY_ENTRY_PATH), paramBundle.getString(AdProxy.KEY_REPORT_DATA), paramBundle.getString(AdProxy.KEY_REFER), paramBundle.getString(AdProxy.KEY_VIA), paramIBoxADLisener);
  }
  
  public AdProxy.AbsInterstitialAdView createInterstitialAdView(Activity paramActivity, String paramString1, String paramString2, AdProxy.InterstitialADLisener paramInterstitialADLisener, Bundle paramBundle)
  {
    if ((paramActivity == null) || (paramBundle == null)) {
      return null;
    }
    return new e(paramActivity, paramString1, paramString2, paramBundle.getString(AdProxy.KEY_ACCOUNT), paramBundle.getInt(AdProxy.KEY_AD_TYPE), paramBundle.getInt(AdProxy.KEY_ORIENTATION), paramBundle.getString(AdProxy.KEY_GDT_COOKIE), paramBundle.getString(AdProxy.KEY_ENTRY_PATH), paramBundle.getString(AdProxy.KEY_REPORT_DATA), paramBundle.getString(AdProxy.KEY_REFER), paramBundle.getString(AdProxy.KEY_VIA), paramInterstitialADLisener);
  }
  
  public AdProxy.AbsRewardVideoAdView createRewardVideoAdView(Context paramContext, String paramString1, String paramString2, AdProxy.IRewardVideoAdListener paramIRewardVideoAdListener, Bundle paramBundle)
  {
    if ((paramContext == null) || (paramBundle == null)) {
      return null;
    }
    return new f(paramContext, paramString1, paramString2, paramBundle.getString(AdProxy.KEY_ACCOUNT), paramBundle.getInt(AdProxy.KEY_AD_TYPE), paramBundle.getInt(AdProxy.KEY_ORIENTATION), paramBundle.getString(AdProxy.KEY_GDT_COOKIE), paramBundle.getString(AdProxy.KEY_ENTRY_PATH), paramBundle.getString(AdProxy.KEY_REPORT_DATA), paramBundle.getString(AdProxy.KEY_REFER), paramBundle.getString(AdProxy.KEY_VIA), paramIRewardVideoAdListener);
  }
  
  public void destroy(Activity paramActivity)
  {
    if (this.mGgtAppReceiver != null) {}
    try
    {
      this.mGgtAppReceiver.unregister(paramActivity);
      label15:
      this.mGgtAppReceiver = null;
      if (this.mRewardedBrowsingCallbackReceiver != null) {}
      try
      {
        BaseApplicationImpl.getApplication().unregisterReceiver(this.mRewardedBrowsingCallbackReceiver);
        this.mRewardedBrowsingCallbackReceiver = null;
        return;
      }
      catch (Throwable paramActivity)
      {
        for (;;)
        {
          QLog.e("AdProxyImpl", 1, "unregisterReceiver exception.", paramActivity);
        }
      }
    }
    catch (Throwable paramActivity)
    {
      break label15;
    }
  }
  
  public void onActivityStart()
  {
    super.onActivityStart();
    asts.onStart();
  }
  
  public void onActivityStop()
  {
    super.onActivityStop();
    asts.onStop();
  }
  
  public void onFirstFrame()
  {
    super.onFirstFrame();
    asts.esi();
  }
  
  public void onReceiveVideoClose(Intent paramIntent)
  {
    if ((paramIntent != null) && (rewardedCallbackData != null))
    {
      String str = paramIntent.getStringExtra("KEY_MOTIVE_BROWSING");
      Object localObject = (a)rewardedCallbackData.get(str);
      if (localObject != null)
      {
        localObject = (f)a.a((a)localObject).get();
        rewardedCallbackData.remove(str);
        if (localObject != null) {
          ((f)localObject).R(-1, paramIntent.getExtras());
        }
      }
    }
  }
  
  public void requestAdInfo(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt4, AdProxy.ICmdListener paramICmdListener)
  {
    if (paramContext == null)
    {
      QLog.i("AdProxyImpl", 1, "context is null");
      if (paramICmdListener != null) {
        paramICmdListener.onCmdListener(true, null);
      }
      return;
    }
    ThreadManagerV2.excute(new AdProxyImpl.1(this, paramContext, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramString4, paramString5, paramString6, paramString7, paramString8, paramInt4, paramICmdListener), 16, null, false);
  }
  
  public static class AdResultReceiver
    extends ResultReceiver
  {
    private AdProxyImpl.f a;
    
    public AdResultReceiver(Handler paramHandler, AdProxyImpl.f paramf)
    {
      super();
      this.a = paramf;
    }
    
    protected void onReceiveResult(int paramInt, Bundle paramBundle)
    {
      super.onReceiveResult(paramInt, paramBundle);
      if (this.a != null)
      {
        this.a.R(paramInt, paramBundle);
        return;
      }
      QLog.d("AdResultReceiver", 1, "adView is null");
    }
  }
  
  static final class a
  {
    private static int dhF;
    private WeakReference<AdProxyImpl.f> view;
    
    private a(AdProxyImpl.f paramf)
    {
      this.view = new WeakReference(paramf);
    }
    
    private String createKey()
    {
      StringBuilder localStringBuilder = new StringBuilder().append("AD_PROXY_ACTION_MOTIVE_BROWSING_END#index#");
      int i = dhF;
      dhF = i + 1;
      return i;
    }
  }
  
  public class b
    extends AdProxy.AbsBannerAdView
  {
    public AdProxy.IBannerAdListener a;
    public long axI;
    String cFQ;
    String cFR;
    String cFS;
    int enY = 53;
    public String jH;
    WeakReference<Activity> mActivity;
    public int mAdType;
    String mAppid;
    int mDeviceOrientation;
    String mEntryPath;
    public the mGdtBannerView;
    public int mHeight;
    String mRefer;
    String mUin;
    String mVia;
    public int mWidth;
    public IMiniAppContext miniAppContext;
    
    public b(Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt3, int paramInt4, AdProxy.IBannerAdListener paramIBannerAdListener, IMiniAppContext paramIMiniAppContext)
    {
      super();
      this.mActivity = new WeakReference(paramActivity);
      this.a = paramIBannerAdListener;
      this.mAppid = paramString1;
      this.cFQ = paramString2;
      this.mUin = paramString3;
      this.mAdType = paramInt1;
      this.mDeviceOrientation = paramInt2;
      this.cFR = paramString4;
      this.mEntryPath = paramString5;
      this.cFS = paramString6;
      this.mRefer = paramString7;
      this.mVia = paramString8;
      this.mWidth = paramInt3;
      this.mHeight = paramInt4;
      this.miniAppContext = paramIMiniAppContext;
    }
    
    public void destroy(Context paramContext)
    {
      this.mActivity = null;
      this.a = null;
      this.mGdtBannerView = null;
    }
    
    public long getAdID()
    {
      return this.axI;
    }
    
    public String getReportUrl()
    {
      return this.jH;
    }
    
    public View getView()
    {
      if (this.mGdtBannerView != null) {
        return this.mGdtBannerView.getView();
      }
      return null;
    }
    
    public void loadAD()
    {
      Object localObject;
      if (this.mActivity != null)
      {
        localObject = (Activity)this.mActivity.get();
        if (localObject != null) {
          break label91;
        }
        localObject = new StringBuilder().append("loadAD, act is null, ");
        if (this.a == null) {
          break label86;
        }
      }
      label86:
      for (boolean bool = true;; bool = false)
      {
        QLog.e("AdProxyImpl", 1, bool);
        if (this.a != null) {
          this.a.onNoAD(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
        }
        return;
        localObject = null;
        break;
      }
      label91:
      AdProxyImpl.this.requestAdInfo((Context)localObject, this.mUin, this.cFQ, this.mAppid, this.enY, this.mAdType, this.mDeviceOrientation, this.cFR, this.mEntryPath, this.cFS, this.mRefer, this.mVia, 1, new astm(this, (Activity)localObject));
    }
    
    public void onExposure()
    {
      if (TextUtils.isEmpty(this.jH)) {
        return;
      }
      asts.a(this.miniAppContext, this.jH, System.currentTimeMillis());
    }
    
    public void pause(Context paramContext)
    {
      if (this.mGdtBannerView != null) {
        this.mGdtBannerView.pause(paramContext);
      }
    }
    
    public void resume(Context paramContext)
    {
      if (this.mGdtBannerView != null) {
        this.mGdtBannerView.resume(paramContext);
      }
    }
    
    public void setSize(int paramInt1, int paramInt2)
    {
      if (this.mGdtBannerView != null) {
        this.mGdtBannerView.setSize(paramInt1, paramInt2);
      }
    }
  }
  
  public class c
    extends AdProxy.AbsBlockAdView
  {
    public ArrayList<String> DR;
    public BlockAdInfo a;
    public BlockAdView a;
    public AdProxy.IBlockAdListener a;
    String cFR;
    String cFS;
    int enY = 53;
    WeakReference<Activity> mActivity;
    public int mAdType;
    String mAppid;
    int mDeviceOrientation;
    String mEntryPath;
    String mRefer;
    String mUin;
    String mVia;
    
    public c(Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString3, int paramInt6, int paramInt7, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, AdProxy.IBlockAdListener paramIBlockAdListener)
    {
      super();
      this.mActivity = new WeakReference(paramActivity);
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBlockAdListener = paramIBlockAdListener;
      this.mAppid = paramString1;
      this.mUin = paramString3;
      this.mAdType = paramInt6;
      this.mDeviceOrientation = paramInt7;
      this.cFR = paramString4;
      this.mEntryPath = paramString5;
      this.cFS = paramString6;
      this.mRefer = paramString7;
      this.mVia = paramString8;
      this.jdField_a_of_type_ComTencentMobileqqMinigameDataBlockAdInfo = new BlockAdInfo(paramString2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    }
    
    public void destroy(Context paramContext)
    {
      this.mActivity = null;
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBlockAdListener = null;
      this.jdField_a_of_type_ComTencentMobileqqMinigameWidgetBlockAdView = null;
    }
    
    public ArrayList<String> getReportUrl()
    {
      return this.DR;
    }
    
    public View getView()
    {
      return this.jdField_a_of_type_ComTencentMobileqqMinigameWidgetBlockAdView;
    }
    
    public void loadAD()
    {
      Object localObject;
      if (this.mActivity != null)
      {
        localObject = (Activity)this.mActivity.get();
        if (localObject != null) {
          break label91;
        }
        localObject = new StringBuilder().append("loadAD, act is null, ");
        if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBlockAdListener == null) {
          break label86;
        }
      }
      label86:
      for (boolean bool = true;; bool = false)
      {
        QLog.e("AdProxyImpl", 1, bool);
        if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBlockAdListener != null) {
          this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBlockAdListener.onNoAD(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
        }
        return;
        localObject = null;
        break;
      }
      label91:
      AdProxyImpl.this.requestAdInfo((Context)localObject, this.mUin, this.jdField_a_of_type_ComTencentMobileqqMinigameDataBlockAdInfo.getAdUnitId(), this.mAppid, this.enY, this.mAdType, this.mDeviceOrientation, this.cFR, this.mEntryPath, this.cFS, this.mRefer, this.mVia, this.jdField_a_of_type_ComTencentMobileqqMinigameDataBlockAdInfo.getSize(), new astn(this, (Activity)localObject));
    }
    
    public View updateAdInfo(int paramInt1, int paramInt2)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqMinigameDataBlockAdInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqMinigameWidgetBlockAdView == null)) {
        return null;
      }
      this.jdField_a_of_type_ComTencentMobileqqMinigameDataBlockAdInfo.setLeft(paramInt1);
      this.jdField_a_of_type_ComTencentMobileqqMinigameDataBlockAdInfo.setTop(paramInt2);
      this.jdField_a_of_type_ComTencentMobileqqMinigameWidgetBlockAdView.setData(this.jdField_a_of_type_ComTencentMobileqqMinigameDataBlockAdInfo);
      if ((this.jdField_a_of_type_ComTencentMobileqqMinigameWidgetBlockAdView.getRealAdNum() == 0) && (this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBlockAdListener != null))
      {
        this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBlockAdListener.onNoAD(1009, PluginConst.AdConst.ERROR_MSG_INVALID_POSITION);
        return null;
      }
      return this.jdField_a_of_type_ComTencentMobileqqMinigameWidgetBlockAdView;
    }
  }
  
  public class d
    extends AdProxy.AbsBoxAdView
  {
    public AdProxy.IBoxADLisener a;
    public tgo b;
    String cFQ;
    String cFR;
    String cFS;
    int enY = 53;
    WeakReference<Activity> mActivity;
    public int mAdType;
    String mAppid;
    int mDeviceOrientation;
    String mEntryPath;
    String mRefer;
    String mUin;
    String mVia;
    
    public d(Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, AdProxy.IBoxADLisener paramIBoxADLisener)
    {
      super();
      this.mActivity = new WeakReference(paramActivity);
      this.a = paramIBoxADLisener;
      this.mAppid = paramString1;
      this.cFQ = paramString2;
      this.mUin = paramString3;
      this.mAdType = paramInt1;
      this.mDeviceOrientation = paramInt2;
      this.cFR = paramString4;
      this.mEntryPath = paramString5;
      this.cFS = paramString6;
      this.mRefer = paramString7;
      this.mVia = paramString8;
    }
    
    public void destroy()
    {
      if (this.b != null) {
        this.b.destroy();
      }
      this.b = null;
      this.mActivity = null;
      this.a = null;
    }
    
    public void loadAD()
    {
      Object localObject;
      if (this.mActivity != null)
      {
        localObject = (Activity)this.mActivity.get();
        if (localObject != null) {
          break label91;
        }
        localObject = new StringBuilder().append("loadAD, act is null, ");
        if (this.a == null) {
          break label86;
        }
      }
      label86:
      for (boolean bool = true;; bool = false)
      {
        QLog.e("AdProxyImpl", 1, bool);
        if (this.a != null) {
          this.a.onError(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
        }
        return;
        localObject = null;
        break;
      }
      label91:
      AdProxyImpl.this.requestAdInfo((Context)localObject, this.mUin, this.cFQ, this.mAppid, this.enY, this.mAdType, this.mDeviceOrientation, this.cFR, this.mEntryPath, this.cFS, this.mRefer, this.mVia, 1, new asto(this, (Activity)localObject));
    }
    
    public void show()
    {
      if (this.b != null) {
        this.b.show();
      }
    }
  }
  
  public class e
    extends AdProxy.AbsInterstitialAdView
  {
    public AdProxy.InterstitialADLisener a;
    public thm c;
    String cFQ;
    String cFR;
    String cFS;
    int enY = 53;
    WeakReference<Activity> mActivity;
    public int mAdType;
    String mAppid;
    public int mDeviceOrientation;
    String mEntryPath;
    String mRefer;
    String mUin;
    String mVia;
    
    public e(Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, AdProxy.InterstitialADLisener paramInterstitialADLisener)
    {
      super();
      this.mActivity = new WeakReference(paramActivity);
      this.a = paramInterstitialADLisener;
      this.mAppid = paramString1;
      this.cFQ = paramString2;
      this.mUin = paramString3;
      this.mAdType = paramInt1;
      this.mDeviceOrientation = paramInt2;
      this.cFR = paramString4;
      this.mEntryPath = paramString5;
      this.cFS = paramString6;
      this.mRefer = paramString7;
      this.mVia = paramString8;
    }
    
    private GdtHandler.Options getClickOption(JSONObject paramJSONObject)
    {
      Object localObject = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(tkv.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo(), paramJSONObject));
      paramJSONObject = new GdtHandler.Options();
      paramJSONObject.ad = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)localObject);
      paramJSONObject.reportForClick = true;
      paramJSONObject.aOV = true;
      localObject = new Bundle();
      ((Bundle)localObject).putString("big_brother_ref_source_key", "biz_src_miniapp");
      paramJSONObject.extra = ((Bundle)localObject);
      return paramJSONObject;
    }
    
    public void destroy()
    {
      this.c = null;
      this.mActivity = null;
      this.a = null;
    }
    
    public void loadAD()
    {
      Object localObject;
      if (this.mActivity != null)
      {
        localObject = (Activity)this.mActivity.get();
        if (localObject != null) {
          break label91;
        }
        localObject = new StringBuilder().append("loadAD, act is null, ");
        if (this.a == null) {
          break label86;
        }
      }
      label86:
      for (boolean bool = true;; bool = false)
      {
        QLog.e("AdProxyImpl", 1, bool);
        if (this.a != null) {
          this.a.onError(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
        }
        return;
        localObject = null;
        break;
      }
      label91:
      AdProxyImpl.this.requestAdInfo((Context)localObject, this.mUin, this.cFQ, this.mAppid, this.enY, this.mAdType, this.mDeviceOrientation, this.cFR, this.mEntryPath, this.cFS, this.mRefer, this.mVia, 1, new astq(this, (Activity)localObject));
    }
    
    public void onClose(Activity paramActivity, int paramInt, Intent paramIntent)
    {
      try
      {
        if ((this.c != null) && (paramActivity != null)) {
          this.c.onClose(paramActivity, paramInt, paramIntent);
        }
        return;
      }
      catch (Exception paramActivity)
      {
        QLog.e("AdProxyImpl", 1, "onClose", paramActivity);
      }
    }
    
    public boolean show(Activity paramActivity)
    {
      if ((this.c != null) && (paramActivity != null))
      {
        boolean bool = this.c.show(paramActivity);
        if ((bool) && (this.a != null)) {
          this.a.onShow();
        }
        return bool;
      }
      return false;
    }
  }
  
  public class f
    extends AdProxy.AbsRewardVideoAdView
  {
    public GdtMotiveVideoPageData a;
    public AdProxy.IRewardVideoAdListener a;
    String cFQ;
    String cFR;
    String cFS;
    String cFT;
    int enY = 53;
    public int mAdType;
    String mAppid;
    WeakReference<Context> mContext;
    public int mDeviceOrientation;
    String mEntryPath;
    String mRefer;
    String mUin;
    String mVia;
    
    public f(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, AdProxy.IRewardVideoAdListener paramIRewardVideoAdListener)
    {
      super();
      this.mContext = new WeakReference(paramContext);
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IRewardVideoAdListener = paramIRewardVideoAdListener;
      this.mAppid = paramString1;
      this.cFQ = paramString2;
      this.mUin = paramString3;
      this.mAdType = paramInt1;
      this.mDeviceOrientation = paramInt2;
      this.cFR = paramString4;
      this.mEntryPath = paramString5;
      this.cFS = paramString6;
      this.mRefer = paramString7;
      this.mVia = paramString8;
    }
    
    public void R(int paramInt, Bundle paramBundle)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AdProxyImpl", 2, "onReceiveResult() called with: resultCode = [" + paramInt + "], resultData = [" + paramBundle + "]");
      }
      long l2 = paramBundle.getLong("duration_time");
      long l3 = paramBundle.getLong("elapsed_time");
      boolean bool = paramBundle.getBoolean("profitable_flag", false);
      long l1;
      if (l2 > l3)
      {
        l1 = l3;
        int j = (int)(l1 / 1000L);
        int i = j;
        if (j > 15) {
          i = 15;
        }
        Object localObject = null;
        paramBundle = localObject;
        if (AppRuntimeLoaderManager.g() != null)
        {
          paramBundle = localObject;
          if (AppRuntimeLoaderManager.g().getCurrentRunTimeLoader() != null) {
            paramBundle = AppRuntimeLoaderManager.g().getCurrentRunTimeLoader().getMiniAppInfo();
          }
        }
        if (paramBundle == null) {
          break label297;
        }
        paramBundle.gameAdsTotalTime += i;
        QLog.d("AdProxyImpl", 1, "RewardedAd now gameAdsTotalTime = " + paramBundle.gameAdsTotalTime + ", reportTime = " + i);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IRewardVideoAdListener != null)
        {
          if ((bool) && (paramInt == -1)) {
            this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IRewardVideoAdListener.onReward();
          }
          this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IRewardVideoAdListener.onADClose(this.cFT);
        }
        if (QLog.isColorLevel()) {
          QLog.d("AdProxyImpl", 1, "RewardedAd ActivityResultListener receive durationTime= " + l2 + " elaspedTime=" + l3 + " profitable=" + bool + ", resultCode = " + paramInt);
        }
        return;
        l1 = l2;
        break;
        label297:
        QLog.d("AdProxyImpl", 1, "RewardedAd miniAppInfo is null");
      }
    }
    
    public void loadAD(Context paramContext)
    {
      if (paramContext == null)
      {
        if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IRewardVideoAdListener != null) {
          this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IRewardVideoAdListener.onError(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
        }
        return;
      }
      QLog.i("AdProxyImpl", 1, "reward load");
      AdProxyImpl.this.requestAdInfo(paramContext, this.mUin, this.cFQ, this.mAppid, this.enY, this.mAdType, this.mDeviceOrientation, this.cFR, this.mEntryPath, this.cFS, this.mRefer, this.mVia, 1, new astr(this));
    }
    
    public void showAD(Context paramContext, String paramString)
    {
      if ((paramContext != null) && ((paramContext instanceof Activity))) {}
      for (paramContext = (Activity)paramContext;; paramContext = null)
      {
        if ((paramContext == null) || (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoPageData == null))
        {
          QLog.d("AdProxyImpl", 1, "data is not GdtMotiveVideoPageData");
          if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IRewardVideoAdListener != null) {
            this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IRewardVideoAdListener.onError(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
          }
          return;
        }
        this.cFT = paramString;
        this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoPageData.refId = "biz_src_miniapp";
        this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoPageData.containerType = 1;
        if ((this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoPageData.vSize == 185) || (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoPageData.vSize == 585)) {
          this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoPageData.resultReceiver = new AdProxyImpl.AdResultReceiver(new Handler(Looper.getMainLooper()), this);
        }
        for (;;)
        {
          GdtMotiveVideoFragment.b(paramContext, GdtMotiveVideoFragment.class, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoPageData);
          if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IRewardVideoAdListener == null) {
            break;
          }
          this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IRewardVideoAdListener.onADShow();
          return;
          paramString = new AdProxyImpl.a(this, null);
          String str = AdProxyImpl.a.a(paramString);
          if (AdProxyImpl.rewardedCallbackData == null) {
            AdProxyImpl.h(new HashMap());
          }
          this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoPageData.motiveBrowsingKey = str;
          AdProxyImpl.rewardedCallbackData.put(str, paramString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl
 * JD-Core Version:    0.7.0.1
 */