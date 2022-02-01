package com.tencent.viola.bridge;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;

public abstract interface Invoker
{
  public abstract Type[] getParameterTypes();
  
  public abstract Object invoke(Object paramObject, Object... paramVarArgs)
    throws InvocationTargetException, IllegalAccessException;
  
  public abstract boolean isRunOnUIThread();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.bridge.Invoker
 * JD-Core Version:    0.7.0.1
 */