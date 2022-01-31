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
  private boolean mUseQqResources;
  
  public void IInit(String paramString1, String paramString2, BroadcastReceiver paramBroadcastReceiver, ClassLoader paramClassLoader, PackageInfo paramPackageInfo, boolean paramBoolean)
  {
    if (DebugHelper.sDebug) {
      DebugHelper.log("PluginDebug", "PluginBroadcastReceiver.Init:" + paramString1 + ", " + paramBoolean);
    }
    this.mIsRunInPlugin = true;
    this.mApkFilePath = paramString2;
    this.mOutReceiver = paramBroadcastReceiver;
    this.mDexClassLoader = paramClassLoader;
    this.mPackageInfo = paramPackageInfo;
    this.mUseQqResources = paramBoolean;
  }
  
  public void IOnReceive(Context paramContext, Intent paramIntent)
  {
    if (DebugHelper.sDebug) {
      DebugHelper.log("PluginDebug", "PluginBroadcastReceiver.IOnReceive");
    }
    if (this.mUseQqResources) {}
    for (paramContext = new PluginContext(paramContext, 0, this.mApkFilePath, this.mDexClassLoader, paramContext.getResources());; paramContext = new PluginContext(paramContext, 0, this.mApkFilePath, this.mDexClassLoader))
    {
      onReceive(paramContext, paramIntent);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */