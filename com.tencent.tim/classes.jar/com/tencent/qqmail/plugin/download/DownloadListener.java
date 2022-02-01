package com.tencent.qqmail.plugin.download;

import androidx.annotation.IntRange;

public abstract interface DownloadListener
{
  public abstract void onFinish(boolean paramBoolean, String paramString);
  
  public abstract void onProgress(@IntRange(from=0L, to=100L) int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.plugin.download.DownloadListener
 * JD-Core Version:    0.7.0.1
 */