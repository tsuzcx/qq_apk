package com.tencent.beacon.a.b;

import android.content.Context;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class c
{
  private static c a = null;
  private e b = null;
  private boolean c = false;
  private int d = 0;
  private com.tencent.beacon.upload.f e = null;
  private Runnable f = null;
  private List<b> g = new ArrayList(5);
  private SparseArray<com.tencent.beacon.upload.g> h = new SparseArray(5);
  private List<f> i = new ArrayList(5);
  private SparseArray<g> j = new SparseArray(2);
  
  private c(Context paramContext)
  {
    this.e = new a(paramContext);
    this.f = new d(paramContext);
    com.tencent.beacon.a.d.a().a(this.f);
  }
  
  public static c a(Context paramContext)
  {
    try
    {
      if ((a == null) && (paramContext != null)) {
        a = new c(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  /* Error */
  public static com.tencent.beacon.upload.g a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 34	com/tencent/beacon/a/b/c:a	Lcom/tencent/beacon/a/b/c;
    //   6: ifnull +15 -> 21
    //   9: getstatic 34	com/tencent/beacon/a/b/c:a	Lcom/tencent/beacon/a/b/c;
    //   12: invokespecial 90	com/tencent/beacon/a/b/c:g	()Lcom/tencent/beacon/upload/g;
    //   15: astore_0
    //   16: ldc 2
    //   18: monitorexit
    //   19: aload_0
    //   20: areturn
    //   21: aconst_null
    //   22: astore_0
    //   23: goto -7 -> 16
    //   26: astore_0
    //   27: ldc 2
    //   29: monitorexit
    //   30: aload_0
    //   31: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   15	8	0	localg	com.tencent.beacon.upload.g
    //   26	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	16	26	finally
  }
  
  /* Error */
  private com.tencent.beacon.upload.g g()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 61	com/tencent/beacon/a/b/c:h	Landroid/util/SparseArray;
    //   6: ifnull +29 -> 35
    //   9: aload_0
    //   10: getfield 61	com/tencent/beacon/a/b/c:h	Landroid/util/SparseArray;
    //   13: invokevirtual 94	android/util/SparseArray:size	()I
    //   16: ifle +19 -> 35
    //   19: aload_0
    //   20: getfield 61	com/tencent/beacon/a/b/c:h	Landroid/util/SparseArray;
    //   23: iconst_0
    //   24: invokevirtual 98	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   27: checkcast 100	com/tencent/beacon/upload/g
    //   30: astore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_1
    //   34: areturn
    //   35: aconst_null
    //   36: astore_1
    //   37: goto -6 -> 31
    //   40: astore_1
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_1
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	c
    //   30	7	1	localg	com.tencent.beacon.upload.g
    //   40	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	31	40	finally
  }
  
  /* Error */
  private f[] h()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 63	com/tencent/beacon/a/b/c:i	Ljava/util/List;
    //   6: ifnull +36 -> 42
    //   9: aload_0
    //   10: getfield 63	com/tencent/beacon/a/b/c:i	Ljava/util/List;
    //   13: invokeinterface 104 1 0
    //   18: ifle +24 -> 42
    //   21: aload_0
    //   22: getfield 63	com/tencent/beacon/a/b/c:i	Ljava/util/List;
    //   25: iconst_0
    //   26: anewarray 106	com/tencent/beacon/a/b/f
    //   29: invokeinterface 110 2 0
    //   34: checkcast 112	[Lcom/tencent/beacon/a/b/f;
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: areturn
    //   42: aconst_null
    //   43: astore_1
    //   44: goto -6 -> 38
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	c
    //   37	7	1	arrayOff	f[]
    //   47	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	38	47	finally
  }
  
  private SparseArray<g> i()
  {
    try
    {
      SparseArray localSparseArray = this.j;
      return localSparseArray;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(int paramInt)
  {
    try
    {
      this.d = paramInt;
      com.tencent.beacon.d.a.f("step:%d", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(int paramInt, g paramg)
  {
    if (paramg != null) {}
    try
    {
      if (this.j != null) {
        this.j.put(1, paramg);
      }
      return;
    }
    finally
    {
      paramg = finally;
      throw paramg;
    }
  }
  
  /* Error */
  public final void a(int paramInt, com.tencent.beacon.upload.g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 61	com/tencent/beacon/a/b/c:h	Landroid/util/SparseArray;
    //   6: ifnull +15 -> 21
    //   9: aload_2
    //   10: ifnonnull +14 -> 24
    //   13: aload_0
    //   14: getfield 61	com/tencent/beacon/a/b/c:h	Landroid/util/SparseArray;
    //   17: iload_1
    //   18: invokevirtual 137	android/util/SparseArray:remove	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 61	com/tencent/beacon/a/b/c:h	Landroid/util/SparseArray;
    //   28: iload_1
    //   29: aload_2
    //   30: invokevirtual 133	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   33: aload_2
    //   34: bipush 101
    //   36: aload_0
    //   37: invokevirtual 140	com/tencent/beacon/a/b/c:c	()Lcom/tencent/beacon/upload/f;
    //   40: invokeinterface 143 3 0
    //   45: pop
    //   46: goto -25 -> 21
    //   49: astore_2
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_2
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	c
    //   0	54	1	paramInt	int
    //   0	54	2	paramg	com.tencent.beacon.upload.g
    // Exception table:
    //   from	to	target	type
    //   2	9	49	finally
    //   13	21	49	finally
    //   24	46	49	finally
  }
  
  public final void a(int paramInt, Map<String, String> paramMap)
  {
    Object localObject = i();
    if (localObject != null)
    {
      localObject = (g)((SparseArray)localObject).get(paramInt);
      if (localObject != null) {
        ((g)localObject).a(paramMap);
      }
    }
  }
  
  public final void a(final b paramb)
  {
    if (paramb == null) {}
    for (;;)
    {
      return;
      try
      {
        if (this.g == null) {
          this.g = new ArrayList();
        }
        if (this.g.contains(paramb)) {
          continue;
        }
        this.g.add(paramb);
        final int k = f();
        if (d())
        {
          com.tencent.beacon.d.a.e("add listener should notify app first run! %s", new Object[] { paramb.toString() });
          com.tencent.beacon.a.d.a().a(new Runnable()
          {
            public final void run()
            {
              paramb.c();
            }
          });
        }
        if (k < 2) {
          continue;
        }
        com.tencent.beacon.d.a.e("add listener should notify app start query! %s", new Object[] { paramb.toString() });
        com.tencent.beacon.a.d.a().a(new Runnable()
        {
          public final void run()
          {
            paramb.a();
            if (k >= 3)
            {
              com.tencent.beacon.d.a.e("query finished should notify", new Object[0]);
              paramb.b();
            }
          }
        });
      }
      finally {}
    }
  }
  
  public final void a(e parame)
  {
    f[] arrayOff = h();
    if (arrayOff != null)
    {
      int m = arrayOff.length;
      int k = 0;
      for (;;)
      {
        if (k < m)
        {
          f localf = arrayOff[k];
          try
          {
            localf.a(parame);
            k += 1;
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              localThrowable.printStackTrace();
              com.tencent.beacon.d.a.d("com strategy changed error %s", new Object[] { localThrowable.toString() });
            }
          }
        }
      }
    }
  }
  
  public final void a(f paramf)
  {
    if (paramf != null) {}
    try
    {
      if ((this.i != null) && (!this.i.contains(paramf))) {
        this.i.add(paramf);
      }
      return;
    }
    finally
    {
      paramf = finally;
      throw paramf;
    }
  }
  
  protected final void a(boolean paramBoolean)
  {
    try
    {
      this.c = true;
      com.tencent.beacon.d.a.f("isFirst }%b", new Object[] { Boolean.valueOf(true) });
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final e b()
  {
    try
    {
      e locale = this.b;
      return locale;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final com.tencent.beacon.upload.f c()
  {
    try
    {
      com.tencent.beacon.upload.f localf = this.e;
      return localf;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean d()
  {
    try
    {
      boolean bool = this.c;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final b[] e()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 56	com/tencent/beacon/a/b/c:g	Ljava/util/List;
    //   6: ifnull +36 -> 42
    //   9: aload_0
    //   10: getfield 56	com/tencent/beacon/a/b/c:g	Ljava/util/List;
    //   13: invokeinterface 104 1 0
    //   18: ifle +24 -> 42
    //   21: aload_0
    //   22: getfield 56	com/tencent/beacon/a/b/c:g	Ljava/util/List;
    //   25: iconst_0
    //   26: anewarray 209	com/tencent/beacon/a/b/b
    //   29: invokeinterface 110 2 0
    //   34: checkcast 211	[Lcom/tencent/beacon/a/b/b;
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: areturn
    //   42: aconst_null
    //   43: astore_1
    //   44: goto -6 -> 38
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	c
    //   37	7	1	arrayOfb	b[]
    //   47	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	38	47	finally
  }
  
  public final int f()
  {
    try
    {
      int k = this.d;
      return k;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.beacon.a.b.c
 * JD-Core Version:    0.7.0.1
 */