package com.google.common.util.concurrent;

import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;

class AbstractScheduledService$ServiceDelegate$2
  implements Runnable
{
  AbstractScheduledService$ServiceDelegate$2(AbstractScheduledService.ServiceDelegate paramServiceDelegate) {}
  
  public void run()
  {
    AbstractScheduledService.ServiceDelegate.access$200(this.this$1).lock();
    try
    {
      this.this$1.this$0.startUp();
      AbstractScheduledService.ServiceDelegate.access$302(this.this$1, this.this$1.this$0.scheduler().schedule(AbstractScheduledService.access$500(this.this$1.this$0), AbstractScheduledService.ServiceDelegate.access$600(this.this$1), AbstractScheduledService.ServiceDelegate.access$700(this.this$1)));
      this.this$1.notifyStarted();
      return;
    }
    catch (Throwable localThrowable)
    {
      this.this$1.notifyFailed(localThrowable);
      if (AbstractScheduledService.ServiceDelegate.access$300(this.this$1) != null) {
        AbstractScheduledService.ServiceDelegate.access$300(this.this$1).cancel(false);
      }
      return;
    }
    finally
    {
      AbstractScheduledService.ServiceDelegate.access$200(this.this$1).unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.AbstractScheduledService.ServiceDelegate.2
 * JD-Core Version:    0.7.0.1
 */