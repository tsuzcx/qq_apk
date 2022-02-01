package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.ThreadSafe;

@Beta
@GwtIncompatible
@ThreadSafe
public abstract class RateLimiter
{
  private volatile Object mutexDoNotUseDirectly;
  private final SleepingStopwatch stopwatch;
  
  RateLimiter(SleepingStopwatch paramSleepingStopwatch)
  {
    this.stopwatch = ((SleepingStopwatch)Preconditions.checkNotNull(paramSleepingStopwatch));
  }
  
  private boolean canAcquire(long paramLong1, long paramLong2)
  {
    return queryEarliestAvailable(paramLong1) - paramLong2 <= paramLong1;
  }
  
  private static void checkPermits(int paramInt)
  {
    if (paramInt > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "Requested permits (%s) must be positive", paramInt);
      return;
    }
  }
  
  public static RateLimiter create(double paramDouble)
  {
    return create(SleepingStopwatch.createFromSystemTimer(), paramDouble);
  }
  
  public static RateLimiter create(double paramDouble, long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramLong >= 0L) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "warmupPeriod must not be negative: %s", paramLong);
      return create(SleepingStopwatch.createFromSystemTimer(), paramDouble, paramLong, paramTimeUnit, 3.0D);
    }
  }
  
  @VisibleForTesting
  static RateLimiter create(SleepingStopwatch paramSleepingStopwatch, double paramDouble)
  {
    paramSleepingStopwatch = new SmoothRateLimiter.SmoothBursty(paramSleepingStopwatch, 1.0D);
    paramSleepingStopwatch.setRate(paramDouble);
    return paramSleepingStopwatch;
  }
  
  @VisibleForTesting
  static RateLimiter create(SleepingStopwatch paramSleepingStopwatch, double paramDouble1, long paramLong, TimeUnit paramTimeUnit, double paramDouble2)
  {
    paramSleepingStopwatch = new SmoothRateLimiter.SmoothWarmingUp(paramSleepingStopwatch, paramLong, paramTimeUnit, paramDouble2);
    paramSleepingStopwatch.setRate(paramDouble1);
    return paramSleepingStopwatch;
  }
  
  private Object mutex()
  {
    Object localObject1 = this.mutexDoNotUseDirectly;
    if (localObject1 == null) {
      try
      {
        Object localObject3 = this.mutexDoNotUseDirectly;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          localObject1 = new Object();
          this.mutexDoNotUseDirectly = localObject1;
        }
        return localObject1;
      }
      finally {}
    }
    return localObject2;
  }
  
  @CanIgnoreReturnValue
  public double acquire()
  {
    return acquire(1);
  }
  
  @CanIgnoreReturnValue
  public double acquire(int paramInt)
  {
    long l = reserve(paramInt);
    this.stopwatch.sleepMicrosUninterruptibly(l);
    return l * 1.0D / TimeUnit.SECONDS.toMicros(1L);
  }
  
  abstract double doGetRate();
  
  abstract void doSetRate(double paramDouble, long paramLong);
  
  public final double getRate()
  {
    synchronized (mutex())
    {
      double d = doGetRate();
      return d;
    }
  }
  
  abstract long queryEarliestAvailable(long paramLong);
  
  final long reserve(int paramInt)
  {
    checkPermits(paramInt);
    synchronized (mutex())
    {
      long l = reserveAndGetWaitLength(paramInt, this.stopwatch.readMicros());
      return l;
    }
  }
  
  final long reserveAndGetWaitLength(int paramInt, long paramLong)
  {
    return Math.max(reserveEarliestAvailable(paramInt, paramLong) - paramLong, 0L);
  }
  
  abstract long reserveEarliestAvailable(int paramInt, long paramLong);
  
  public final void setRate(double paramDouble)
  {
    if ((paramDouble > 0.0D) && (!Double.isNaN(paramDouble))) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "rate must be positive");
      synchronized (mutex())
      {
        doSetRate(paramDouble, this.stopwatch.readMicros());
        return;
      }
    }
  }
  
  public String toString()
  {
    return String.format(Locale.ROOT, "RateLimiter[stableRate=%3.1fqps]", new Object[] { Double.valueOf(getRate()) });
  }
  
  public boolean tryAcquire()
  {
    return tryAcquire(1, 0L, TimeUnit.MICROSECONDS);
  }
  
  public boolean tryAcquire(int paramInt)
  {
    return tryAcquire(paramInt, 0L, TimeUnit.MICROSECONDS);
  }
  
  public boolean tryAcquire(int paramInt, long paramLong, TimeUnit arg4)
  {
    paramLong = Math.max(???.toMicros(paramLong), 0L);
    checkPermits(paramInt);
    synchronized (mutex())
    {
      long l = this.stopwatch.readMicros();
      if (!canAcquire(l, paramLong)) {
        return false;
      }
      paramLong = reserveAndGetWaitLength(paramInt, l);
      this.stopwatch.sleepMicrosUninterruptibly(paramLong);
      return true;
    }
  }
  
  public boolean tryAcquire(long paramLong, TimeUnit paramTimeUnit)
  {
    return tryAcquire(1, paramLong, paramTimeUnit);
  }
  
  static abstract class SleepingStopwatch
  {
    public static final SleepingStopwatch createFromSystemTimer()
    {
      return new RateLimiter.SleepingStopwatch.1();
    }
    
    protected abstract long readMicros();
    
    protected abstract void sleepMicrosUninterruptibly(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.RateLimiter
 * JD-Core Version:    0.7.0.1
 */