package com.tencent.tmassistantsdk.openSDK;

public class TMQQDownloaderOpenSDKParam
{
  public String SNGAppId = "";
  public String actionFlag = "0";
  public String channelId = "";
  public String sdkId = "";
  public String taskApkId = "";
  public String taskAppId = "";
  public String taskPackageName = "";
  public int taskVersion = 0;
  public String uin = "";
  public String uinType = "";
  public String via = "";
  
  public TMQQDownloaderOpenSDKParam() {}
  
  public TMQQDownloaderOpenSDKParam(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    this.SNGAppId = paramString1;
    this.taskAppId = paramString2;
    this.taskApkId = paramString3;
    this.taskVersion = paramInt;
    this.via = paramString4;
    this.taskPackageName = paramString5;
    this.uin = paramString6;
    this.uinType = paramString7;
    this.channelId = paramString8;
    this.actionFlag = paramString9;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKParam
 * JD-Core Version:    0.7.0.1
 */