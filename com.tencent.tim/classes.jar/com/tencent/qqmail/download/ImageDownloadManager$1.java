package com.tencent.qqmail.download;

import android.graphics.Bitmap;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.qmimagecache.ImageCache;
import com.tencent.qqmail.utilities.imageextention.ImageUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;
import java.io.File;

class ImageDownloadManager$1
  implements Runnable
{
  ImageDownloadManager$1(ImageDownloadManager paramImageDownloadManager, String paramString1, String paramString2, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    Object localObject = ImageDownloadManager.access$000(this.this$0).getDiskCacheFilePathByKey(this.val$key);
    File localFile = new File((String)localObject);
    if ((localFile.exists()) && (localFile.length() == 0L))
    {
      localFile.delete();
      QMLog.log(4, "ImageDownloadManager", "load bitmap from disk error, file is empty!" + this.val$url);
      Threads.runOnMainThread(new ImageDownloadManager.1.1(this));
      return;
    }
    localObject = ImageUtil.memSafeScaleImage((String)localObject, 1, 1.0F);
    if (localObject == null)
    {
      ImageDownloadManager.access$000(this.this$0).removeDiskCache(this.val$key);
      ImageDownloadManager.access$100(this.this$0, this.val$info);
      return;
    }
    ImageDownloadManager.access$000(this.this$0).addBitmapToCache(this.val$key, (Bitmap)localObject);
    QMLog.log(4, "ImageDownloadManager", "load bitmap from disk success " + this.val$url);
    Threads.runOnMainThread(new ImageDownloadManager.1.2(this, (Bitmap)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.download.ImageDownloadManager.1
 * JD-Core Version:    0.7.0.1
 */