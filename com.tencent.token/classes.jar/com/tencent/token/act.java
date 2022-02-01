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

public final class act
{
  public static final int[] a = { 1, 4, 9 };
  public final SensorManager b;
  public final HashSet<Sensor> c = new HashSet();
  public final SparseArray<acv> d = new SparseArray();
  public a e = new a();
  
  public act(Context paramContext)
  {
    paramContext = paramContext.getSystemService("sensor");
    if (paramContext != null)
    {
      this.b = ((SensorManager)paramContext);
      return;
    }
    this.b = null;
  }
  
  public static boolean a(SparseArray<acv> paramSparseArray)
  {
    if (paramSparseArray.size() == 0) {
      return false;
    }
    int i = 0;
    while (i < paramSparseArray.size())
    {
      Object localObject = (acv)paramSparseArray.valueAt(i);
      if (localObject != null)
      {
        Object[] arrayOfObject1 = (Object[])((acv)localObject).b.clone();
        if (arrayOfObject1.length != 0)
        {
          int j = 0;
          int m;
          for (int k = 0;; k = m)
          {
            Object[] arrayOfObject2 = ((acv)localObject).b;
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
            if ((localObject != null) && (((List)localObject).size() < afg.c / 4)) {
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
  
  /* Error */
  public final void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 54	com/tencent/token/act:b	Landroid/hardware/SensorManager;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnonnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 32	com/tencent/token/act:c	Ljava/util/HashSet;
    //   18: astore_3
    //   19: aload_3
    //   20: monitorenter
    //   21: aload_0
    //   22: getfield 32	com/tencent/token/act:c	Ljava/util/HashSet;
    //   25: invokevirtual 87	java/util/HashSet:iterator	()Ljava/util/Iterator;
    //   28: astore 4
    //   30: aload 4
    //   32: invokeinterface 93 1 0
    //   37: ifeq +31 -> 68
    //   40: aload 4
    //   42: invokeinterface 96 1 0
    //   47: checkcast 98	android/hardware/Sensor
    //   50: astore 5
    //   52: aload_0
    //   53: getfield 54	com/tencent/token/act:b	Landroid/hardware/SensorManager;
    //   56: aload_0
    //   57: getfield 42	com/tencent/token/act:e	Lcom/tencent/token/act$a;
    //   60: aload 5
    //   62: invokevirtual 102	android/hardware/SensorManager:unregisterListener	(Landroid/hardware/SensorEventListener;Landroid/hardware/Sensor;)V
    //   65: goto -35 -> 30
    //   68: aload_0
    //   69: getfield 32	com/tencent/token/act:c	Ljava/util/HashSet;
    //   72: invokevirtual 105	java/util/HashSet:clear	()V
    //   75: aload_3
    //   76: monitorexit
    //   77: aload_0
    //   78: getfield 42	com/tencent/token/act:e	Lcom/tencent/token/act$a;
    //   81: astore 4
    //   83: aload 4
    //   85: getfield 108	com/tencent/token/act$a:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   88: astore_3
    //   89: aload_3
    //   90: monitorenter
    //   91: aload 4
    //   93: getfield 108	com/tencent/token/act$a:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   96: invokevirtual 113	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   99: ifne +8 -> 107
    //   102: aload_3
    //   103: monitorexit
    //   104: aload_0
    //   105: monitorexit
    //   106: return
    //   107: aload 4
    //   109: getfield 108	com/tencent/token/act$a:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   112: iconst_0
    //   113: invokevirtual 117	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   116: invokestatic 123	java/lang/System:currentTimeMillis	()J
    //   119: aload 4
    //   121: getfield 126	com/tencent/token/act$a:b	J
    //   124: lsub
    //   125: lstore_1
    //   126: aload 4
    //   128: lload_1
    //   129: putfield 128	com/tencent/token/act$a:d	J
    //   132: lload_1
    //   133: lconst_0
    //   134: lcmp
    //   135: ifge +9 -> 144
    //   138: aload 4
    //   140: lconst_0
    //   141: putfield 128	com/tencent/token/act$a:d	J
    //   144: aload 4
    //   146: lconst_0
    //   147: putfield 126	com/tencent/token/act$a:b	J
    //   150: aload_3
    //   151: monitorexit
    //   152: aload_0
    //   153: monitorexit
    //   154: return
    //   155: astore 4
    //   157: aload_3
    //   158: monitorexit
    //   159: aload 4
    //   161: athrow
    //   162: astore 4
    //   164: aload_3
    //   165: monitorexit
    //   166: aload 4
    //   168: athrow
    //   169: astore_3
    //   170: aload_0
    //   171: monitorexit
    //   172: aload_3
    //   173: athrow
    //   174: astore 5
    //   176: goto -146 -> 30
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	179	0	this	act
    //   125	8	1	l	long
    //   169	4	3	localObject2	Object
    //   28	117	4	localObject3	Object
    //   155	5	4	localObject4	Object
    //   162	5	4	localObject5	Object
    //   50	11	5	localSensor	Sensor
    //   174	1	5	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   91	104	155	finally
    //   107	132	155	finally
    //   138	144	155	finally
    //   144	152	155	finally
    //   157	159	155	finally
    //   21	30	162	finally
    //   30	52	162	finally
    //   68	77	162	finally
    //   164	166	162	finally
    //   2	7	169	finally
    //   14	21	169	finally
    //   77	91	169	finally
    //   159	162	169	finally
    //   166	169	169	finally
    //   52	65	174	finally
  }
  
  public final boolean a(long paramLong, Handler paramHandler)
  {
    for (;;)
    {
      boolean bool3;
      try
      {
        ??? = this.b;
        if (??? == null) {
          return false;
        }
        Object localObject2 = this.e;
        int i;
        synchronized (((a)localObject2).a)
        {
          if (!((a)localObject2).a.get())
          {
            ((a)localObject2).a.set(true);
            ((a)localObject2).b = System.currentTimeMillis();
            double d1 = paramLong;
            Double.isNaN(d1);
            paramLong = afg.b;
            double d2 = paramLong;
            Double.isNaN(d2);
            d1 = d1 * 1.0D / d2;
            ((a)localObject2).c = ((int)Math.ceil(d1));
          }
          synchronized (this.c)
          {
            this.c.clear();
            synchronized (this.c)
            {
              localObject2 = a;
              int j = localObject2.length;
              i = 0;
              bool1 = false;
              Sensor localSensor;
              if (i < j)
              {
                int k = localObject2[i];
                localSensor = this.b.getDefaultSensor(k);
                bool3 = bool1;
                if (localSensor == null) {}
              }
              else
              {
                try
                {
                  bool2 = this.b.registerListener(this.e, localSensor, 0, paramHandler);
                  continue;
                }
                finally {}
                boolean bool2 = false;
                bool3 = bool1;
                if (bool2)
                {
                  this.c.add(localSensor);
                  bool3 = true;
                  break label285;
                  if (!bool1) {
                    a();
                  }
                  return bool1;
                }
              }
            }
          }
        }
        i += 1;
      }
      finally {}
      label285:
      boolean bool1 = bool3;
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
          acw localacw = new acw(paramSensorEvent, System.currentTimeMillis());
          long l = localacw.b - this.b;
          if (l < 0L) {
            return;
          }
          int j = localacw.a;
          int i = (int)(l / afg.b);
          synchronized (act.this.d)
          {
            ??? = (acv)act.this.d.get(j);
            paramSensorEvent = (SensorEvent)???;
            if (??? == null)
            {
              paramSensorEvent = new acv(j, afg.c, this.c);
              act.this.d.put(j, paramSensorEvent);
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
              ((List)???).add(localacw);
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
 * Qualified Name:     com.tencent.token.act
 * JD-Core Version:    0.7.0.1
 */