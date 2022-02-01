package com.tencent.qmsp.sdk.g.h;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.tencent.qmsp.sdk.base.c;

public class b
{
  private static String e = "SDI";
  public static String f = "SI";
  public b a = null;
  private ServiceConnection b;
  private Context c = null;
  public a d;
  
  public b(Context paramContext, b paramb)
  {
    if (paramContext != null)
    {
      this.c = paramContext;
      this.a = paramb;
      this.b = new b.a(this);
      return;
    }
    throw new NullPointerException("Context can not be null.");
  }
  
  public String a()
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      localObject = ((Context)localObject).getPackageName();
      c.a(f + "apackage：" + (String)localObject);
      if ((localObject == null) || (((String)localObject).equals(""))) {
        c.c(f + " input package is null!");
      }
      for (;;)
      {
        return null;
        try
        {
          if (this.d != null)
          {
            String str = this.d.a((String)localObject);
            StringBuilder localStringBuilder = new StringBuilder().append(f);
            c.a(" getAAID Package: " + (String)localObject);
            return str;
          }
        }
        catch (Exception localException)
        {
          c.c(f + " geta error, RemoteException!");
        }
      }
    }
    c.c(f + " Context is null.");
    throw new IllegalArgumentException("Context is null, must be new SxCore first");
  }
  
  public String b()
  {
    if (this.c != null)
    {
      try
      {
        if (this.d != null)
        {
          String str = this.d.a();
          StringBuilder localStringBuilder = new StringBuilder().append(e);
          c.c(" geto call");
          return str;
        }
      }
      catch (Exception localException)
      {
        c.c(f + " geto error, RemoteException!");
        localException.printStackTrace();
      }
      return null;
    }
    c.c(f + " Context is null.");
    throw new IllegalArgumentException("Context is null, must be new SxCore first");
  }
  
  public void c()
  {
    Intent localIntent = new Intent();
    localIntent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
    if (this.c.bindService(localIntent, this.b, 1))
    {
      c.c(f + " bindService Successful!");
      return;
    }
    this.a.a(this);
    c.c(f + " bindService Failed!");
  }
  
  public boolean d()
  {
    try
    {
      if (this.d == null)
      {
        localStringBuilder = new StringBuilder().append(f);
        c.c(" Device not support opendeviceid");
        return false;
      }
      StringBuilder localStringBuilder = new StringBuilder().append(f);
      c.c(" Device support opendeviceid");
      return true;
    }
    catch (Exception localException)
    {
      c.c(f + " isSupport error, RemoteException!");
    }
    return false;
  }
  
  public void e()
  {
    try
    {
      this.c.unbindService(this.b);
      StringBuilder localStringBuilder = new StringBuilder().append(f);
      c.c(" unBind Service successful");
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        c.c(f + " unBind Service exception");
      }
    }
    this.d = null;
  }
  
  public static abstract interface b
  {
    public abstract void a(b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.g.h.b
 * JD-Core Version:    0.7.0.1
 */