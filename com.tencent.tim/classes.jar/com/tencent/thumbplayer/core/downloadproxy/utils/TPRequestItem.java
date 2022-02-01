package com.tencent.thumbplayer.core.downloadproxy.utils;

class TPRequestItem
{
  private long mRequestFailedTime = -1L;
  private int mRequestTimes = 0;
  private int mRequestType;
  private String mUrl;
  
  TPRequestItem(String paramString, int paramInt)
  {
    this.mUrl = paramString;
    this.mRequestType = paramInt;
  }
  
  public long getRequestFailedTime()
  {
    return this.mRequestFailedTime;
  }
  
  public int getRequestTimes()
  {
    return this.mRequestTimes;
  }
  
  public int getRequestType()
  {
    return this.mRequestType;
  }
  
  public String getUrl()
  {
    return this.mUrl;
  }
  
  public void updateFailedTime()
  {
    this.mRequestFailedTime = System.currentTimeMillis();
    this.mRequestTimes += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.utils.TPRequestItem
 * JD-Core Version:    0.7.0.1
 */