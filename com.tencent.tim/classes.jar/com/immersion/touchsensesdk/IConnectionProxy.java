package com.immersion.touchsensesdk;

import java.net.SocketTimeoutException;

public abstract interface IConnectionProxy
{
  public abstract IConnection connect(String paramString, int paramInt1, int paramInt2)
    throws SocketTimeoutException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.immersion.touchsensesdk.IConnectionProxy
 * JD-Core Version:    0.7.0.1
 */