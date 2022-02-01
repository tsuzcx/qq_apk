package com.tencent.ad.tangram.canvas.download;

import android.support.annotation.Keep;

@Keep
public abstract interface AdDownloadTaskAdapter
{
  public abstract Object getDownloadTask();
  
  public abstract void setDownloadTask(Object paramObject);
  
  public abstract void setDownloadUrl(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.download.AdDownloadTaskAdapter
 * JD-Core Version:    0.7.0.1
 */