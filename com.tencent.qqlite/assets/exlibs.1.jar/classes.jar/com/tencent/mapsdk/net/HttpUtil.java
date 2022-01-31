package com.tencent.mapsdk.net;

import com.tencent.tencentmap.mapsdk.a.b;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

public class HttpUtil
{
  public static HttpURLConnection createAConnection(String paramString)
  {
    if (!NetContext.isInitialized()) {
      return null;
    }
    return b.a(paramString, false);
  }
  
  public static InputStream getNetInputStream(String paramString1, String paramString2)
    throws c, IllegalStateException, IOException
  {
    if (!NetContext.isInitialized()) {
      throw new c();
    }
    return b.a(paramString1, paramString2);
  }
  
  public static NetResponse sendSyncGetRequest(String paramString1, String paramString2)
    throws c, com.tencent.tencentmap.mapsdk.a.c, Exception
  {
    if (!NetContext.isInitialized()) {
      throw new c();
    }
    try
    {
      paramString1 = b.a(true, paramString1, paramString2, null);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      throw paramString1;
    }
  }
  
  public static NetResponse sendSyncPostRequest(String paramString1, String paramString2, byte[] paramArrayOfByte)
    throws c, com.tencent.tencentmap.mapsdk.a.c, Exception
  {
    if (!NetContext.isInitialized()) {
      throw new c();
    }
    try
    {
      paramString1 = b.a(false, paramString1, paramString2, paramArrayOfByte);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      throw paramString1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mapsdk.net.HttpUtil
 * JD-Core Version:    0.7.0.1
 */