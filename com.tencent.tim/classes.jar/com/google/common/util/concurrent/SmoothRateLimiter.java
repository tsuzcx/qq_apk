package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.math.LongMath;
import java.util.concurrent.TimeUnit;

@GwtIncompatible
abstract class SmoothRateLimiter
  extends RateLimiter
{
  double maxPermits;
  private long nextFreeTicketMicros = 0L;
  double stableIntervalMicros;
  double storedPermits;
  
  private SmoothRateLimiter(RateLimiter.SleepingStopwatch paramSleepingStopwatch)
  {
    super(paramSleepingStopwatch);
  }
  
  abstract double coolDownIntervalMicros();
  
  final double doGetRate()
  {
    return TimeUnit.SECONDS.toMicros(1L) / this.stableIntervalMicros;
  }
  
  abstract void doSetRate(double paramDouble1, double paramDouble2);
  
  final void doSetRate(double paramDouble, long paramLong)
  {
    resync(paramLong);
    double d = TimeUnit.SECONDS.toMicros(1L) / paramDouble;
    this.stableIntervalMicros = d;
    doSetRate(paramDouble, d);
  }
  
  final long queryEarliestAvailable(long paramLong)
  {
    return this.nextFreeTicketMicros;
  }
  
  final long reserveEarliestAvailable(int paramInt, long paramLong)
  {
    resync(paramLong);
    paramLong = this.nextFreeTicketMicros;
    double d1 = Math.min(paramInt, this.storedPermits);
    double d2 = paramInt;
    long l1 = storedPermitsToWaitTime(this.storedPermits, d1);
    long l2 = ((d2 - d1) * this.stableIntervalMicros);
    this.nextFreeTicketMicros = LongMath.saturatedAdd(this.nextFreeTicketMicros, l2 + l1);
    this.storedPermits -= d1;
    return paramLong;
  }
  
  void resync(long paramLong)
  {
    if (paramLong > this.nextFreeTicketMicros)
    {
      double d = (paramLong - this.nextFreeTicketMicros) / coolDownIntervalMicros();
      this.storedPermits = Math.min(this.maxPermits, d + this.storedPermits);
      this.nextFreeTicketMicros = paramLong;
    }
  }
  
  abstract long storedPermitsToWaitTime(double paramDouble1, double paramDouble2);
  
  static final class SmoothBursty
    extends SmoothRateLimiter
  {
    final double maxBurstSeconds;
    
    SmoothBursty(RateLimiter.SleepingStopwatch paramSleepingStopwatch, double paramDouble)
    {
      super(null);
      this.maxBurstSeconds = paramDouble;
    }
    
    double coolDownIntervalMicros()
    {
      return this.stableIntervalMicros;
    }
    
    void doSetRate(double paramDouble1, double paramDouble2)
    {
      paramDouble2 = 0.0D;
      double d = this.maxPermits;
      this.maxPermits = (this.maxBurstSeconds * paramDouble1);
      if (d == (1.0D / 0.0D))
      {
        this.storedPermits = this.maxPermits;
        return;
      }
      if (d == 0.0D) {}
      for (paramDouble1 = paramDouble2;; paramDouble1 = this.storedPermits * this.maxPermits / d)
      {
        this.storedPermits = paramDouble1;
        return;
      }
    }
    
    long storedPermitsToWaitTime(double paramDouble1, double paramDouble2)
    {
      return 0L;
    }
  }
  
  static final class SmoothWarmingUp
    extends SmoothRateLimiter
  {
    private double coldFactor;
    private double slope;
    private double thresholdPermits;
    private final long warmupPeriodMicros;
    
    SmoothWarmingUp(RateLimiter.SleepingStopwatch paramSleepingStopwatch, long paramLong, TimeUnit paramTimeUnit, double paramDouble)
    {
      super(null);
      this.warmupPeriodMicros = paramTimeUnit.toMicros(paramLong);
      this.coldFactor = paramDouble;
    }
    
    private double permitsToTime(double paramDouble)
    {
      return this.stableIntervalMicros + this.slope * paramDouble;
    }
    
    double coolDownIntervalMicros()
    {
      return this.warmupPeriodMicros / this.maxPermits;
    }
    
    void doSetRate(double paramDouble1, double paramDouble2)
    {
      paramDouble1 = this.maxPermits;
      double d = this.coldFactor * paramDouble2;
      this.thresholdPermits = (0.5D * this.warmupPeriodMicros / paramDouble2);
      this.maxPermits = (this.thresholdPermits + 2.0D * this.warmupPeriodMicros / (paramDouble2 + d));
      this.slope = ((d - paramDouble2) / (this.maxPermits - this.thresholdPermits));
      if (paramDouble1 == (1.0D / 0.0D))
      {
        this.storedPermits = 0.0D;
        return;
      }
      if (paramDouble1 == 0.0D) {}
      for (paramDouble1 = this.maxPermits;; paramDouble1 = this.storedPermits * this.maxPermits / paramDouble1)
      {
        this.storedPermits = paramDouble1;
        return;
      }
    }
    
    long storedPermitsToWaitTime(double paramDouble1, double paramDouble2)
    {
      double d = paramDouble1 - this.thresholdPermits;
      long l = 0L;
      paramDouble1 = paramDouble2;
      if (d > 0.0D)
      {
        paramDouble1 = Math.min(d, paramDouble2);
        l = ((permitsToTime(d) + permitsToTime(d - paramDouble1)) * paramDouble1 / 2.0D);
        paramDouble1 = paramDouble2 - paramDouble1;
      }
      return (l + this.stableIntervalMicros * paramDouble1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.SmoothRateLimiter
 * JD-Core Version:    0.7.0.1
 */