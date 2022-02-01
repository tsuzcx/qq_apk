package com.google.common.eventbus;

import java.lang.reflect.InvocationTargetException;

class Subscriber$1
  implements Runnable
{
  Subscriber$1(Subscriber paramSubscriber, Object paramObject) {}
  
  public void run()
  {
    try
    {
      this.this$0.invokeSubscriberMethod(this.val$event);
      return;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      Subscriber.access$200(this.this$0).handleSubscriberException(localInvocationTargetException.getCause(), Subscriber.access$100(this.this$0, this.val$event));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.eventbus.Subscriber.1
 * JD-Core Version:    0.7.0.1
 */