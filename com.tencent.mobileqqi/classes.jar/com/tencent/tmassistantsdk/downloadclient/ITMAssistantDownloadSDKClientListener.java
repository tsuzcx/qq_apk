package com.tencent.tmassistantsdk.downloadclient;

public abstract interface ITMAssistantDownloadSDKClientListener
{
  public abstract void OnDownloadSDKTaskProgressChanged(TMAssistantDownloadSDKClient paramTMAssistantDownloadSDKClient, String paramString, long paramLong1, long paramLong2);
  
  public abstract void OnDownloadSDKTaskStateChanged(TMAssistantDownloadSDKClient paramTMAssistantDownloadSDKClient, String paramString1, int paramInt1, int paramInt2, String paramString2);
  
  public abstract void OnDwonloadSDKServiceInvalid(TMAssistantDownloadSDKClient paramTMAssistantDownloadSDKClient);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadclient.ITMAssistantDownloadSDKClientListener
 * JD-Core Version:    0.7.0.1
 */