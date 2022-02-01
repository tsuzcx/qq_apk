package com.tencent.qqmail.download;

import android.graphics.Bitmap;
import com.tencent.qqmail.download.listener.ImageDownloadListener;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.qmimagecache.ImageCache;

class ImageDownloadManager$5$1
  implements Runnable
{
  ImageDownloadManager$5$1(ImageDownloadManager.5 param5, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (this.this$1.val$info.getImageDownloadListener() != null) {
      this.this$1.val$info.getImageDownloadListener().onSuccessInMainThread(this.this$1.val$url, this.val$localBitmap, ImageDownloadManager.access$000(this.this$1.this$0).getDiskCacheFilePathByKey(this.this$1.val$key));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.download.ImageDownloadManager.5.1
 * JD-Core Version:    0.7.0.1
 */