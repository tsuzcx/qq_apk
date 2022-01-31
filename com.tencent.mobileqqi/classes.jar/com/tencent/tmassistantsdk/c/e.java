package com.tencent.tmassistantsdk.c;

import com.tencent.tmassistantsdk.downloadservice.NetworkMonitorReceiver;
import com.tencent.tmassistantsdk.downloadservice.c;
import com.tencent.tmassistantsdk.downloadservice.m;
import com.tencent.tmassistantsdk.f.j;

public final class e
  implements m
{
  private static e a = null;
  private static Class[] b = { a.class };
  
  protected e()
  {
    NetworkMonitorReceiver.a().a(this);
  }
  
  public static e a()
  {
    try
    {
      if (a == null) {
        a = new e();
      }
      e locale = a;
      return locale;
    }
    finally {}
  }
  
  public static void c()
  {
    Class[] arrayOfClass = b;
    int j = arrayOfClass.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        Class localClass = arrayOfClass[i];
        try
        {
          if (localClass.equals(a.class)) {
            a.a().e();
          }
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
    }
  }
  
  public static void d()
  {
    Class[] arrayOfClass = b;
    int j = arrayOfClass.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        Class localClass = arrayOfClass[i];
        try
        {
          if (localClass.equals(a.class)) {
            a.a().d();
          }
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
    }
  }
  
  public final void b()
  {
    Class[] arrayOfClass = b;
    int j = arrayOfClass.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        Class localClass = arrayOfClass[i];
        try
        {
          if (localClass.equals(a.class)) {
            a.a().c();
          }
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
    }
    NetworkMonitorReceiver.a().b(this);
  }
  
  public final void e()
  {
    j.b("LogReportManager", "onNetworkChanged,netState:" + c.b());
    Class[] arrayOfClass = b;
    int j = arrayOfClass.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        Class localClass = arrayOfClass[i];
        try
        {
          if (localClass.equals(a.class)) {
            a.a().f();
          }
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
    }
    if ((c.c()) && (c.b().equalsIgnoreCase("wifi"))) {
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.tmassistantsdk.c.e
 * JD-Core Version:    0.7.0.1
 */