package com.tencent.moai.mailsdk.callback;

public abstract interface AttachmentCallBack
{
  public abstract void onError(int paramInt1, int paramInt2, String paramString);
  
  public abstract boolean onProgress(long paramLong);
  
  public abstract void onSuccess(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.callback.AttachmentCallBack
 * JD-Core Version:    0.7.0.1
 */