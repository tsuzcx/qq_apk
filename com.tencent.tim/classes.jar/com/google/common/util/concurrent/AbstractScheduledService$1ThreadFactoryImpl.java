package com.google.common.util.concurrent;

import java.util.concurrent.ThreadFactory;

class AbstractScheduledService$1ThreadFactoryImpl
  implements ThreadFactory
{
  AbstractScheduledService$1ThreadFactoryImpl(AbstractScheduledService paramAbstractScheduledService) {}
  
  public Thread newThread(Runnable paramRunnable)
  {
    return MoreExecutors.newThread(this.this$0.serviceName(), paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.AbstractScheduledService.1ThreadFactoryImpl
 * JD-Core Version:    0.7.0.1
 */