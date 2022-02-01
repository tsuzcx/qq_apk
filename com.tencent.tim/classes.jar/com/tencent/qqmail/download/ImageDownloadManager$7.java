package com.tencent.qqmail.download;

import com.tencent.qqmail.download.listener.ImageDownloadListener;
import com.tencent.qqmail.model.mail.watcher.CompressImageWatcher;
import com.tencent.qqmail.model.uidomain.ComposeMailUI.ImageScaleDegree;
import com.tencent.qqmail.qmimagecache.ImageCompresser;
import com.tencent.qqmail.utilities.imageextention.ImageUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;
import java.io.File;

class ImageDownloadManager$7
  implements CompressImageWatcher
{
  ImageDownloadManager$7(ImageDownloadManager paramImageDownloadManager, ImageCompresser paramImageCompresser, String paramString, int paramInt, ImageDownloadListener paramImageDownloadListener, File paramFile) {}
  
  public void onError(String paramString1, String paramString2)
  {
    QMLog.log(6, "ImageDownloadManager", "compress error, src:" + paramString1 + ", reason:" + paramString2);
  }
  
  public void onSuccess(String paramString1, String paramString2)
  {
    QMLog.log(4, "ImageDownloadManager", "compress success:" + paramString2);
    paramString1 = ImageUtil.memSafeScaleImage(paramString2, 1, ComposeMailUI.ImageScaleDegree.ImageScaleDegree_Origin.ordinal());
    this.val$imageCompresser.addBitmapToMemCache(this.val$url, paramString1, this.val$compressSizeType);
    Threads.runOnMainThread(new ImageDownloadManager.7.1(this, paramString1));
  }
  
  public void onWait(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.download.ImageDownloadManager.7
 * JD-Core Version:    0.7.0.1
 */