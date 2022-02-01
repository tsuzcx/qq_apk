package com.tencent.qqlive.tvkplayer.vinfo.api;

import android.support.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.vinfo.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.vinfo.TVKUserInfo;
import com.tencent.qqlive.tvkplayer.vinfo.TVKVideoInfo;

public abstract interface ITVKVodInfoGetter
{
  public abstract int getDlnaUrl(@NonNull TVKUserInfo paramTVKUserInfo, @NonNull TVKPlayerVideoInfo paramTVKPlayerVideoInfo, @NonNull String paramString, int paramInt);
  
  public abstract int getPlayInfo(@NonNull TVKUserInfo paramTVKUserInfo, @NonNull TVKPlayerVideoInfo paramTVKPlayerVideoInfo, @NonNull String paramString, int paramInt1, int paramInt2);
  
  public abstract void setOnInfoGetListener(ITVKVodInfoGetterCallback paramITVKVodInfoGetterCallback);
  
  public static abstract interface ITVKVodInfoGetterCallback
  {
    public abstract void onFailure(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2);
    
    public abstract void onSuccess(int paramInt, TVKVideoInfo paramTVKVideoInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.api.ITVKVodInfoGetter
 * JD-Core Version:    0.7.0.1
 */