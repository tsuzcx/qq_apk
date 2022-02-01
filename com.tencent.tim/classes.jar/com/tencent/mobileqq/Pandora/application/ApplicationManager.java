package com.tencent.mobileqq.Pandora.application;

import alkx;
import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.mobileqq.Pandora.util.BackgroundUtil;
import com.tencent.mobileqq.Pandora.util.Log;
import com.tencent.mobileqq.Pandora.util.SharedPreferencesManager;
import com.tencent.mobileqq.Pandora.util.StringUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class ApplicationManager
{
  private static final long MILLISECONDS_OF_MAX_UPDATE_TIME = 115200000L;
  private static final String TAG = "ApplicationManager";
  private static List<String> activityList = new ArrayList();
  private static List<String> applicationList = new ArrayList();
  private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.SIMPLIFIED_CHINESE);
  
  public static List<String> getApplicationList(Context paramContext)
  {
    if ((isUpdateApplicationList(paramContext, "applicationList_last_update_time")) && (!BackgroundUtil.isOnBackgroud(paramContext))) {
      updateApplicationList(paramContext);
    }
    if (!applicationList.isEmpty()) {
      return applicationList;
    }
    if (SharedPreferencesManager.contain(paramContext, "applicationlist").booleanValue()) {
      applicationList = StringUtil.split(SharedPreferencesManager.getData(paramContext, "applicationlist"), ",");
    }
    return new ArrayList();
  }
  
  public static boolean isUpdateApplicationList(Context paramContext, String paramString)
  {
    long l1 = System.currentTimeMillis();
    if (SharedPreferencesManager.contain(paramContext, paramString).booleanValue())
    {
      long l2 = StringUtil.stringToLong("ApplicationManager", SharedPreferencesManager.getData(paramContext, paramString));
      if (Math.abs(l1 - l2) >= 115200000L)
      {
        SharedPreferencesManager.save(paramContext, paramString, String.valueOf(l1));
        Log.d("ApplicationManager", "lastTime: " + sdf.format(new Date(l2)) + " currTime: " + sdf.format(new Date(l1)));
        return true;
      }
    }
    else
    {
      SharedPreferencesManager.save(paramContext, paramString, String.valueOf(l1));
      return true;
    }
    return false;
  }
  
  public static List<String> updateApplicationList(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      Iterator localIterator = alkx.a(paramContext.getPackageManager(), 5).iterator();
      while (localIterator.hasNext())
      {
        localArrayList.add(((PackageInfo)localIterator.next()).packageName);
        continue;
        applicationList = localArrayList;
      }
    }
    catch (Throwable localThrowable)
    {
      Log.e("ApplicationManager", "getInstalledPackages Throwable error is :", localThrowable);
    }
    for (;;)
    {
      SharedPreferencesManager.save(paramContext, "applicationlist", StringUtil.listToString(applicationList, ","));
      return applicationList;
      Log.e("ApplicationManager", "getInstalledPackages class", new Throwable());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.Pandora.application.ApplicationManager
 * JD-Core Version:    0.7.0.1
 */