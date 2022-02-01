package com.tencent.qqmail.folderlist;

import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.model.mail.QMFolderSQLite;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import java.util.concurrent.Callable;

class QMFolderManager$1
  implements Callable<Void>
{
  QMFolderManager$1(QMFolderManager paramQMFolderManager, QMMailSQLiteHelper paramQMMailSQLiteHelper) {}
  
  public Void call()
  {
    SQLiteDatabase localSQLiteDatabase = this.val$sqliteHelper.getReadableDatabase();
    this.val$sqliteHelper.folder.initCache(localSQLiteDatabase);
    QMFolderManager.access$000(this.this$0);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.QMFolderManager.1
 * JD-Core Version:    0.7.0.1
 */