package com.google.common.util.concurrent;

class AbstractIdleService$DelegateService$2
  implements Runnable
{
  AbstractIdleService$DelegateService$2(AbstractIdleService.DelegateService paramDelegateService) {}
  
  public void run()
  {
    try
    {
      this.this$1.this$0.shutDown();
      this.this$1.notifyStopped();
      return;
    }
    catch (Throwable localThrowable)
    {
      this.this$1.notifyFailed(localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.AbstractIdleService.DelegateService.2
 * JD-Core Version:    0.7.0.1
 */