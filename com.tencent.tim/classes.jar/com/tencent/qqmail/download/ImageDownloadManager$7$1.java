package com.tencent.qqmail.download;

import android.graphics.Bitmap;
import com.tencent.qqmail.download.listener.ImageDownloadListener;
import java.io.File;

class ImageDownloadManager$7$1
  implements Runnable
{
  ImageDownloadManager$7$1(ImageDownloadManager.7 param7, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (this.this$1.val$listener != null) {
      this.this$1.val$listener.onSuccessInMainThread(this.this$1.val$url, this.val$bitmap, this.this$1.val$image.getAbsolutePath());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.download.ImageDownloadManager.7.1
 * JD-Core Version:    0.7.0.1
 */