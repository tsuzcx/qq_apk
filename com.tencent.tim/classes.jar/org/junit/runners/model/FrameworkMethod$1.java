package org.junit.runners.model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.internal.runners.model.ReflectiveCallable;

class FrameworkMethod$1
  extends ReflectiveCallable
{
  FrameworkMethod$1(FrameworkMethod paramFrameworkMethod, Object paramObject, Object[] paramArrayOfObject)
    throws InvocationTargetException, IllegalAccessException
  {}
  
  public Object runReflectiveCall()
    throws Throwable
  {
    return FrameworkMethod.access$000(this.this$0).invoke(this.val$target, this.val$params);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.junit.runners.model.FrameworkMethod.1
 * JD-Core Version:    0.7.0.1
 */