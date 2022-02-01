package com.tencent.moai.mailsdk.net.http;

public abstract interface HttpCallBack
{
  public abstract void onBefore(HttpRequest paramHttpRequest);
  
  public abstract void onComplete(HttpRequest paramHttpRequest, HttpResponse paramHttpResponse);
  
  public abstract void onError(HttpRequest paramHttpRequest, HttpResponse paramHttpResponse);
  
  public abstract void onPost(long paramLong1, long paramLong2);
  
  public abstract void onReceive(long paramLong1, long paramLong2);
  
  public abstract void onSuccess(HttpRequest paramHttpRequest, HttpResponse paramHttpResponse);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.net.http.HttpCallBack
 * JD-Core Version:    0.7.0.1
 */