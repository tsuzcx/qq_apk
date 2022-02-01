package com.google.common.util.concurrent;

final class AbstractService$4
  extends ListenerCallQueue.Callback<Service.Listener>
{
  AbstractService$4(String paramString, Service.State paramState)
  {
    super(paramString);
  }
  
  void call(Service.Listener paramListener)
  {
    paramListener.stopping(this.val$from);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.AbstractService.4
 * JD-Core Version:    0.7.0.1
 */