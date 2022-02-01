package com.google.common.util.concurrent;

final class ServiceManager$2
  extends ListenerCallQueue.Callback<ServiceManager.Listener>
{
  ServiceManager$2(String paramString)
  {
    super(paramString);
  }
  
  void call(ServiceManager.Listener paramListener)
  {
    paramListener.stopped();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.ServiceManager.2
 * JD-Core Version:    0.7.0.1
 */