package com.tencent.moai.downloader.model;

import com.tencent.moai.downloader.exception.DownloadTaskError;

public abstract interface ConnectInterface
{
  public abstract void connect()
    throws DownloadTaskError;
  
  public abstract boolean isConnected();
  
  public abstract boolean isConnecting();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.downloader.model.ConnectInterface
 * JD-Core Version:    0.7.0.1
 */