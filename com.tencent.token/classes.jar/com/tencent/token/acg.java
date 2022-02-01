package com.tencent.token;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public final class acg
{
  public static final int[] a = { 1, 4, 9 };
  public final SensorManager b;
  public final HashSet<Sensor> c = new HashSet();
  public final SparseArray<acm> d = new SparseArray();
  public a e = new a();
  
  public acg(Context paramContext)
  {
    paramContext = paramContext.getSystemService("sensor");
    if (paramContext != null)
    {
      this.b = ((SensorManager)paramContext);
      return;
    }
    this.b = null;
  }
  
  private static boolean a(SparseArray<acm> paramSparseArray)
  {
    if (paramSparseArray.size() != 0)
    {
      int i = 0;
      while (i < paramSparseArray.size())
      {
        Object localObject = (acm)paramSparseArray.valueAt(i);
        if (localObject != null)
        {
          Object[] arrayOfObject1 = (Object[])((acm)localObject).b.clone();
          if ((arrayOfObject1 != null) && (arrayOfObject1.length != 0))
          {
            int j = 0;
            int m;
            for (int k = 0;; k = m)
            {
              Object[] arrayOfObject2 = ((acm)localObject).b;
              if (j >= arrayOfObject2.length) {
                break;
              }
              m = k;
              if ((List)arrayOfObject2[j] != null) {
                m = k + 1;
              }
              j += 1;
            }
            if (k <= 0) {
              return false;
            }
            j = 0;
            while (j < arrayOfObject1.length)
            {
              localObject = (List)arrayOfObject1[j];
              if ((localObject != null) && (((List)localObject).size() < adl.c / 4)) {
                return false;
              }
              j += 1;
            }
          }
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  /* Error */
  public final void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 54	com/tencent/token/acg:b	Landroid/hardware/SensorManager;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 32	com/tencent/token/acg:c	Ljava/util/HashSet;
    //   18: astore_1
    //   19: aload_1
    //   20: monitorenter
    //   21: aload_0
    //   22: getfield 32	com/tencent/token/acg:c	Ljava/util/HashSet;
    //   25: invokevirtual 88	java/util/HashSet:iterator	()Ljava/util/Iterator;
    //   28: astore_2
    //   29: aload_2
    //   30: invokeinterface 94 1 0
    //   35: ifeq +28 -> 63
    //   38: aload_2
    //   39: invokeinterface 97 1 0
    //   44: checkcast 99	android/hardware/Sensor
    //   47: astore_3
    //   48: aload_0
    //   49: getfield 54	com/tencent/token/acg:b	Landroid/hardware/SensorManager;
    //   52: aload_0
    //   53: getfield 42	com/tencent/token/acg:e	Lcom/tencent/token/acg$a;
    //   56: aload_3
    //   57: invokevirtual 103	android/hardware/SensorManager:unregisterListener	(Landroid/hardware/SensorEventListener;Landroid/hardware/Sensor;)V
    //   60: goto -31 -> 29
    //   63: aload_0
    //   64: getfield 32	com/tencent/token/acg:c	Ljava/util/HashSet;
    //   67: invokevirtual 106	java/util/HashSet:clear	()V
    //   70: aload_1
    //   71: monitorexit
    //   72: aload_0
    //   73: getfield 42	com/tencent/token/acg:e	Lcom/tencent/token/acg$a;
    //   76: astore_2
    //   77: aload_2
    //   78: getfield 109	com/tencent/token/acg$a:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   81: astore_1
    //   82: aload_1
    //   83: monitorenter
    //   84: aload_2
    //   85: getfield 109	com/tencent/token/acg$a:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   88: invokevirtual 114	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   91: ifne +8 -> 99
    //   94: aload_1
    //   95: monitorexit
    //   96: aload_0
    //   97: monitorexit
    //   98: return
    //   99: aload_2
    //   100: getfield 109	com/tencent/token/acg$a:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   103: iconst_0
    //   104: invokevirtual 118	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   107: aload_2
    //   108: invokestatic 124	java/lang/System:currentTimeMillis	()J
    //   111: aload_2
    //   112: getfield 127	com/tencent/token/acg$a:b	J
    //   115: lsub
    //   116: putfield 129	com/tencent/token/acg$a:d	J
    //   119: aload_2
    //   120: getfield 129	com/tencent/token/acg$a:d	J
    //   123: lconst_0
    //   124: lcmp
    //   125: ifge +8 -> 133
    //   128: aload_2
    //   129: lconst_0
    //   130: putfield 129	com/tencent/token/acg$a:d	J
    //   133: aload_2
    //   134: lconst_0
    //   135: putfield 127	com/tencent/token/acg$a:b	J
    //   138: aload_1
    //   139: monitorexit
    //   140: aload_0
    //   141: monitorexit
    //   142: return
    //   143: astore_2
    //   144: aload_1
    //   145: monitorexit
    //   146: aload_2
    //   147: athrow
    //   148: astore_2
    //   149: aload_1
    //   150: monitorexit
    //   151: aload_2
    //   152: athrow
    //   153: astore_1
    //   154: aload_0
    //   155: monitorexit
    //   156: aload_1
    //   157: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	this	acg
    //   153	4	1	localObject2	Object
    //   28	106	2	localObject3	Object
    //   143	4	2	localObject4	Object
    //   148	4	2	localObject5	Object
    //   47	10	3	localSensor	Sensor
    // Exception table:
    //   from	to	target	type
    //   84	96	143	finally
    //   99	133	143	finally
    //   133	140	143	finally
    //   144	146	143	finally
    //   21	29	148	finally
    //   29	60	148	finally
    //   63	72	148	finally
    //   149	151	148	finally
    //   2	7	153	finally
    //   14	21	153	finally
    //   72	84	153	finally
    //   146	148	153	finally
    //   151	153	153	finally
  }
  
  public final boolean a(long paramLong, Handler paramHandler)
  {
    for (;;)
    {
      boolean bool2;
      try
      {
        ??? = this.b;
        if (??? == null) {
          return false;
        }
        this.e.a(paramLong);
        int i;
        synchronized (this.c)
        {
          this.c.clear();
          synchronized (this.c)
          {
            int[] arrayOfInt = a;
            int j = arrayOfInt.length;
            i = 0;
            bool1 = false;
            if (i < j)
            {
              int k = arrayOfInt[i];
              Sensor localSensor = this.b.getDefaultSensor(k);
              bool2 = bool1;
              if (localSensor != null)
              {
                bool2 = bool1;
                if (this.b.registerListener(this.e, localSensor, 0, paramHandler))
                {
                  this.c.add(localSensor);
                  bool2 = true;
                }
              }
            }
            else
            {
              if (!bool1) {
                a();
              }
              return bool1;
            }
          }
        }
        i += 1;
      }
      finally {}
      boolean bool1 = bool2;
    }
  }
  
  public final SparseArray<acm> b()
  {
    synchronized (this.d)
    {
      SparseArray localSparseArray2 = new SparseArray();
      int i = 0;
      while (i < this.d.size())
      {
        localSparseArray2.append(this.d.keyAt(i), (acm)this.d.valueAt(i));
        i += 1;
      }
      if (a(localSparseArray2)) {
        return localSparseArray2;
      }
      localSparseArray2 = new SparseArray();
      return localSparseArray2;
    }
  }
  
  public final class a
    implements SensorEventListener
  {
    public final AtomicBoolean a = new AtomicBoolean(false);
    public long b = 0L;
    public int c = 0;
    public long d = 0L;
    
    public a() {}
    
    public final void a(long paramLong)
    {
      synchronized (this.a)
      {
        if (this.a.get()) {
          return;
        }
        this.a.set(true);
        this.b = System.currentTimeMillis();
        double d1 = paramLong;
        Double.isNaN(d1);
        paramLong = adl.b;
        double d2 = paramLong;
        Double.isNaN(d2);
        d1 = d1 * 1.0D / d2;
        this.c = ((int)Math.ceil(d1));
        return;
      }
    }
    
    public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
    
    public final void onSensorChanged(SensorEvent paramSensorEvent)
    {
      synchronized (this.a)
      {
        if (!this.a.get()) {
          return;
        }
        if ((paramSensorEvent != null) && (paramSensorEvent.sensor != null))
        {
          aco localaco = new aco(paramSensorEvent, System.currentTimeMillis());
          long l = localaco.b - this.b;
          if (l < 0L) {
            return;
          }
          int j = localaco.a;
          int i = (int)(l / adl.b);
          synchronized (acg.a(acg.this))
          {
            ??? = (acm)acg.a(acg.this).get(j);
            paramSensorEvent = (SensorEvent)???;
            if (??? == null)
            {
              paramSensorEvent = new acm(j, adl.c, this.c);
              acg.a(acg.this).put(j, paramSensorEvent);
            }
            if ((i < paramSensorEvent.d) && (i > paramSensorEvent.c))
            {
              j = i / paramSensorEvent.e;
              List localList = (List)paramSensorEvent.b[j];
              ??? = localList;
              if (localList == null)
              {
                ??? = new ArrayList();
                paramSensorEvent.b[j] = ???;
              }
              ((List)???).add(localaco);
              paramSensorEvent.c = i;
            }
            return;
          }
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.acg
 * JD-Core Version:    0.7.0.1
 */