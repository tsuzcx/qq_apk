package com.tencent.hlyyb.common.a.a;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class d
  extends ThreadPoolExecutor
{
  private final AtomicInteger a = new AtomicInteger(0);
  private final AtomicLong b = new AtomicLong(0L);
  private final AtomicLong c = new AtomicLong(0L);
  private long d = 1000L;
  
  public d(int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit, BlockingQueue<Runnable> paramBlockingQueue, ThreadFactory paramThreadFactory)
  {
    super(0, paramInt2, 5L, paramTimeUnit, paramBlockingQueue, paramThreadFactory, new e((byte)0));
  }
  
  protected final void a()
  {
    if (b())
    {
      long l = this.c.longValue();
      if ((this.d + l < System.currentTimeMillis()) && (this.c.compareAndSet(l, System.currentTimeMillis() + 1L)))
      {
        Thread.currentThread().setUncaughtExceptionHandler(new f(this));
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
    return (this.d >= 0L) && ((Thread.currentThread() instanceof c)) && (((c)Thread.currentThread()).a() < this.b.longValue());
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
      b localb;
      while ((super.getQueue() instanceof b))
      {
        localb = (b)super.getQueue();
        try
        {
          if (!localb.a(paramRunnable, 0L, localTimeUnit))
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
      throw localb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.hlyyb.common.a.a.d
 * JD-Core Version:    0.7.0.1
 */