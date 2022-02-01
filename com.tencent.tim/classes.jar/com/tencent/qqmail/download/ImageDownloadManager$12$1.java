package com.tencent.qqmail.download;

import android.graphics.Bitmap;
import com.tencent.qqmail.download.listener.ImageDownloadListener;

class ImageDownloadManager$12$1
  implements Runnable
{
  ImageDownloadManager$12$1(ImageDownloadManager.12 param12, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (this.val$bitmap == null)
    {
      this.this$1.val$listener.onErrorInMainThread(this.this$1.val$url, null);
      return;
    }
    this.this$1.val$listener.onSuccessInMainThread(this.this$1.val$url, this.val$bitmap, this.this$1.val$url);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.download.ImageDownloadManager.12.1
 * JD-Core Version:    0.7.0.1
 */