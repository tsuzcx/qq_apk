package com.google.common.util.concurrent;

final class ServiceManager$1
  extends ListenerCallQueue.Callback<ServiceManager.Listener>
{
  ServiceManager$1(String paramString)
  {
    super(paramString);
  }
  
  void call(ServiceManager.Listener paramListener)
  {
    paramListener.healthy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.ServiceManager.1
 * JD-Core Version:    0.7.0.1
 */