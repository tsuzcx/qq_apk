package com.tencent.superplayer.api;

import android.content.Context;
import com.tencent.qqlive.tvkplayer.TVideoMgr;
import com.tencent.qqlive.tvkplayer.TVideoMgr.OnTVideoLogListener;
import com.tencent.superplayer.config.ConfigManager;
import com.tencent.superplayer.datatransport.SPProxyConfig;
import com.tencent.superplayer.player.SuperPlayerPool;
import com.tencent.superplayer.report.SPBeaconReporter;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.thumbplayer.api.ITPModuleLoader;
import com.tencent.thumbplayer.api.TPPlayerMgr;
import com.tencent.thumbplayer.api.TPPlayerMgr.OnLogListener;
import com.tencent.thumbplayer.core.common.TPSystemInfo;
import com.tencent.thumbplayer.core.downloadproxy.jni.TPDownloadProxyNative;
import com.tencent.thumbplayer.datatransport.TPProxyGlobalManager;
import com.tencent.thumbplayer.tplayer.plugins.report.BeaconAdapter;
import com.tencent.tmediacodec.TCodecManager;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class SuperPlayerSDKMgr
{
  private static final String SDK_Version = "1.1.0";
  private static final String TAG = "SuperPlayerSDKMgr";
  private static Context sAppContext;
  private static String sDataCacheFolder;
  private static String sDeviceId;
  private static Map<String, String> sGlobalReportMap;
  private static final InnerLogListener sInnerLogListener = new InnerLogListener(null);
  private static AtomicBoolean sIsInit = new AtomicBoolean(false);
  private static ILogListener sLogListener;
  private static int sPlatform;
  private static ISuperPlayerPool sPlayerRunningPool = new SuperPlayerPool();
  private static SuperPlayerSdkOption sSdkOption;
  private static String sUid;
  
  public static Context getContext()
  {
    return sAppContext;
  }
  
  public static String getDataCacheFolder()
  {
    return sDataCacheFolder;
  }
  
  public static String getDeviceId()
  {
    return sDeviceId;
  }
  
  public static Map<String, String> getGlobalReportMap()
  {
    return sGlobalReportMap;
  }
  
  public static ILogListener getLogListener()
  {
    return sLogListener;
  }
  
  public static int getPlatform()
  {
    return sPlatform;
  }
  
  public static ISuperPlayerPool getPlayerPool()
  {
    return sPlayerRunningPool;
  }
  
  public static String getSDKVersion()
  {
    return "1.1.0";
  }
  
  public static SuperPlayerSdkOption getSdkOption()
  {
    return sSdkOption;
  }
  
  public static String getUid()
  {
    return sUid;
  }
  
  public static boolean hasDeviceId()
  {
    return (sDeviceId != null) && (!sDeviceId.isEmpty());
  }
  
  private static void initConfigComponent()
  {
    ConfigManager.get().init();
    ConfigManager.get().setCallback(new SuperPlayerSDKMgr.2());
  }
  
  public static void initSDK(Context paramContext, int paramInt, String paramString)
  {
    initSDK(paramContext, paramInt, paramString, SuperPlayerSdkOption.option());
  }
  
  public static void initSDK(Context paramContext, int paramInt, String paramString, SuperPlayerSdkOption paramSuperPlayerSdkOption)
  {
    if (sIsInit.get()) {
      return;
    }
    sIsInit.set(true);
    sAppContext = paramContext.getApplicationContext();
    sPlatform = paramInt;
    sDataCacheFolder = paramString;
    paramContext = paramSuperPlayerSdkOption;
    if (paramSuperPlayerSdkOption == null) {
      paramContext = SuperPlayerSdkOption.option();
    }
    sSdkOption = paramContext;
    sUid = sSdkOption.uid;
    if (sSdkOption.deviceId.isEmpty()) {}
    for (paramContext = BeaconAdapter.getQIMEI();; paramContext = sSdkOption.deviceId)
    {
      sDeviceId = paramContext;
      sSdkOption.loadConfigFromConfigManager();
      SPProxyConfig.init(sSdkOption);
      SPBeaconReporter.init();
      innerInitTVideoMgr();
      innerInitTPPlayerMgr();
      initTMediaCodecComponent();
      initConfigComponent();
      return;
    }
  }
  
  private static void initTMediaCodecComponent()
  {
    TCodecManager.getInstance().setGlobalReuseEnable(true);
    TCodecManager.getInstance().setLogLevel(2);
    TCodecManager.getInstance().setLogProxy(new SuperPlayerSDKMgr.1());
  }
  
  private static void innerInitTPPlayerMgr()
  {
    TPPlayerMgr.setOnLogListener(sInnerLogListener);
    TPPlayerMgr.initSdk(sAppContext, sDeviceId, getPlatform());
    TPPlayerMgr.setProxyEnable(true);
    TPPlayerMgr.setDebugEnable(false);
    TPDownloadProxyNative.getInstance().isNativeLoaded();
  }
  
  private static void innerInitTVideoMgr()
  {
    try
    {
      TVideoMgr.init(sAppContext, getPlatform(), BeaconAdapter.getQIMEI());
      TVideoMgr.setOnLogListener(sInnerLogListener);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        LogUtil.e("SuperPlayerSDKMgr", "innerInitTVideoMgr error, " + localThrowable.toString());
      }
    }
  }
  
  public static void notifyAppBackground()
  {
    TPPlayerMgr.postEvent(100001, 0, 0, null);
  }
  
  public static void notifyAppForeground()
  {
    TPPlayerMgr.postEvent(100002, 0, 0, null);
  }
  
  public static boolean registerTVideoPlatformInfo(TVideoPlatformInfo paramTVideoPlatformInfo)
  {
    return TVideoMgr.registerTVideoPlatformInfo(TVideoPlatformInfo.convert(paramTVideoPlatformInfo));
  }
  
  public static void setDeviceId(String paramString)
  {
    sDeviceId = paramString;
    TPPlayerMgr.setGuid(paramString);
  }
  
  public static void setDeviceInfo(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    TVideoMgr.setDeviceInfo(paramString1, paramString2, paramString3);
    TPSystemInfo.setDeviceInfo(paramString1, paramString2, paramString3, paramString4);
  }
  
  public static void setGlobalReportMap(Map<String, String> paramMap)
  {
    sGlobalReportMap = paramMap;
  }
  
  public static void setLibLoader(ITPModuleLoader paramITPModuleLoader)
  {
    TPPlayerMgr.setLibLoader(paramITPModuleLoader);
  }
  
  public static void setOnLogListener(ILogListener paramILogListener)
  {
    sLogListener = paramILogListener;
  }
  
  public static void setProxyMaxUseMemoryMB(int paramInt)
  {
    TPPlayerMgr.setProxyMaxUseMemoryMB(paramInt);
  }
  
  public static void setUpcInfo(String paramString, int paramInt)
  {
    TPPlayerMgr.setUpcInfo(paramString, paramInt);
  }
  
  public static void setUpdatePlayerInfoInterval(int paramInt)
  {
    TPProxyGlobalManager.getInstance().setUpdatePlayerInfoInterval(paramInt);
  }
  
  public static void setsUid(String paramString)
  {
    sUid = paramString;
  }
  
  public static abstract interface ILogListener
  {
    public abstract int d(String paramString1, String paramString2);
    
    public abstract int e(String paramString1, String paramString2);
    
    public abstract int i(String paramString1, String paramString2);
    
    public abstract int v(String paramString1, String paramString2);
    
    public abstract int w(String paramString1, String paramString2);
  }
  
  static class InnerLogListener
    implements TVideoMgr.OnTVideoLogListener, TPPlayerMgr.OnLogListener
  {
    public int d(String paramString1, String paramString2)
    {
      if (SuperPlayerSDKMgr.sLogListener != null) {
        return SuperPlayerSDKMgr.sLogListener.d(paramString1, paramString2);
      }
      return 0;
    }
    
    public int e(String paramString1, String paramString2)
    {
      if (SuperPlayerSDKMgr.sLogListener != null) {
        return SuperPlayerSDKMgr.sLogListener.e(paramString1, paramString2);
      }
      return 0;
    }
    
    public int i(String paramString1, String paramString2)
    {
      if (SuperPlayerSDKMgr.sLogListener != null) {
        return SuperPlayerSDKMgr.sLogListener.i(paramString1, paramString2);
      }
      return 0;
    }
    
    public int v(String paramString1, String paramString2)
    {
      if (SuperPlayerSDKMgr.sLogListener != null) {
        return SuperPlayerSDKMgr.sLogListener.v(paramString1, paramString2);
      }
      return 0;
    }
    
    public int w(String paramString1, String paramString2)
    {
      if (SuperPlayerSDKMgr.sLogListener != null) {
        return SuperPlayerSDKMgr.sLogListener.w(paramString1, paramString2);
      }
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.superplayer.api.SuperPlayerSDKMgr
 * JD-Core Version:    0.7.0.1
 */