package com.tencent.turingfd.sdk.base;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class e
{
  public static final cx<e> a = new a();
  public d b;
  public final AtomicBoolean c = new AtomicBoolean(false);
  
  public static e a()
  {
    return (e)a.b();
  }
  
  public break a(int paramInt1, int paramInt2, int paramInt3, break parambreak1, break parambreak2, long paramLong)
  {
    final Object localObject;
    final AtomicReference localAtomicReference;
    final AtomicBoolean localAtomicBoolean;
    label134:
    label158:
    try
    {
      if (this.c.get())
      {
        localObject = new Object();
        localAtomicReference = new AtomicReference();
        localAtomicBoolean = new AtomicBoolean(false);
        localAtomicReference.set(parambreak2);
        b localb = new b(localAtomicBoolean, localAtomicReference, localObject);
        d locald = this.b;
        o.b localb1 = new o.b(paramInt1, paramInt2, paramInt3);
        localb1.d = parambreak1;
        localb1.f = parambreak2;
        localb1.a = localb;
        Message.obtain(locald, 2, localb1.a()).sendToTarget();
      }
    }
    finally {}
    try
    {
      try
      {
        localObject.wait(paramLong);
      }
      finally
      {
        break label158;
      }
    }
    catch (InterruptedException parambreak1)
    {
      break label134;
    }
    localAtomicBoolean.set(true);
    parambreak1 = (break)localAtomicReference.get();
    return parambreak1;
    throw parambreak1;
    throw new RuntimeException("Must call after initialized");
  }
  
  public void a(ck paramck)
  {
    if (paramck == null) {
      return;
    }
    try
    {
      boolean bool = this.c.compareAndSet(false, true);
      if (!bool) {
        return;
      }
      HandlerThread localHandlerThread = new HandlerThread("TuringFdShark");
      localHandlerThread.start();
      this.b = new d(localHandlerThread.getLooper(), paramck);
      Message.obtain(this.b, 1).sendToTarget();
      return;
    }
    finally {}
  }
  
  public byte[] a(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte, long paramLong)
  {
    final Object localObject;
    final AtomicReference localAtomicReference;
    final AtomicBoolean localAtomicBoolean;
    label128:
    label152:
    try
    {
      if (this.c.get())
      {
        localObject = new Object();
        localAtomicReference = new AtomicReference();
        localAtomicBoolean = new AtomicBoolean(false);
        localAtomicReference.set(new byte[0]);
        c localc = new c(localAtomicBoolean, localAtomicReference, localObject);
        d locald = this.b;
        o.b localb = new o.b(paramInt1, paramInt2, paramInt3);
        localb.e = paramArrayOfByte;
        localb.a = localc;
        Message.obtain(locald, 2, localb.a()).sendToTarget();
      }
    }
    finally {}
    try
    {
      try
      {
        localObject.wait(paramLong);
      }
      finally
      {
        break label152;
      }
    }
    catch (InterruptedException paramArrayOfByte)
    {
      break label128;
    }
    localAtomicBoolean.set(true);
    paramArrayOfByte = (byte[])localAtomicReference.get();
    return paramArrayOfByte;
    throw paramArrayOfByte;
    throw new RuntimeException("Must call after initialized");
  }
  
  public static final class a
    extends cx<e>
  {
    public Object a()
    {
      return new e(null);
    }
  }
  
  public class b
    implements o.c
  {
    public b(AtomicBoolean paramAtomicBoolean, AtomicReference paramAtomicReference, Object paramObject) {}
    
    public void a(int paramInt, break arg2)
    {
      if (localAtomicBoolean.get()) {
        return;
      }
      if ((paramInt == 0) && (??? != null)) {
        localAtomicReference.set(???);
      }
      synchronized (localObject)
      {
        localObject.notify();
        return;
      }
    }
    
    public void a(int paramInt, byte[] paramArrayOfByte) {}
  }
  
  public class c
    implements o.c
  {
    public c(AtomicBoolean paramAtomicBoolean, AtomicReference paramAtomicReference, Object paramObject) {}
    
    public void a(int paramInt, break parambreak) {}
    
    public void a(int paramInt, byte[] arg2)
    {
      if (localAtomicBoolean.get()) {
        return;
      }
      if ((paramInt == 0) && (??? != null)) {
        localAtomicReference.set(???);
      }
      synchronized (localObject)
      {
        localObject.notify();
        return;
      }
    }
  }
  
  private static class d
    extends Handler
  {
    public int a = 1;
    public do b = new do();
    public d c;
    public ck d;
    
    public d(Looper paramLooper, ck paramck)
    {
      super();
      this.b.B = 49;
      this.c = new d();
      this.d = paramck;
    }
    
    public final String a(Context paramContext)
    {
      System.currentTimeMillis();
      paramContext = b.a(paramContext);
      paramContext = cm.a(a(cm.a(), paramContext), paramContext.g, false);
      if ((paramContext instanceof try)) {
        return ((try)paramContext).u;
      }
      return "";
    }
    
    public final boolean a()
    {
      System.currentTimeMillis();
      Object localObject = this.c.a();
      localObject = cm.a(a(cm.a(), (o)localObject), ((o)localObject).g, false);
      if ((localObject instanceof synchronized))
      {
        localObject = (synchronized)localObject;
        this.c.a((synchronized)localObject);
        return true;
      }
      return false;
    }
    
    public final byte[] a(Context paramContext, o paramo)
    {
      int i = paramo.a;
      Object localObject1 = paramo.f;
      if (localObject1 == null) {
        localObject1 = cm.a(paramo.e);
      }
      Object localObject2 = this.c;
      if (TextUtils.isEmpty(((d)localObject2).a)) {
        localObject2 = ((d)localObject2).e;
      } else {
        localObject2 = ((d)localObject2).b;
      }
      localObject2 = e.a(i, (byte[])localObject1, (String)localObject2);
      do localdo = this.b;
      if (paramo.a == 152) {
        localObject1 = "";
      } else {
        localObject1 = this.c.a;
      }
      localdo.A = ((String)localObject1);
      this.b.u = b.b(paramContext);
      paramContext = cm.a(e.a(this.a, (int)localObject2, this.b));
      localObject1 = this.d;
      if (localObject1 == null) {
        paramContext = new byte[0];
      }
      try
      {
        i = paramo.c;
        int j = paramo.a;
        int k = paramo.b;
        localObject1 = (cr)localObject1;
        paramContext = ((cr)localObject1).a(i, paramContext, j, k).a;
      }
      catch (Throwable paramContext)
      {
        label199:
        break label199;
      }
      paramContext = new byte[0];
      paramContext = cm.a(paramContext, new char(), false);
      if (paramContext == null) {
        paramContext = null;
      } else {
        paramContext = (char)paramContext;
      }
      if (paramContext == null) {
        return null;
      }
      i = this.a;
      this.a = (i + 1);
      if (i >= 2147483647) {
        this.a = 1;
      }
      paramo = e.a(paramo.b, paramContext);
      if (paramo == null) {
        return null;
      }
      if (paramo.cb == 2)
      {
        this.c.c = 0L;
        return null;
      }
      paramContext = this.c;
      if (TextUtils.isEmpty(paramContext.a)) {
        paramContext = paramContext.e;
      } else {
        paramContext = paramContext.b;
      }
      return e.a(paramo, paramContext);
    }
    
    public void handleMessage(Message paramMessage)
    {
      int i = paramMessage.what;
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
        paramMessage = (o)paramMessage.obj;
        Object localObject1 = paramMessage.d;
        if ((this.c.b()) && (!a()))
        {
          ((o.c)localObject1).a(-1, null);
          return;
        }
        Object localObject2 = cm.a();
        if (TextUtils.isEmpty(b.b((Context)localObject2)))
        {
          b.a((Context)localObject2, a((Context)localObject2));
          if (TextUtils.isEmpty(b.b((Context)localObject2)))
          {
            ((o.c)localObject1).a(-2, null);
            return;
          }
        }
        localObject1 = a((Context)localObject2, paramMessage);
        localObject2 = paramMessage.g;
        if (localObject2 != null)
        {
          localObject1 = cm.a((byte[])localObject1, (break)localObject2, false);
          if (localObject1 == null)
          {
            paramMessage.d.a(-3, null);
            return;
          }
          paramMessage.d.a(0, (break)localObject1);
          return;
        }
        if (localObject1 == null)
        {
          paramMessage.d.a(-3, null);
          return;
        }
        paramMessage.d.a(0, (byte[])localObject1);
        return;
      }
      System.currentTimeMillis();
      if (!a()) {
        return;
      }
      paramMessage = cm.a();
      if (TextUtils.isEmpty(b.b(paramMessage))) {
        b.a(paramMessage, a(paramMessage));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.e
 * JD-Core Version:    0.7.0.1
 */