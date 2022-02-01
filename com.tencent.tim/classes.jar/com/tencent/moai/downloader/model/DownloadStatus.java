package com.tencent.moai.downloader.model;

public class DownloadStatus
{
  public static final int STATUS_ABORT = 6;
  public static final int STATUS_DOWNLOAD_COMPLETE = 3;
  public static final int STATUS_FAILED = 5;
  public static final int STATUS_PROGRESS = 2;
  public static final int STATUS_STARTED = 1;
  public static final int STATUS_SUCCESS = 4;
  public static final int STATUS_WAITING = 0;
  private int status = 0;
  
  public DownloadStatus() {}
  
  public DownloadStatus(int paramInt)
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
 * Qualified Name:     com.tencent.moai.downloader.model.DownloadStatus
 * JD-Core Version:    0.7.0.1
 */