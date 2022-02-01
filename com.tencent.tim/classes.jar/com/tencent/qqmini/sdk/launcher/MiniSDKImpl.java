package com.tencent.qqmini.sdk.launcher;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.qqmini.sdk.launcher.core.IProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniCodeProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IAppBrandProxy;
import com.tencent.qqmini.sdk.launcher.shell.ILaunchManager;
import com.tencent.qqmini.sdk.launcher.shell.ILaunchManager.MiniProcessorConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MiniSDKImpl
{
  public static final int LINKTYPE_FAKEURL = 0;
  public static final int LINKTYPE_MINICODE = 1;
  public static final int LINKTYPE_SCHEMA = 2;
  public static final String TAG = "minisdk-start_MiniSDKImpl";
  private Configuration mConfiguration;
  private Context mContext;
  private Class miniAppInfoLoadingFragment;
  
  private static Configuration createConfiguration(Context paramContext)
  {
    Configuration localConfiguration = new Configuration.Builder(paramContext).build();
    paramContext = localConfiguration;
    if (!isConfigurationValid(localConfiguration))
    {
      QMLog.e("minisdk-start_MiniSDKImpl", "Failed to create invalid configuration");
      paramContext = null;
    }
    return paramContext;
  }
  
  private static boolean isConfigurationValid(Configuration paramConfiguration)
  {
    return (paramConfiguration != null) && (paramConfiguration.processInfoList != null) && (paramConfiguration.processInfoList.size() > 0);
  }
  
  private void processConfiguration()
  {
    if (this.mConfiguration == null)
    {
      QMLog.e("minisdk-start_MiniSDKImpl", "processConfiguration with Configuration is null!");
      return;
    }
    if (this.mContext == null)
    {
      QMLog.e("minisdk-start_MiniSDKImpl", "processConfiguration with Context is null!");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mConfiguration.processInfoList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Configuration.ProcessInfo)localIterator.next();
      localObject = new ILaunchManager.MiniProcessorConfig(((Configuration.ProcessInfo)localObject).processType, ((Configuration.ProcessInfo)localObject).name, ((Configuration.ProcessInfo)localObject).uiClass, ((Configuration.ProcessInfo)localObject).internalUIClass, ((Configuration.ProcessInfo)localObject).receiverClass, ((Configuration.ProcessInfo)localObject).supportRuntimeType);
      QMLog.i("minisdk-start_MiniSDKImpl", "createConfiguration. Add processor config: " + localObject);
      localArrayList.add(localObject);
    }
    registerProcessInfo(this.mContext, localArrayList);
  }
  
  private static void registerProcessInfo(Context paramContext, List<ILaunchManager.MiniProcessorConfig> paramList)
  {
    AppLoaderFactory.g().registerProcessInfo(paramContext, paramList);
  }
  
  public Class getMiniAppInfoLoadingFragmentClass()
  {
    if (this.miniAppInfoLoadingFragment == null) {
      this.miniAppInfoLoadingFragment = AppLoaderFactory.g().findClass("com.tencent.qqmini.sdk.launcher.MiniAppInfoLoadingFragment");
    }
    return this.miniAppInfoLoadingFragment;
  }
  
  public void init(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      try
      {
        QMLog.e("minisdk-start_MiniSDKImpl", "Failed to init MiniSDK. context is null");
        return;
      }
      finally {}
      if (this.mConfiguration == null) {
        this.mConfiguration = createConfiguration(paramContext);
      }
      if (this.mContext == null)
      {
        QMLog.i("minisdk-start_MiniSDKImpl", "MiniSDK init context.");
        this.mContext = paramContext;
        AppLoaderFactory.g().init(paramContext, this.mConfiguration);
        processConfiguration();
      }
    }
  }
  
  public void notifyPeriodicCacheUpdate(MiniAppInfo paramMiniAppInfo)
  {
    if (AppLoaderFactory.g().isMainProcess()) {
      AppLoaderFactory.g().getLaunchManager().sendCmdToMiniProcess(1002, new Bundle(), paramMiniAppInfo, null);
    }
  }
  
  public void notifyShareResult(MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    if (AppLoaderFactory.g().isMainProcess())
    {
      Bundle localBundle = paramBundle;
      if (paramBundle == null) {
        localBundle = new Bundle();
      }
      AppLoaderFactory.g().getLaunchManager().sendCmdToMiniProcess(1001, localBundle, paramMiniAppInfo, paramResultReceiver);
      return;
    }
    AppLoaderFactory.g().getAppBrandProxy().notifyShareResult(paramMiniAppInfo, paramBundle, paramResultReceiver);
  }
  
  public void onHostAppBackground()
  {
    AppLoaderFactory.g().getLaunchManager().onHostAppBackground();
  }
  
  public void preloadMiniApp(Context paramContext, Bundle paramBundle)
  {
    QMLog.i("minisdk-start_MiniSDKImpl", "preloadMiniApp");
    if (AppLoaderFactory.g().isMainProcess())
    {
      AppLoaderFactory.g().getLaunchManager().preloadMiniApp(paramBundle);
      return;
    }
    QMLog.e("minisdk-start_MiniSDKImpl", "preloadMiniApp should be called only in main process!!!");
  }
  
  public String scanMiniCode(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    try
    {
      paramArrayOfByte = ((MiniCodeProxy)AppLoaderFactory.g().getProxyManager().get(MiniCodeProxy.class)).decode(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte) {}
    return "scanMiniCode error";
  }
  
  public void startMiniApp(Activity paramActivity, MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    QMLog.i("minisdk-start_MiniSDKImpl", "startMiniApp miniappInfo:" + paramMiniAppInfo);
    if (AppLoaderFactory.g().isMainProcess())
    {
      AppLoaderFactory.g().getLaunchManager().startMiniApp(paramActivity, paramMiniAppInfo, paramBundle, paramResultReceiver);
      return;
    }
    AppLoaderFactory.g().getAppBrandProxy().startMiniApp(paramActivity, paramMiniAppInfo, paramBundle, paramResultReceiver);
  }
  
  public void stopAllMiniApp()
  {
    QMLog.i("minisdk-start_MiniSDKImpl", "stopAllMiniApp");
    if (AppLoaderFactory.g().isMainProcess())
    {
      AppLoaderFactory.g().getLaunchManager().stopAllMiniApp();
      return;
    }
    AppLoaderFactory.g().getAppBrandProxy().stopAllMiniApp();
  }
  
  public void stopMiniApp(MiniAppInfo paramMiniAppInfo)
  {
    QMLog.i("minisdk-start_MiniSDKImpl", "stopMiniApp");
    if (AppLoaderFactory.g().isMainProcess())
    {
      AppLoaderFactory.g().getLaunchManager().stopMiniApp(paramMiniAppInfo);
      return;
    }
    AppLoaderFactory.g().getAppBrandProxy().stopMiniApp(paramMiniAppInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.MiniSDKImpl
 * JD-Core Version:    0.7.0.1
 */