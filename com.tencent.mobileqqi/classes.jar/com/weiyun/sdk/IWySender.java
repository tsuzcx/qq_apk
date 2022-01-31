package com.weiyun.sdk;

public abstract interface IWySender
{
  public abstract void cancelCallback();
  
  public abstract void sendRequest(int paramInt, String paramString, byte[] paramArrayOfByte);
  
  public abstract void setCallback(IWySenderCallback paramIWySenderCallback);
  
  public static abstract interface IWySenderCallback
  {
    public abstract void onRespond(int paramInt1, int paramInt2, byte[] paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.weiyun.sdk.IWySender
 * JD-Core Version:    0.7.0.1
 */