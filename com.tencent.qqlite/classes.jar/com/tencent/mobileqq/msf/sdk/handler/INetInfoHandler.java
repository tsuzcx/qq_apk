package com.tencent.mobileqq.msf.sdk.handler;

public abstract interface INetInfoHandler
  extends IMsfHandler
{
  public abstract void onNetMobile2None();
  
  public abstract void onNetMobile2Wifi();
  
  public abstract void onNetNone2Mobile();
  
  public abstract void onNetNone2Wifi();
  
  public abstract void onNetWifi2Mobile();
  
  public abstract void onNetWifi2None();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
 * JD-Core Version:    0.7.0.1
 */