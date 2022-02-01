package com.tencent.qqmail.download;

import android.graphics.Bitmap;
import com.tencent.qqmail.download.listener.ImageDownloadListener;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;

class ImageDownloadManager$6
  implements ImageDownloadListener
{
  ImageDownloadManager$6(ImageDownloadManager paramImageDownloadManager, int paramInt, DownloadInfo paramDownloadInfo) {}
  
  public void onErrorInMainThread(String paramString, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("download image fail url:").append(paramString).append(", error:");
    if (paramObject != null) {}
    for (String str = paramObject.toString();; str = "")
    {
      QMLog.log(6, "ImageDownloadManager", str);
      Threads.runOnMainThread(new ImageDownloadManager.6.1(this, paramString, paramObject));
      return;
    }
  }
  
  public void onProgressInMainThread(String paramString, long paramLong1, long paramLong2) {}
  
  public void onSuccessInMainThread(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    QMLog.log(4, "ImageDownloadManager", "download image success, start to compress:" + paramString2);
    ImageDownloadManager.access$400(this.this$0, paramString1, this.val$compressSizeType, this.val$info.getImageDownloadListener());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.download.ImageDownloadManager.6
 * JD-Core Version:    0.7.0.1
 */