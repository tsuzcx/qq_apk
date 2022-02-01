package com.tencent.qqlive.module.videoreport.dtreport.api;

public abstract interface IDTAppInfoProvider
{
  public abstract String getAdCode();
  
  public abstract String getAppVersion();
  
  public abstract String getChannelId();
  
  public abstract String getFactoryChannelId();
  
  public abstract String getGuid();
  
  public abstract String getModifyChannelId();
  
  public abstract String getOaid();
  
  public abstract String getOmgId();
  
  public abstract String getOmgbzid();
  
  public abstract String getSIMType();
  
  public abstract String getTid();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.api.IDTAppInfoProvider
 * JD-Core Version:    0.7.0.1
 */