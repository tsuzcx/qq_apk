package com.tencent.thumbplayer.api.proxy;

import java.util.ArrayList;
import java.util.Map;

public abstract interface ITPPreloadProxy
{
  public abstract String getPlayErrorCodeStr(int paramInt);
  
  public abstract boolean isAvailable();
  
  public abstract void pushEvent(int paramInt);
  
  public abstract void setPreloadListener(IPreloadListener paramIPreloadListener);
  
  public abstract int startClipPreload(String paramString, ArrayList<TPDownloadParamData> paramArrayList);
  
  public abstract int startPreload(String paramString, TPDownloadParamData paramTPDownloadParamData, IPreloadListener paramIPreloadListener);
  
  public abstract int startPreload(String paramString, TPDownloadParamData paramTPDownloadParamData, Map<String, String> paramMap, IPreloadListener paramIPreloadListener);
  
  public abstract void stopPreload(int paramInt);
  
  public static abstract interface IPreloadListener
  {
    public abstract void onInfo(int paramInt, long paramLong1, long paramLong2, Object paramObject);
    
    public abstract void onPrepareDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString);
    
    public abstract void onPrepareError();
    
    public abstract void onPrepareSuccess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.api.proxy.ITPPreloadProxy
 * JD-Core Version:    0.7.0.1
 */