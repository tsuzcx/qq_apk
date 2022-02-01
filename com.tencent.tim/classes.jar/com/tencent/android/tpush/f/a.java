package com.tencent.android.tpush.f;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.reflecttools.Reflect;
import com.tencent.tpns.reflecttools.ReflectException;
import java.util.Iterator;
import java.util.List;

public class a
{
  private static Boolean a = null;
  private static Boolean b = null;
  
  public static int a()
  {
    try
    {
      int i = ((Integer)Reflect.on("com.tencent.tpns.syspush.XGSystemPush").call("getPushChannelType").get()).intValue();
      return i;
    }
    catch (ReflectException localReflectException) {}
    return -1;
  }
  
  public static String a(Context paramContext, long paramLong)
  {
    try
    {
      paramContext = (String)Reflect.on("com.tencent.tpns.syspush.XGSystemPush").call("getAppPackage", new Object[] { paramContext, Long.valueOf(paramLong) }).get();
      return paramContext;
    }
    catch (ReflectException paramContext) {}
    return null;
  }
  
  public static boolean a(Context paramContext)
  {
    if (a == null)
    {
      paramContext = paramContext.getApplicationInfo();
      if ((paramContext.uid > 1000) && ((paramContext.flags & 0x1) == 0)) {
        break label79;
      }
    }
    for (;;)
    {
      try
      {
        Class.forName("com.tencent.tpns.syspush.XGSystemPush");
        a = Boolean.valueOf(true);
        TLogger.ii("SysPush", "Run As SysPush!");
        return a.booleanValue();
      }
      catch (Throwable paramContext)
      {
        a = Boolean.valueOf(false);
        TLogger.ii("SysPush", "Run in sys app, but not found sys push sdk");
        return a.booleanValue();
      }
      label79:
      a = Boolean.valueOf(false);
      TLogger.d("SysPush", "Run in normal app");
    }
  }
  
  public static boolean a(Context paramContext, long paramLong, String paramString)
  {
    try
    {
      boolean bool = ((Boolean)Reflect.on("com.tencent.tpns.syspush.XGSystemPush").call("checkAccessIdAndPackage", new Object[] { paramContext, Long.valueOf(paramLong), paramString }).get()).booleanValue();
      return bool;
    }
    catch (ReflectException paramContext) {}
    return false;
  }
  
  public static boolean b(Context paramContext)
  {
    if (b == null) {
      try
      {
        Iterator localIterator = paramContext.getPackageManager().queryContentProviders(null, 0, 0).iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (ProviderInfo)localIterator.next();
          if ((((ProviderInfo)localObject).name.equals("com.tencent.tpns.syspush.XGSystemPushProvider")) && (((ProviderInfo)localObject).authority.equals("com.tencent.tpns.syspush.auth")))
          {
            TLogger.d("SysPush", "get sys push content provider");
            localObject = ((ProviderInfo)localObject).applicationInfo;
            if (paramContext.getPackageName().equals(((ApplicationInfo)localObject).packageName))
            {
              b = Boolean.valueOf(false);
              TLogger.i("SysPush", "Get isUseXgSysDevice false, beacuse it is itself");
              return b.booleanValue();
            }
            if ((((ApplicationInfo)localObject).uid <= 1000) || ((((ApplicationInfo)localObject).flags & 0x1) != 0))
            {
              b = Boolean.valueOf(true);
              TLogger.i("SysPush", "Get isUseXgSysDevice true -> uid:" + ((ApplicationInfo)localObject).uid + ", applicationInfo.flags:" + ((ApplicationInfo)localObject).flags);
              boolean bool = b.booleanValue();
              return bool;
            }
          }
        }
      }
      catch (Throwable paramContext)
      {
        TLogger.w("SysPush", "isUseXgSysDevice Throwable ", paramContext);
        b = Boolean.valueOf(false);
      }
    }
    TLogger.i("SysPush", "isUseXgSysDevice: " + b);
    return b.booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.f.a
 * JD-Core Version:    0.7.0.1
 */