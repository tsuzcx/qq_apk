package com.tencent.qqmail.model.mail.loader;

public abstract interface ProtocolInlineImgCallback
{
  public abstract void onError(Object paramObject);
  
  public abstract boolean onProgress(long paramLong1, long paramLong2);
  
  public abstract void onSuccess(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.loader.ProtocolInlineImgCallback
 * JD-Core Version:    0.7.0.1
 */