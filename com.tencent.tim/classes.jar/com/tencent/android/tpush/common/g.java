package com.tencent.android.tpush.common;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.android.tpush.logging.TLogger;
import java.lang.reflect.Method;

public class g
{
  private static String a = "";
  private static String b = "";
  private static String c = "";
  private static String d = "";
  private static String e = "";
  private static String f = "";
  
  public static String a()
  {
    try
    {
      String str = Build.MANUFACTURER.toLowerCase();
      if (str.contains("huawei")) {
        return d();
      }
      if (str.contains("xiaomi")) {
        return h();
      }
      if (str.contains("meizu")) {
        return g();
      }
      if ((str.contains("oppo")) || (str.contains("realme"))) {
        return f();
      }
      if (str.contains("vivo")) {
        return e();
      }
      if (str.contains("oneplus"))
      {
        str = i();
        return str;
      }
    }
    catch (Throwable localThrowable) {}
    return "";
  }
  
  private static String a(String paramString)
  {
    try
    {
      Object localObject = Class.forName("android.os.SystemProperties");
      localObject = (String)((Class)localObject).getDeclaredMethod("get", new Class[] { String.class }).invoke(localObject, new Object[] { paramString });
      TLogger.i("RomVersionHelper", "get " + paramString + " version is:" + (String)localObject);
      return localObject;
    }
    catch (Throwable paramString) {}
    return "";
  }
  
  public static boolean b()
  {
    try
    {
      Class localClass = Class.forName("com.huawei.system.BuildEx");
      boolean bool = "harmony".equals(localClass.getMethod("getOsBrand", new Class[0]).invoke(localClass, new Object[0]));
      return bool;
    }
    catch (Exception localException)
    {
      return false;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      return false;
    }
    catch (ClassNotFoundException localClassNotFoundException) {}
    return false;
  }
  
  public static String c()
  {
    if (!b()) {
      return null;
    }
    try
    {
      String str = ((Integer)Class.forName("ohos.system.version.SystemVersion").getMethod("getMajorVerion", new Class[0]).invoke(null, new Object[0])).toString();
      return str;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  private static String d()
  {
    if (!TextUtils.isEmpty(a)) {
      return a;
    }
    a = a("ro.build.version.emui");
    return a;
  }
  
  private static String e()
  {
    if (!TextUtils.isEmpty(c)) {
      return c;
    }
    c = a("ro.vivo.os.build.display.id");
    return c;
  }
  
  private static String f()
  {
    if (!TextUtils.isEmpty(b)) {
      return b;
    }
    b = a("ro.build.version.opporom");
    return b;
  }
  
  private static String g()
  {
    if (!TextUtils.isEmpty(f)) {
      return f;
    }
    f = a("ro.build.display.id");
    return f;
  }
  
  private static String h()
  {
    if (!TextUtils.isEmpty(e)) {
      return e;
    }
    e = a("ro.miui.ui.version.name");
    return e;
  }
  
  private static String i()
  {
    if (!TextUtils.isEmpty(d)) {
      return d;
    }
    d = a("ro.rom.version");
    return d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.common.g
 * JD-Core Version:    0.7.0.1
 */