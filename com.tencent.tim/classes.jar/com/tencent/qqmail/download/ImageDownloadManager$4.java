package com.tencent.qqmail.download;

import android.graphics.Bitmap;
import com.tencent.qqmail.download.listener.ImageDownloadListener;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.qmimagecache.ImageCache;

class ImageDownloadManager$4
  implements Runnable
{
  ImageDownloadManager$4(ImageDownloadManager paramImageDownloadManager, DownloadInfo paramDownloadInfo, String paramString1, Bitmap paramBitmap, String paramString2) {}
  
  public void run()
  {
    if (this.val$info.getImageDownloadListener() != null) {
      this.val$info.getImageDownloadListener().onSuccessInMainThread(this.val$url, this.val$bitmap, ImageDownloadManager.access$000(this.this$0).getDiskCacheFilePathByKey(this.val$key));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.download.ImageDownloadManager.4
 * JD-Core Version:    0.7.0.1
 */