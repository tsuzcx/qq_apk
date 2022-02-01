package com.tencent.viola.bridge;

public abstract interface JavascriptInvokable
{
  public abstract Invoker getMethodInvoker(String paramString);
  
  public abstract String[] getMethods();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.bridge.JavascriptInvokable
 * JD-Core Version:    0.7.0.1
 */