package com.tencent.moai.downloader.listener;

import com.tencent.moai.downloader.exception.ConnectTaskError;

public abstract interface ConnectTaskListener
{
  public abstract void onConnectError(String paramString, ConnectTaskError paramConnectTaskError);
  
  public abstract void onConnectSuccess(String paramString, long paramLong, boolean paramBoolean);
  
  public abstract void onConnecting(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.downloader.listener.ConnectTaskListener
 * JD-Core Version:    0.7.0.1
 */