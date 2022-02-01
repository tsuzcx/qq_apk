package com.tencent.qqlive.mediaplayer.api;

import android.content.Context;

public abstract interface TVK_ICacheMgr
{
  public abstract void addCgiPreloadCallback(ICGIPreloadCallback paramICGIPreloadCallback);
  
  public abstract int isVideoCached(Context paramContext, String paramString1, TVK_UserInfo paramTVK_UserInfo, TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo, String paramString2);
  
  public abstract void preLoadVideoById(Context paramContext, TVK_UserInfo paramTVK_UserInfo, TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo, String paramString);
  
  public abstract void preLoadVideoByUrl(Context paramContext, String paramString, TVK_UserInfo paramTVK_UserInfo, TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo);
  
  public abstract int preLoadVideoByUrlWithResult(Context paramContext, String paramString, TVK_UserInfo paramTVK_UserInfo, TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo);
  
  public abstract boolean quickCheckVideoCached(Context paramContext, String paramString1, TVK_UserInfo paramTVK_UserInfo, TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo, String paramString2);
  
  public abstract void releasePreload(int paramInt);
  
  public abstract void removeCgiPreloadCallback();
  
  public abstract void removePreloadCallback();
  
  public abstract void setOnPreLoadCompleteCallback(IPreloadCompleteCallback paramIPreloadCompleteCallback);
  
  public abstract void setPreloadCallback(IPreloadCallback paramIPreloadCallback);
  
  public abstract void stopCacheData(int paramInt);
  
  public abstract void stopCacheDataById(int paramInt1, int paramInt2);
  
  public static abstract interface ICGIPreloadCallback
  {
    public abstract void onCgiPreloadFailed(int paramInt, String paramString);
    
    public abstract void onCgiPreloadSucess(String paramString);
  }
  
  public static abstract interface IPreloadCallback
  {
    public abstract void onPreLoadFailed(String paramString1, int paramInt, String paramString2);
    
    public abstract void onPreLoadSucess(String paramString1, String paramString2);
  }
  
  public static abstract interface IPreloadCompleteCallback
  {
    public abstract void onComplete(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr
 * JD-Core Version:    0.7.0.1
 */