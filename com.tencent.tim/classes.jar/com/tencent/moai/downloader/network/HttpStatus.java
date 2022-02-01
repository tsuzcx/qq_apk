package com.tencent.moai.downloader.network;

public class HttpStatus
{
  public static final int STATUS_ABORT = 4;
  public static final int STATUS_ERROR = 3;
  public static final int STATUS_STARTED = 1;
  public static final int STATUS_SUCCESS = 2;
  public static final int STATUS_WAITING = 0;
  private int status = 0;
  
  public HttpStatus(int paramInt)
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
 * Qualified Name:     com.tencent.moai.downloader.network.HttpStatus
 * JD-Core Version:    0.7.0.1
 */