package btmsdkobf;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicReference;

public class ev
{
  private static String pa = "";
  private static long pb = -1L;
  private static long pc = -1L;
  private static int pd = -1;
  
  private static int a(Context paramContext, AtomicReference<IBinder> paramAtomicReference, final AtomicReference<ServiceConnection> paramAtomicReference1)
  {
    long l = System.currentTimeMillis();
    final Object localObject = new Object();
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
    localIntent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
    if (!paramContext.bindService(localIntent, new ServiceConnection()
    {
      public final void onServiceConnected(ComponentName arg1, IBinder paramAnonymousIBinder)
      {
        ev.i(System.currentTimeMillis() - this.a);
        paramAtomicReference1.set(paramAnonymousIBinder);
        localObject.set(this);
        try
        {
          synchronized (this.d)
          {
            this.d.notifyAll();
          }
        }
        catch (Throwable paramAnonymousIBinder)
        {
          label49:
          break label49;
        }
        return;
        throw paramAnonymousIBinder;
      }
      
      public final void onServiceDisconnected(ComponentName paramAnonymousComponentName) {}
    }, 1)) {
      return -400;
    }
    if (paramAtomicReference.get() == null) {}
    try
    {
      try
      {
        localObject.wait(1000L);
      }
      finally
      {
        break label104;
      }
    }
    catch (Throwable paramContext)
    {
      label98:
      break label98;
    }
    break label109;
    label104:
    throw paramContext;
    label109:
    if (paramAtomicReference.get() == null) {
      return -405;
    }
    return 0;
  }
  
  public static String a(Context paramContext)
  {
    if (!o(paramContext))
    {
      pd = -407;
      return pa;
    }
    if (TextUtils.isEmpty(pa)) {
      return p(paramContext);
    }
    return pa;
  }
  
  private static int b(final Context paramContext, AtomicReference<IBinder> paramAtomicReference, final AtomicReference<ServiceConnection> paramAtomicReference1)
  {
    final Object localObject = new Object();
    final AtomicReference localAtomicReference = new AtomicReference(Integer.valueOf(0));
    long l = System.currentTimeMillis();
    new Thread()
    {
      public final void run()
      {
        label137:
        try
        {
          ??? = eu.a.c((IBinder)this.a.get());
        }
        catch (Throwable localThrowable1)
        {
          label17:
          label70:
          label103:
          break label17;
        }
        localAtomicReference.set(Integer.valueOf(-401));
        ??? = null;
        if (??? != null) {}
        try
        {
          String str = paramContext.getPackageName();
          ev.N(((eu)???).a(str, et.a(paramContext, str, "SHA1"), "OUID"));
        }
        catch (Throwable localThrowable2)
        {
          break label70;
        }
        localAtomicReference.set(Integer.valueOf(-402));
        try
        {
          paramContext.unbindService((ServiceConnection)paramAtomicReference1.get());
        }
        catch (Throwable localThrowable3)
        {
          break label103;
        }
        localAtomicReference.set(Integer.valueOf(-403));
        try
        {
          synchronized (localObject)
          {
            localObject.notifyAll();
          }
        }
        catch (Throwable localThrowable4)
        {
          break label137;
        }
        return;
        throw localObject2;
      }
    }.start();
    try
    {
      try
      {
        localObject.wait(1000L);
      }
      finally
      {
        break label84;
      }
    }
    catch (Throwable paramContext)
    {
      label61:
      break label61;
    }
    pc = System.currentTimeMillis() - l;
    return ((Integer)localAtomicReference.get()).intValue();
    label84:
    throw paramContext;
  }
  
  private static boolean o(Context paramContext)
  {
    return true;
  }
  
  private static String p(Context paramContext)
  {
    try
    {
      pd = 0;
      AtomicReference localAtomicReference1 = new AtomicReference();
      AtomicReference localAtomicReference2 = new AtomicReference();
      int i = a(paramContext, localAtomicReference1, localAtomicReference2);
      pd = i;
      if (i == 0) {
        pd = b(paramContext, localAtomicReference1, localAtomicReference2);
      }
      paramContext = pa;
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      eg.e("OPPOImpl", paramContext.getMessage());
      pd = -406;
    }
    return pa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.ev
 * JD-Core Version:    0.7.0.1
 */