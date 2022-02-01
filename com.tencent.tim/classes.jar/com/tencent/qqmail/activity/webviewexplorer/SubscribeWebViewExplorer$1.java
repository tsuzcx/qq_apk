package com.tencent.qqmail.activity.webviewexplorer;

import android.graphics.Bitmap;
import com.tencent.qqmail.download.listener.ImageDownloadListener;

class SubscribeWebViewExplorer$1
  implements ImageDownloadListener
{
  SubscribeWebViewExplorer$1(SubscribeWebViewExplorer paramSubscribeWebViewExplorer) {}
  
  public void onErrorInMainThread(String paramString, Object paramObject) {}
  
  public void onProgressInMainThread(String paramString, long paramLong1, long paramLong2) {}
  
  public void onSuccessInMainThread(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    SubscribeWebViewExplorer.access$202(this.this$0, paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.webviewexplorer.SubscribeWebViewExplorer.1
 * JD-Core Version:    0.7.0.1
 */