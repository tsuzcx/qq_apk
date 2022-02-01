package com.tencent.moai.mailsdk.callback;

public abstract interface IdleCallback
{
  public abstract void onIdleDetectNew();
  
  public abstract void onIdleError(int paramInt1, int paramInt2, String paramString);
  
  public abstract void onIdleSuccess();
  
  public abstract void onSvrCountChange();
  
  public abstract void reportDomain();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.callback.IdleCallback
 * JD-Core Version:    0.7.0.1
 */