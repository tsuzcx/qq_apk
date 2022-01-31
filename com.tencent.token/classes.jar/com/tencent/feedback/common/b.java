package com.tencent.feedback.common;

import android.util.SparseArray;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public abstract class b
{
  private static b a;
  
  public static b a(ScheduledExecutorService paramScheduledExecutorService)
  {
    return new a(paramScheduledExecutorService);
  }
  
  public static void a(b paramb)
  {
    try
    {
      e.a("rqdp{  AsyncTaskHandlerAbs setInstance} " + paramb, new Object[0]);
      if ((a != null) && (a != paramb)) {
        a.a();
      }
      a = paramb;
      e.a("rqdp{  AsyncTaskHandlerAbs setInstance end}", new Object[0]);
      return;
    }
    finally {}
  }
  
  public static b b()
  {
    try
    {
      if (a == null) {
        a = new a();
      }
      b localb = a;
      return localb;
    }
    finally {}
  }
  
  public abstract boolean a();
  
  public abstract boolean a(Runnable paramRunnable);
  
  public abstract boolean a(Runnable paramRunnable, long paramLong);
  
  static final class a
    extends b
  {
    private ScheduledExecutorService a = null;
    private SparseArray<ScheduledFuture<?>> b = null;
    
    public a()
    {
      this(Executors.newScheduledThreadPool(3));
    }
    
    public a(ScheduledExecutorService paramScheduledExecutorService)
    {
      if ((paramScheduledExecutorService == null) || (paramScheduledExecutorService.isShutdown())) {
        throw new IllegalArgumentException("ScheduledExecutorService is not valiable!");
      }
      this.a = paramScheduledExecutorService;
      this.b = new SparseArray();
    }
    
    /* Error */
    private boolean c()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 25	com/tencent/feedback/common/b$a:a	Ljava/util/concurrent/ScheduledExecutorService;
      //   6: ifnull +23 -> 29
      //   9: aload_0
      //   10: getfield 25	com/tencent/feedback/common/b$a:a	Ljava/util/concurrent/ScheduledExecutorService;
      //   13: invokeinterface 33 1 0
      //   18: istore_1
      //   19: iload_1
      //   20: ifne +9 -> 29
      //   23: iconst_1
      //   24: istore_1
      //   25: aload_0
      //   26: monitorexit
      //   27: iload_1
      //   28: ireturn
      //   29: iconst_0
      //   30: istore_1
      //   31: goto -6 -> 25
      //   34: astore_2
      //   35: aload_0
      //   36: monitorexit
      //   37: aload_2
      //   38: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	39	0	this	a
      //   18	13	1	bool	boolean
      //   34	4	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	19	34	finally
    }
    
    /* Error */
    public final boolean a()
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_1
      //   2: aload_0
      //   3: monitorenter
      //   4: ldc 46
      //   6: iconst_0
      //   7: anewarray 48	java/lang/Object
      //   10: invokestatic 53	com/tencent/feedback/common/e:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
      //   13: pop
      //   14: aload_0
      //   15: invokespecial 55	com/tencent/feedback/common/b$a:c	()Z
      //   18: ifne +17 -> 35
      //   21: ldc 57
      //   23: iconst_0
      //   24: anewarray 48	java/lang/Object
      //   27: invokestatic 60	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
      //   30: pop
      //   31: aload_0
      //   32: monitorexit
      //   33: iload_1
      //   34: ireturn
      //   35: ldc 62
      //   37: iconst_0
      //   38: anewarray 48	java/lang/Object
      //   41: invokestatic 64	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
      //   44: pop
      //   45: aload_0
      //   46: getfield 25	com/tencent/feedback/common/b$a:a	Ljava/util/concurrent/ScheduledExecutorService;
      //   49: invokeinterface 67 1 0
      //   54: aload_0
      //   55: aconst_null
      //   56: putfield 25	com/tencent/feedback/common/b$a:a	Ljava/util/concurrent/ScheduledExecutorService;
      //   59: aload_0
      //   60: getfield 27	com/tencent/feedback/common/b$a:b	Landroid/util/SparseArray;
      //   63: invokevirtual 70	android/util/SparseArray:clear	()V
      //   66: aload_0
      //   67: aconst_null
      //   68: putfield 27	com/tencent/feedback/common/b$a:b	Landroid/util/SparseArray;
      //   71: ldc 72
      //   73: iconst_0
      //   74: anewarray 48	java/lang/Object
      //   77: invokestatic 53	com/tencent/feedback/common/e:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
      //   80: pop
      //   81: iconst_1
      //   82: istore_1
      //   83: goto -52 -> 31
      //   86: astore_2
      //   87: aload_0
      //   88: monitorexit
      //   89: aload_2
      //   90: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	91	0	this	a
      //   1	82	1	bool	boolean
      //   86	4	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   4	31	86	finally
      //   35	81	86	finally
    }
    
    public final boolean a(Runnable paramRunnable)
    {
      boolean bool = false;
      for (;;)
      {
        try
        {
          if (!c())
          {
            e.d("rqdp{  ScheduleTaskHandlerImp was closed , should not post!}", new Object[0]);
            return bool;
          }
          if (paramRunnable == null)
          {
            e.d("rqdp{  task runner should not be null}", new Object[0]);
            continue;
          }
          this.a.execute(paramRunnable);
        }
        finally {}
        bool = true;
      }
    }
    
    public final boolean a(Runnable paramRunnable, long paramLong)
    {
      boolean bool = false;
      try
      {
        if (!c()) {
          e.d("rqdp{  ScheduleTaskHandlerImp was closed , should not post!}", new Object[0]);
        }
        for (;;)
        {
          return bool;
          if (paramRunnable != null) {
            break;
          }
          e.d("rqdp{  task runner should not be null}", new Object[0]);
        }
        if (paramLong <= 0L) {}
      }
      finally {}
      for (;;)
      {
        this.a.schedule(paramRunnable, paramLong, TimeUnit.MILLISECONDS);
        bool = true;
        break;
        paramLong = 0L;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.common.b
 * JD-Core Version:    0.7.0.1
 */