package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

@GwtIncompatible
@CanIgnoreReturnValue
abstract class WrappingScheduledExecutorService
  extends WrappingExecutorService
  implements ScheduledExecutorService
{
  final ScheduledExecutorService delegate;
  
  protected WrappingScheduledExecutorService(ScheduledExecutorService paramScheduledExecutorService)
  {
    super(paramScheduledExecutorService);
    this.delegate = paramScheduledExecutorService;
  }
  
  public final ScheduledFuture<?> schedule(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
  {
    return this.delegate.schedule(wrapTask(paramRunnable), paramLong, paramTimeUnit);
  }
  
  public final <V> ScheduledFuture<V> schedule(Callable<V> paramCallable, long paramLong, TimeUnit paramTimeUnit)
  {
    return this.delegate.schedule(wrapTask(paramCallable), paramLong, paramTimeUnit);
  }
  
  public final ScheduledFuture<?> scheduleAtFixedRate(Runnable paramRunnable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    return this.delegate.scheduleAtFixedRate(wrapTask(paramRunnable), paramLong1, paramLong2, paramTimeUnit);
  }
  
  public final ScheduledFuture<?> scheduleWithFixedDelay(Runnable paramRunnable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    return this.delegate.scheduleWithFixedDelay(wrapTask(paramRunnable), paramLong1, paramLong2, paramTimeUnit);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.WrappingScheduledExecutorService
 * JD-Core Version:    0.7.0.1
 */