package com.pay.googlewalletsdk.http;

public abstract interface IHttpDownAgency
{
  public abstract void onDownLoading(byte[] paramArrayOfByte, int paramInt, long paramLong, BaseHttpClient paramBaseHttpClient);
  
  public abstract void onError(BaseHttpClient paramBaseHttpClient);
  
  public abstract void onFinish(BaseHttpClient paramBaseHttpClient);
  
  public abstract void onPause(BaseHttpClient paramBaseHttpClient);
  
  public abstract void onReady(BaseHttpClient paramBaseHttpClient);
  
  public abstract void onStart(BaseHttpClient paramBaseHttpClient);
  
  public abstract void onStop(BaseHttpClient paramBaseHttpClient);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.pay.googlewalletsdk.http.IHttpDownAgency
 * JD-Core Version:    0.7.0.1
 */