package com.tencent.qqmail.download;

import android.graphics.Bitmap;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.qmimagecache.ImageCache;
import com.tencent.qqmail.utilities.imageextention.ImageUtil;
import com.tencent.qqmail.utilities.thread.Threads;
import java.io.File;

class ImageDownloadManager$9
  implements Runnable
{
  ImageDownloadManager$9(ImageDownloadManager paramImageDownloadManager, File paramFile, String paramString1, DownloadInfo paramDownloadInfo, String paramString2) {}
  
  public void run()
  {
    Bitmap localBitmap = ImageUtil.memSafeScaleImage(this.val$finalLocalFile.getAbsolutePath(), 1, 1.0F);
    ImageDownloadManager.access$000(this.this$0).addBitmapToCache(this.val$key, localBitmap);
    Threads.runOnMainThread(new ImageDownloadManager.9.1(this, localBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.download.ImageDownloadManager.9
 * JD-Core Version:    0.7.0.1
 */