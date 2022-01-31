package com.tencent.beacon.event;

import android.content.Context;
import com.tencent.beacon.a.e;
import com.tencent.beacon.a.g;

public final class d
{
  private static d a = null;
  private String b = "";
  private String c = "";
  private String d = "";
  private String e = "";
  private String f = "";
  
  private d(Context paramContext)
  {
    if (paramContext == null) {
      com.tencent.beacon.d.a.d(" DetailUserInfo context == null? pls check!", new Object[0]);
    }
    com.tencent.beacon.d.a.b(" start to create DetailUserInfo", new Object[0]);
    long l = System.currentTimeMillis();
    g.a(paramContext);
    e locale = e.m();
    this.b = g.b(paramContext);
    com.tencent.beacon.d.a.b(" imei:" + this.b, new Object[0]);
    if (!"".equals(this.b)) {}
    try
    {
      if ("".equals(com.tencent.beacon.a.a.b(paramContext, "IMEI_DENGTA", ""))) {
        com.tencent.beacon.a.a.a(paramContext, "IMEI_DENGTA", this.b);
      }
      label156:
      if ("".equals(locale.i())) {
        locale.b(this.b);
      }
      this.c = g.e(paramContext);
      this.d = g.c(paramContext);
      this.e = g.d(paramContext);
      String str = locale.k();
      if ((str != null) && (!"".equals(str))) {
        this.f = g.d(str);
      }
      for (;;)
      {
        com.tencent.beacon.d.a.b(" detail create cost: %d  values:\n %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), toString() });
        return;
        this.f = g.d(com.tencent.beacon.a.a.b(paramContext));
        locale.c(this.f);
      }
    }
    catch (Exception localException)
    {
      break label156;
    }
  }
  
  public static d a(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new d(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public final String a()
  {
    try
    {
      String str = this.c;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String b()
  {
    try
    {
      String str = this.d;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String c()
  {
    try
    {
      String str = this.e;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String d()
  {
    try
    {
      String str = this.f;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.beacon.event.d
 * JD-Core Version:    0.7.0.1
 */