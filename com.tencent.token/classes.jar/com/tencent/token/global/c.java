package com.tencent.token.global;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.tencent.token.cx;
import com.tencent.token.ui.IndexActivity;
import com.tencent.token.utils.u;

public class c
{
  public static String a;
  private static int b = 0;
  private static String c;
  private static int d;
  private static boolean e;
  private static Context f;
  private static String g;
  private static int h;
  
  static
  {
    a = "official";
    c = "https://w.aq.qq.com";
    d = 1;
    if (u.c == 0)
    {
      c = "http://test.aq.qq.com";
      d = 0;
      a = "dev";
    }
    for (;;)
    {
      e = true;
      f = null;
      g = null;
      h = 0;
      return;
      if (u.c == 1)
      {
        c = "https://w.aq.qq.com";
        d = 1;
      }
      else if (u.c == 2)
      {
        c = "http://exp.aq.qq.com";
        d = 2;
        a = "rdm";
      }
      else if (u.c == 3)
      {
        c = "http://gray.aq.qq.com";
        d = 3;
        a = "rdm";
      }
    }
  }
  
  public static int a()
  {
    return d;
  }
  
  public static void a(int paramInt)
  {
    d = paramInt;
    if (d == 0)
    {
      a("http://test.aq.qq.com");
      cx.a("http://test.aq.qq.com");
    }
    do
    {
      return;
      if (d == 1)
      {
        a("https://w.aq.qq.com");
        cx.a("https://aq.qq.com");
        return;
      }
      if (d == 2)
      {
        a("http://exp.aq.qq.com");
        cx.a("https://aq.qq.com");
        return;
      }
    } while (d != 3);
    a("http://gray.aq.qq.com");
    cx.a("https://aq.qq.com");
  }
  
  public static void a(Context paramContext)
  {
    if (f == null) {
      f = paramContext;
    }
  }
  
  public static void a(String paramString)
  {
    c = paramString;
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
    return (short)m();
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
    if (f != null) {}
    for (boolean bool = true;; bool = false)
    {
      h.a(bool);
      return f;
    }
  }
  
  public static String h()
  {
    try
    {
      String str1 = ((TelephonyManager)f.getSystemService("phone")).getDeviceId();
      String str2 = str1;
      if (str1 == null) {
        str2 = "";
      }
      return str2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject = null;
      }
    }
  }
  
  public static boolean i()
  {
    return IndexActivity.S_RES_HEIGHT <= 480;
  }
  
  public static int j()
  {
    if (h == 0) {
      h = Build.VERSION.SDK_INT;
    }
    return h;
  }
  
  public static boolean k()
  {
    return j() <= 10;
  }
  
  public static boolean l()
  {
    return (k()) && (i());
  }
  
  private static int m()
  {
    Context localContext = g();
    int i = u.a;
    try
    {
      int j = localContext.getPackageManager().getPackageInfo(localContext.getPackageName(), 16384).versionCode;
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        h.c(localException.getMessage());
      }
    }
    h.b("versionCode : " + i);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.global.c
 * JD-Core Version:    0.7.0.1
 */