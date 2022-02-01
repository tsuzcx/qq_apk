package com.tencent.token;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.atomic.AtomicReference;

public abstract class aed
  implements adx
{
  public aeb a;
  
  private static int a(Context paramContext, AtomicReference<IBinder> paramAtomicReference, final AtomicReference<ServiceConnection> paramAtomicReference1)
  {
    final Object localObject = new Object();
    Intent localIntent = new Intent(afg.a(afg.k));
    localIntent.setComponent(new ComponentName(afg.a(afg.g), afg.a(afg.h)));
    if (!paramContext.bindService(localIntent, new a(paramAtomicReference, paramAtomicReference1, localObject), 1)) {
      return -100;
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
        break label99;
      }
    }
    catch (Throwable paramContext)
    {
      label94:
      break label94;
    }
    break label103;
    label99:
    throw paramContext;
    label103:
    if (paramAtomicReference.get() == null) {
      return -105;
    }
    return 0;
  }
  
  private int a(final Context paramContext, final AtomicReference<IBinder> paramAtomicReference, final AtomicReference<ServiceConnection> paramAtomicReference1, final AtomicReference<String> paramAtomicReference2)
  {
    final Object localObject = new Object();
    final AtomicReference localAtomicReference = new AtomicReference(Integer.valueOf(0));
    new b(paramAtomicReference, localAtomicReference, paramAtomicReference2, paramContext, paramAtomicReference1, localObject).start();
    try
    {
      try
      {
        localObject.wait(1000L);
      }
      finally
      {
        break label75;
      }
    }
    catch (Throwable paramContext)
    {
      label60:
      break label60;
    }
    return ((Integer)localAtomicReference.get()).intValue();
    label75:
    throw paramContext;
  }
  
  private aeb c(Context paramContext)
  {
    AtomicReference localAtomicReference1 = new AtomicReference();
    localAtomicReference1.set("");
    try
    {
      localAtomicReference2 = new AtomicReference();
      localAtomicReference3 = new AtomicReference();
      j = a(paramContext, localAtomicReference2, localAtomicReference3);
      i = j;
      if (j != 0) {}
    }
    catch (Throwable paramContext)
    {
      AtomicReference localAtomicReference2;
      AtomicReference localAtomicReference3;
      label64:
      label66:
      break label64;
    }
    try
    {
      i = a(paramContext, localAtomicReference2, localAtomicReference3, localAtomicReference1);
    }
    catch (Throwable paramContext)
    {
      i = j;
      break label66;
    }
    i = -1;
    return new aeb((String)localAtomicReference1.get(), i);
  }
  
  public final aeb a(Context paramContext)
  {
    aeb localaeb = this.a;
    if ((localaeb == null) || (localaeb.b != 0)) {
      this.a = c(paramContext);
    }
    return this.a;
  }
  
  public abstract String a(IBinder paramIBinder);
  
  public final void b(Context paramContext)
  {
    this.a = c(paramContext);
  }
  
  public final class a
    implements ServiceConnection
  {
    public a(AtomicReference paramAtomicReference, Object paramObject) {}
    
    public final void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
    {
      aed.this.set(paramIBinder);
      paramAtomicReference1.set(this);
      try
      {
        synchronized (localObject)
        {
          localObject.notifyAll();
        }
      }
      catch (Throwable paramIBinder)
      {
        label37:
        break label37;
      }
      return;
      throw paramIBinder;
    }
    
    public final void onServiceDisconnected(ComponentName paramComponentName) {}
  }
  
  public final class b
    extends Thread
  {
    public b(AtomicReference paramAtomicReference1, AtomicReference paramAtomicReference2, AtomicReference paramAtomicReference3, Context paramContext, AtomicReference paramAtomicReference4, Object paramObject) {}
    
    public final void run()
    {
      ??? = "";
      try
      {
        String str = aed.this.a((IBinder)paramAtomicReference.get());
        ??? = str;
      }
      catch (Throwable localThrowable2)
      {
        label26:
        break label26;
      }
      localAtomicReference.set(Integer.valueOf(-102));
      paramAtomicReference2.set(???);
      try
      {
        paramContext.unbindService((ServiceConnection)paramAtomicReference1.get());
      }
      catch (Throwable localThrowable1)
      {
        label66:
        label99:
        break label66;
      }
      localAtomicReference.set(Integer.valueOf(-103));
      try
      {
        synchronized (localObject)
        {
          localObject.notifyAll();
        }
      }
      catch (Throwable localThrowable3)
      {
        break label99;
      }
      return;
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aed
 * JD-Core Version:    0.7.0.1
 */