package com.google.common.util.concurrent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.concurrent.TimeUnit;

class SimpleTimeLimiter$1
  implements InvocationHandler
{
  SimpleTimeLimiter$1(SimpleTimeLimiter paramSimpleTimeLimiter, Object paramObject, long paramLong, TimeUnit paramTimeUnit, Set paramSet) {}
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    throws Throwable
  {
    paramObject = new SimpleTimeLimiter.1.1(this, paramMethod, paramArrayOfObject);
    return this.this$0.callWithTimeout(paramObject, this.val$timeoutDuration, this.val$timeoutUnit, this.val$interruptibleMethods.contains(paramMethod));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.SimpleTimeLimiter.1
 * JD-Core Version:    0.7.0.1
 */