package com.tencent.qapmsdk.socket.handler;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qapmsdk.socket.model.SocketInfo;

public abstract interface ITrafficInputStreamHandler
{
  public abstract void onClose();
  
  public abstract void onInput(@NonNull byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, @Nullable SocketInfo paramSocketInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.handler.ITrafficInputStreamHandler
 * JD-Core Version:    0.7.0.1
 */