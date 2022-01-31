package com.tencent.mobileqq.pluginsdk;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.os.IBinder;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

public class PluginProxyService
  extends Service
{
  private String mApkFilePath;
  private String mLaunchService;
  private String mPluginID;
  private String mPluginName;
  private int mPluginResoucesType;
  private IPluginService mPluginService;
  
  public static void bindService(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, Intent paramIntent, ServiceConnection paramServiceConnection)
  {
    paramIntent.putExtra("pluginsdk_pluginName", paramString1);
    paramIntent.putExtra("pluginsdk_pluginLocation", paramString2);
    paramIntent.putExtra("pluginsdk_launchService", paramString4);
    paramIntent.putExtra("pluginsdk_pluginpath", paramString3);
    try
    {
      paramContext.bindService(paramIntent, paramServiceConnection, 1);
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  private String initPlugin()
    throws Exception
  {
    PluginRecoverReceiver.addCarePluginId(this.mPluginID);
    Object localObject1 = (PackageInfo)PluginStatic.sPackageInfoMap.get(this.mApkFilePath);
    Object localObject2 = localObject1;
    if (localObject1 == null) {}
    try
    {
      localObject2 = ApkFileParser.getPackageInfo(this, this.mApkFilePath, 1);
      localObject1 = localObject2;
    }
    catch (Throwable localThrowable2)
    {
      label39:
      Class localClass;
      break label39;
    }
    if (localObject1 == null) {
      return "Get Package Info Failed!";
    }
    PluginStatic.sPackageInfoMap.put(this.mApkFilePath, localObject1);
    localObject2 = localObject1;
    localObject1 = PluginStatic.getOrCreateClassLoaderByPath(this, this.mPluginID, this.mApkFilePath);
    localClass = ((ClassLoader)localObject1).loadClass(this.mLaunchService);
    try
    {
      this.mPluginService = ((IPluginService)localClass.newInstance());
      this.mPluginService.IInit(this.mPluginID, this.mApkFilePath, this, (ClassLoader)localObject1, (PackageInfo)localObject2, this.mPluginResoucesType);
      return null;
    }
    catch (Throwable localThrowable1)
    {
      return "new PluginService failed!";
    }
  }
  
  public static void openService(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, Intent paramIntent)
  {
    paramIntent.putExtra("pluginsdk_pluginName", paramString1);
    paramIntent.putExtra("pluginsdk_pluginLocation", paramString2);
    paramIntent.putExtra("pluginsdk_launchService", paramString4);
    paramIntent.putExtra("pluginsdk_pluginpath", paramString3);
    try
    {
      paramContext.startService(paramIntent);
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    IBinder localIBinder = null;
    if (DebugHelper.sDebug) {
      DebugHelper.log("plugin_tag", "PluginProxyService.onBind PluginService:" + this.mPluginService);
    }
    if (this.mPluginService == null) {
      startPluginIfNeccessary(paramIntent);
    }
    if (this.mPluginService != null) {
      localIBinder = this.mPluginService.IOnBind(paramIntent);
    }
    if (DebugHelper.sDebug) {
      DebugHelper.log("plugin_tag", "PluginProxyService.onBind IBinder:" + localIBinder);
    }
    return localIBinder;
  }
  
  public void onCreate()
  {
    super.onCreate();
    IPluginProxyComponent.registerAccountReceiverIfNeccessary();
    if (DebugHelper.sDebug) {
      DebugHelper.log("plugin_tag", "PluginProxyService.onCreate");
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (DebugHelper.sDebug) {
      DebugHelper.log("plugin_tag", "PluginProxyService.onDestroy");
    }
    if (this.mPluginService != null)
    {
      this.mPluginService.IOnDestroy();
      this.mPluginService = null;
    }
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    super.onStart(paramIntent, paramInt);
    if (DebugHelper.sDebug) {
      DebugHelper.log("plugin_tag", "PluginProxyService.onStart Intent:" + paramIntent);
    }
    if ((startPluginIfNeccessary(paramIntent)) && (this.mPluginService != null)) {
      this.mPluginService.IOnStart(paramIntent, paramInt);
    }
  }
  
  @SuppressLint({"NewApi"})
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    super.onStartCommand(paramIntent, paramInt1, paramInt2);
    if (DebugHelper.sDebug) {
      DebugHelper.log("plugin_tag", "PluginProxyService.onStartCommand Intent:" + paramIntent);
    }
    if ((startPluginIfNeccessary(paramIntent)) && (this.mPluginService != null)) {
      this.mPluginService.IOnStartCommand(paramIntent, paramInt1, paramInt2);
    }
    return 3;
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    boolean bool = super.onUnbind(paramIntent);
    if (DebugHelper.sDebug) {
      DebugHelper.log("plugin_tag", "PluginProxyService.onUnbind Intent:" + paramIntent);
    }
    if (this.mPluginService != null) {
      bool = this.mPluginService.IOnUnbind(paramIntent);
    }
    return bool;
  }
  
  protected boolean startPluginIfNeccessary(Intent paramIntent)
  {
    boolean bool = true;
    if (DebugHelper.sDebug) {
      DebugHelper.log("plugin_tag", "PluginProxyService.startPluginIfNeccessary Intent:" + paramIntent);
    }
    if ((paramIntent == null) || (!PluginStatic.isValidPluginIntent(paramIntent.getExtras()))) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      String str2 = paramIntent.getStringExtra("pluginsdk_pluginName");
      String str3 = paramIntent.getStringExtra("pluginsdk_pluginLocation");
      String str4 = paramIntent.getStringExtra("pluginsdk_launchService");
      this.mPluginResoucesType = paramIntent.getIntExtra("userQqResources", 0);
      String str1 = paramIntent.getStringExtra("pluginsdk_pluginpath");
      Object localObject1 = str1;
      if (TextUtils.isEmpty(str1)) {
        localObject1 = PluginUtils.getInstalledPluginPath(this, str3);
      }
      try
      {
        localObject1 = ((File)localObject1).getCanonicalPath();
        if (DebugHelper.sDebug) {
          DebugHelper.log("plugin_tag", "PluginProxyService.startPluginIfNeccessary Params:" + str3 + ", " + str4);
        }
        if (this.mPluginService != null) {
          if ((this.mPluginID.equals(str3)) && (this.mPluginName.equals(str2)) && (this.mLaunchService.equals(str4)))
          {
            if (!DebugHelper.sDebug) {
              continue;
            }
            DebugHelper.log("plugin_tag", "PluginProxyService.startPluginIfNeccessary: already init the same service");
            return true;
          }
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          localObject2 = str1;
        }
        if (DebugHelper.sDebug) {
          DebugHelper.log("plugin_tag", "PluginProxyService.startPluginIfNeccessary: error arguments");
        }
        return false;
      }
      this.mPluginID = str3;
      this.mApkFilePath = ((String)localObject2);
      this.mPluginName = str2;
      this.mLaunchService = str4;
      Object localObject2 = PluginStatic.getClassLoader(this.mPluginID);
      if (localObject2 != null) {
        paramIntent.setExtrasClassLoader((ClassLoader)localObject2);
      }
      if ((this.mPluginID == null) || (this.mPluginID.length() == 0)) {
        paramIntent = "Param mPluingLocation missing!";
      }
      while (DebugHelper.sDebug)
      {
        DebugHelper.log("plugin_tag", "PluginProxyService.startPluginIfNeccessary ErrorInfo: " + paramIntent);
        return true;
        paramIntent = new File(this.mApkFilePath);
        if ((!paramIntent.exists()) && (!paramIntent.isFile())) {
          paramIntent = "Plugin File Not Found!";
        } else {
          try
          {
            localObject2 = initPlugin();
            paramIntent = (Intent)localObject2;
            if (localObject2 == null)
            {
              this.mPluginService.IOnCreate();
              paramIntent = (Intent)localObject2;
            }
          }
          catch (Exception paramIntent)
          {
            paramIntent.printStackTrace();
            paramIntent = PluginUtils.getExceptionInfo(paramIntent);
            stopSelf();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginProxyService
 * JD-Core Version:    0.7.0.1
 */