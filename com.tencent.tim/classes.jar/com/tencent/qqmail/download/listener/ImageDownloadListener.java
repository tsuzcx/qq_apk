package com.tencent.qqmail.download.listener;

import android.graphics.Bitmap;

public abstract interface ImageDownloadListener
{
  public abstract void onErrorInMainThread(String paramString, Object paramObject);
  
  public abstract void onProgressInMainThread(String paramString, long paramLong1, long paramLong2);
  
  public abstract void onSuccessInMainThread(String paramString1, Bitmap paramBitmap, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.download.listener.ImageDownloadListener
 * JD-Core Version:    0.7.0.1
 */