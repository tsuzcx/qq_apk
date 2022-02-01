package com.google.common.util.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

class MoreExecutors$Application$1
  implements Runnable
{
  MoreExecutors$Application$1(MoreExecutors.Application paramApplication, ExecutorService paramExecutorService, long paramLong, TimeUnit paramTimeUnit) {}
  
  public void run()
  {
    try
    {
      this.val$service.shutdown();
      this.val$service.awaitTermination(this.val$terminationTimeout, this.val$timeUnit);
      return;
    }
    catch (InterruptedException localInterruptedException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.MoreExecutors.Application.1
 * JD-Core Version:    0.7.0.1
 */