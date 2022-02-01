package com.tencent.ark;

public class ArkDispatchQueue
{
  public static native void asyncRun(Runnable paramRunnable);
  
  public static native void asyncRun(String paramString, Runnable paramRunnable);
  
  public static native void asyncRun(String paramString, Runnable paramRunnable, long paramLong);
  
  public static native String getCurrentQueueKey();
  
  public static native void setDefaultAttribute(int paramInt);
  
  public static native void syncRun(String paramString, Runnable paramRunnable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.ark.ArkDispatchQueue
 * JD-Core Version:    0.7.0.1
 */