package com.tencent.component.network.module.base.inter;

public abstract interface IDownloadConfig
{
  public abstract boolean enableDns114();
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.module.base.inter.IDownloadConfig
 * JD-Core Version:    0.7.0.1
 */