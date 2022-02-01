package com.tencent.qapmsdk.socket.handler;

import com.tencent.qapmsdk.socket.model.SocketInfo;

public abstract interface IHttpBodyLogInterceptor
{
  public abstract byte[] intercept(byte[] paramArrayOfByte, SocketInfo paramSocketInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.handler.IHttpBodyLogInterceptor
 * JD-Core Version:    0.7.0.1
 */