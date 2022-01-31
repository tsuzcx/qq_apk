package com.tencent.base;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public final class Global
{
  private static Context context;
  private static boolean isDebug = false;
  
  public static final String currentProcessName()
  {
    Object localObject = (ActivityManager)getSystemService("activity");
    if (localObject == null) {}
    int i;
    ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
    do
    {
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          return null;
          localObject = ((ActivityManager)localObject).getRunningAppProcesses();
        } while (localObject == null);
        i = Process.myPid();
        localObject = ((List)localObject).iterator();
      }
      localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
    } while (i != localRunningAppProcessInfo.pid);
    return localRunningAppProcessInfo.processName;
  }
  
  public static final AssetManager getAssets()
  {
    return getContext().getAssets();
  }
  
  public static final File getCacheDir()
  {
    return getContext().getCacheDir();
  }
  
  public static final Context getContext()
  {
    if (context == null) {
      throw new BaseLibException("Global's Context is NULL, have your Application in manifest subclasses BaseApplication or Call 'Global.init(this)' in your own Application ? ");
    }
    return context;
  }
  
  public static final File getFilesDir()
  {
    return getContext().getFilesDir();
  }
  
  public static final Looper getMainLooper()
  {
    return getContext().getMainLooper();
  }
  
  public static final PackageManager getPackageManager()
  {
    return getContext().getPackageManager();
  }
  
  public static final String getPackageName()
  {
    return getContext().getPackageName();
  }
  
  public static final SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    return getContext().getSharedPreferences(paramString, paramInt);
  }
  
  public static final Object getSystemService(String paramString)
  {
    return getContext().getSystemService(paramString);
  }
  
  public static final void init(Context paramContext)
  {
    setContext(paramContext);
  }
  
  public static final Intent registerReceiver(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter)
  {
    return getContext().registerReceiver(paramBroadcastReceiver, paramIntentFilter);
  }
  
  public static final void setContext(Context paramContext)
  {
    context = paramContext;
    try
    {
      if ((paramContext.getApplicationInfo().flags & 0x2) != 0) {}
      for (boolean bool = true;; bool = false)
      {
        isDebug = bool;
        if (isDebug) {
          Log.w("Wns.Global.Runtime", "DEBUG is ON");
        }
        return;
      }
      return;
    }
    catch (Exception paramContext)
    {
      isDebug = false;
    }
  }
  
  public static final void unregisterReceiver(BroadcastReceiver paramBroadcastReceiver)
  {
    getContext().unregisterReceiver(paramBroadcastReceiver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.base.Global
 * JD-Core Version:    0.7.0.1
 */