package com.tencent.qqmail.download.cursor;

import android.database.Cursor;
import java.util.concurrent.Callable;

class DownloadInfoCursor$3
  implements Callable<Cursor>
{
  DownloadInfoCursor$3(DownloadInfoCursor paramDownloadInfoCursor) {}
  
  public Cursor call()
    throws Exception
  {
    Cursor localCursor = DownloadInfoCursor.access$000(this.this$0);
    if (localCursor != null) {
      localCursor.getCount();
    }
    return localCursor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.download.cursor.DownloadInfoCursor.3
 * JD-Core Version:    0.7.0.1
 */