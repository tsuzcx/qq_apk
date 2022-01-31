package com.tencent.token;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.Locale;

public final class c
  extends i
{
  private Context a = null;
  
  public c(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private Object a(Class paramClass, String paramString)
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
  
  public final String a()
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
  
  public final String b()
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
  
  public final String c()
  {
    Object localObject = a(Build.class, "CPU_ABI");
    if (localObject == null) {
      return "";
    }
    return (String)localObject;
  }
  
  public final String d()
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
  
  public final String e()
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
  
  public final int f()
  {
    Object localObject = a(Build.VERSION.class, "SDK_INT");
    if (localObject == null) {
      return 0;
    }
    return ((Integer)localObject).intValue();
  }
  
  public final String g()
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
  
  public final String h()
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
  
  public final String i()
  {
    Object localObject = a(Build.class, "HARDWARE");
    if (localObject == null) {
      return "";
    }
    return (String)localObject;
  }
  
  public final String j()
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
  
  public final String k()
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
  
  public final String l()
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
  
  public final String m()
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
  
  public final String n()
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
  
  public final String o()
  {
    Object localObject = a(Build.class, "MANUFACTURER");
    if (localObject == null) {
      return "";
    }
    return (String)localObject;
  }
  
  public final String p()
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
  
  public final String q()
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
  
  public final String r()
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
 * Qualified Name:     com.tencent.token.c
 * JD-Core Version:    0.7.0.1
 */