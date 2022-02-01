package com.tencent.superplayer.api;

public abstract interface ISPlayerPreDownloader
{
  public abstract void destory();
  
  public abstract void setOnPreDownloadListener(Listener paramListener);
  
  public abstract int startPreDownload(SuperPlayerVideoInfo paramSuperPlayerVideoInfo, long paramLong);
  
  public abstract int startPreDownload(SuperPlayerVideoInfo paramSuperPlayerVideoInfo, long paramLong1, long paramLong2);
  
  public abstract int startPreDownload(SuperPlayerVideoInfo paramSuperPlayerVideoInfo, long paramLong1, long paramLong2, SuperPlayerDownOption paramSuperPlayerDownOption);
  
  public abstract int startPreDownload(SuperPlayerVideoInfo paramSuperPlayerVideoInfo, long paramLong, SuperPlayerDownOption paramSuperPlayerDownOption);
  
  public abstract void stopAllPreDownload();
  
  public abstract void stopPreDownload(int paramInt);
  
  public static abstract interface Listener
  {
    public abstract void onInfo(int paramInt, long paramLong1, long paramLong2, Object paramObject);
    
    public abstract void onPrepareDownloadProgressUpdate(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, String paramString);
    
    public abstract void onPrepareError(int paramInt);
    
    public abstract void onPrepareSuccess(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.superplayer.api.ISPlayerPreDownloader
 * JD-Core Version:    0.7.0.1
 */