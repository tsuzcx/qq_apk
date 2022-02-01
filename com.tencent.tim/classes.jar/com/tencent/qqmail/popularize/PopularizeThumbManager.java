package com.tencent.qqmail.popularize;

import android.graphics.Bitmap;
import com.tencent.qqmail.download.ImageDownloadManager;
import com.tencent.qqmail.download.listener.ImageDownloadListener;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;

public class PopularizeThumbManager
{
  private static final String TAG = "PopularizeThumbManager";
  private static final PopularizeThumbManager instance = new PopularizeThumbManager();
  
  public static PopularizeThumbManager sharedInstance()
  {
    return instance;
  }
  
  public Bitmap getPopularizeThumb(String paramString)
  {
    if ((paramString != null) && (!paramString.equals("")))
    {
      paramString = ImageDownloadManager.shareInstance().getThumbBitmapFromLocal(paramString);
      if ((paramString != null) && (!paramString.isRecycled())) {
        return paramString;
      }
    }
    return null;
  }
  
  public void loadPopularizeThumb(String paramString)
  {
    loadPopularizeThumbWithCallBack(paramString, null);
  }
  
  public void loadPopularizeThumbCheckMd5(String paramString1, String paramString2, ImageDownloadListener paramImageDownloadListener)
  {
    if (!StringExtention.isNullOrEmpty(paramString2))
    {
      loadPopularizeThumbWithCallBack(paramString1, new PopularizeThumbManager.1(this, paramString2, paramImageDownloadListener));
      return;
    }
    QMLog.log(6, "PopularizeThumbManager", "load popularize image with null md5");
  }
  
  public void loadPopularizeThumbWithCallBack(String paramString, ImageDownloadListener paramImageDownloadListener)
  {
    Threads.runInBackground(new PopularizeThumbManager.2(this, paramString, paramImageDownloadListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.PopularizeThumbManager
 * JD-Core Version:    0.7.0.1
 */