package com.tencent.feedback.proguard;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.feedback.common.b;
import com.tencent.feedback.upload.f;
import java.util.ArrayList;
import java.util.List;

public final class t
{
  private static t a = null;
  private w b = null;
  private boolean c = false;
  private int d = 0;
  private com.tencent.feedback.upload.e e = null;
  private Runnable f = null;
  private List<s> g = new ArrayList(5);
  private SparseArray<f> h = new SparseArray(5);
  private List<x> i = new ArrayList(5);
  
  private t(Context paramContext)
  {
    this.e = new r(paramContext);
    this.f = new u(paramContext);
    b.b().a(this.f);
  }
  
  public static t a(Context paramContext)
  {
    try
    {
      if ((a == null) && (paramContext != null)) {
        a = new t(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  /* Error */
  public static f a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 32	com/tencent/feedback/proguard/t:a	Lcom/tencent/feedback/proguard/t;
    //   6: ifnull +15 -> 21
    //   9: getstatic 32	com/tencent/feedback/proguard/t:a	Lcom/tencent/feedback/proguard/t;
    //   12: invokespecial 84	com/tencent/feedback/proguard/t:f	()Lcom/tencent/feedback/upload/f;
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
    //   15	8	0	localf	f
    //   26	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	16	26	finally
  }
  
  /* Error */
  private f f()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 59	com/tencent/feedback/proguard/t:h	Landroid/util/SparseArray;
    //   6: ifnull +29 -> 35
    //   9: aload_0
    //   10: getfield 59	com/tencent/feedback/proguard/t:h	Landroid/util/SparseArray;
    //   13: invokevirtual 88	android/util/SparseArray:size	()I
    //   16: ifle +19 -> 35
    //   19: aload_0
    //   20: getfield 59	com/tencent/feedback/proguard/t:h	Landroid/util/SparseArray;
    //   23: iconst_0
    //   24: invokevirtual 92	android/util/SparseArray:valueAt	(I)Ljava/lang/Object;
    //   27: checkcast 94	com/tencent/feedback/upload/f
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
    //   0	45	0	this	t
    //   30	7	1	localf	f
    //   40	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	31	40	finally
  }
  
  private boolean g()
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
  private x[] h()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 61	com/tencent/feedback/proguard/t:i	Ljava/util/List;
    //   6: ifnull +36 -> 42
    //   9: aload_0
    //   10: getfield 61	com/tencent/feedback/proguard/t:i	Ljava/util/List;
    //   13: invokeinterface 99 1 0
    //   18: ifle +24 -> 42
    //   21: aload_0
    //   22: getfield 61	com/tencent/feedback/proguard/t:i	Ljava/util/List;
    //   25: iconst_0
    //   26: anewarray 101	com/tencent/feedback/proguard/x
    //   29: invokeinterface 105 2 0
    //   34: checkcast 107	[Lcom/tencent/feedback/proguard/x;
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
    //   0	52	0	this	t
    //   37	7	1	arrayOfx	x[]
    //   47	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	38	47	finally
  }
  
  public final void a(int paramInt)
  {
    try
    {
      this.d = paramInt;
      com.tencent.feedback.common.e.f("rqdp{  step }%d", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final void a(int paramInt, f paramf)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 59	com/tencent/feedback/proguard/t:h	Landroid/util/SparseArray;
    //   6: ifnull +15 -> 21
    //   9: aload_2
    //   10: ifnonnull +14 -> 24
    //   13: aload_0
    //   14: getfield 59	com/tencent/feedback/proguard/t:h	Landroid/util/SparseArray;
    //   17: iload_1
    //   18: invokevirtual 124	android/util/SparseArray:remove	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 59	com/tencent/feedback/proguard/t:h	Landroid/util/SparseArray;
    //   28: iload_1
    //   29: aload_2
    //   30: invokevirtual 128	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   33: aload_2
    //   34: sipush 300
    //   37: aload_0
    //   38: invokevirtual 131	com/tencent/feedback/proguard/t:c	()Lcom/tencent/feedback/upload/e;
    //   41: invokeinterface 134 3 0
    //   46: pop
    //   47: goto -26 -> 21
    //   50: astore_2
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_2
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	t
    //   0	55	1	paramInt	int
    //   0	55	2	paramf	f
    // Exception table:
    //   from	to	target	type
    //   2	9	50	finally
    //   13	21	50	finally
    //   24	47	50	finally
  }
  
  public final void a(final s params)
  {
    if (params == null) {}
    for (;;)
    {
      return;
      try
      {
        if (this.g == null) {
          this.g = new ArrayList();
        }
        if (this.g.contains(params)) {
          continue;
        }
        this.g.add(params);
        final int j = e();
        if (g())
        {
          com.tencent.feedback.common.e.e("rqdp{  add listener should notify app first run! }%s", new Object[] { params.toString() });
          b.b().a(new Runnable()
          {
            public final void run()
            {
              params.f();
            }
          });
        }
        if (j < 2) {
          continue;
        }
        com.tencent.feedback.common.e.e("rqdp{  add listener should notify app start query!} %s", new Object[] { params.toString() });
        b.b().a(new Runnable()
        {
          public final void run()
          {
            params.d();
            if (j >= 3)
            {
              com.tencent.feedback.common.e.e("rqdp{  query finished should notify}", new Object[0]);
              params.e();
            }
          }
        });
      }
      finally {}
    }
  }
  
  public final void a(w paramw)
  {
    x[] arrayOfx = h();
    if (arrayOfx != null)
    {
      int k = arrayOfx.length;
      int j = 0;
      for (;;)
      {
        if (j < k)
        {
          x localx = arrayOfx[j];
          try
          {
            localx.a(paramw);
            j += 1;
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              localThrowable.printStackTrace();
              com.tencent.feedback.common.e.d("rqdp{  com strategy changed error }%s", new Object[] { localThrowable.toString() });
            }
          }
        }
      }
    }
  }
  
  public final void a(x paramx)
  {
    if (paramx != null) {}
    try
    {
      if ((this.i != null) && (!this.i.contains(paramx))) {
        this.i.add(paramx);
      }
      return;
    }
    finally
    {
      paramx = finally;
      throw paramx;
    }
  }
  
  protected final void a(boolean paramBoolean)
  {
    try
    {
      this.c = true;
      com.tencent.feedback.common.e.f("rqdp{  isFirst }%b", new Object[] { Boolean.valueOf(true) });
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final w b()
  {
    try
    {
      w localw = this.b;
      return localw;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final com.tencent.feedback.upload.e c()
  {
    try
    {
      com.tencent.feedback.upload.e locale = this.e;
      return locale;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final s[] d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 54	com/tencent/feedback/proguard/t:g	Ljava/util/List;
    //   6: ifnull +36 -> 42
    //   9: aload_0
    //   10: getfield 54	com/tencent/feedback/proguard/t:g	Ljava/util/List;
    //   13: invokeinterface 99 1 0
    //   18: ifle +24 -> 42
    //   21: aload_0
    //   22: getfield 54	com/tencent/feedback/proguard/t:g	Ljava/util/List;
    //   25: iconst_0
    //   26: anewarray 191	com/tencent/feedback/proguard/s
    //   29: invokeinterface 105 2 0
    //   34: checkcast 193	[Lcom/tencent/feedback/proguard/s;
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
    //   0	52	0	this	t
    //   37	7	1	arrayOfs	s[]
    //   47	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	38	47	finally
  }
  
  public final int e()
  {
    try
    {
      int j = this.d;
      return j;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.t
 * JD-Core Version:    0.7.0.1
 */