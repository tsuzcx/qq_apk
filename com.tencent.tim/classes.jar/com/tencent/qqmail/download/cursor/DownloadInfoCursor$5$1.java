package com.tencent.qqmail.download.cursor;

import com.tencent.qqmail.model.mail.QMCursorCollector;

class DownloadInfoCursor$5$1
  implements Runnable
{
  DownloadInfoCursor$5$1(DownloadInfoCursor.5 param5) {}
  
  public void run()
  {
    DownloadInfoCursor.access$202(this.this$1.this$0, DownloadInfoCursor.access$300(this.this$1.this$0));
    if (DownloadInfoCursor.access$100(this.this$1.this$0) != null) {
      DownloadInfoCursor.access$100(this.this$1.this$0).run();
    }
    QMCursorCollector.release(this.this$1.val$originalCursor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.download.cursor.DownloadInfoCursor.5.1
 * JD-Core Version:    0.7.0.1
 */