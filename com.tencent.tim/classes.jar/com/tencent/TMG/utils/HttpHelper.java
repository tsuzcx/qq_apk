package com.tencent.TMG.utils;

import java.util.Map;

public class HttpHelper
{
  private static final String TAG = "HttpHelper";
  
  public static boolean httpPostRequest(String paramString, byte[] paramArrayOfByte, Map<String, String> paramMap, Object paramObject, HttpRequestListener paramHttpRequestListener)
  {
    new Thread(new HttpHelper.1(paramString, paramArrayOfByte, paramMap, paramHttpRequestListener, paramObject)).start();
    return true;
  }
  
  public static abstract interface HttpRequestListener
  {
    public abstract void onCompleted(String paramString, int paramInt, byte[] paramArrayOfByte, Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.TMG.utils.HttpHelper
 * JD-Core Version:    0.7.0.1
 */