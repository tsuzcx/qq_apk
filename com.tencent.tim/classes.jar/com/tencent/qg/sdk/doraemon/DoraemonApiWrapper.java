package com.tencent.qg.sdk.doraemon;

public abstract class DoraemonApiWrapper
{
  protected boolean mHasInit;
  
  public native void attachNative();
  
  public abstract void call(String paramString1, String paramString2, long paramLong);
  
  public void init()
  {
    if (!this.mHasInit) {
      attachNative();
    }
    this.mHasInit = true;
  }
  
  public void release() {}
  
  public static abstract interface ApiCallback
  {
    public abstract void onComplete();
    
    public abstract void onFailure(int paramInt, String paramString);
    
    public abstract void onPermission(int paramInt);
    
    public abstract void onSuccess(String paramString);
    
    public abstract void onTrigger(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qg.sdk.doraemon.DoraemonApiWrapper
 * JD-Core Version:    0.7.0.1
 */