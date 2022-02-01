package com.google.common.util.concurrent;

import java.util.concurrent.ScheduledExecutorService;

class AbstractScheduledService$1
  extends Service.Listener
{
  AbstractScheduledService$1(AbstractScheduledService paramAbstractScheduledService, ScheduledExecutorService paramScheduledExecutorService) {}
  
  public void failed(Service.State paramState, Throwable paramThrowable)
  {
    this.val$executor.shutdown();
  }
  
  public void terminated(Service.State paramState)
  {
    this.val$executor.shutdown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.AbstractScheduledService.1
 * JD-Core Version:    0.7.0.1
 */