package com.tencent.mobileqq.pluginsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

public class PluginProxyBroadcastReceiver
  extends BroadcastReceiver
{
  public static void sendBroadcastReceiver(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, Intent paramIntent)
  {
    paramIntent.putExtra("pluginsdk_pluginName", paramString1);
    paramIntent.putExtra("pluginsdk_pluginLocation", paramString2);
    paramIntent.putExtra("pluginsdk_launchReceiver", paramString4);
    paramIntent.putExtra("pluginsdk_pluginpath", paramString3);
    try
    {
      paramContext.sendBroadcast(paramIntent);
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  private IPluginBroadcastReceiver startPluginIfNeccessary(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (!PluginStatic.isValidPluginIntent(paramIntent.getExtras()))) {}
    for (;;)
    {
      return null;
      String str1 = paramIntent.getStringExtra("pluginsdk_pluginLocation");
      String str2 = paramIntent.getStringExtra("pluginsdk_launchReceiver");
      Object localObject1 = paramIntent.getStringExtra("pluginsdk_pluginpath");
      paramIntent = (Intent)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {}
      try
      {
        paramIntent = PluginUtils.getInstallPath(paramContext, str1).getCanonicalPath();
        if (DebugHelper.sDebug) {
          DebugHelper.log("PluginDebug", "PluginProxyBroadcastReceiver.startPluginIfNeccessary Params:" + str1 + ", " + str2);
        }
        Object localObject3 = null;
        if ((str1 == null) || (str1.length() <= 0)) {
          continue;
        }
        PluginRecoverReceiver.addCarePluginId(str1);
        localObject1 = new File(paramIntent);
        if ((!((File)localObject1).exists()) || (!((File)localObject1).isFile())) {
          continue;
        }
        Object localObject2 = (PackageInfo)PluginStatic.sPackageInfoMap.get(paramIntent);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = ApkFileParser.getPackageInfo(paramContext, paramIntent, 1);
          PluginStatic.sPackageInfoMap.put(paramIntent, localObject1);
        }
        localObject2 = localObject3;
        try
        {
          ClassLoader localClassLoader = PluginStatic.getOrCreateClassLoaderByPath(paramContext, str1, paramIntent);
          localObject2 = localObject3;
          paramContext = (IPluginBroadcastReceiver)localClassLoader.loadClass(str2).newInstance();
          localObject2 = paramContext;
          paramContext.IInit(str1, paramIntent, this, localClassLoader, (PackageInfo)localObject1, false);
          return paramContext;
        }
        catch (Exception paramContext)
        {
          return localObject2;
        }
      }
      catch (IOException paramIntent)
      {
        for (;;)
        {
          paramIntent = (Intent)localObject1;
        }
      }
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (DebugHelper.sDebug) {
      DebugHelper.log("PluginDebug", "PluginProxyBroadcastReceiver.onReceive: " + paramIntent);
    }
    IPluginProxyComponent.registerAccountReceiverIfNeccessary();
    IPluginBroadcastReceiver localIPluginBroadcastReceiver = startPluginIfNeccessary(paramContext, paramIntent);
    if (DebugHelper.sDebug) {
      DebugHelper.log("PluginDebug", "PluginProxyBroadcastReceiver.startPluginIfNeccessary: " + localIPluginBroadcastReceiver);
    }
    if (localIPluginBroadcastReceiver != null) {
      localIPluginBroadcastReceiver.IOnReceive(paramContext, paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginProxyBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */