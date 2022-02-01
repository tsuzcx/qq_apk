package com.tencent.qqmail.download.cursor;

import com.tencent.qqmail.model.mail.callback.QMRefreshCallback;

class DownloadInfoCursor$2
  implements Runnable
{
  DownloadInfoCursor$2(DownloadInfoCursor paramDownloadInfoCursor, QMRefreshCallback paramQMRefreshCallback) {}
  
  public void run()
  {
    this.val$refreshCallback.onRefreshComplete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.download.cursor.DownloadInfoCursor.2
 * JD-Core Version:    0.7.0.1
 */