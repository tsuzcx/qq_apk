package com.tencent.qqmail.model.mail;

import com.tencent.moai.database.sqlite.SQLiteDatabase;

class QMFolderSQLite$56
  implements Runnable
{
  QMFolderSQLite$56(QMFolderSQLite paramQMFolderSQLite, SQLiteDatabase paramSQLiteDatabase, String paramString, int paramInt) {}
  
  public void run()
  {
    this.val$writableDb.execSQL("UPDATE QM_FOLDER SET since=(SELECT utcSent FROM QM_MAIL_INFO WHERE remoteId=?) WHERE id=?", new Object[] { this.val$sinceRemoteId, Integer.valueOf(this.val$folderId) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMFolderSQLite.56
 * JD-Core Version:    0.7.0.1
 */