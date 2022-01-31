package com.tencent.token.global;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.tencent.token.ag;
import com.tencent.token.ui.IndexActivity;
import com.tencent.token.utils.q;

public final class b
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
    c = "http://w.aq.qq.com";
    d = 1;
    if (q.c == 0)
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
      if (q.c == 1)
      {
        c = "http://w.aq.qq.com";
        d = 1;
      }
      else if (q.c == 2)
      {
        c = "http://exp.aq.qq.com";
        d = 2;
        a = "rdm";
      }
      else if (q.c == 3)
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
    if (paramInt == 0)
    {
      c = "http://test.aq.qq.com";
      ag.a("http://test.aq.qq.com");
    }
    do
    {
      return;
      if (d == 1)
      {
        c = "http://w.aq.qq.com";
        ag.a("http://aq.qq.com");
        return;
      }
      if (d == 2)
      {
        c = "http://exp.aq.qq.com";
        ag.a("http://aq.qq.com");
        return;
      }
    } while (d != 3);
    c = "http://gray.aq.qq.com";
    ag.a("http://aq.qq.com");
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
    return (short)j();
  }
  
  public static String c()
  {
    return c;
  }
  
  public static boolean d()
  {
    return e;
  }
  
  public static Context e()
  {
    if (f != null) {}
    for (boolean bool = true;; bool = false)
    {
      e.a(bool);
      return f;
    }
  }
  
  public static String f()
  {
    return g;
  }
  
  public static String g()
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
  
  public static boolean h()
  {
    return IndexActivity.S_RES_HEIGHT <= 480;
  }
  
  public static boolean i()
  {
    if (h == 0) {
      h = Build.VERSION.SDK_INT;
    }
    if (h <= 10)
    {
      i = 1;
      if (i == 0) {
        break label53;
      }
      if (IndexActivity.S_RES_HEIGHT > 480) {
        break label48;
      }
    }
    label48:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label53;
      }
      return true;
      i = 0;
      break;
    }
    label53:
    return false;
  }
  
  private static int j()
  {
    if (f != null) {}
    for (boolean bool = true;; bool = false)
    {
      e.a(bool);
      Context localContext = f;
      int i = q.a;
      try
      {
        int j = localContext.getPackageManager().getPackageInfo(localContext.getPackageName(), 16384).versionCode;
        i = j;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          e.c(localException.getMessage());
        }
      }
      e.b("versionCode : " + i);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.global.b
 * JD-Core Version:    0.7.0.1
 */