package com.tencent.halley.downloader.d.a;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class h
  extends ThreadPoolExecutor
{
  private final AtomicInteger a = new AtomicInteger(0);
  private final AtomicLong b = new AtomicLong(0L);
  private final AtomicLong c = new AtomicLong(0L);
  private long d = 1000L;
  
  public h(int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit, BlockingQueue paramBlockingQueue, ThreadFactory paramThreadFactory)
  {
    super(1, paramInt2, 60L, paramTimeUnit, paramBlockingQueue, paramThreadFactory, new i((byte)0));
  }
  
  protected final void a()
  {
    if (b())
    {
      long l = this.c.longValue();
      if ((this.d + l < System.currentTimeMillis()) && (this.c.compareAndSet(l, System.currentTimeMillis() + 1L)))
      {
        Thread.currentThread().setUncaughtExceptionHandler(new j(this));
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
  
  protected final boolean b()
  {
    return (this.d >= 0L) && ((Thread.currentThread() instanceof g)) && (((g)Thread.currentThread()).a() < this.b.longValue());
  }
  
  public final int c()
  {
    return this.a.get();
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
      while ((super.getQueue() instanceof d))
      {
        locald = (d)super.getQueue();
        try
        {
          if (!locald.a(paramRunnable, 0L, localTimeUnit))
          {
            this.a.decrementAndGet();
            throw new RejectedExecutionException("Queue capacity is full.");
          }
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.downloader.d.a.h
 * JD-Core Version:    0.7.0.1
 */