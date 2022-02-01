package com.tencent.token;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import com.tencent.token.ui.IndexActivity;
import java.io.File;

public final class xr
{
  public static String a = "official";
  private static int b = 0;
  private static String c = "https://w.aq.qq.com";
  private static int d = 1;
  private static boolean e = true;
  private static Context f = null;
  private static String g = null;
  private static int h = 0;
  
  static
  {
    if (aaw.c == 0)
    {
      c = "http://test.aq.qq.com";
      d = 0;
      a = "dev";
    }
    else if (aaw.c == 1)
    {
      c = "https://w.aq.qq.com";
      d = 1;
    }
    else if (aaw.c == 2)
    {
      c = "http://exp.aq.qq.com";
      d = 2;
      a = "rdm";
    }
    else if (aaw.c == 3)
    {
      c = "http://gray.aq.qq.com";
      d = 3;
      a = "rdm";
    }
  }
  
  public static int a()
  {
    return d;
  }
  
  public static void a(int paramInt)
  {
    d = paramInt;
    if (paramInt == 0)
    {
      c = "http://test.aq.qq.com";
      sv.a("http://test.aq.qq.com");
      return;
    }
    paramInt = d;
    if (paramInt == 1)
    {
      c = "https://w.aq.qq.com";
      sv.a("https://aq.qq.com");
      return;
    }
    if (paramInt == 2)
    {
      c = "http://exp.aq.qq.com";
      sv.a("https://aq.qq.com");
      return;
    }
    if (paramInt == 3)
    {
      c = "http://gray.aq.qq.com";
      sv.a("https://aq.qq.com");
    }
  }
  
  public static void a(Context paramContext)
  {
    if (f == null) {
      f = paramContext;
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    e = paramBoolean;
  }
  
  public static short b()
  {
    return 4;
  }
  
  public static short c()
  {
    return 2;
  }
  
  public static short d()
  {
    return (short)k();
  }
  
  public static String e()
  {
    return c;
  }
  
  public static boolean f()
  {
    return e;
  }
  
  public static Context g()
  {
    boolean bool;
    if (f != null) {
      bool = true;
    } else {
      bool = false;
    }
    xv.a(bool);
    return f;
  }
  
  @SuppressLint({"MissingPermission"})
  public static String h()
  {
    return "00000000000018";
  }
  
  public static boolean i()
  {
    return IndexActivity.S_RES_HEIGHT <= 480;
  }
  
  public static boolean j()
  {
    if (h == 0) {
      h = Build.VERSION.SDK_INT;
    }
    int i;
    if (h <= 10) {
      i = 1;
    } else {
      i = 0;
    }
    return (i != 0) && (i());
  }
  
  private static int k()
  {
    Context localContext = g();
    int i = aaw.a;
    try
    {
      int j = localContext.getPackageManager().getPackageInfo(localContext.getPackageName(), 16384).versionCode;
      i = j;
    }
    catch (Exception localException)
    {
      xv.c(localException.getMessage());
    }
    xv.b("versionCode : ".concat(String.valueOf(i)));
    return i;
  }
  
  public static abstract interface a
  {
    public static final boolean a = aaw.e;
    public static final boolean b = aaw.f;
    public static final boolean c = aaw.g;
    public static final boolean d = aaw.i;
    public static final boolean e = aaw.j;
    public static final boolean f = aaw.k;
    public static final String g;
    public static final int h = aaw.h;
    
    static
    {
      StringBuilder localStringBuilder = new StringBuilder("Tencent");
      localStringBuilder.append(File.separator);
      localStringBuilder.append("QQSec");
      localStringBuilder.append(File.separator);
      localStringBuilder.append("log");
      g = localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.xr
 * JD-Core Version:    0.7.0.1
 */