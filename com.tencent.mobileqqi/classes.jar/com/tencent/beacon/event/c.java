package com.tencent.beacon.event;

import android.content.Context;
import com.tencent.beacon.a.d;
import com.tencent.beacon.a.e;

public final class c
{
  private static c a = null;
  private String b = "";
  private String c = "";
  private String d = "";
  private String e = "";
  private String f = "";
  
  private c(Context paramContext)
  {
    if (paramContext == null) {
      com.tencent.beacon.d.a.d(" DetailUserInfo context == null? pls check!}", new Object[0]);
    }
    com.tencent.beacon.d.a.b(" start to create DetailUserInfo}", new Object[0]);
    long l = System.currentTimeMillis();
    e.a(paramContext);
    this.b = e.b(paramContext);
    com.tencent.beacon.d.a.b(" imei:}" + this.b, new Object[0]);
    this.c = e.e(paramContext);
    this.d = e.c(paramContext);
    this.e = e.d(paramContext);
    String str = d.m().k();
    if ((str != null) && (!"".equals(str))) {
      this.f = str;
    }
    for (;;)
    {
      com.tencent.beacon.d.a.b(" detail create cost} %d  values:\n} %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), toString() });
      return;
      this.f = com.tencent.beacon.a.a.b(paramContext);
      d.m().b(this.f);
    }
  }
  
  public static c a(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new c(paramContext);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.beacon.event.c
 * JD-Core Version:    0.7.0.1
 */