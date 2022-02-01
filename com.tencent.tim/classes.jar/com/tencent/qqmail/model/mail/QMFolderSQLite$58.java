package com.tencent.qqmail.model.mail;

import com.tencent.moai.database.sqlite.SQLiteDatabase;

class QMFolderSQLite$58
  implements Runnable
{
  QMFolderSQLite$58(QMFolderSQLite paramQMFolderSQLite, SQLiteDatabase paramSQLiteDatabase, String paramString, int paramInt) {}
  
  public void run()
  {
    this.val$writableDb.execSQL("UPDATE QM_FOLDER SET since=(SELECT utcSent FROM QM_MAIL_INFO WHERE remoteId=?) WHERE accountId=?", new Object[] { this.val$sinceRemoteId, Integer.valueOf(this.val$accountId) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMFolderSQLite.58
 * JD-Core Version:    0.7.0.1
 */