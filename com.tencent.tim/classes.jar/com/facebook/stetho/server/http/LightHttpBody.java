package com.facebook.stetho.server.http;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public abstract class LightHttpBody
{
  public static LightHttpBody create(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = create(paramString1.getBytes("UTF-8"), paramString2);
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      throw new RuntimeException(paramString1);
    }
  }
  
  public static LightHttpBody create(byte[] paramArrayOfByte, String paramString)
  {
    return new LightHttpBody.1(paramString, paramArrayOfByte);
  }
  
  public abstract int contentLength();
  
  public abstract String contentType();
  
  public abstract void writeTo(OutputStream paramOutputStream)
    throws IOException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.server.http.LightHttpBody
 * JD-Core Version:    0.7.0.1
 */