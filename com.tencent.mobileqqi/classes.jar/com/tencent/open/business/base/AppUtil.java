package com.tencent.open.business.base;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.StartAppCheckHandler;
import com.tencent.mobileqq.utils.FileProvider7Helper;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.ImageUtil;
import com.tencent.open.base.LogUtility;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AppUtil
{
  protected static final String a = "AppUtil";
  protected static Map a = new HashMap();
  
  public static int a(String paramString)
  {
    PackageManager localPackageManager = CommonDataAdapter.a().a().getPackageManager();
    try
    {
      paramString = localPackageManager.getPackageInfo(paramString, 1);
      if (paramString != null)
      {
        int i = paramString.versionCode;
        return i;
      }
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      LogUtility.b("AppUtil", "getApkVersonCode>>>", paramString);
    }
    return 0;
  }
  
  public static Intent a(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.MAIN", null);
    localIntent.addCategory("android.intent.category.LAUNCHER");
    localIntent.addFlags(1073741824);
    if (!a.containsKey(paramString))
    {
      paramContext = paramContext.getPackageManager().queryIntentActivities(localIntent, 0).iterator();
      while (paramContext.hasNext())
      {
        ResolveInfo localResolveInfo = (ResolveInfo)paramContext.next();
        if (!a.containsKey(localResolveInfo.activityInfo.applicationInfo.packageName)) {
          a.put(localResolveInfo.activityInfo.applicationInfo.packageName, localResolveInfo.activityInfo.name);
        }
      }
    }
    paramContext = (String)a.get(paramString);
    if (paramContext != null)
    {
      localIntent.setComponent(new ComponentName(paramString, paramContext));
      return localIntent;
    }
    return null;
  }
  
  public static Bitmap a(String paramString)
  {
    try
    {
      PackageManager localPackageManager = CommonDataAdapter.a().a().getPackageManager();
      paramString = localPackageManager.getPackageInfo(paramString, 1);
      if ((paramString != null) && (paramString.applicationInfo != null))
      {
        paramString = paramString.applicationInfo.loadIcon(localPackageManager);
        if (paramString != null)
        {
          paramString = ImageUtil.b(paramString);
          return paramString;
        }
      }
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
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
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      try
      {
        paramString = CommonDataAdapter.a().a().getPackageManager().getPackageArchiveInfo(paramString, 1);
        if (paramString != null)
        {
          paramString = paramString.applicationInfo.packageName;
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        LogUtility.c("AppUtil", "getApkName>>>", paramString);
      }
    }
    return null;
  }
  
  public static List a(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = paramContext.getPackageManager();
      if (paramContext != null)
      {
        LogUtility.b("AppUtil", "getInstalledPackages switch is open, will scan local packages");
        return paramContext.getInstalledPackages(0);
      }
    }
    LogUtility.b("AppUtil", "getInstalledPackages switch is closed, will not scan local packages");
    return null;
  }
  
  public static void a(Context paramContext, String paramString)
  {
    try
    {
      Intent localIntent = paramContext.getPackageManager().getLaunchIntentForPackage(paramString);
      localIntent.putExtra("platformId", "qzone_m");
      LogUtility.c("add", ">>has add platformid=qzone_m");
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception localException)
    {
      new Intent();
      paramString = a(paramContext, paramString);
      if (paramString != null)
      {
        paramString.setAction("android.intent.action.MAIN");
        paramString.putExtra("platformId", "qzone_m");
        LogUtility.c("add", ">>has add platformid=qzone_m");
        try
        {
          paramContext.startActivity(paramString);
          return;
        }
        catch (ActivityNotFoundException paramString)
        {
          paramString.printStackTrace();
          Toast.makeText(paramContext, "无法启动该应用", 0).show();
          return;
        }
      }
      Toast.makeText(paramContext, "无法启动该应用", 0).show();
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    Intent localIntent = paramContext.getPackageManager().getLaunchIntentForPackage(paramString2);
    paramString1 = localIntent;
    if (localIntent == null)
    {
      paramString1 = new Intent(paramString2);
      paramString1.addCategory("android.intent.category.DEFAULT");
    }
    if (!TextUtils.isEmpty(paramString3))
    {
      paramString1.putExtra("appCustom", paramString3);
      LogUtility.c("add", ">>has add appCustom=" + paramString3);
    }
    paramString1.putExtra("platformId", "qzone_m");
    LogUtility.c("add", ">>has add platformid=qzone_m");
    try
    {
      if (!(paramContext instanceof Activity)) {
        paramString1.addFlags(268435456);
      }
      paramContext.startActivity(paramString1);
      return;
    }
    catch (Exception paramString1)
    {
      Toast.makeText(paramContext, "启动失败", 0).show();
    }
  }
  
  public static boolean a(Context paramContext)
  {
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      if (new File(paramString).exists())
      {
        paramContext.startActivity(FileProvider7Helper.openApkIntent(paramContext, paramString));
        return true;
      }
    }
    catch (Exception paramContext)
    {
      LogUtility.c("AppUtil", "installApp>>>", paramContext);
    }
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString, Bundle paramBundle, int paramInt)
  {
    Intent localIntent = paramContext.getPackageManager().getLaunchIntentForPackage(paramString);
    if (localIntent == null)
    {
      localIntent = new Intent(paramString);
      localIntent.addCategory("android.intent.category.DEFAULT");
      try
      {
        for (;;)
        {
          localIntent.addFlags(paramInt);
          localIntent.putExtras(paramBundle);
          try
          {
            ((StartAppCheckHandler)((BaseActivity)paramContext).b.a(22)).b(paramString.trim(), paramContext, localIntent);
            return true;
          }
          catch (Exception paramBundle)
          {
            for (;;)
            {
              try
              {
                new StartAppCheckHandler((QQAppInterface)null).a(paramString.trim(), paramContext, localIntent);
              }
              catch (Exception paramString)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("AppStartedHandler", 2, "<-- StartAppCheckHandler Failed!");
                }
                paramContext.startActivity(localIntent);
              }
            }
          }
        }
      }
      catch (Exception paramString)
      {
        Toast.makeText(paramContext, "无法启动该应用", 0).show();
        return false;
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    PackageManager localPackageManager = CommonDataAdapter.a().a().getPackageManager();
    try
    {
      localPackageManager.getPackageInfo(paramString, 0);
      return true;
    }
    catch (PackageManager.NameNotFoundException paramString) {}
    return false;
  }
  
  public static int b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return 0;
      try
      {
        paramString = CommonDataAdapter.a().a().getPackageManager().getPackageArchiveInfo(paramString, 1);
        if (paramString != null)
        {
          int i = paramString.versionCode;
          return i;
        }
      }
      catch (Exception paramString)
      {
        LogUtility.c("AppUtil", "getApkVersonCodeFromApkFile>>>", paramString);
      }
    }
    return 0;
  }
  
  public static String b(Context paramContext)
  {
    try
    {
      int i = Process.myPid();
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (localRunningAppProcessInfo.pid == i)
        {
          paramContext = localRunningAppProcessInfo.processName;
          return paramContext;
        }
      }
    }
    catch (Exception paramContext)
    {
      LogUtility.b("AppUtil", "getCurProcessName err", paramContext);
    }
    return null;
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    try
    {
      paramContext.startActivity(new Intent("android.intent.action.DELETE", Uri.parse("package:" + paramString)));
      return true;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.business.base.AppUtil
 * JD-Core Version:    0.7.0.1
 */