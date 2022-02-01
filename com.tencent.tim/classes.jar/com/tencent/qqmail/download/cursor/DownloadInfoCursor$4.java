package com.tencent.qqmail.download.cursor;

import android.database.Cursor;
import com.tencent.qqmail.model.mail.QMCursorCollector;

class DownloadInfoCursor$4
  implements Runnable
{
  DownloadInfoCursor$4(DownloadInfoCursor paramDownloadInfoCursor, boolean paramBoolean, Cursor paramCursor) {}
  
  public void run()
  {
    if ((this.val$noData) && (DownloadInfoCursor.access$100(this.this$0) != null)) {
      DownloadInfoCursor.access$100(this.this$0).run();
    }
    QMCursorCollector.release(this.val$originalCursor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.download.cursor.DownloadInfoCursor.4
 * JD-Core Version:    0.7.0.1
 */