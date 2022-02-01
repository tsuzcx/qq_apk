package com.tencent.qqmail.download.cursor;

import com.tencent.qqmail.model.mail.callback.QMRefreshCallback;

class DownloadInfoCursor$1
  implements Runnable
{
  DownloadInfoCursor$1(DownloadInfoCursor paramDownloadInfoCursor, QMRefreshCallback paramQMRefreshCallback) {}
  
  public void run()
  {
    this.val$refreshCallback.onBeforeRefresh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.download.cursor.DownloadInfoCursor.1
 * JD-Core Version:    0.7.0.1
 */