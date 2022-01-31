package com.tencent.mobileqq.cooperation;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import java.io.File;
import java.util.List;

public abstract class ApkUtils
{
  public static int a(Context paramContext)
  {
    try
    {
      int i = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionCode;
      return i;
    }
    catch (Exception paramContext) {}
    return 0;
  }
  
  public static Intent a(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setDataAndType(Uri.fromFile(new File(paramString)), "application/vnd.android.package-archive");
    return localIntent;
  }
  
  public static String a(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      return paramContext;
    }
    catch (Exception paramContext) {}
    return "";
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
    if ((paramContext != null) && (paramContext.size() > 0)) {
      return ((ActivityManager.RunningTaskInfo)paramContext.get(0)).topActivity.getPackageName().equalsIgnoreCase(paramString);
    }
    return false;
  }
  
  public static boolean a(String paramString, Context paramContext)
  {
    paramContext = paramContext.getPackageManager();
    try
    {
      paramString = paramContext.getApplicationInfo(paramString, 1);
      return paramString != null;
    }
    catch (PackageManager.NameNotFoundException paramString) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.cooperation.ApkUtils
 * JD-Core Version:    0.7.0.1
 */