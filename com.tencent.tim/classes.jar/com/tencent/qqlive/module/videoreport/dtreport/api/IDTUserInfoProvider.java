package com.tencent.qqlive.module.videoreport.dtreport.api;

public abstract interface IDTUserInfoProvider
{
  public abstract String getMainLogin();
  
  public abstract String getQQ();
  
  public abstract String getQQOpenID();
  
  public abstract String getWbOpenID();
  
  public abstract String getWxOpenID();
  
  public abstract String getWxUnionID();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.api.IDTUserInfoProvider
 * JD-Core Version:    0.7.0.1
 */