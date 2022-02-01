package com.google.common.util.concurrent;

import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

final class AbstractScheduledService$Scheduler$1
  extends AbstractScheduledService.Scheduler
{
  AbstractScheduledService$Scheduler$1(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    super(null);
  }
  
  public Future<?> schedule(AbstractService paramAbstractService, ScheduledExecutorService paramScheduledExecutorService, Runnable paramRunnable)
  {
    return paramScheduledExecutorService.scheduleWithFixedDelay(paramRunnable, this.val$initialDelay, this.val$delay, this.val$unit);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.AbstractScheduledService.Scheduler.1
 * JD-Core Version:    0.7.0.1
 */