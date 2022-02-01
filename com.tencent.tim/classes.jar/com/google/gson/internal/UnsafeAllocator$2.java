package com.google.gson.internal;

import java.lang.reflect.Method;

final class UnsafeAllocator$2
  extends UnsafeAllocator
{
  UnsafeAllocator$2(Method paramMethod, int paramInt) {}
  
  public <T> T newInstance(Class<T> paramClass)
    throws Exception
  {
    assertInstantiable(paramClass);
    return this.val$newInstance.invoke(null, new Object[] { paramClass, Integer.valueOf(this.val$constructorId) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.gson.internal.UnsafeAllocator.2
 * JD-Core Version:    0.7.0.1
 */