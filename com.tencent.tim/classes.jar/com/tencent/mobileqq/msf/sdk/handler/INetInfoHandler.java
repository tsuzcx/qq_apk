package com.tencent.mobileqq.msf.sdk.handler;

public abstract interface INetInfoHandler
  extends IMsfHandler
{
  public abstract void onNetMobile2None();
  
  public abstract void onNetMobile2Wifi(String paramString);
  
  public abstract void onNetNone2Mobile(String paramString);
  
  public abstract void onNetNone2Wifi(String paramString);
  
  public abstract void onNetWifi2Mobile(String paramString);
  
  public abstract void onNetWifi2None();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
 * JD-Core Version:    0.7.0.1
 */