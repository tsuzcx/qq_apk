package com.android.safeguard;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.Locale;

public class b
  extends h
{
  private Context a = null;
  
  public b(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private String a(Class paramClass, String paramString)
  {
    paramClass = c(paramClass, paramString);
    if (paramClass == null) {
      return "";
    }
    return (String)paramClass;
  }
  
  private int b(Class paramClass, String paramString)
  {
    paramClass = c(paramClass, paramString);
    if (paramClass == null) {
      return 0;
    }
    return ((Integer)paramClass).intValue();
  }
  
  private Object c(Class paramClass, String paramString)
  {
    try
    {
      paramClass = paramClass.getDeclaredField(paramString).get(paramClass);
      return paramClass;
    }
    catch (Throwable paramClass)
    {
      a(paramClass);
    }
    return null;
  }
  
  public String a()
  {
    try
    {
      String str = this.a.getPackageManager().getPackageInfo(this.a.getPackageName(), 64).applicationInfo.sourceDir;
      return str;
    }
    catch (Throwable localThrowable)
    {
      a(localThrowable);
    }
    return "";
  }
  
  public String b()
  {
    try
    {
      String str = Build.PRODUCT;
      return str;
    }
    catch (Throwable localThrowable)
    {
      a(localThrowable);
    }
    return "";
  }
  
  public String c()
  {
    return a(Build.class, "CPU_ABI");
  }
  
  public String d()
  {
    try
    {
      String str = Build.TAGS;
      return str;
    }
    catch (Throwable localThrowable)
    {
      a(localThrowable);
    }
    return "";
  }
  
  public int e()
  {
    return 1;
  }
  
  public String f()
  {
    try
    {
      String str = Build.MODEL;
      return str;
    }
    catch (Throwable localThrowable)
    {
      a(localThrowable);
    }
    return "";
  }
  
  public int g()
  {
    return b(Build.VERSION.class, "SDK_INT");
  }
  
  public String h()
  {
    try
    {
      String str = Build.VERSION.RELEASE;
      return str;
    }
    catch (Throwable localThrowable)
    {
      a(localThrowable);
    }
    return "";
  }
  
  public String i()
  {
    try
    {
      String str = Build.DEVICE;
      return str;
    }
    catch (Throwable localThrowable)
    {
      a(localThrowable);
    }
    return "";
  }
  
  public String j()
  {
    return a(Build.class, "HARDWARE");
  }
  
  public String k()
  {
    try
    {
      String str = Build.DISPLAY;
      return str;
    }
    catch (Throwable localThrowable)
    {
      a(localThrowable);
    }
    return "";
  }
  
  public String l()
  {
    try
    {
      String str = Build.BRAND;
      return str;
    }
    catch (Throwable localThrowable)
    {
      a(localThrowable);
    }
    return "";
  }
  
  public String m()
  {
    try
    {
      String str = Build.BOARD;
      return str;
    }
    catch (Throwable localThrowable)
    {
      a(localThrowable);
    }
    return "";
  }
  
  public String n()
  {
    try
    {
      String str = Build.FINGERPRINT;
      return str;
    }
    catch (Throwable localThrowable)
    {
      a(localThrowable);
    }
    return "";
  }
  
  public String o()
  {
    try
    {
      String str = Build.ID;
      return str;
    }
    catch (Throwable localThrowable)
    {
      a(localThrowable);
    }
    return "";
  }
  
  public String p()
  {
    return a(Build.class, "MANUFACTURER");
  }
  
  public String q()
  {
    try
    {
      String str = Build.USER;
      return str;
    }
    catch (Throwable localThrowable)
    {
      a(localThrowable);
    }
    return "";
  }
  
  public String r()
  {
    try
    {
      String str = Locale.getDefault().toString();
      return str;
    }
    catch (Throwable localThrowable)
    {
      a(localThrowable);
    }
    return "";
  }
  
  public String s()
  {
    try
    {
      String str = Charset.defaultCharset().name();
      return str;
    }
    catch (Throwable localThrowable)
    {
      a(localThrowable);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.android.safeguard.b
 * JD-Core Version:    0.7.0.1
 */