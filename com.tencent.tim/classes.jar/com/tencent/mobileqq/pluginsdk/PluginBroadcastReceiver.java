package com.tencent.mobileqq.pluginsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import mqq.app.MobileQQ;

public abstract class PluginBroadcastReceiver
  extends BroadcastReceiver
  implements IPluginBroadcastReceiver
{
  protected String mApkFilePath;
  protected ClassLoader mDexClassLoader;
  protected boolean mIsRunInPlugin;
  protected BroadcastReceiver mOutReceiver;
  protected PackageInfo mPackageInfo;
  protected String mPluginID;
  protected String mPluginName;
  private int mPluginResourcesType;
  
  public void IInit(String paramString1, String paramString2, String paramString3, BroadcastReceiver paramBroadcastReceiver, ClassLoader paramClassLoader, PackageInfo paramPackageInfo, int paramInt)
  {
    if (DebugHelper.sDebug) {
      DebugHelper.log("plugin_tag", "PluginBroadcastReceiver.Init:" + paramString2 + ", " + this.mPluginResourcesType);
    }
    this.mIsRunInPlugin = true;
    this.mPluginName = paramString1;
    this.mPluginID = paramString2;
    this.mApkFilePath = paramString3;
    this.mOutReceiver = paramBroadcastReceiver;
    this.mDexClassLoader = paramClassLoader;
    this.mPackageInfo = paramPackageInfo;
    this.mPluginResourcesType = paramInt;
  }
  
  public void IOnReceive(Context paramContext, Intent paramIntent)
  {
    if (DebugHelper.sDebug) {
      DebugHelper.log("plugin_tag", "PluginBroadcastReceiver.IOnReceive");
    }
    onReceive(new PluginContext(paramContext, 0, this.mApkFilePath, this.mDexClassLoader, paramContext.getResources(), this.mPluginResourcesType), paramIntent);
  }
  
  public void openActivity(Intent paramIntent, String paramString1, String paramString2, boolean paramBoolean)
  {
    paramIntent.putExtra("pluginsdk_IsPluginActivity", true);
    PluginProxyActivity.StartActivityParams localStartActivityParams = new PluginProxyActivity.StartActivityParams();
    localStartActivityParams.mPluginName = this.mPluginName;
    localStartActivityParams.mPluginID = this.mPluginID;
    localStartActivityParams.mPluginApkFilePath = this.mApkFilePath;
    localStartActivityParams.proxyActivity = paramString1;
    localStartActivityParams.mPluginResoucesType = this.mPluginResourcesType;
    localStartActivityParams.mUseSkinEngine = paramBoolean;
    localStartActivityParams.loader = this.mDexClassLoader;
    localStartActivityParams.launchActivity = paramString2;
    PluginProxyActivity.openActivity(MobileQQ.sMobileQQ, paramIntent, localStartActivityParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */