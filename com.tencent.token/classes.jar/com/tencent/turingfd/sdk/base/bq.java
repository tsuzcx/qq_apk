package com.tencent.turingfd.sdk.base;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.atomic.AtomicReference;

public abstract class bq
  implements bk
{
  public bo a;
  
  public final int a(Context paramContext, final AtomicReference<IBinder> paramAtomicReference, final AtomicReference<ServiceConnection> paramAtomicReference1)
  {
    final Object localObject1 = new Object();
    Object localObject2 = (bs)this;
    localObject2 = new Intent(ct.a(ct.k));
    ((Intent)localObject2).setComponent(new ComponentName(ct.a(ct.g), ct.a(ct.h)));
    if (!paramContext.bindService((Intent)localObject2, new a(paramAtomicReference, paramAtomicReference1, localObject1), 1)) {
      return -100;
    }
    if (paramAtomicReference.get() == null) {}
    try
    {
      try
      {
        localObject1.wait(1000L);
      }
      finally
      {
        break label111;
      }
    }
    catch (Throwable paramContext)
    {
      label105:
      break label105;
    }
    break label116;
    label111:
    throw paramContext;
    label116:
    if (paramAtomicReference.get() == null) {
      return -105;
    }
    return 0;
  }
  
  public final int a(final Context paramContext, final AtomicReference<IBinder> paramAtomicReference, final AtomicReference<ServiceConnection> paramAtomicReference1, final AtomicReference<String> paramAtomicReference2)
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
  
  public bo a(Context paramContext)
  {
    bo localbo = this.a;
    if ((localbo == null) || (localbo.b != 0)) {
      this.a = c(paramContext);
    }
    return this.a;
  }
  
  public abstract String a(IBinder paramIBinder);
  
  public void b(Context paramContext)
  {
    this.a = c(paramContext);
  }
  
  public final bo c(Context paramContext)
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
      label65:
      label67:
      break label65;
    }
    try
    {
      i = a(paramContext, localAtomicReference2, localAtomicReference3, localAtomicReference1);
    }
    catch (Throwable paramContext)
    {
      i = j;
      break label67;
    }
    i = -1;
    return new bo((String)localAtomicReference1.get(), i);
  }
  
  public class a
    implements ServiceConnection
  {
    public a(AtomicReference paramAtomicReference1, AtomicReference paramAtomicReference2, Object paramObject) {}
    
    public void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
    {
      paramAtomicReference.set(paramIBinder);
      paramAtomicReference1.set(this);
      try
      {
        synchronized (localObject1)
        {
          localObject1.notifyAll();
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
    
    public void onServiceDisconnected(ComponentName paramComponentName) {}
  }
  
  public class b
    extends Thread
  {
    public b(AtomicReference paramAtomicReference1, AtomicReference paramAtomicReference2, AtomicReference paramAtomicReference3, Context paramContext, AtomicReference paramAtomicReference4, Object paramObject) {}
    
    public void run()
    {
      ??? = "";
      try
      {
        String str = bq.this.a((IBinder)paramAtomicReference.get());
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
 * Qualified Name:     com.tencent.turingfd.sdk.base.bq
 * JD-Core Version:    0.7.0.1
 */