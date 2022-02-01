package com.tencent.ad.tangram.canvas.download;

import android.support.annotation.Keep;
import com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.AdAppDownloadManager;

@Keep
public abstract interface AdCanvasDownloadListenerAdapter
{
  public abstract IAdDownloader.Callback getDownloadListener(AdAppDownloadManager paramAdAppDownloadManager);
  
  public abstract void removeDownloadListener(AdAppDownloadManager paramAdAppDownloadManager);
  
  public abstract void setDownloadListener(AdAppDownloadManager paramAdAppDownloadManager);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.download.AdCanvasDownloadListenerAdapter
 * JD-Core Version:    0.7.0.1
 */