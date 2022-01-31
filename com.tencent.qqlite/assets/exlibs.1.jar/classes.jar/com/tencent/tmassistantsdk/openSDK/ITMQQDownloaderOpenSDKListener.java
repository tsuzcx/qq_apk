package com.tencent.tmassistantsdk.openSDK;

public abstract interface ITMQQDownloaderOpenSDKListener
{
  public abstract void OnDownloadTaskProgressChanged(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, long paramLong1, long paramLong2);
  
  public abstract void OnDownloadTaskStateChanged(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, int paramInt1, int paramInt2, String paramString);
  
  public abstract void OnQQDownloaderInvalid();
  
  public abstract void OnServiceFree();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.openSDK.ITMQQDownloaderOpenSDKListener
 * JD-Core Version:    0.7.0.1
 */