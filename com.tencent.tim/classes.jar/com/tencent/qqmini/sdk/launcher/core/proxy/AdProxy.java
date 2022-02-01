package com.tencent.qqmini.sdk.launcher.core.proxy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import java.util.ArrayList;
import org.json.JSONObject;

public abstract class AdProxy
{
  public static String KEY_ACCOUNT = "key_account";
  public static String KEY_ADCOUNT = "key_ad_count";
  public static String KEY_AD_TYPE = "key_ad_type";
  public static String KEY_APPID;
  public static String KEY_ENTRY_PATH;
  public static String KEY_GDT_COOKIE;
  public static String KEY_MODE = "key_mode";
  public static String KEY_ORIENTATION = "key_orientation";
  public static String KEY_POSID;
  public static String KEY_REFER;
  public static String KEY_REPORT_DATA;
  public static String KEY_SHARE_RATE;
  public static String KEY_VIA;
  
  static
  {
    KEY_GDT_COOKIE = "key_gdt_cookie";
    KEY_ENTRY_PATH = "key_entry_path";
    KEY_REPORT_DATA = "key_report_data";
    KEY_REFER = "key_refer";
    KEY_VIA = "key_via";
    KEY_APPID = "key_appid";
    KEY_SHARE_RATE = "key_share_rate";
    KEY_POSID = "key_pos_id";
  }
  
  public boolean adClick(Context paramContext, String paramString1, String paramString2)
  {
    return false;
  }
  
  public boolean adExposure(Context paramContext, String paramString1, String paramString2)
  {
    return false;
  }
  
  public abstract AbsBannerAdView createBannerAdView(Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2, IBannerAdListener paramIBannerAdListener, Bundle paramBundle, IMiniAppContext paramIMiniAppContext);
  
  public AbsBlockAdView createBlockAdView(Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, IBlockAdListener paramIBlockAdListener, Bundle paramBundle)
  {
    return null;
  }
  
  public AbsBoxAdView createBoxAdView(Activity paramActivity, String paramString1, String paramString2, IBoxADLisener paramIBoxADLisener, Bundle paramBundle)
  {
    return null;
  }
  
  public AbsInterstitialAdView createInterstitialAdView(Activity paramActivity, String paramString1, String paramString2, InterstitialADLisener paramInterstitialADLisener, Bundle paramBundle)
  {
    return null;
  }
  
  public abstract AbsRewardVideoAdView createRewardVideoAdView(Context paramContext, String paramString1, String paramString2, IRewardVideoAdListener paramIRewardVideoAdListener, Bundle paramBundle);
  
  public void destroy(Activity paramActivity) {}
  
  public void onActivityStart() {}
  
  public void onActivityStop() {}
  
  public void onFirstFrame() {}
  
  public void preloadLoadingAd(Context paramContext, Bundle paramBundle, ILoadingAdListener paramILoadingAdListener) {}
  
  public void requestAdInfo(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt4, ICmdListener paramICmdListener) {}
  
  public void selectLoadingAd(Context paramContext, Bundle paramBundle, ILoadingAdListener paramILoadingAdListener) {}
  
  public void updateLoadingAdLayoutAndShow(Context paramContext, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, ILoadingAdListener paramILoadingAdListener) {}
  
  public abstract class AbsBannerAdView
  {
    public AbsBannerAdView() {}
    
    public abstract void destroy(Context paramContext);
    
    public long getAdID()
    {
      return 0L;
    }
    
    public String getReportUrl()
    {
      return "";
    }
    
    public abstract View getView();
    
    public abstract void loadAD();
    
    public void onExposure() {}
    
    public void pause(Context paramContext) {}
    
    public void resume(Context paramContext) {}
    
    public void setSize(int paramInt1, int paramInt2) {}
  }
  
  public abstract class AbsBlockAdView
  {
    public AbsBlockAdView() {}
    
    public abstract void destroy(Context paramContext);
    
    public ArrayList<String> getReportUrl()
    {
      return null;
    }
    
    public abstract View getView();
    
    public abstract void loadAD();
    
    public abstract View updateAdInfo(int paramInt1, int paramInt2);
  }
  
  public abstract class AbsBoxAdView
  {
    public AbsBoxAdView() {}
    
    public abstract void destroy();
    
    public abstract void loadAD();
    
    public abstract void show();
  }
  
  public abstract class AbsInterstitialAdView
  {
    public AbsInterstitialAdView() {}
    
    public abstract void destroy();
    
    public abstract void loadAD();
    
    public void onClose(Activity paramActivity, int paramInt, Intent paramIntent) {}
    
    public abstract boolean show(Activity paramActivity);
  }
  
  public abstract class AbsRewardVideoAdView
  {
    public AbsRewardVideoAdView() {}
    
    public abstract void loadAD(Context paramContext);
    
    public abstract void showAD(Context paramContext, String paramString);
  }
  
  public static abstract interface IBannerAdListener
  {
    public abstract void onADClicked();
    
    public abstract void onADCloseOverlay();
    
    public abstract void onADClosed();
    
    public abstract void onADExposure();
    
    public abstract void onADLeftApplication();
    
    public abstract void onADOpenOverlay();
    
    public abstract void onADReceive();
    
    public abstract void onNoAD(int paramInt, String paramString);
  }
  
  public static abstract interface IBlockAdListener
  {
    public abstract void onADClicked();
    
    public abstract void onADClosed();
    
    public abstract void onADExposure();
    
    public abstract void onADReceive(int paramInt1, int paramInt2, int paramInt3);
    
    public abstract void onNoAD(int paramInt, String paramString);
  }
  
  public static abstract interface IBoxADLisener
  {
    public abstract void onDismiss();
    
    public abstract void onError(int paramInt, String paramString);
    
    public abstract void onLoad();
    
    public abstract void onShow();
  }
  
  public static abstract interface ICmdListener
  {
    public abstract void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject);
  }
  
  public static abstract interface ILoadingAdListener
  {
    public abstract void getLoadingAdLayoutReady();
    
    public abstract void onAdClick();
    
    public abstract void onAdDismiss(boolean paramBoolean);
    
    public abstract void onAdShow(View paramView);
    
    public abstract void onPreloadAdReceive(boolean paramBoolean);
    
    public abstract void onSelectAdProcessDone(String paramString, long paramLong);
  }
  
  public static abstract interface IRewardVideoAdListener
  {
    public abstract void onADClick();
    
    public abstract void onADClose(String paramString);
    
    public abstract void onADExpose();
    
    public abstract void onADLoad();
    
    public abstract void onADShow();
    
    public abstract void onError(int paramInt, String paramString);
    
    public abstract void onReward();
    
    public abstract void onVideoCached();
    
    public abstract void onVideoComplete();
  }
  
  public static abstract interface InterstitialADLisener
  {
    public abstract void onDismiss();
    
    public abstract void onError(int paramInt, String paramString);
    
    public abstract void onLoad();
    
    public abstract void onShow();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy
 * JD-Core Version:    0.7.0.1
 */