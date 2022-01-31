package com.weiyun.sdk;

public class WyConfiguration
{
  private static final long MAX_DISK_CACHE_SIZE = 20971520L;
  private final String cachePath;
  private boolean debug = false;
  private long maxDiskCacheSize = 20971520L;
  private int maxTaskNum = 2;
  
  public WyConfiguration(String paramString)
  {
    this.cachePath = paramString;
  }
  
  public void enableDebugModel()
  {
    this.debug = true;
  }
  
  public String getCachePath()
  {
    return this.cachePath;
  }
  
  public long getMaxDiskCacheSize()
  {
    return this.maxDiskCacheSize;
  }
  
  public int getMaxTaskNum()
  {
    return this.maxTaskNum;
  }
  
  public int getTaskNum()
  {
    return this.maxTaskNum;
  }
  
  public boolean isDebugModel()
  {
    return this.debug;
  }
  
  public void setMaxDiskCacheSize(long paramLong)
  {
    this.maxDiskCacheSize = paramLong;
  }
  
  public void setMaxTaskNum(int paramInt)
  {
    this.maxTaskNum = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.weiyun.sdk.WyConfiguration
 * JD-Core Version:    0.7.0.1
 */