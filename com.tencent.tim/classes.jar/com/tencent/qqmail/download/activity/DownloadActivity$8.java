package com.tencent.qqmail.download.activity;

import com.tencent.qqmail.download.DownloadInfoManager;
import com.tencent.qqmail.download.cursor.DownloadInfoCursor;
import java.util.concurrent.Callable;

class DownloadActivity$8
  implements Callable<DownloadInfoCursor>
{
  DownloadActivity$8(DownloadActivity paramDownloadActivity) {}
  
  public DownloadInfoCursor call()
    throws Exception
  {
    DownloadInfoManager.shareInstance().clearInvalidDownloadInfoData();
    DownloadInfoCursor localDownloadInfoCursor = DownloadInfoManager.shareInstance().getDownloadCursor();
    localDownloadInfoCursor.setOnRefresh(new DownloadActivity.8.1(this));
    localDownloadInfoCursor.setThreadWrapper(new DownloadActivity.8.2(this));
    localDownloadInfoCursor.refresh(true, null);
    return localDownloadInfoCursor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.download.activity.DownloadActivity.8
 * JD-Core Version:    0.7.0.1
 */