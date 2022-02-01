package com.tencent.moai.downloader.network;

import java.util.List;
import java.util.Map;

public abstract interface HttpListener
{
  public abstract void onAbort(HttpRequest paramHttpRequest, HttpError paramHttpError);
  
  public abstract void onComplete(HttpRequest paramHttpRequest, HttpResponse paramHttpResponse, HttpError paramHttpError);
  
  public abstract void onFail(HttpRequest paramHttpRequest, HttpError paramHttpError, HttpResponse paramHttpResponse);
  
  public abstract void onPostData(HttpRequest paramHttpRequest, long paramLong1, long paramLong2);
  
  public abstract void onPrepare(HttpRequest paramHttpRequest);
  
  public abstract void onReceiveData(HttpRequest paramHttpRequest, byte[] paramArrayOfByte, long paramLong1, long paramLong2);
  
  public abstract boolean onReceiveHeader(HttpRequest paramHttpRequest, Map<String, List<String>> paramMap);
  
  public abstract void onSuccess(HttpRequest paramHttpRequest, HttpResponse paramHttpResponse);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.downloader.network.HttpListener
 * JD-Core Version:    0.7.0.1
 */