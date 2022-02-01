package com.tencent.youtu.ytcommon.auth;

import android.text.TextUtils;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtil
{
  private static final String CHARSET_UTF8 = "UTF-8";
  private static final int DEFAULT_TIMEOUT_MILLIS = 10000;
  
  private static HttpURLConnection buildConnection(String paramString, int paramInt)
    throws IOException
  {
    paramString = (HttpURLConnection)new URL(paramString).openConnection();
    paramString.setConnectTimeout(paramInt);
    paramString.setReadTimeout(paramInt);
    return paramString;
  }
  
  private static String getResponse(HttpURLConnection paramHttpURLConnection, HttpResponseListener paramHttpResponseListener)
    throws IOException
  {
    Object localObject = null;
    int i;
    do
    {
      for (;;)
      {
        try
        {
          i = paramHttpURLConnection.getResponseCode();
          if (i != 200) {
            break;
          }
          paramHttpURLConnection = paramHttpURLConnection.getInputStream();
          localObject = new StringBuilder();
          byte[] arrayOfByte = new byte[1024];
          i = paramHttpURLConnection.read(arrayOfByte);
          if (i != -1)
          {
            ((StringBuilder)localObject).append(new String(arrayOfByte, 0, i));
            continue;
          }
          paramHttpURLConnection.close();
        }
        catch (Exception paramHttpURLConnection)
        {
          paramHttpURLConnection.printStackTrace();
          paramHttpURLConnection = (HttpURLConnection)localObject;
          return paramHttpURLConnection;
        }
        localObject = ((StringBuilder)localObject).toString();
        paramHttpURLConnection = (HttpURLConnection)localObject;
        if (paramHttpResponseListener != null)
        {
          paramHttpResponseListener.onSuccess((String)localObject);
          return localObject;
        }
      }
      paramHttpURLConnection = (HttpURLConnection)localObject;
    } while (paramHttpResponseListener == null);
    paramHttpResponseListener.onFail(i);
    return null;
  }
  
  public static String post(String paramString1, String paramString2, HttpResponseListener paramHttpResponseListener)
    throws IOException
  {
    paramString1 = buildConnection(paramString1, 10000);
    paramString1.setRequestProperty("Content-Type", "application/json");
    paramString1.setRequestMethod("POST");
    if (!TextUtils.isEmpty(paramString2))
    {
      OutputStream localOutputStream = paramString1.getOutputStream();
      BufferedWriter localBufferedWriter = new BufferedWriter(new OutputStreamWriter(localOutputStream, "UTF-8"));
      localBufferedWriter.write(paramString2);
      localBufferedWriter.flush();
      localBufferedWriter.close();
      localOutputStream.close();
    }
    return getResponse(paramString1, paramHttpResponseListener);
  }
  
  public static abstract interface HttpResponseListener
  {
    public abstract void onFail(int paramInt);
    
    public abstract void onSuccess(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.youtu.ytcommon.auth.HttpUtil
 * JD-Core Version:    0.7.0.1
 */