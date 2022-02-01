package com.google.common.util.concurrent;

class AbstractService$5
  extends ListenerCallQueue.Callback<Service.Listener>
{
  AbstractService$5(AbstractService paramAbstractService, String paramString, Service.State paramState, Throwable paramThrowable)
  {
    super(paramString);
  }
  
  void call(Service.Listener paramListener)
  {
    paramListener.failed(this.val$from, this.val$cause);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.AbstractService.5
 * JD-Core Version:    0.7.0.1
 */