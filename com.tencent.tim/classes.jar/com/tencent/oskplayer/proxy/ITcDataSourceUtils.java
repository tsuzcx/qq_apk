package com.tencent.oskplayer.proxy;

import com.tencent.oskplayer.cache.Cache;

public abstract interface ITcDataSourceUtils
{
  public abstract int cleanStorage();
  
  public abstract boolean deleteFileOnDisk(String paramString);
  
  public abstract DataSourceBuilder getDataSourceBuilder(Cache paramCache, HttpRetryLogic paramHttpRetryLogic, VideoRequest paramVideoRequest);
  
  public abstract String getFileId(String paramString);
  
  public abstract String getLocalUrl(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract boolean isClipCompleteOnDisk(String paramString, int paramInt);
  
  public abstract boolean isEnabled();
  
  public abstract boolean isUseDefaultSourceBuilder(String paramString);
  
  public abstract int pauseStorageIO();
  
  public abstract boolean preload(String paramString1, long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString2);
  
  public abstract int resumeStorageIO();
  
  public abstract void setPlayerState(String paramString, int paramInt);
  
  public abstract void setRemainTime(String paramString, int paramInt);
  
  public abstract void stopAllPreload();
  
  public abstract void stopPlay(int paramInt);
  
  public abstract void stopPlay(String paramString);
  
  public abstract void stopPlay(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.proxy.ITcDataSourceUtils
 * JD-Core Version:    0.7.0.1
 */