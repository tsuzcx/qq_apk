package com.tencent.moai.mailsdk.protocol.mime;

public abstract interface AttachListener
{
  public abstract void onError(int paramInt1, int paramInt2, String paramString);
  
  public abstract void onFinish();
  
  public abstract boolean onProgress(long paramLong);
  
  public abstract void onSuccess(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.mime.AttachListener
 * JD-Core Version:    0.7.0.1
 */