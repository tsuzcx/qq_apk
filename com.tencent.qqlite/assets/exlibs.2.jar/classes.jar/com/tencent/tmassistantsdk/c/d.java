package com.tencent.tmassistantsdk.c;

import com.tencent.tmassistantsdk.downloadservice.NetworkMonitorReceiver;
import com.tencent.tmassistantsdk.downloadservice.l;

public final class d
{
  private static d a = null;
  private static final Class[] b = { a.class, f.class, g.class };
  private final l c = new e(this);
  
  private d()
  {
    NetworkMonitorReceiver.a().a(this.c);
  }
  
  public static d a()
  {
    try
    {
      if (a == null) {
        a = new d();
      }
      d locald = a;
      return locald;
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
            a.a().f();
          } else if (localClass.equals(f.class)) {
            f.a().f();
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        if (localException.equals(g.class)) {
          g.a().f();
        }
      }
      else
      {
        return;
      }
      i += 1;
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
            a.a().e();
          } else if (localClass.equals(f.class)) {
            f.a().e();
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
      else
      {
        return;
      }
      i += 1;
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
            a.a().d();
          } else if (localClass.equals(f.class)) {
            f.a().d();
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
      else
      {
        NetworkMonitorReceiver.a().b(this.c);
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.c.d
 * JD-Core Version:    0.7.0.1
 */