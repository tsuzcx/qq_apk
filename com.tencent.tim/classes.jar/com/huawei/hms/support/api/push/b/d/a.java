package com.huawei.hms.support.api.push.b.d;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class a
{
  public static long a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    try
    {
      paramString = new Date();
      int j = paramString.getHours() * 2 + paramString.getMinutes() / 30;
      str = str.concat(str);
      HMSLog.i("PushSelfShowLog", "startIndex is " + j + ",ap is:" + str + ",length is:" + str.length());
      int k = str.length();
      int i = j;
      while (i < k)
      {
        if (str.charAt(i) != '0')
        {
          long l = ((i - j) * 30 - paramString.getMinutes() % 30) * 60000L;
          HMSLog.d("PushSelfShowLog", "startIndex is:" + j + " i is:" + i + " delay:" + l);
          if (l >= 0L) {
            return l;
          }
          return 0L;
        }
        i += 1;
      }
      return 0L;
    }
    catch (Exception paramString)
    {
      HMSLog.e("PushSelfShowLog", "error ", paramString);
    }
  }
  
  public static Boolean a(Context paramContext, String paramString, Intent paramIntent)
  {
    try
    {
      paramContext = paramContext.getPackageManager().queryIntentActivities(paramIntent, 0);
      if ((paramContext != null) && (paramContext.size() > 0))
      {
        int j = paramContext.size();
        int i = 0;
        while (i < j)
        {
          if ((((ResolveInfo)paramContext.get(i)).activityInfo != null) && (paramString.equals(((ResolveInfo)paramContext.get(i)).activityInfo.applicationInfo.packageName))) {
            return Boolean.valueOf(true);
          }
          i += 1;
        }
      }
      return Boolean.valueOf(false);
    }
    catch (Exception paramContext)
    {
      HMSLog.e("PushSelfShowLog", paramContext.toString(), paramContext);
    }
  }
  
  public static String a(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager();
      paramContext = paramContext.getApplicationLabel(paramContext.getApplicationInfo(paramString, 128)).toString();
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      HMSLog.i("PushSelfShowLog", "get the app name of package:" + paramString + " failed.");
    }
    return null;
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    if (paramContext == null) {
      HMSLog.e("PushSelfShowLog", "context is null");
    }
    for (;;)
    {
      return;
      try
      {
        paramContext = (NotificationManager)paramContext.getSystemService("notification");
        if (paramContext != null)
        {
          paramContext.cancel(paramInt);
          return;
        }
      }
      catch (Exception paramContext)
      {
        HMSLog.e("PushSelfShowLog", "removeNotifiCationById err:" + paramContext.toString());
      }
    }
  }
  
  @SuppressLint({"TrulyRandom"})
  public static void a(Context paramContext, Intent paramIntent, long paramLong)
  {
    try
    {
      HMSLog.d("PushSelfShowLog", "enter setAPDelayAlarm(intent:" + paramIntent.toURI() + " interval:" + paramLong + "ms, context:" + paramContext);
      AlarmManager localAlarmManager = (AlarmManager)paramContext.getSystemService("alarm");
      if (localAlarmManager != null)
      {
        paramContext = PendingIntent.getBroadcast(paramContext, new SecureRandom().nextInt(), paramIntent, 0);
        localAlarmManager.set(0, System.currentTimeMillis() + paramLong, paramContext);
      }
      return;
    }
    catch (Exception paramContext)
    {
      HMSLog.w("PushSelfShowLog", "set DelayAlarm error" + paramContext.toString());
    }
  }
  
  public static boolean a()
  {
    return Build.VERSION.SDK_INT >= 11;
  }
  
  public static boolean a(Context paramContext)
  {
    return "com.huawei.android.pushagent".equals(paramContext.getPackageName());
  }
  
  public static boolean a(Context paramContext, Intent paramIntent)
  {
    if (paramContext == null)
    {
      HMSLog.i("PushSelfShowLog", "context is null");
      return false;
    }
    if (paramIntent == null)
    {
      HMSLog.i("PushSelfShowLog", "intent is null");
      return false;
    }
    paramContext = paramContext.getPackageManager().queryIntentActivities(paramIntent, 640);
    if ((paramContext == null) || (paramContext.size() == 0))
    {
      HMSLog.e("PushSelfShowLog", "no activity exist, may be system Err!! pkgName:");
      return false;
    }
    boolean bool = ((ResolveInfo)paramContext.get(0)).activityInfo.exported;
    HMSLog.i("PushSelfShowLog", "exportedFlag:" + bool);
    paramContext = ((ResolveInfo)paramContext.get(0)).activityInfo.permission;
    HMSLog.i("PushSelfShowLog", "need permission:" + paramContext);
    if (!bool) {
      return false;
    }
    if (TextUtils.isEmpty(paramContext)) {
      return true;
    }
    HMSLog.e("PushSelfShowLog", "does't have the permission to open this activity");
    return false;
  }
  
  public static Intent b(Context paramContext, String paramString)
  {
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext = paramContext.getLaunchIntentForPackage(paramString);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      HMSLog.w("PushSelfShowLog", paramString + "not have launch activity");
    }
    return null;
  }
  
  public static void b(Context paramContext, Intent paramIntent)
  {
    for (;;)
    {
      try
      {
        if (paramIntent.hasExtra("selfshow_notify_id"))
        {
          i = paramIntent.getIntExtra("selfshow_notify_id", 0) + 3;
          HMSLog.d("PushSelfShowLog", "setDelayAlarm(cancel) alarmNotityId " + i + " and intent is " + paramIntent.toURI());
          Intent localIntent = new Intent("com.huawei.intent.action.PUSH_DELAY_NOTIFY");
          localIntent.setPackage(paramContext.getPackageName()).setFlags(32);
          paramIntent = (AlarmManager)paramContext.getSystemService("alarm");
          paramContext = PendingIntent.getBroadcast(paramContext, i, localIntent, 536870912);
          if ((paramContext != null) && (paramIntent != null))
          {
            HMSLog.d("PushSelfShowLog", "  alarm cancel");
            paramIntent.cancel(paramContext);
            return;
          }
          HMSLog.d("PushSelfShowLog", "alarm not exist");
          return;
        }
      }
      catch (Exception paramContext)
      {
        HMSLog.e("PushSelfShowLog", "cancelAlarm err:" + paramContext.toString());
        return;
      }
      int i = 0;
    }
  }
  
  public static boolean b(Context paramContext)
  {
    return "com.huawei.hwid".equals(paramContext.getPackageName());
  }
  
  public static boolean c(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null) || ("".equals(paramString))) {}
    for (;;)
    {
      return false;
      try
      {
        if (paramContext.getPackageManager().getApplicationInfo(paramString, 8192) != null)
        {
          HMSLog.d("PushSelfShowLog", paramString + " is installed");
          return true;
        }
      }
      catch (Exception paramContext) {}
    }
    return false;
  }
  
  public static void d(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      HMSLog.i("PushSelfShowLog", "url is null.");
      return;
    }
    for (;;)
    {
      try
      {
        Intent localIntent = new Intent("android.intent.action.VIEW");
        localIntent.setData(Uri.parse(paramString));
        localIntent.setFlags(402653184);
        Object localObject = paramContext.getPackageManager().queryIntentActivities(localIntent, 0);
        Iterator localIterator = ((List)localObject).iterator();
        if (!localIterator.hasNext()) {
          break label197;
        }
        paramString = ((ResolveInfo)localIterator.next()).activityInfo.packageName;
        if (!e(paramContext, paramString)) {
          continue;
        }
        if (paramString == null)
        {
          localIterator = ((List)localObject).iterator();
          if (localIterator.hasNext())
          {
            localObject = ((ResolveInfo)localIterator.next()).activityInfo.packageName;
            if (!"com.android.browser".equalsIgnoreCase((String)localObject)) {
              continue;
            }
            paramString = (String)localObject;
            if (paramString != null) {
              localIntent.setPackage(paramString);
            }
            paramContext.startActivity(localIntent);
            return;
          }
        }
      }
      catch (Exception paramContext)
      {
        HMSLog.e("PushSelfShowLog", "start browser activity failed, exception:" + paramContext.getMessage());
        return;
      }
      continue;
      label197:
      paramString = null;
    }
  }
  
  public static boolean e(Context paramContext, String paramString)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramContext.getPackageManager().getPreferredActivities(localArrayList1, localArrayList2, paramString);
    return localArrayList2.size() > 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.support.api.push.b.d.a
 * JD-Core Version:    0.7.0.1
 */