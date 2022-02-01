package com.tencent.av.HttpHelper;

import android.util.Log;
import java.util.Map;

public class HttpHelper
{
  private static final String TAG = "HttpHelper";
  
  public static boolean httpGetRequest(String paramString, Object paramObject, int paramInt, HttpRequestListener paramHttpRequestListener)
  {
    Log.e("HttpHelper", "httpGetRequest|url = " + paramString + "|| http request timeout =" + paramInt);
    new Thread(new HttpHelper.1(paramString, paramInt, paramHttpRequestListener, paramObject)).start();
    return true;
  }
  
  public static boolean httpGetRequest(String paramString, Object paramObject, HttpRequestListener paramHttpRequestListener)
  {
    return httpGetRequest(paramString, paramObject, 5000, paramHttpRequestListener);
  }
  
  public static boolean httpPostRequest(String paramString, byte[] paramArrayOfByte, Map<String, String> paramMap, Object paramObject, int paramInt, HttpRequestListener paramHttpRequestListener)
  {
    Log.e("HttpHelper", "httpPostRequest|url = " + paramString + "|| http request timeout =" + paramInt);
    new Thread(new HttpHelper.2(paramString, paramInt, paramArrayOfByte, paramMap, paramHttpRequestListener, paramObject)).start();
    return true;
  }
  
  public static boolean httpPostRequest(String paramString, byte[] paramArrayOfByte, Map<String, String> paramMap, Object paramObject, HttpRequestListener paramHttpRequestListener)
  {
    return httpPostRequest(paramString, paramArrayOfByte, paramMap, paramObject, 5000, paramHttpRequestListener);
  }
  
  public static abstract interface HttpRequestListener
  {
    public abstract void onCompleted(String paramString, int paramInt, byte[] paramArrayOfByte, Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.HttpHelper.HttpHelper
 * JD-Core Version:    0.7.0.1
 */