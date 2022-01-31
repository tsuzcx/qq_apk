package com.tencent.mobileqq.pluginsdk;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.IBinder;
import mqq.app.AppService;

@SuppressLint({"NewApi"})
public abstract class PluginService
  extends AppService
  implements IPluginService
{
  protected String mApkFilePath;
  private Context mContext;
  protected ClassLoader mDexClassLoader;
  protected boolean mIsRunInPlugin;
  protected Service mOutService;
  protected PackageInfo mPackageInfo;
  protected String mPluginID;
  private int mPluginResourcesType;
  
  public void IInit(String paramString1, String paramString2, Service paramService, ClassLoader paramClassLoader, PackageInfo paramPackageInfo, int paramInt)
  {
    if (DebugHelper.sDebug) {
      DebugHelper.log("plugin_tag", "PluginService.IInit: " + paramString1 + ", " + this.mPluginResourcesType);
    }
    this.mIsRunInPlugin = true;
    this.mPluginID = paramString1;
    this.mApkFilePath = paramString2;
    this.mOutService = paramService;
    this.mDexClassLoader = paramClassLoader;
    this.mPackageInfo = paramPackageInfo;
    this.mPluginResourcesType = paramInt;
    if (this.mContext == null) {}
    try
    {
      this.mContext = new PluginContext(paramService, 0, this.mApkFilePath, this.mDexClassLoader, paramService.getResources(), this.mPluginResourcesType);
      label116:
      attachBaseContext(this.mContext);
      return;
    }
    catch (Error paramString1)
    {
      break label116;
    }
  }
  
  public IBinder IOnBind(Intent paramIntent)
  {
    IBinder localIBinder = onBind(paramIntent);
    if (DebugHelper.sDebug) {
      DebugHelper.log("plugin_tag", "PluginService.IOnBind: " + localIBinder + ", " + paramIntent);
    }
    return localIBinder;
  }
  
  public void IOnCreate()
  {
    onCreate();
  }
  
  public void IOnDestroy()
  {
    onDestroy();
  }
  
  public void IOnStart(Intent paramIntent, int paramInt)
  {
    onStart(paramIntent, paramInt);
  }
  
  public int IOnStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return onStartCommand(paramIntent, paramInt1, paramInt2);
  }
  
  public boolean IOnUnbind(Intent paramIntent)
  {
    return onUnbind(paramIntent);
  }
  
  public ApplicationInfo getApplicationInfo()
  {
    if (this.mIsRunInPlugin) {
      return this.mPackageInfo.applicationInfo;
    }
    return super.getApplicationInfo();
  }
  
  public PackageInfo getPackageInfo()
  {
    if (this.mIsRunInPlugin) {
      return this.mPackageInfo;
    }
    return null;
  }
  
  public String getPackageName()
  {
    if (this.mIsRunInPlugin) {
      return this.mPackageInfo.packageName;
    }
    return super.getPackageName();
  }
  
  public Object getSystemService(String paramString)
  {
    if (("window".equals(paramString)) || ("search".equals(paramString)))
    {
      if (this.mIsRunInPlugin) {
        return this.mOutService.getSystemService(paramString);
      }
      return super.getSystemService(paramString);
    }
    if (this.mContext != null) {
      return this.mContext.getSystemService(paramString);
    }
    return super.getSystemService(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginService
 * JD-Core Version:    0.7.0.1
 */