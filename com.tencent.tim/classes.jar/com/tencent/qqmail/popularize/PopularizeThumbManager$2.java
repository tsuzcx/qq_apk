package com.tencent.qqmail.popularize;

import com.tencent.qqmail.download.ImageDownloadManager;
import com.tencent.qqmail.download.listener.ImageDownloadListener;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;

class PopularizeThumbManager$2
  implements Runnable
{
  PopularizeThumbManager$2(PopularizeThumbManager paramPopularizeThumbManager, String paramString, ImageDownloadListener paramImageDownloadListener) {}
  
  public void run()
  {
    try
    {
      if (!StringExtention.isNullOrEmpty(this.val$url))
      {
        DownloadInfo localDownloadInfo = new DownloadInfo();
        localDownloadInfo.setAccountId(-1);
        localDownloadInfo.setUrl(this.val$url);
        localDownloadInfo.setImageDownloadListener(new PopularizeThumbManager.2.1(this));
        ImageDownloadManager.shareInstance().fetchImage(localDownloadInfo);
      }
      return;
    }
    catch (Exception localException)
    {
      QMLog.log(6, "PopularizeThumbManager", "load PopularizeThumbWithCallBack");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.PopularizeThumbManager.2
 * JD-Core Version:    0.7.0.1
 */