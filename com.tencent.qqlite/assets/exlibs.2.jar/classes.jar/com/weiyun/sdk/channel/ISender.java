package com.weiyun.sdk.channel;

public abstract interface ISender
{
  public abstract void releaseSender();
  
  public abstract boolean sendRequest(String paramString, byte[] paramArrayOfByte, ICallback paramICallback);
  
  public static abstract interface ICallback
  {
    public abstract void onRespond(int paramInt, byte[] paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.weiyun.sdk.channel.ISender
 * JD-Core Version:    0.7.0.1
 */