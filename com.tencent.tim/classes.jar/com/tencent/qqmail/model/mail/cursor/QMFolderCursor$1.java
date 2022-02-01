package com.tencent.qqmail.model.mail.cursor;

import com.tencent.qqmail.model.mail.QMMailSQLite;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import java.util.concurrent.Callable;

class QMFolderCursor$1
  implements Callable<Boolean>
{
  QMFolderCursor$1(QMFolderCursor paramQMFolderCursor, QMMailSQLiteHelper paramQMMailSQLiteHelper) {}
  
  public Boolean call()
    throws Exception
  {
    return Boolean.valueOf(this.val$sqliteHelper.mail.isFolderSyncEmpty(this.val$sqliteHelper.getReadableDatabase(), this.this$0.folder));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.cursor.QMFolderCursor.1
 * JD-Core Version:    0.7.0.1
 */