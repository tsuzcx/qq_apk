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
      StringBuilder localStringBuilder = new StringBuilder("rqdp{  AsyncTaskHandlerAbs setInstance} ");
      localStringBuilder.append(paramb);
      e.a(localStringBuilder.toString(), new Object[0]);
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
      if ((paramScheduledExecutorService != null) && (!paramScheduledExecutorService.isShutdown()))
      {
        this.a = paramScheduledExecutorService;
        this.b = new SparseArray();
        return;
      }
      throw new IllegalArgumentException("ScheduledExecutorService is not valiable!");
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
    
    public final boolean a()
    {
      try
      {
        e.a("rqdp{  stopAllScheduleTasks start}", new Object[0]);
        if (!c())
        {
          e.d("rqdp{  ScheduleTaskHandlerImp was closed , should all stopped!}", new Object[0]);
          return false;
        }
        e.b("rqdp{  stop All ScheduleTasks!}", new Object[0]);
        this.a.shutdown();
        this.a = null;
        this.b.clear();
        this.b = null;
        e.a("rqdp{  stopAllScheduleTasks end}", new Object[0]);
        return true;
      }
      finally {}
    }
    
    public final boolean a(Runnable paramRunnable)
    {
      try
      {
        if (!c())
        {
          e.d("rqdp{  ScheduleTaskHandlerImp was closed , should not post!}", new Object[0]);
          return false;
        }
        if (paramRunnable == null)
        {
          e.d("rqdp{  task runner should not be null}", new Object[0]);
          return false;
        }
        this.a.execute(paramRunnable);
        return true;
      }
      finally {}
    }
    
    public final boolean a(Runnable paramRunnable, long paramLong)
    {
      try
      {
        if (!c())
        {
          e.d("rqdp{  ScheduleTaskHandlerImp was closed , should not post!}", new Object[0]);
          return false;
        }
        if (paramRunnable == null)
        {
          e.d("rqdp{  task runner should not be null}", new Object[0]);
          return false;
        }
        if (paramLong <= 0L) {
          paramLong = 0L;
        }
        this.a.schedule(paramRunnable, paramLong, TimeUnit.MILLISECONDS);
        return true;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.common.b
 * JD-Core Version:    0.7.0.1
 */