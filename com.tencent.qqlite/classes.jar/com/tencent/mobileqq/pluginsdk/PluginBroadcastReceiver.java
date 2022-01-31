package com.tencent.mobileqq.pluginsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;

public abstract class PluginBroadcastReceiver
  extends BroadcastReceiver
  implements IPluginBroadcastReceiver
{
  protected String mApkFilePath;
  protected ClassLoader mDexClassLoader;
  protected boolean mIsRunInPlugin;
  protected BroadcastReceiver mOutReceiver;
  protected PackageInfo mPackageInfo;
  private int mPluginResourcesType;
  
  public void IInit(String paramString1, String paramString2, BroadcastReceiver paramBroadcastReceiver, ClassLoader paramClassLoader, PackageInfo paramPackageInfo, int paramInt)
  {
    if (DebugHelper.sDebug) {
      DebugHelper.log("plugin_tag", "PluginBroadcastReceiver.Init:" + paramString1 + ", " + this.mPluginResourcesType);
    }
    this.mIsRunInPlugin = true;
    this.mApkFilePath = paramString2;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */