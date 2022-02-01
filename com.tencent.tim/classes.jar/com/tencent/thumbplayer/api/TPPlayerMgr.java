package com.tencent.thumbplayer.api;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.thumbplayer.adapter.player.thumbplayer.TPDrmCapability;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMapUtil;
import com.tencent.thumbplayer.common.report.TPBeaconReportWrapper;
import com.tencent.thumbplayer.common.report.TPDeviceCapabilityReportManager;
import com.tencent.thumbplayer.config.TPPlayerConfig;
import com.tencent.thumbplayer.core.common.TPNativeLibraryLoader;
import com.tencent.thumbplayer.core.common.TPNativeLog;
import com.tencent.thumbplayer.core.common.TPThumbplayerCapabilityHelper;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPProxyAdapter;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyHelper;
import com.tencent.thumbplayer.core.player.TPNativePlayer;
import com.tencent.thumbplayer.utils.TPGlobalEventNofication;
import com.tencent.thumbplayer.utils.TPLogUtil;
import com.tencent.thumbplayer.utils.TPNetworkChangeMonitor;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class TPPlayerMgr
{
  public static final String BEACON_LOG_HOST_KEY = "beacon_log_host";
  public static final String BEACON_POLICY_HOST_KEY = "beacon_policy_host";
  public static final int EVENT_ID_APP_ENTER_BACKGROUND = 100001;
  public static final int EVENT_ID_APP_ENTER_FOREGROUND = 100002;
  public static final String PLYAER_HOST_KEY = "player_host_config";
  public static final String PROPERTY_MEDIA_DRM_REUSE_BEFORE_INIT_SDK = "PROPERTY_MediaDrmReuse";
  public static final String PROPERTY_VIDEO_MEDIACODEC_CO_EXIST_MAX_CNT = "PROPERTY_VideoMediaCodecCoexistMaxCnt";
  public static final String PROXY_HOST_KEY = "httpproxy_config";
  private static final String TAG = "TPThumbPlayer[TPPlayerMgr.java]";
  public static final String TP_DOWNLOAD_PROXY_MODULE_NAME = "DownloadProxy";
  public static final String TP_PLAYERCORE_MODULE_NAME = "TPCore";
  private static boolean isInit;
  private static Context mAppContext;
  
  public static Context getAppContext()
  {
    return mAppContext;
  }
  
  public static String getLibVersion(String paramString)
    throws IllegalStateException, IllegalArgumentException
  {
    if (!isInit) {
      throw new IllegalStateException("player not initialized");
    }
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.equals("DownloadProxy")) {
        return TPDownloadProxyHelper.getNativeLibVersion();
      }
      if (paramString.equals("TPCore")) {
        return TPNativeLibraryLoader.getLibVersion();
      }
    }
    throw new IllegalArgumentException("libName:" + paramString);
  }
  
  public static boolean getPropertyBoolean(@NonNull String paramString)
  {
    if (TextUtils.equals("PROPERTY_MediaDrmReuse", paramString)) {
      return TPPlayerConfig.getMediaDrmReuseEnable();
    }
    return true;
  }
  
  public static int getPropertyInteger(@NonNull String paramString)
  {
    if (TextUtils.equals("PROPERTY_VideoMediaCodecCoexistMaxCnt", paramString)) {
      return TPPlayerConfig.getVideoMediaCodecCoexistMaxCnt();
    }
    return 0;
  }
  
  public static String getThumbPlayerVersion()
  {
    return "2.20.0.1123";
  }
  
  public static void initSdk(Context paramContext, String paramString, int paramInt)
  {
    if (!isInit)
    {
      TPLogUtil.i("TPThumbPlayer[TPPlayerMgr.java]", "Enter initSdk");
      isInit = true;
      mAppContext = paramContext.getApplicationContext();
      TPPlayerConfig.setGuid(paramString);
      TPPlayerConfig.setPlatform(paramInt);
      TPNetworkChangeMonitor.getInstance().init(mAppContext);
      TPNativeKeyMapUtil.init();
      TPLogUtil.i("TPThumbPlayer[TPPlayerMgr.java]", "Enter initSdk for monitor");
      TPBeaconReportWrapper.init(paramContext.getApplicationContext());
      TPLogUtil.i("TPThumbPlayer[TPPlayerMgr.java]", "Enter initSdk for report");
      TPNativeLog.setLogCallback(new TPPlayerMgr.1());
    }
    try
    {
      TPNativeLibraryLoader.loadLibIfNeeded(mAppContext);
      TPLogUtil.i("TPThumbPlayer[TPPlayerMgr.java]", "Enter initSdk for loadlib");
      TPDrmCapability.init(mAppContext);
      TPLogUtil.i("TPThumbPlayer[TPPlayerMgr.java]", "Enter initSdk for drm cap");
      TPThumbplayerCapabilityHelper.init(mAppContext, true);
      TPLogUtil.i("TPThumbPlayer[TPPlayerMgr.java]", "Enter initSdk DONE");
      new TPDeviceCapabilityReportManager().reportAsync();
    }
    catch (UnsupportedOperationException paramContext)
    {
      for (;;)
      {
        try
        {
          TPNativePlayer.playerCoreNativeSetup(mAppContext);
          return;
        }
        catch (UnsupportedOperationException paramContext)
        {
          TPLogUtil.e("TPThumbPlayer[TPPlayerMgr.java]", paramContext);
        }
        paramContext = paramContext;
        TPLogUtil.e("TPThumbPlayer[TPPlayerMgr.java]", paramContext);
      }
    }
  }
  
  public static boolean isProxyEnable()
  {
    return (TPPlayerConfig.isUseP2P()) && (TPDownloadProxyHelper.isReadyForPlay());
  }
  
  public static boolean isThumbPlayerEnable()
  {
    return TPNativeLibraryLoader.isLibLoaded();
  }
  
  public static void postEvent(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    TPGlobalEventNofication.postGlobalEvent(paramInt1, paramInt2, paramInt3, paramObject);
  }
  
  public static void setDebugEnable(boolean paramBoolean)
  {
    TPPlayerConfig.setDebugEnable(paramBoolean);
  }
  
  public static void setGuid(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      TPPlayerConfig.setGuid(paramString);
      TPGlobalEventNofication.postGlobalEvent(100004, 0, 0, paramString);
    }
  }
  
  public static void setHost(String paramString)
  {
    TPPlayerConfig.parseHostConfig(paramString);
  }
  
  public static void setLibLoader(ITPModuleLoader paramITPModuleLoader)
  {
    if (isInit) {
      throw new IllegalStateException("player has init");
    }
    TPNativeLibraryLoader.setLibLoader(new TPPlayerMgr.2(paramITPModuleLoader));
    TPDownloadProxyHelper.setNativeLibLoader(new TPPlayerMgr.3(paramITPModuleLoader));
  }
  
  public static void setOnLogListener(OnLogListener paramOnLogListener)
  {
    TPLogUtil.setOnLogListener(paramOnLogListener);
  }
  
  public static void setOutNetIP(String paramString)
  {
    TPPlayerConfig.setOutNetIp(paramString);
  }
  
  public static void setPropertyBool(@NonNull String paramString, boolean paramBoolean)
  {
    if (TextUtils.equals("PROPERTY_MediaDrmReuse", paramString)) {
      TPPlayerConfig.setMediaDrmReuseEnable(paramBoolean);
    }
  }
  
  public static void setPropertyInteger(@NonNull String paramString, int paramInt)
  {
    if (TextUtils.equals("PROPERTY_VideoMediaCodecCoexistMaxCnt", paramString)) {
      TPPlayerConfig.setVideoMediaCodecCoexistMaxCnt(paramInt);
    }
  }
  
  public static void setProxyConfigsWithServiceType(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    TPPlayerConfig.addProxyCacheDir(paramInt, paramString1);
    TPPlayerConfig.addProxyDataDir(paramInt, paramString2);
    TPPlayerConfig.setProxyConfigStr(paramString3);
  }
  
  public static void setProxyEnable(boolean paramBoolean)
  {
    TPPlayerConfig.setP2PEnable(paramBoolean);
  }
  
  public static void setProxyMaxUseMemoryMB(int paramInt)
  {
    TPPlayerConfig.setProxyMaxUseMemoryMB(paramInt);
  }
  
  public static void setProxyServiceType(int paramInt)
  {
    TPPlayerConfig.setProxyServiceType(paramInt);
  }
  
  public static void setTPProxyAdapter(ITPProxyAdapter paramITPProxyAdapter)
  {
    TPDownloadProxyHelper.setTPProxyAdapter(paramITPProxyAdapter);
  }
  
  public static void setUpcInfo(String paramString, int paramInt)
  {
    TPPlayerConfig.setUserUpc(paramString);
    TPPlayerConfig.setUserUpcState(paramInt);
    TPGlobalEventNofication.postGlobalEvent(100003, paramInt, 0, paramString);
  }
  
  public static void setUserInfo(String paramString, boolean paramBoolean)
  {
    TPPlayerConfig.setUserUin(paramString);
    TPPlayerConfig.setUserIsVip(paramBoolean);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface BooleanProperty {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface EventId {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface IntegerProperty {}
  
  public static abstract interface OnLogListener
  {
    public abstract int d(String paramString1, String paramString2);
    
    public abstract int e(String paramString1, String paramString2);
    
    public abstract int i(String paramString1, String paramString2);
    
    public abstract int v(String paramString1, String paramString2);
    
    public abstract int w(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.api.TPPlayerMgr
 * JD-Core Version:    0.7.0.1
 */