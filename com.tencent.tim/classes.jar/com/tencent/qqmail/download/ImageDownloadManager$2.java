package com.tencent.qqmail.download;

import com.tencent.moai.downloader.exception.DownloadTaskError;
import com.tencent.moai.downloader.listener.DownloadTaskListener;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.download.util.DownloadUtil;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.qmimagecache.DiskLruCache;
import com.tencent.qqmail.qmimagecache.DiskLruCache.Editor;
import com.tencent.qqmail.qmimagecache.ImageCache;
import com.tencent.qqmail.utilities.imageextention.ImageUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

class ImageDownloadManager$2
  implements DownloadTaskListener
{
  ImageDownloadManager$2(ImageDownloadManager paramImageDownloadManager, DownloadInfo paramDownloadInfo) {}
  
  public void onAbort(long paramLong, String arg3)
  {
    QMLog.log(6, "ImageDownloadManager", "attach download abort:" + ???);
    if (paramLong == DownloadUtil.getDownloadTaskId(this.val$info.getKey())) {
      this.val$info.setStatus(6);
    }
    synchronized (ImageDownloadManager.access$200(this.this$0))
    {
      ImageDownloadManager.access$200(this.this$0).remove(Long.valueOf(paramLong));
      ImageDownloadManager.access$300(this.this$0).remove(Long.valueOf(paramLong));
      return;
    }
  }
  
  public void onFail(long paramLong, String paramString, DownloadTaskError paramDownloadTaskError)
  {
    QMLog.log(6, "ImageDownloadManager", "download image fail:" + paramString);
    if (paramLong == DownloadUtil.getDownloadTaskId(this.val$info.getKey()))
    {
      if ((paramDownloadTaskError != null) && (paramDownloadTaskError.getErrorCode() == 5)) {
        DataCollector.logDetailEvent("DetailEvent_SSL_Error", 0L, -1L, paramDownloadTaskError.getMessage());
      }
      Threads.runOnMainThread(new ImageDownloadManager.2.3(this, paramLong, paramDownloadTaskError));
      ImageDownloadManager.access$300(this.this$0).remove(Long.valueOf(paramLong));
    }
  }
  
  public void onProgress(long paramLong1, String paramString, long paramLong2, long paramLong3)
  {
    if (paramLong1 == DownloadUtil.getDownloadTaskId(this.val$info.getKey())) {
      Threads.runOnMainThread(new ImageDownloadManager.2.1(this, paramLong1, paramLong2, paramLong3));
    }
  }
  
  public void onStart(long paramLong, String paramString) {}
  
  public void onSuccess(long paramLong, String paramString1, String paramString2)
  {
    boolean bool = true;
    QMLog.log(4, "ImageDownloadManager", "image download success:" + paramString1 + ", path:" + paramString2);
    if (paramLong == DownloadUtil.getDownloadTaskId(this.val$info.getKey())) {}
    try
    {
      paramString1 = StringExtention.hashKeyForDisk(this.val$info.getUrl());
      ImageDownloadManager.access$000(this.this$0).getDiskLruCache().edit(paramString1).commit();
      this.val$info.setFileName(paramString1);
      paramString1 = ImageDownloadManager.access$000(this.this$0).getDiskLruCache().getReadableFile(this.val$info.getFileName());
      if ((paramString1 == null) || (!paramString1.exists()) || (paramString1.length() == 0L))
      {
        paramString2 = new StringBuilder().append("image download file null:");
        if (paramString1 == null)
        {
          QMLog.log(6, "ImageDownloadManager", bool);
          if ((paramString1 != null) && (paramString1.length() == 0L))
          {
            QMLog.log(6, "ImageDownloadManager", "downloadImage file zero error " + this.val$info.getUrl() + "," + paramString1.getName());
            paramString1.delete();
          }
          onFail(paramLong, this.val$info.getUrl(), new DownloadTaskError(2, "download error"));
          return;
        }
      }
    }
    catch (IOException paramString1)
    {
      for (;;)
      {
        QMLog.log(6, "ImageDownloadManager", paramString1.getMessage());
        continue;
        bool = false;
      }
      QMLog.log(4, "ImageDownloadManager", "image size: " + paramString1.length());
      paramString2 = ImageUtil.memSafeScaleImage(paramString1.getAbsolutePath(), 1, 1.0F);
    }
    try
    {
      ImageDownloadManager.access$000(this.this$0).addBitmapToCache(this.val$info.getFileName(), paramString2);
      ImageDownloadManager.access$000(this.this$0).getDiskLruCache().flush();
      Threads.runOnMainThread(new ImageDownloadManager.2.2(this, paramLong, paramString2, paramString1));
      ImageDownloadManager.access$300(this.this$0).remove(Long.valueOf(paramLong));
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.download.ImageDownloadManager.2
 * JD-Core Version:    0.7.0.1
 */