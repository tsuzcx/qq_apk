package com.tencent.qqmail.model.mail;

import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.model.cache.IReducer;
import com.tencent.qqmail.model.qmdomain.QMFolder;

class QMFolderSQLite$55
  implements IReducer<QMFolder>
{
  QMFolderSQLite$55(QMFolderSQLite paramQMFolderSQLite, SQLiteDatabase paramSQLiteDatabase, String paramString) {}
  
  public void reduce(QMFolder paramQMFolder)
  {
    paramQMFolder.setSince(QMFolderSQLite.access$200(this.this$0, this.val$writableDb, this.val$sinceRemoteId));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMFolderSQLite.55
 * JD-Core Version:    0.7.0.1
 */