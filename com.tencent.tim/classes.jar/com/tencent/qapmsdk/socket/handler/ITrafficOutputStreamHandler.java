package com.tencent.qapmsdk.socket.handler;

import android.support.annotation.NonNull;
import com.tencent.qapmsdk.socket.model.SocketInfo;

public abstract interface ITrafficOutputStreamHandler
{
  public abstract void onOutput(@NonNull byte[] paramArrayOfByte, int paramInt1, int paramInt2, SocketInfo paramSocketInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.handler.ITrafficOutputStreamHandler
 * JD-Core Version:    0.7.0.1
 */