package com.tencent.token;

import com.tencent.halley.downloader.d.a.d;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class mw
  extends ThreadPoolExecutor
{
  public final AtomicInteger a = new AtomicInteger(0);
  private final AtomicLong b = new AtomicLong(0L);
  private final AtomicLong c = new AtomicLong(0L);
  private long d = 1000L;
  
  public mw(int paramInt, TimeUnit paramTimeUnit, BlockingQueue paramBlockingQueue, ThreadFactory paramThreadFactory)
  {
    super(1, paramInt, 60L, paramTimeUnit, paramBlockingQueue, paramThreadFactory, new a((byte)0));
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
        Thread.currentThread().setUncaughtExceptionHandler(new mx());
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
    TimeUnit localTimeUnit = TimeUnit.MILLISECONDS;
    this.a.incrementAndGet();
    try
    {
      super.execute(paramRunnable);
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      d locald;
      if ((super.getQueue() instanceof d))
      {
        locald = (d)super.getQueue();
        try
        {
          if (locald.a(paramRunnable, localTimeUnit)) {
            return;
          }
          this.a.decrementAndGet();
          throw new RejectedExecutionException("Queue capacity is full.");
        }
        catch (InterruptedException paramRunnable)
        {
          this.a.decrementAndGet();
          Thread.interrupted();
          throw new RejectedExecutionException(paramRunnable);
        }
      }
      this.a.decrementAndGet();
      throw locald;
    }
  }
  
  static final class a
    implements RejectedExecutionHandler
  {
    public final void rejectedExecution(Runnable paramRunnable, ThreadPoolExecutor paramThreadPoolExecutor)
    {
      throw new RejectedExecutionException();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.mw
 * JD-Core Version:    0.7.0.1
 */