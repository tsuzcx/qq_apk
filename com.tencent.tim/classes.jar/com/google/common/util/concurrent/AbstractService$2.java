package com.google.common.util.concurrent;

final class AbstractService$2
  extends ListenerCallQueue.Callback<Service.Listener>
{
  AbstractService$2(String paramString)
  {
    super(paramString);
  }
  
  void call(Service.Listener paramListener)
  {
    paramListener.running();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.AbstractService.2
 * JD-Core Version:    0.7.0.1
 */