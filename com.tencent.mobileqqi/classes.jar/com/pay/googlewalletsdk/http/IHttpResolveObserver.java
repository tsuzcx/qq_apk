package com.pay.googlewalletsdk.http;

public abstract interface IHttpResolveObserver
{
  public abstract void onDownLoading(byte[] paramArrayOfByte, int paramInt, long paramLong, BaseHttpResolve paramBaseHttpResolve);
  
  public abstract void onError(BaseHttpResolve paramBaseHttpResolve);
  
  public abstract void onFinish(BaseHttpResolve paramBaseHttpResolve);
  
  public abstract void onPause(BaseHttpResolve paramBaseHttpResolve);
  
  public abstract void onReady(BaseHttpResolve paramBaseHttpResolve);
  
  public abstract void onStart(BaseHttpResolve paramBaseHttpResolve);
  
  public abstract void onStop(BaseHttpResolve paramBaseHttpResolve);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.pay.googlewalletsdk.http.IHttpResolveObserver
 * JD-Core Version:    0.7.0.1
 */