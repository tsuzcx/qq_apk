package com.tencent.weiyun.uploader;

public abstract interface IConfig
{
  public abstract String getCachePath();
  
  public abstract long getCurrentUin();
  
  public abstract int getIsp();
  
  public abstract String getQUA();
  
  public abstract String getRefer();
  
  public abstract int getReportPercent();
  
  public abstract String getTerminal();
  
  public abstract String getUserAgent();
  
  public abstract String getVersion();
  
  public abstract boolean isRdm();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.weiyun.uploader.IConfig
 * JD-Core Version:    0.7.0.1
 */