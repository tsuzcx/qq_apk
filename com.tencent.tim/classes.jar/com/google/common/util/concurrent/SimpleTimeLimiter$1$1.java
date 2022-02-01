package com.google.common.util.concurrent;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

class SimpleTimeLimiter$1$1
  implements Callable<Object>
{
  SimpleTimeLimiter$1$1(SimpleTimeLimiter.1 param1, Method paramMethod, Object[] paramArrayOfObject) {}
  
  public Object call()
    throws Exception
  {
    try
    {
      Object localObject = this.val$method.invoke(this.this$1.val$target, this.val$args);
      return localObject;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw SimpleTimeLimiter.access$000(localInvocationTargetException, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.SimpleTimeLimiter.1.1
 * JD-Core Version:    0.7.0.1
 */