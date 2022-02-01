package com.tencent.qapmsdk.socket.handler;

import com.tencent.qapmsdk.socket.model.SocketInfo;

public class HttpBodyLogInterceptor
{
  private static IHttpBodyLogInterceptor bodyLogInterceptor;
  
  public static byte[] intercept(byte[] paramArrayOfByte, SocketInfo paramSocketInfo)
  {
    IHttpBodyLogInterceptor localIHttpBodyLogInterceptor = bodyLogInterceptor;
    byte[] arrayOfByte = paramArrayOfByte;
    if (localIHttpBodyLogInterceptor != null) {
      arrayOfByte = localIHttpBodyLogInterceptor.intercept(paramArrayOfByte, paramSocketInfo);
    }
    return arrayOfByte;
  }
  
  public static void setInterceptor(IHttpBodyLogInterceptor paramIHttpBodyLogInterceptor)
  {
    bodyLogInterceptor = paramIHttpBodyLogInterceptor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.handler.HttpBodyLogInterceptor
 * JD-Core Version:    0.7.0.1
 */