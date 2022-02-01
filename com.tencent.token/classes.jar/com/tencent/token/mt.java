package com.tencent.token;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class mt
  extends ThreadPoolExecutor
{
  public final AtomicInteger a = new AtomicInteger(0);
  private final AtomicLong b = new AtomicLong(0L);
  private final AtomicLong c = new AtomicLong(0L);
  private long d = 1000L;
  
  public mt(int paramInt1, int paramInt2, TimeUnit paramTimeUnit, BlockingQueue paramBlockingQueue, ThreadFactory paramThreadFactory)
  {
    super(paramInt1, paramInt2, 60L, paramTimeUnit, paramBlockingQueue, paramThreadFactory, new b((byte)0));
  }
  
  public final void a()
  {
    if (b())
    {
      long l = this.c.longValue();
      if (this.d + l < System.currentTimeMillis())
      {
        if (!this.c.compareAndSet(l, System.currentTimeMillis() + 1L)) {
          return;
        }
        Thread.currentThread().setUncaughtExceptionHandler(new mu());
        throw new RuntimeException("Stopping thread to avoid potential memory leaks after a context was stopped.");
      }
    }
  }
  
  protected final void afterExecute(Runnable paramRunnable, Throwable paramThrowable)
  {
    this.a.decrementAndGet();
    if (paramThrowable == null) {
      a();
    }
  }
  
  public final boolean b()
  {
    return (this.d >= 0L) && ((Thread.currentThread() instanceof mv)) && (((mv)Thread.currentThread()).a < this.b.longValue());
  }
  
  public final void execute(Runnable paramRunnable)
  {
    super.execute(new a(paramRunnable));
  }
  
  protected final RunnableFuture newTaskFor(Runnable paramRunnable, Object paramObject)
  {
    return (RunnableFuture)paramRunnable;
  }
  
  protected final RunnableFuture newTaskFor(Callable paramCallable)
  {
    return (RunnableFuture)paramCallable;
  }
  
  public final Future submit(Runnable paramRunnable)
  {
    return super.submit(new a(paramRunnable));
  }
  
  public final class a
    extends FutureTask
    implements Comparable
  {
    public a()
    {
      super(null);
    }
  }
  
  static final class b
    implements RejectedExecutionHandler
  {
    public final void rejectedExecution(Runnable paramRunnable, ThreadPoolExecutor paramThreadPoolExecutor)
    {
      throw new RejectedExecutionException();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.mt
 * JD-Core Version:    0.7.0.1
 */