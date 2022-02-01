package com.tencent.token;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.turingfd.sdk.base.break;
import com.tencent.turingfd.sdk.base.case;
import com.tencent.turingfd.sdk.base.char;
import com.tencent.turingfd.sdk.base.do;
import com.tencent.turingfd.sdk.base.int;
import com.tencent.turingfd.sdk.base.synchronized;
import com.tencent.turingfd.sdk.base.try;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class abr
{
  public static final afk<abr> a = new a();
  public d b;
  public final AtomicBoolean c = new AtomicBoolean(false);
  
  public static abr a()
  {
    return (abr)a.b();
  }
  
  public final break a(break parambreak1, break parambreak2)
  {
    final Object localObject;
    final AtomicReference localAtomicReference;
    AtomicBoolean localAtomicBoolean;
    label130:
    label151:
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
        acc.a locala = new acc.a(4103, 14103, 2);
        locala.d = parambreak1;
        locala.f = parambreak2;
        locala.a = localb;
        Message.obtain(locald, 2, locala.a()).sendToTarget();
      }
    }
    finally {}
    try
    {
      try
      {
        localObject.wait(100000L);
      }
      finally
      {
        break label151;
      }
    }
    catch (InterruptedException parambreak1)
    {
      break label130;
    }
    localAtomicBoolean.set(true);
    parambreak1 = (break)localAtomicReference.get();
    return parambreak1;
    throw parambreak1;
    throw new RuntimeException("Must call after initialized");
  }
  
  public final void a(aex paramaex)
  {
    if (paramaex == null) {
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
      this.b = new d(localHandlerThread.getLooper(), paramaex);
      Message.obtain(this.b, 1).sendToTarget();
      return;
    }
    finally {}
  }
  
  public final byte[] a(int paramInt1, int paramInt2, byte[] paramArrayOfByte, long paramLong)
  {
    final Object localObject;
    final AtomicReference localAtomicReference;
    AtomicBoolean localAtomicBoolean;
    label125:
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
        acc.a locala = new acc.a(paramInt1, paramInt2, 1);
        locala.e = paramArrayOfByte;
        locala.a = localc;
        Message.obtain(locald, 2, locala.a()).sendToTarget();
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
        break label147;
      }
    }
    catch (InterruptedException paramArrayOfByte)
    {
      label147:
      break label125;
    }
    localAtomicBoolean.set(true);
    paramArrayOfByte = (byte[])localAtomicReference.get();
    return paramArrayOfByte;
    throw paramArrayOfByte;
    throw new RuntimeException("Must call after initialized");
  }
  
  public static final class a
    extends afk<abr>
  {
    public final Object a()
    {
      return new abr((byte)0);
    }
  }
  
  public final class b
    implements acc.b
  {
    public b(AtomicReference paramAtomicReference, Object paramObject) {}
    
    public final void a(int paramInt, break arg2)
    {
      if (abr.this.get()) {
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
    
    public final void a(int paramInt, byte[] paramArrayOfByte) {}
  }
  
  public final class c
    implements acc.b
  {
    public c(AtomicReference paramAtomicReference, Object paramObject) {}
    
    public final void a(int paramInt, break parambreak) {}
    
    public final void a(int paramInt, byte[] arg2)
    {
      if (abr.this.get()) {
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
  
  public static final class d
    extends Handler
  {
    public int a = 1;
    public do b = new do();
    public abq c;
    public aex d;
    
    public d(Looper paramLooper, aex paramaex)
    {
      super();
      this.b.B = 49;
      this.c = new abq();
      this.d = paramaex;
    }
    
    private String a(Context paramContext)
    {
      System.currentTimeMillis();
      paramContext = abo.a(paramContext);
      paramContext = aez.a(a(aez.a(), paramContext), paramContext.g);
      if ((paramContext instanceof try)) {
        return ((try)paramContext).u;
      }
      return "";
    }
    
    private boolean a()
    {
      System.currentTimeMillis();
      Object localObject = this.c.a();
      localObject = aez.a(a(aez.a(), (acc)localObject), ((acc)localObject).g);
      if ((localObject instanceof synchronized))
      {
        localObject = (synchronized)localObject;
        this.c.a((synchronized)localObject);
        return true;
      }
      return false;
    }
    
    private byte[] a(Context paramContext, acc paramacc)
    {
      int i = paramacc.a;
      Object localObject2 = paramacc.f;
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = aez.a(paramacc.e);
      }
      localObject2 = this.c;
      if (TextUtils.isEmpty(((abq)localObject2).a)) {
        localObject2 = ((abq)localObject2).e;
      } else {
        localObject2 = ((abq)localObject2).b;
      }
      localObject2 = abr.a(i, (byte[])localObject1, (String)localObject2);
      do localdo = this.b;
      if (paramacc.a == 152) {
        localObject1 = "";
      } else {
        localObject1 = this.c.a;
      }
      localdo.A = ((String)localObject1);
      this.b.u = abo.b(paramContext);
      paramContext = aez.a(abr.a(this.a, (int)localObject2, this.b));
      localObject1 = this.d;
      if (localObject1 == null) {
        paramContext = new byte[0];
      } else {
        localObject1 = (afe)localObject1;
      }
      try
      {
        paramContext = ((afe)localObject1).a(paramContext).a;
      }
      catch (Throwable paramContext)
      {
        label178:
        break label178;
      }
      paramContext = new byte[0];
      paramContext = aez.a(paramContext, new char());
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
      paramacc = abr.a(paramacc.b, paramContext);
      if (paramacc == null) {
        return null;
      }
      if (paramacc.cb == 2)
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
      return abr.a(paramacc, paramContext);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      int j = paramMessage.what;
      int i = 1;
      if (j != 1)
      {
        if (j == 2)
        {
          paramMessage = (acc)paramMessage.obj;
          Object localObject1 = paramMessage.d;
          Object localObject2 = this.c;
          long l1 = System.currentTimeMillis();
          long l2 = ((abq)localObject2).c;
          if ((l2 != 0L) && (Math.abs(l1 - l2) < ((abq)localObject2).d)) {
            i = 0;
          }
          if ((i != 0) && (!a()))
          {
            ((acc.b)localObject1).a(-1, null);
            return;
          }
          localObject2 = aez.a();
          if (TextUtils.isEmpty(abo.b((Context)localObject2)))
          {
            abo.a((Context)localObject2, a((Context)localObject2));
            if (TextUtils.isEmpty(abo.b((Context)localObject2)))
            {
              ((acc.b)localObject1).a(-2, null);
              return;
            }
          }
          localObject1 = a((Context)localObject2, paramMessage);
          localObject2 = paramMessage.g;
          if (localObject2 != null)
          {
            localObject1 = aez.a((byte[])localObject1, (break)localObject2);
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
        }
      }
      else
      {
        System.currentTimeMillis();
        if (!a()) {
          return;
        }
        paramMessage = aez.a();
        if (TextUtils.isEmpty(abo.b(paramMessage))) {
          abo.a(paramMessage, a(paramMessage));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.abr
 * JD-Core Version:    0.7.0.1
 */