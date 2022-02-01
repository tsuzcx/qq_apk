package com.tencent.mobileqq.minigame.manager;

public abstract class AbstractDownloader
{
  protected DownloadListener mDownloadListener;
  public String mUrl;
  
  public abstract void download();
  
  public void setDownloadListener(DownloadListener paramDownloadListener)
  {
    this.mDownloadListener = paramDownloadListener;
  }
  
  public void setUrl(String paramString)
  {
    this.mUrl = paramString;
  }
  
  public static abstract interface DownloadListener
  {
    public abstract void onDownloadCanceled(String paramString);
    
    public abstract void onDownloadFailed(String paramString);
    
    public abstract void onDownloadProgress(String paramString, float paramFloat);
    
    public abstract void onDownloadSucceed(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.AbstractDownloader
 * JD-Core Version:    0.7.0.1
 */