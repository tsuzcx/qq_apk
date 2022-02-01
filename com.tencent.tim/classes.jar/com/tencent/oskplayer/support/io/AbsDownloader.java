package com.tencent.oskplayer.support.io;

public abstract class AbsDownloader
{
  public DownloadListener mDownloadListener;
  protected String mUrl;
  
  protected AbsDownloader(String paramString)
  {
    this(paramString, null);
  }
  
  protected AbsDownloader(String paramString, DownloadListener paramDownloadListener)
  {
    this.mUrl = paramString;
    this.mDownloadListener = paramDownloadListener;
  }
  
  public abstract void download();
  
  public void setDownloadListener(DownloadListener paramDownloadListener)
  {
    this.mDownloadListener = paramDownloadListener;
  }
  
  public static abstract interface DownloadListener
  {
    public abstract void onDownloadCanceled(String paramString);
    
    public abstract void onDownloadFailed(String paramString);
    
    public abstract void onDownloadProgress(String paramString, float paramFloat);
    
    public abstract void onDownloadSucceed(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.support.io.AbsDownloader
 * JD-Core Version:    0.7.0.1
 */