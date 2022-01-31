package com.qzone.download.uinterface;

public abstract interface IDownloadConfig
{
  public abstract boolean enableDns114();
  
  public abstract boolean enableReport();
  
  public abstract long getCurrentUin();
  
  public abstract int getOperator();
  
  public abstract String getQUA();
  
  public abstract String getRefer();
  
  public abstract int getReportPercent();
  
  public abstract String getTerminal();
  
  public abstract String getUserAgent();
  
  public abstract String getVersion();
  
  public abstract int photoDownloadKeepAliveConfig();
  
  public abstract int photoDownloadKeepAliveProxyConfig();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.qzone.download.uinterface.IDownloadConfig
 * JD-Core Version:    0.7.0.1
 */