package com.tencent.qmsp.sdk.g.b;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.tencent.qmsp.sdk.base.c;
import java.util.concurrent.LinkedBlockingQueue;

public class a
{
  public static a a(Context paramContext)
  {
    Log.i(a(), "getAdvertisingIdInfo " + System.currentTimeMillis());
    if (Looper.myLooper() != Looper.getMainLooper()) {
      try
      {
        Object localObject1 = paramContext.getPackageManager();
        ((PackageManager)localObject1).getPackageInfo("com.huawei.hwid", 0);
        b localb = new b();
        localObject1 = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        ((Intent)localObject1).setPackage("com.huawei.hwid");
        if (paramContext.bindService((Intent)localObject1, localb, 1))
        {
          Log.i(a(), "bind ok");
          try
          {
            if (localb.a) {
              break label149;
            }
            localb.a = true;
            localObject1 = d.a.a((IBinder)localb.b.take());
            localObject1 = new a(((d)localObject1).i(), ((d)localObject1).f());
            paramContext.unbindService(localb);
            paramContext = (Context)localObject1;
          }
          catch (RemoteException localRemoteException)
          {
            for (;;)
            {
              String str1 = "bind hms service RemoteException";
              c.b(str1);
              paramContext.unbindService(localb);
              paramContext = null;
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;)
            {
              label149:
              String str2 = "bind hms service InterruptedException";
            }
          }
          finally
          {
            paramContext.unbindService(localb);
          }
          return paramContext;
          throw new IllegalStateException();
        }
        c.b("bind failed");
        return null;
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        c.b("HMS not found");
        return null;
      }
    }
    c.b("Cannot be called from the main thread");
    throw new IllegalStateException("Cannot be called from the main thread");
  }
  
  private static String a()
  {
    return "AdId";
  }
  
  public static final class a
  {
    private final String a;
    private final boolean b;
    
    a(String paramString, boolean paramBoolean)
    {
      this.a = paramString;
      this.b = paramBoolean;
    }
    
    public final String a()
    {
      return this.a;
    }
    
    public final boolean b()
    {
      return this.b;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.g.b.a
 * JD-Core Version:    0.7.0.1
 */