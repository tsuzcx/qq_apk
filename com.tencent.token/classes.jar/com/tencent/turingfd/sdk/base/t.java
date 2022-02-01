package com.tencent.turingfd.sdk.base;

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

public class t
{
  public static final int[] a = { 1, 4, 9 };
  public final SensorManager b;
  public final HashSet<Sensor> c = new HashSet();
  public final SparseArray<z> d = new SparseArray();
  public a e = new a();
  
  public t(Context paramContext)
  {
    paramContext = paramContext.getSystemService("sensor");
    if (paramContext != null)
    {
      this.b = ((SensorManager)paramContext);
      return;
    }
    this.b = null;
  }
  
  public static boolean a(SparseArray<z> paramSparseArray)
  {
    if (paramSparseArray != null)
    {
      if (paramSparseArray.size() == 0) {
        return false;
      }
      int i = 0;
      while (i < paramSparseArray.size())
      {
        Object localObject = (z)paramSparseArray.valueAt(i);
        if (localObject != null)
        {
          Object[] arrayOfObject1 = (Object[])((z)localObject).b.clone();
          if ((arrayOfObject1 != null) && (arrayOfObject1.length != 0))
          {
            int j = 0;
            int k = 0;
            for (;;)
            {
              Object[] arrayOfObject2 = ((z)localObject).b;
              if (j >= arrayOfObject2.length) {
                break;
              }
              if ((List)arrayOfObject2[j] != null) {
                k += 1;
              }
              j += 1;
            }
            if (k < 1) {
              return false;
            }
            j = 0;
            while (j < arrayOfObject1.length)
            {
              localObject = (List)arrayOfObject1[j];
              if ((localObject != null) && (((List)localObject).size() < ay.c / 4)) {
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
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 54	com/tencent/turingfd/sdk/base/t:b	Landroid/hardware/SensorManager;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 32	com/tencent/turingfd/sdk/base/t:c	Ljava/util/HashSet;
    //   18: astore_1
    //   19: aload_1
    //   20: monitorenter
    //   21: aload_0
    //   22: getfield 32	com/tencent/turingfd/sdk/base/t:c	Ljava/util/HashSet;
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
    //   49: getfield 54	com/tencent/turingfd/sdk/base/t:b	Landroid/hardware/SensorManager;
    //   52: aload_0
    //   53: getfield 42	com/tencent/turingfd/sdk/base/t:e	Lcom/tencent/turingfd/sdk/base/t$a;
    //   56: aload_3
    //   57: invokevirtual 103	android/hardware/SensorManager:unregisterListener	(Landroid/hardware/SensorEventListener;Landroid/hardware/Sensor;)V
    //   60: goto -31 -> 29
    //   63: aload_0
    //   64: getfield 32	com/tencent/turingfd/sdk/base/t:c	Ljava/util/HashSet;
    //   67: invokevirtual 106	java/util/HashSet:clear	()V
    //   70: aload_1
    //   71: monitorexit
    //   72: aload_0
    //   73: getfield 42	com/tencent/turingfd/sdk/base/t:e	Lcom/tencent/turingfd/sdk/base/t$a;
    //   76: invokevirtual 108	com/tencent/turingfd/sdk/base/t$a:a	()V
    //   79: aload_0
    //   80: monitorexit
    //   81: return
    //   82: astore_2
    //   83: aload_1
    //   84: monitorexit
    //   85: aload_2
    //   86: athrow
    //   87: astore_1
    //   88: aload_0
    //   89: monitorexit
    //   90: aload_1
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	t
    //   87	4	1	localObject2	Object
    //   28	11	2	localIterator	java.util.Iterator
    //   82	4	2	localObject3	Object
    //   47	10	3	localSensor	Sensor
    // Exception table:
    //   from	to	target	type
    //   21	29	82	finally
    //   29	60	82	finally
    //   63	72	82	finally
    //   83	85	82	finally
    //   2	7	87	finally
    //   14	21	87	finally
    //   72	79	87	finally
    //   85	87	87	finally
  }
  
  public boolean a(long paramLong, Handler paramHandler)
  {
    for (;;)
    {
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
            boolean bool = false;
            if (i < j)
            {
              int k = arrayOfInt[i];
              Sensor localSensor = this.b.getDefaultSensor(k);
              if ((localSensor != null) && (this.b.registerListener(this.e, localSensor, 0, paramHandler)))
              {
                this.c.add(localSensor);
                bool = true;
              }
            }
            else
            {
              if (!bool) {
                a();
              }
              return bool;
            }
          }
        }
        i += 1;
      }
      finally {}
    }
  }
  
  public void b()
  {
    synchronized (this.d)
    {
      this.d.clear();
      return;
    }
  }
  
  public SparseArray<z> c()
  {
    synchronized (this.d)
    {
      SparseArray localSparseArray2 = new SparseArray();
      int i = 0;
      while (i < this.d.size())
      {
        localSparseArray2.append(this.d.keyAt(i), (z)this.d.valueAt(i));
        i += 1;
      }
      if (a(localSparseArray2)) {
        return localSparseArray2;
      }
      localSparseArray2 = new SparseArray();
      return localSparseArray2;
    }
  }
  
  private class a
    implements SensorEventListener
  {
    public final AtomicBoolean a = new AtomicBoolean(false);
    public long b = 0L;
    public int c = 0;
    public long d = 0L;
    
    public a() {}
    
    public void a()
    {
      synchronized (this.a)
      {
        if (!this.a.get()) {
          return;
        }
        this.a.set(false);
        this.d = (System.currentTimeMillis() - this.b);
        if (this.d < 0L) {
          this.d = 0L;
        }
        this.b = 0L;
        return;
      }
    }
    
    public void a(long paramLong)
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
        paramLong = ay.b;
        double d2 = paramLong;
        Double.isNaN(d2);
        d1 = d1 * 1.0D / d2;
        this.c = ((int)Math.ceil(d1));
        return;
      }
    }
    
    public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
    
    public void onSensorChanged(SensorEvent paramSensorEvent)
    {
      synchronized (this.a)
      {
        if (!this.a.get()) {
          return;
        }
        if (paramSensorEvent != null)
        {
          if (paramSensorEvent.sensor == null) {
            return;
          }
          ab localab = new ab(paramSensorEvent, System.currentTimeMillis());
          long l = localab.b - this.b;
          if (l < 0L) {
            return;
          }
          int j = localab.a;
          int i = (int)(l / ay.b);
          synchronized (t.a(t.this))
          {
            ??? = (z)t.a(t.this).get(j);
            paramSensorEvent = (SensorEvent)???;
            if (??? == null)
            {
              paramSensorEvent = new z(j, ay.c, this.c);
              t.a(t.this).put(j, paramSensorEvent);
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
              ((List)???).add(localab);
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
 * Qualified Name:     com.tencent.turingfd.sdk.base.t
 * JD-Core Version:    0.7.0.1
 */