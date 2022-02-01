package com.google.common.util.concurrent;

class AbstractIdleService$DelegateService$1
  implements Runnable
{
  AbstractIdleService$DelegateService$1(AbstractIdleService.DelegateService paramDelegateService) {}
  
  public void run()
  {
    try
    {
      this.this$1.this$0.startUp();
      this.this$1.notifyStarted();
      return;
    }
    catch (Throwable localThrowable)
    {
      this.this$1.notifyFailed(localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.AbstractIdleService.DelegateService.1
 * JD-Core Version:    0.7.0.1
 */