package com.tencent.qmsp.sdk.g.c;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;

public class c
{
  private static String e = "LXOP";
  private Context a = null;
  public a b;
  private ServiceConnection c;
  public b d = null;
  
  public c(Context paramContext, b paramb)
  {
    if (paramContext != null)
    {
      this.a = paramContext;
      this.d = paramb;
      this.c = new c.a(this);
      paramContext = new Intent();
      paramContext.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
      if (this.a.bindService(paramContext, this.c, 1))
      {
        b("bindService Successful!");
        return;
      }
      paramContext = this.d;
      if (paramContext != null) {
        paramContext.a(this);
      }
      b("bindService Failed!!!");
      return;
    }
    throw new NullPointerException("Context can not be null.");
  }
  
  private void a(String paramString)
  {
    com.tencent.qmsp.sdk.base.c.b(e + " " + paramString);
  }
  
  private void b(String paramString)
  {
    com.tencent.qmsp.sdk.base.c.a(e + " " + paramString);
  }
  
  public String a()
  {
    if (this.a != null)
    {
      try
      {
        if (this.b != null)
        {
          String str = this.b.g();
          return str;
        }
      }
      catch (Exception localException)
      {
        a("getOAID error, RemoteException!");
        localException.printStackTrace();
      }
      return null;
    }
    a("Context is null.");
    throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
  }
  
  public boolean b()
  {
    try
    {
      a locala = this.b;
      if (locala == null) {
        return false;
      }
      b("Device support opendeviceid");
      boolean bool = this.b.c();
      return bool;
    }
    catch (Exception localException)
    {
      a("isSupport error, RemoteException!");
    }
    return false;
  }
  
  public String c()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = ((Context)localObject).getPackageName();
      b("liufeng, getAAID package：" + (String)localObject);
      if ((localObject == null) || (((String)localObject).equals(""))) {
        b("input package is null!");
      }
      for (;;)
      {
        return null;
        try
        {
          if (this.b != null)
          {
            localObject = this.b.b((String)localObject);
            return localObject;
          }
        }
        catch (Exception localException)
        {
          a("getAAID error, RemoteException!");
        }
      }
    }
    b("Context is null.");
    throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
  }
  
  public void d()
  {
    try
    {
      this.a.unbindService(this.c);
      b("unBind Service successful");
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        a("unBind Service exception");
      }
    }
    this.b = null;
  }
  
  public static abstract interface b
  {
    public abstract void a(c paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.g.c.c
 * JD-Core Version:    0.7.0.1
 */