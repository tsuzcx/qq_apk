package org.junit.internal.runners.model;

import java.lang.reflect.InvocationTargetException;

public abstract class ReflectiveCallable
{
  public Object run()
    throws Throwable
  {
    try
    {
      Object localObject = runReflectiveCall();
      return localObject;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw localInvocationTargetException.getTargetException();
    }
  }
  
  protected abstract Object runReflectiveCall()
    throws Throwable;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.junit.internal.runners.model.ReflectiveCallable
 * JD-Core Version:    0.7.0.1
 */