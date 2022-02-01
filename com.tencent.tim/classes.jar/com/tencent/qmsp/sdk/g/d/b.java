package com.tencent.qmsp.sdk.g.d;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.AsyncTask;
import android.os.IBinder;

public class b
{
  private static String e = "com.mdid.msa";
  private c a;
  private ServiceConnection b;
  private Context c;
  private a d;
  
  public b(Context paramContext, c paramc)
  {
    if (paramContext != null)
    {
      this.c = paramContext;
      this.a = paramc;
      this.b = new a(this, paramc);
      return;
    }
    throw new NullPointerException("Context can not be null.");
  }
  
  public static void a(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setClassName(e, "com.mdid.msa.service.MsaKlService");
    localIntent.setAction("com.bun.msa.action.start.service");
    localIntent.putExtra("com.bun.msa.param.pkgname", paramString);
    try
    {
      localIntent.putExtra("com.bun.msa.param.runinset", true);
      paramContext = paramContext.startService(localIntent);
      if (paramContext != null) {}
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static boolean a(Context paramContext)
  {
    try
    {
      paramContext.getPackageManager().getPackageInfo(e, 0);
      return true;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return false;
  }
  
  public String a()
  {
    try
    {
      Object localObject = this.d;
      if (localObject == null) {
        return "";
      }
      localObject = this.d.b();
      return localObject;
    }
    catch (Exception localException) {}
    return "";
  }
  
  public void a(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
    localIntent.setAction("com.bun.msa.action.bindto.service");
    localIntent.putExtra("com.bun.msa.param.pkgname", paramString);
    if (this.c.bindService(localIntent, this.b, 1)) {}
    do
    {
      return;
      paramString = this.a;
    } while (paramString == null);
    paramString.g();
  }
  
  public String b()
  {
    try
    {
      Object localObject = this.d;
      if (localObject == null) {
        return "";
      }
      localObject = this.d.a();
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }
  
  public boolean c()
  {
    try
    {
      if (this.d == null) {
        return false;
      }
      boolean bool = this.d.d();
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public void d()
  {
    a locala = this.d;
    if (locala != null) {}
    try
    {
      locala.e();
      if (this.b != null) {
        this.c.unbindService(this.b);
      }
      label33:
      this.b = null;
      this.d = null;
      return;
    }
    catch (Exception localException)
    {
      break label33;
    }
  }
  
  class a
    implements ServiceConnection
  {
    c a;
    
    a(b paramb, c paramc)
    {
      this.a = paramc;
    }
    
    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      try
      {
        b.a(b.this, a.a.a(paramIBinder));
        new d(b.a(b.this), this.a).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        return;
      }
      finally {}
    }
    
    public void onServiceDisconnected(ComponentName paramComponentName)
    {
      b.a(b.this, null);
      b.a(b.this, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.g.d.b
 * JD-Core Version:    0.7.0.1
 */