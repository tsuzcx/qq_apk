package com.tencent.feedback.common;

import android.util.SparseArray;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public abstract class b
{
  public static boolean a = true;
  private static b b;
  
  public static b a(ScheduledExecutorService paramScheduledExecutorService)
  {
    return new a(paramScheduledExecutorService);
  }
  
  public static void a(b paramb)
  {
    try
    {
      e.a("rqdp{  AsyncTaskHandlerAbs setInstance} " + paramb, new Object[0]);
      if ((b != null) && (b != paramb)) {
        b.a();
      }
      b = paramb;
      e.a("rqdp{  AsyncTaskHandlerAbs setInstance end}", new Object[0]);
      return;
    }
    finally {}
  }
  
  public static b b()
  {
    try
    {
      if (b == null) {
        b = new a();
      }
      b localb = b;
      return localb;
    }
    finally {}
  }
  
  public abstract boolean a();
  
  public abstract boolean a(int paramInt, Runnable paramRunnable, long paramLong1, long paramLong2);
  
  public abstract boolean a(int paramInt, boolean paramBoolean);
  
  public abstract boolean a(Runnable paramRunnable);
  
  public abstract boolean a(Runnable paramRunnable, long paramLong);
  
  static final class a
    extends b
  {
    private ScheduledExecutorService b = null;
    private SparseArray<ScheduledFuture<?>> c = null;
    
    public a()
    {
      this(Executors.newScheduledThreadPool(3));
    }
    
    public a(ScheduledExecutorService paramScheduledExecutorService)
    {
      if ((paramScheduledExecutorService == null) || (paramScheduledExecutorService.isShutdown())) {
        throw new IllegalArgumentException("ScheduledExecutorService is not valiable!");
      }
      this.b = paramScheduledExecutorService;
      this.c = new SparseArray();
    }
    
    /* Error */
    private boolean c()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 26	com/tencent/feedback/common/b$a:b	Ljava/util/concurrent/ScheduledExecutorService;
      //   6: ifnull +23 -> 29
      //   9: aload_0
      //   10: getfield 26	com/tencent/feedback/common/b$a:b	Ljava/util/concurrent/ScheduledExecutorService;
      //   13: invokeinterface 34 1 0
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
      //   10: invokestatic 53	com/tencent/feedback/common/e:a	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   13: aload_0
      //   14: invokespecial 55	com/tencent/feedback/common/b$a:c	()Z
      //   17: ifne +16 -> 33
      //   20: ldc 57
      //   22: iconst_0
      //   23: anewarray 48	java/lang/Object
      //   26: invokestatic 60	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   29: aload_0
      //   30: monitorexit
      //   31: iload_1
      //   32: ireturn
      //   33: ldc 62
      //   35: iconst_0
      //   36: anewarray 48	java/lang/Object
      //   39: invokestatic 64	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   42: aload_0
      //   43: getfield 26	com/tencent/feedback/common/b$a:b	Ljava/util/concurrent/ScheduledExecutorService;
      //   46: invokeinterface 67 1 0
      //   51: aload_0
      //   52: aconst_null
      //   53: putfield 26	com/tencent/feedback/common/b$a:b	Ljava/util/concurrent/ScheduledExecutorService;
      //   56: aload_0
      //   57: getfield 28	com/tencent/feedback/common/b$a:c	Landroid/util/SparseArray;
      //   60: invokevirtual 70	android/util/SparseArray:clear	()V
      //   63: aload_0
      //   64: aconst_null
      //   65: putfield 28	com/tencent/feedback/common/b$a:c	Landroid/util/SparseArray;
      //   68: ldc 72
      //   70: iconst_0
      //   71: anewarray 48	java/lang/Object
      //   74: invokestatic 53	com/tencent/feedback/common/e:a	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   77: iconst_1
      //   78: istore_1
      //   79: goto -50 -> 29
      //   82: astore_2
      //   83: aload_0
      //   84: monitorexit
      //   85: aload_2
      //   86: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	87	0	this	a
      //   1	78	1	bool	boolean
      //   82	4	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   4	29	82	finally
      //   33	77	82	finally
    }
    
    public final boolean a(int paramInt, Runnable paramRunnable, long paramLong1, long paramLong2)
    {
      for (;;)
      {
        try
        {
          boolean bool;
          if (!c())
          {
            e.d("rqdp{  ScheduleTaskHandlerImp was closed , should not post!}", new Object[0]);
            bool = false;
            return bool;
          }
          if (paramRunnable == null)
          {
            e.d("rqdp{  task runner should not be null}", new Object[0]);
            bool = false;
            continue;
          }
          if (a) {
            if (paramLong2 > 10000L)
            {
              break label150;
              a(19, true);
              paramRunnable = this.b.scheduleAtFixedRate(paramRunnable, 0L, paramLong1, TimeUnit.MILLISECONDS);
              if (paramRunnable != null)
              {
                e.b("rqdp{  add a new future! taskId} %d ,rqdp{   periodTime} %d", new Object[] { Integer.valueOf(19), Long.valueOf(paramLong1) });
                this.c.put(19, paramRunnable);
              }
              bool = true;
            }
            else
            {
              paramLong2 = 10000L;
            }
          }
        }
        finally {}
        paramLong1 = paramLong2;
        continue;
        label150:
        paramLong1 = paramLong2;
      }
    }
    
    /* Error */
    public final boolean a(int paramInt, boolean paramBoolean)
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_2
      //   2: aload_0
      //   3: monitorenter
      //   4: aload_0
      //   5: invokespecial 55	com/tencent/feedback/common/b$a:c	()Z
      //   8: ifne +16 -> 24
      //   11: ldc 114
      //   13: iconst_0
      //   14: anewarray 48	java/lang/Object
      //   17: invokestatic 60	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   20: aload_0
      //   21: monitorexit
      //   22: iload_2
      //   23: ireturn
      //   24: aload_0
      //   25: getfield 28	com/tencent/feedback/common/b$a:c	Landroid/util/SparseArray;
      //   28: iload_1
      //   29: invokevirtual 118	android/util/SparseArray:get	(I)Ljava/lang/Object;
      //   32: checkcast 120	java/util/concurrent/ScheduledFuture
      //   35: astore_3
      //   36: aload_3
      //   37: ifnull +29 -> 66
      //   40: aload_3
      //   41: invokeinterface 123 1 0
      //   46: ifne +20 -> 66
      //   49: ldc 125
      //   51: iconst_0
      //   52: anewarray 48	java/lang/Object
      //   55: invokestatic 64	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   58: aload_3
      //   59: iconst_1
      //   60: invokeinterface 129 2 0
      //   65: pop
      //   66: aload_0
      //   67: getfield 28	com/tencent/feedback/common/b$a:c	Landroid/util/SparseArray;
      //   70: iload_1
      //   71: invokevirtual 133	android/util/SparseArray:remove	(I)V
      //   74: iconst_1
      //   75: istore_2
      //   76: goto -56 -> 20
      //   79: astore_3
      //   80: aload_0
      //   81: monitorexit
      //   82: aload_3
      //   83: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	84	0	this	a
      //   0	84	1	paramInt	int
      //   0	84	2	paramBoolean	boolean
      //   35	24	3	localScheduledFuture	ScheduledFuture
      //   79	4	3	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   4	20	79	finally
      //   24	36	79	finally
      //   40	66	79	finally
      //   66	74	79	finally
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
          this.b.execute(paramRunnable);
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
        this.b.schedule(paramRunnable, paramLong, TimeUnit.MILLISECONDS);
        bool = true;
        break;
        paramLong = 0L;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.feedback.common.b
 * JD-Core Version:    0.7.0.1
 */