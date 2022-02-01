package com.tencent.mobileqq.cuckoo;

public abstract class MethodCallback
  extends Callback
{
  protected void methodCallbackEntry(String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject) {}
  
  protected void methodCallbackEntry(Object[] paramArrayOfObject) {}
  
  protected void methodCallbackEntry(Object[] paramArrayOfObject, Object paramObject) {}
  
  protected void methodCallbackExit(Object paramObject) {}
  
  protected void methodCallbackExitThrowable(Object paramObject) {}
  
  protected Object[] methodCallbackSetArgs(Object[] paramArrayOfObject)
  {
    return paramArrayOfObject;
  }
  
  protected Object methodCallbackSetResult(Object paramObject)
  {
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.cuckoo.MethodCallback
 * JD-Core Version:    0.7.0.1
 */