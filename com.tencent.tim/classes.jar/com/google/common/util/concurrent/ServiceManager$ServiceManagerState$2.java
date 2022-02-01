package com.google.common.util.concurrent;

class ServiceManager$ServiceManagerState$2
  extends ListenerCallQueue.Callback<ServiceManager.Listener>
{
  ServiceManager$ServiceManagerState$2(ServiceManager.ServiceManagerState paramServiceManagerState, String paramString, Service paramService)
  {
    super(paramString);
  }
  
  void call(ServiceManager.Listener paramListener)
  {
    paramListener.failure(this.val$service);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.ServiceManager.ServiceManagerState.2
 * JD-Core Version:    0.7.0.1
 */