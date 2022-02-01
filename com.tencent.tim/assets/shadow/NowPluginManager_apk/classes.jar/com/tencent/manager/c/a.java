package com.tencent.manager.c;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Process;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;

public class a
{
  public static boolean a(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.iterator();
    while (paramContext.hasNext()) {
      if (paramString.compareTo(((ActivityManager.RunningAppProcessInfo)paramContext.next()).processName) == 0) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo(paramString.trim(), 0);
        if (paramContext != null) {
          return true;
        }
      }
      catch (Exception paramContext) {}
    }
    return false;
  }
  
  public static void c(Context paramContext, String paramString)
  {
    if (paramString == null) {}
    do
    {
      return;
      localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    } while ((localObject == null) || (((List)localObject).size() == 0));
    Object localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
      if (paramString.equals(localRunningAppProcessInfo.processName)) {
        Process.killProcess(localRunningAppProcessInfo.pid);
      }
    }
    d(paramContext, paramString);
  }
  
  public static void d(Context paramContext, String paramString)
  {
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    Object localObject = paramContext.getRunningAppProcesses();
    if ((localObject == null) || (((List)localObject).size() == 0)) {}
    label90:
    for (;;)
    {
      return;
      localObject = ((List)localObject).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!paramString.equals(((ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next()).processName));
      for (int i = 1;; i = 0)
      {
        for (;;)
        {
          if (i == 0) {
            break label90;
          }
          try
          {
            Thread.sleep(10L);
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
          }
        }
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\assets\shadow\NowPluginManager_apk\classes.jar
 * Qualified Name:     com.tencent.manager.c.a
 * JD-Core Version:    0.7.0.1
 */