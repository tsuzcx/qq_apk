package com.tencent.qapmsdk.impl.tracing;

public abstract interface TraceLifecycleAware
{
  public abstract void onEnterMethod();
  
  public abstract void onExitMethod();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.tracing.TraceLifecycleAware
 * JD-Core Version:    0.7.0.1
 */