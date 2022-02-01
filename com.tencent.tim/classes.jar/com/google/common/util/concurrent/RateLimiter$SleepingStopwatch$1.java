package com.google.common.util.concurrent;

import com.google.common.base.Stopwatch;
import java.util.concurrent.TimeUnit;

final class RateLimiter$SleepingStopwatch$1
  extends RateLimiter.SleepingStopwatch
{
  final Stopwatch stopwatch = Stopwatch.createStarted();
  
  protected long readMicros()
  {
    return this.stopwatch.elapsed(TimeUnit.MICROSECONDS);
  }
  
  protected void sleepMicrosUninterruptibly(long paramLong)
  {
    if (paramLong > 0L) {
      Uninterruptibles.sleepUninterruptibly(paramLong, TimeUnit.MICROSECONDS);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.RateLimiter.SleepingStopwatch.1
 * JD-Core Version:    0.7.0.1
 */