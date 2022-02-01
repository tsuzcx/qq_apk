package com.tencent.turingfd.sdk.base;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
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
    if ((paramSparseArray == null) || (paramSparseArray.size() == 0)) {}
    Object localObject;
    Object[] arrayOfObject1;
    int k;
    do
    {
      return false;
      int i = 0;
      if (i >= paramSparseArray.size()) {
        break;
      }
      localObject = (z)paramSparseArray.valueAt(i);
      if (localObject == null) {}
      do
      {
        i += 1;
        break;
        arrayOfObject1 = (Object[])((z)localObject).b.clone();
      } while ((arrayOfObject1 == null) || (arrayOfObject1.length == 0));
      j = 0;
      k = 0;
      Object[] arrayOfObject2 = ((z)localObject).b;
      if (j < arrayOfObject2.length)
      {
        if ((List)arrayOfObject2[j] == null) {}
        for (;;)
        {
          j += 1;
          break;
          k += 1;
        }
      }
    } while (k < 1);
    int j = 0;
    label118:
    if (j < arrayOfObject1.length)
    {
      localObject = (List)arrayOfObject1[j];
      if (localObject != null) {
        break label146;
      }
    }
    label146:
    while (((List)localObject).size() >= ay.c / 4)
    {
      j += 1;
      break label118;
      break;
    }
    return false;
    return true;
  }
  
  public void a()
  {
    for (;;)
    {
      try
      {
        ??? = this.b;
        if (??? == null) {
          return;
        }
        synchronized (this.c)
        {
          Iterator localIterator = this.c.iterator();
          if (localIterator.hasNext())
          {
            Sensor localSensor = (Sensor)localIterator.next();
            this.b.unregisterListener(this.e, localSensor);
          }
        }
        this.c.clear();
      }
      finally {}
      this.e.a();
    }
  }
  
  /* Error */
  public boolean a(long paramLong, android.os.Handler paramHandler)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 7
    //   3: iconst_0
    //   4: istore 8
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_0
    //   9: getfield 54	com/tencent/turingfd/sdk/base/t:b	Landroid/hardware/SensorManager;
    //   12: astore 9
    //   14: aload 9
    //   16: ifnonnull +8 -> 24
    //   19: aload_0
    //   20: monitorexit
    //   21: iload 8
    //   23: ireturn
    //   24: aload_0
    //   25: getfield 42	com/tencent/turingfd/sdk/base/t:e	Lcom/tencent/turingfd/sdk/base/t$a;
    //   28: lload_1
    //   29: invokevirtual 112	com/tencent/turingfd/sdk/base/t$a:a	(J)V
    //   32: aload_0
    //   33: getfield 32	com/tencent/turingfd/sdk/base/t:c	Ljava/util/HashSet;
    //   36: astore 9
    //   38: aload 9
    //   40: monitorenter
    //   41: aload_0
    //   42: getfield 32	com/tencent/turingfd/sdk/base/t:c	Ljava/util/HashSet;
    //   45: invokevirtual 106	java/util/HashSet:clear	()V
    //   48: aload 9
    //   50: monitorexit
    //   51: aload_0
    //   52: getfield 32	com/tencent/turingfd/sdk/base/t:c	Ljava/util/HashSet;
    //   55: astore 9
    //   57: aload 9
    //   59: monitorenter
    //   60: getstatic 22	com/tencent/turingfd/sdk/base/t:a	[I
    //   63: astore 10
    //   65: aload 10
    //   67: arraylength
    //   68: istore 5
    //   70: iconst_0
    //   71: istore 4
    //   73: iload 4
    //   75: iload 5
    //   77: if_icmpge +74 -> 151
    //   80: aload 10
    //   82: iload 4
    //   84: iaload
    //   85: istore 6
    //   87: aload_0
    //   88: getfield 54	com/tencent/turingfd/sdk/base/t:b	Landroid/hardware/SensorManager;
    //   91: iload 6
    //   93: invokevirtual 116	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
    //   96: astore 11
    //   98: aload 11
    //   100: ifnonnull +6 -> 106
    //   103: goto +77 -> 180
    //   106: aload_0
    //   107: getfield 54	com/tencent/turingfd/sdk/base/t:b	Landroid/hardware/SensorManager;
    //   110: aload_0
    //   111: getfield 42	com/tencent/turingfd/sdk/base/t:e	Lcom/tencent/turingfd/sdk/base/t$a;
    //   114: aload 11
    //   116: iconst_0
    //   117: aload_3
    //   118: invokevirtual 120	android/hardware/SensorManager:registerListener	(Landroid/hardware/SensorEventListener;Landroid/hardware/Sensor;ILandroid/os/Handler;)Z
    //   121: ifeq +59 -> 180
    //   124: iconst_1
    //   125: istore 7
    //   127: aload_0
    //   128: getfield 32	com/tencent/turingfd/sdk/base/t:c	Ljava/util/HashSet;
    //   131: aload 11
    //   133: invokevirtual 124	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   136: pop
    //   137: goto +43 -> 180
    //   140: astore_3
    //   141: aload 9
    //   143: monitorexit
    //   144: aload_3
    //   145: athrow
    //   146: astore_3
    //   147: aload_0
    //   148: monitorexit
    //   149: aload_3
    //   150: athrow
    //   151: aload 9
    //   153: monitorexit
    //   154: iload 7
    //   156: istore 8
    //   158: iload 7
    //   160: ifne -141 -> 19
    //   163: aload_0
    //   164: invokevirtual 125	com/tencent/turingfd/sdk/base/t:a	()V
    //   167: iload 7
    //   169: istore 8
    //   171: goto -152 -> 19
    //   174: astore_3
    //   175: aload 9
    //   177: monitorexit
    //   178: aload_3
    //   179: athrow
    //   180: iload 4
    //   182: iconst_1
    //   183: iadd
    //   184: istore 4
    //   186: goto -113 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	189	0	this	t
    //   0	189	1	paramLong	long
    //   0	189	3	paramHandler	android.os.Handler
    //   71	114	4	i	int
    //   68	10	5	j	int
    //   85	7	6	k	int
    //   1	167	7	bool1	boolean
    //   4	166	8	bool2	boolean
    //   63	18	10	arrayOfInt	int[]
    //   96	36	11	localSensor	Sensor
    // Exception table:
    //   from	to	target	type
    //   60	70	140	finally
    //   87	98	140	finally
    //   106	124	140	finally
    //   127	137	140	finally
    //   141	144	140	finally
    //   151	154	140	finally
    //   8	14	146	finally
    //   24	41	146	finally
    //   51	60	146	finally
    //   144	146	146	finally
    //   163	167	146	finally
    //   178	180	146	finally
    //   41	51	174	finally
    //   175	178	174	finally
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
        this.c = ((int)Math.ceil(paramLong * 1.0D / ay.b));
        return;
      }
    }
    
    public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
    
    public void onSensorChanged(SensorEvent paramSensorEvent)
    {
      label236:
      for (;;)
      {
        synchronized (this.a)
        {
          if (!this.a.get()) {
            return;
          }
          if ((paramSensorEvent == null) || (paramSensorEvent.sensor == null)) {
            break;
          }
          ab localab = new ab(paramSensorEvent, System.currentTimeMillis());
          long l = localab.b - this.b;
          if (l < 0L) {
            break;
          }
          int j = localab.a;
          int i = (int)(l / ay.b);
          synchronized (t.a(t.this))
          {
            paramSensorEvent = (z)t.a(t.this).get(j);
            if (paramSensorEvent != null) {
              break label236;
            }
            paramSensorEvent = new z(j, ay.c, this.c);
            t.a(t.this).put(j, paramSensorEvent);
            if (i >= paramSensorEvent.d) {
              return;
            }
          }
          if (i > paramSensorEvent.c)
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
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.t
 * JD-Core Version:    0.7.0.1
 */