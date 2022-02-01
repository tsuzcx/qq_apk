package com.tencent.moai.downloader.model;

public class ConnectStatus
{
  public static final int STATUS_CONNECTING = 0;
  public static final int STATUS_CONNECT_ERROR = 2;
  public static final int STATUS_CONNECT_SUCCESS = 1;
  private int status = 0;
  
  public ConnectStatus() {}
  
  public ConnectStatus(int paramInt)
  {
    this.status = paramInt;
  }
  
  public int getStatus()
  {
    return this.status;
  }
  
  public void setStatus(int paramInt)
  {
    this.status = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.downloader.model.ConnectStatus
 * JD-Core Version:    0.7.0.1
 */