package com.tencent.android.tpush.common;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.android.tpush.logging.TLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AppInfos
{
  private static String a = "";
  
  public static boolean checkApplicationIcon(Context paramContext)
  {
    try
    {
      paramContext = getAppInfo(paramContext);
      if (paramContext == null)
      {
        TLogger.ee("AppInfos", "Failed to init due to null ApplicationInfo.");
        return false;
      }
      if (paramContext.icon == 0)
      {
        TLogger.ee("AppInfos", "Failed to get Application icon in AndroidManifest.xml, You App maybe can not show notification, Please add Application icon in AndroidManifest.xml");
        return false;
      }
    }
    catch (Throwable paramContext)
    {
      TLogger.w("AppInfos", "unexpected for checkApplicationIcon:" + paramContext.getMessage());
      return false;
    }
    return true;
  }
  
  public static boolean forbidPullupService(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      if (paramContext != null)
      {
        paramContext = paramContext.metaData;
        if (paramContext != null)
        {
          boolean bool = paramContext.getBoolean("XG_SERVICE_PULL_UP_OFF");
          return bool;
        }
      }
    }
    catch (Throwable paramContext)
    {
      TLogger.w("AppInfos", "unexpected for forbidPullupService", paramContext);
    }
    return false;
  }
  
  public static int getApiLevel()
  {
    return Build.VERSION.SDK_INT;
  }
  
  public static ApplicationInfo getAppInfo(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 0);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      TLogger.ee("AppInfos", "Failed to get Application info", paramContext);
    }
    return null;
  }
  
  public static String getAppVersion(Context paramContext)
  {
    if (i.c(a)) {
      return a;
    }
    try
    {
      a = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      if ((a == null) || (a.length() == 0)) {
        return "unknown";
      }
    }
    catch (Throwable paramContext)
    {
      TLogger.ee("AppInfos", "getAppVersion error!", paramContext);
    }
    return a;
  }
  
  public static String getApplicationName(Context paramContext)
  {
    try
    {
      ApplicationInfo localApplicationInfo = paramContext.getApplicationInfo();
      int i = localApplicationInfo.labelRes;
      if (i == 0) {
        return localApplicationInfo.nonLocalizedLabel.toString();
      }
      paramContext = paramContext.getString(i);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      TLogger.e("AppInfos", "", paramContext);
    }
    return null;
  }
  
  public static String getCurAppVersion(Context paramContext)
  {
    try
    {
      String str = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      paramContext = str;
      if (str == null) {
        paramContext = "";
      }
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      TLogger.e("AppInfos", "get app version error", paramContext);
    }
    return "";
  }
  
  public static String getCurrentPackageName(Context paramContext)
  {
    if (paramContext != null) {
      return paramContext.getPackageName();
    }
    return "";
  }
  
  public static String getLauncherPackageName(Context paramContext)
  {
    if (paramContext == null) {}
    do
    {
      return null;
      Intent localIntent = new Intent("android.intent.action.MAIN");
      localIntent.addCategory("android.intent.category.HOME");
      paramContext = paramContext.getPackageManager().resolveActivity(localIntent, 0);
    } while ((paramContext == null) || (paramContext.activityInfo == null) || (paramContext.activityInfo.packageName.equals("android")));
    return paramContext.activityInfo.packageName;
  }
  
  public static Object getMetaData(Context paramContext, String paramString, Object paramObject)
  {
    ApplicationInfo localApplicationInfo = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
    paramContext = paramObject;
    if (localApplicationInfo != null)
    {
      paramString = localApplicationInfo.metaData.get(paramString);
      paramContext = paramObject;
      if (paramString != null) {
        paramContext = paramString;
      }
    }
    return paramContext;
  }
  
  public static String getOsVersion()
  {
    return Build.VERSION.RELEASE;
  }
  
  public static List<String> getRunningPkgsByPkgs(Context paramContext, List<String> paramList)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      if (isAppOnForeground(paramContext, (String)paramList.get(i)))
      {
        localArrayList.clear();
        localArrayList.add(paramList.get(i));
        return localArrayList;
      }
      if (isAppRunning(paramContext, (String)paramList.get(i))) {
        localArrayList.add(paramList.get(i));
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static boolean isAppOnForeground(Context paramContext)
  {
    return isAppOnForeground(paramContext, paramContext.getPackageName());
  }
  
  public static boolean isAppOnForeground(Context paramContext, String paramString)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      if ((localRunningAppProcessInfo.processName.equals(paramString)) && (localRunningAppProcessInfo.importance == 100)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean isAppRunning(Context paramContext, String paramString)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (paramContext != null)
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext()) {
        if (((ActivityManager.RunningAppProcessInfo)paramContext.next()).processName.equals(paramString)) {
          return true;
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.common.AppInfos
 * JD-Core Version:    0.7.0.1
 */