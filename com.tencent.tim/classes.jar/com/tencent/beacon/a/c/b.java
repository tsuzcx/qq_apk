package com.tencent.beacon.a.c;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.Process;
import android.text.TextUtils;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class b
{
  public static String a;
  public static int b = 0;
  public static String c = "";
  public static boolean d = false;
  private static String e;
  private static boolean f = false;
  private static String g = "";
  private static boolean h = false;
  private static boolean i = false;
  private static int j = -2;
  private static boolean k = true;
  
  public static String a()
  {
    if (a == null) {
      a = e();
    }
    return a;
  }
  
  public static String a(Context paramContext)
  {
    try
    {
      if (TextUtils.isEmpty(e))
      {
        paramContext = "on_app_first_install_time_" + c(paramContext);
        com.tencent.beacon.a.d.a locala = com.tencent.beacon.a.d.a.a();
        long l2 = locala.getLong(paramContext, 0L);
        long l1 = l2;
        if (l2 == 0L)
        {
          l1 = new Date().getTime();
          com.tencent.beacon.a.b.a.a().a(new a(locala, paramContext, l1));
        }
        e = String.valueOf(l1);
        com.tencent.beacon.base.util.c.a("[appInfo] process: %s, getAppFirstInstallTime: %s", new Object[] { paramContext, e });
      }
      com.tencent.beacon.base.util.c.a("[appInfo] getAppFirstInstallTime: %s", new Object[] { e });
      paramContext = e;
      return paramContext;
    }
    finally {}
  }
  
  public static void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        if (Long.parseLong(paramString) > 10000L) {
          g = paramString;
        }
        return;
      }
      catch (Exception paramString)
      {
        com.tencent.beacon.base.util.c.e("[appInfo] set qq is not available !", new Object[0]);
        return;
      }
    }
    com.tencent.beacon.base.util.c.e("[appInfo] set qq is null !", new Object[0]);
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if (i) {
      return k;
    }
    if ((paramContext == null) || (paramString == null) || (paramString.trim().length() <= 0)) {
      return false;
    }
    if (!com.tencent.beacon.e.b.a().h())
    {
      com.tencent.beacon.base.util.c.a("[DeviceInfo] current collect Process Info be refused! isCollect Process Info: %s", new Object[] { Boolean.valueOf(false) });
      return true;
    }
    if (i) {
      return k;
    }
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if ((paramContext == null) || (paramContext.size() == 0))
    {
      com.tencent.beacon.base.util.c.e("[appInfo] no running proc", new Object[0]);
      return false;
    }
    paramContext = paramContext.iterator();
    while (paramContext.hasNext())
    {
      Object localObject = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      if (((ActivityManager.RunningAppProcessInfo)localObject).importance == 100)
      {
        localObject = ((ActivityManager.RunningAppProcessInfo)localObject).pkgList;
        int n = localObject.length;
        int m = 0;
        while (m < n)
        {
          if (paramString.equals(localObject[m]))
          {
            k = true;
            i = true;
            return k;
          }
          m += 1;
        }
      }
    }
    k = false;
    i = true;
    return k;
  }
  
  public static int b(Context paramContext)
  {
    if (h) {
      return j;
    }
    if (b == 0) {
      b = Process.myPid();
    }
    if (!com.tencent.beacon.e.b.a().h())
    {
      com.tencent.beacon.base.util.c.a("[DeviceInfo] current collect Process Info be refused! isCollect Process Info: %s", new Object[] { Boolean.valueOf(false) });
      return -2;
    }
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    if ((paramContext != null) && (paramContext.getRunningAppProcesses() != null))
    {
      paramContext = paramContext.getRunningAppProcesses().iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (localRunningAppProcessInfo.pid == b)
        {
          j = localRunningAppProcessInfo.importance;
          h = true;
          return j;
        }
      }
    }
    j = 0;
    h = true;
    return j;
  }
  
  public static String b()
  {
    Object localObject = c.d().c();
    if (localObject == null) {
      localObject = null;
    }
    String str;
    do
    {
      return localObject;
      str = ((Context)localObject).getPackageName();
      localObject = str;
    } while (!TextUtils.isEmpty(str));
    return "";
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    boolean bool3 = true;
    boolean bool1;
    boolean bool2;
    if ((paramContext != null) && (paramString != null)) {
      if (paramContext.checkPermission(paramString, Process.myPid(), Process.myUid()) == 0)
      {
        bool1 = true;
        bool2 = bool1;
        if (bool1) {}
      }
    }
    label164:
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT >= 23) {
          break label164;
        }
        paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 4096).requestedPermissions;
        if (paramContext == null) {
          break label164;
        }
        int n = paramContext.length;
        int m = 0;
        if (m >= n) {
          break label164;
        }
        bool2 = paramString.equals(paramContext[m]);
        if (bool2)
        {
          bool1 = bool3;
          com.tencent.beacon.base.util.c.a("[appInfo] end", new Object[0]);
          bool2 = bool1;
          return bool2;
          bool1 = false;
          break;
        }
        m += 1;
        continue;
      }
      catch (Throwable paramContext)
      {
        com.tencent.beacon.base.util.c.a(paramContext);
        return bool1;
      }
      finally
      {
        com.tencent.beacon.base.util.c.a("[appInfo] end", new Object[0]);
      }
      return false;
    }
  }
  
  public static String c()
  {
    return g;
  }
  
  public static String c(Context paramContext)
  {
    return com.tencent.beacon.base.util.a.a();
  }
  
  public static String d()
  {
    if (!"".equals(c)) {
      return c;
    }
    if (b == 0) {
      b = Process.myPid();
    }
    c = c + b + "_";
    c += new Date().getTime();
    return c;
  }
  
  public static boolean d(Context paramContext)
  {
    boolean bool1 = false;
    if (paramContext == null) {}
    for (;;)
    {
      try
      {
        com.tencent.beacon.base.util.c.b("[appInfo] context is null", new Object[0]);
        return bool1;
      }
      finally {}
      Object localObject = com.tencent.beacon.a.d.a.a();
      String str = ((com.tencent.beacon.a.d.a)localObject).getString("APPVER_DENGTA", "");
      paramContext = a();
      if ((str.isEmpty()) || (!str.equals(paramContext)))
      {
        boolean bool2 = true;
        localObject = ((com.tencent.beacon.a.d.a)localObject).edit();
        bool1 = bool2;
        if (com.tencent.beacon.base.util.b.a((SharedPreferences.Editor)localObject))
        {
          ((SharedPreferences.Editor)localObject).putString("APPVER_DENGTA", paramContext);
          bool1 = bool2;
        }
      }
    }
  }
  
  public static String e()
  {
    int n = 0;
    try
    {
      Object localObject1 = b();
      boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
      if (bool)
      {
        localObject1 = null;
        return localObject1;
      }
      Object localObject3 = c.d().c();
      for (;;)
      {
        try
        {
          localObject1 = ((Context)localObject3).getPackageManager().getPackageInfo((String)localObject1, 0);
          localObject3 = ((PackageInfo)localObject1).versionName;
          int i2 = ((PackageInfo)localObject1).versionCode;
          if ((localObject3 == null) || (((String)localObject3).trim().length() <= 0))
          {
            localObject1 = new StringBuilder();
            localObject1 = "" + i2;
            break;
          }
          localObject1 = ((String)localObject3).trim().replace('\n', ' ').replace('\r', ' ');
          localObject1 = ((String)localObject1).replace("|", "%7C");
          localObject3 = ((String)localObject1).toCharArray();
          int m = 0;
          if (m < localObject3.length)
          {
            int i3 = localObject3[m];
            int i1 = n;
            if (i3 == 46) {
              i1 = n + 1;
            }
            m += 1;
            n = i1;
            continue;
          }
          if (n >= 3) {
            break label292;
          }
          com.tencent.beacon.base.util.c.a("[appInfo] add versionCode: %s", new Object[] { Integer.valueOf(i2) });
          localObject1 = new StringBuilder().append((String)localObject1);
          localObject1 = "." + i2;
          com.tencent.beacon.base.util.c.a("[appInfo] final Version: %s", new Object[] { localObject1 });
        }
        catch (Throwable localThrowable)
        {
          com.tencent.beacon.base.util.c.a(localThrowable);
          com.tencent.beacon.base.util.c.b(localThrowable.toString(), new Object[0]);
          String str = "";
        }
        break;
      }
    }
    finally {}
  }
  
  public static boolean e(Context paramContext)
  {
    return a(paramContext, paramContext.getPackageName());
  }
  
  public static void f() {}
  
  public static boolean f(Context paramContext)
  {
    if (paramContext == null) {}
    String str;
    do
    {
      return true;
      str = c(paramContext);
    } while ((TextUtils.isEmpty(str)) || (str.equals(paramContext.getPackageName())));
    return false;
  }
  
  public static boolean g()
  {
    boolean bool1 = false;
    try
    {
      Object localObject2 = com.tencent.beacon.a.d.a.a();
      String str2 = ((com.tencent.beacon.a.d.a)localObject2).getString("APPKEY_DENGTA", "");
      String str1 = c.d().f();
      if ((TextUtils.isEmpty(str2)) || (!str1.equals(str2)))
      {
        boolean bool2 = true;
        localObject2 = ((com.tencent.beacon.a.d.a)localObject2).edit();
        bool1 = bool2;
        if (com.tencent.beacon.base.util.b.a((SharedPreferences.Editor)localObject2))
        {
          ((SharedPreferences.Editor)localObject2).putString("APPKEY_DENGTA", str1);
          bool1 = bool2;
        }
      }
      return bool1;
    }
    finally {}
  }
  
  public static boolean h()
  {
    return f;
  }
  
  private static void i()
  {
    try
    {
      Object localObject = com.tencent.beacon.a.d.a.a();
      String str2 = ((com.tencent.beacon.a.d.a)localObject).getString("APPVER_DENGTA", "");
      String str1 = a();
      if ((!TextUtils.isEmpty(str2)) && (str1.equals(str2)))
      {
        f = false;
        return;
      }
      f = true;
      localObject = ((com.tencent.beacon.a.d.a)localObject).edit();
      boolean bool = com.tencent.beacon.base.util.b.a((SharedPreferences.Editor)localObject);
      if (bool)
      {
        ((SharedPreferences.Editor)localObject).putString("APPVER_DENGTA", str1);
        return;
      }
    }
    catch (Exception localException)
    {
      com.tencent.beacon.base.util.c.b("[core] app version check fail!", new Object[0]);
      com.tencent.beacon.base.util.c.a(localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.a.c.b
 * JD-Core Version:    0.7.0.1
 */