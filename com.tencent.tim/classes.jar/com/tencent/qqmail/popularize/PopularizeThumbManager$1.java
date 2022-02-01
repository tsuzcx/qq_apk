package com.tencent.qqmail.popularize;

import android.graphics.Bitmap;
import com.tencent.moai.downloader.exception.DownloadTaskError;
import com.tencent.qqmail.download.listener.ImageDownloadListener;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.io.File;

class PopularizeThumbManager$1
  implements ImageDownloadListener
{
  PopularizeThumbManager$1(PopularizeThumbManager paramPopularizeThumbManager, String paramString, ImageDownloadListener paramImageDownloadListener) {}
  
  public void onErrorInMainThread(String paramString, Object paramObject)
  {
    if (this.val$listener != null) {
      this.val$listener.onErrorInMainThread(paramString, paramObject);
    }
  }
  
  public void onProgressInMainThread(String paramString, long paramLong1, long paramLong2)
  {
    if (this.val$listener != null) {
      this.val$listener.onProgressInMainThread(paramString, paramLong1, paramLong2);
    }
  }
  
  public void onSuccessInMainThread(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    File localFile = new File(paramString2);
    long l = System.currentTimeMillis();
    String str = StringExtention.fileMD5(localFile);
    QMLog.log(4, "PopularizeThumbManager", "get md5 time:" + (System.currentTimeMillis() - l));
    if ((StringExtention.isNullOrEmpty(str)) || (!str.equals(this.val$md5)))
    {
      QMLog.log(6, "PopularizeThumbManager", "download popularize md5 fail. file:" + str + ", src:" + this.val$md5);
      localFile.delete();
      onErrorInMainThread(paramString1, new DownloadTaskError(2, "error file with error md5"));
    }
    do
    {
      return;
      QMLog.log(4, "PopularizeThumbManager", "check md5 success");
    } while (this.val$listener == null);
    this.val$listener.onSuccessInMainThread(paramString1, paramBitmap, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.PopularizeThumbManager.1
 * JD-Core Version:    0.7.0.1
 */