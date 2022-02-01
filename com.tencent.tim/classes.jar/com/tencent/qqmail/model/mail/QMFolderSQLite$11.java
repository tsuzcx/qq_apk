package com.tencent.qqmail.model.mail;

import android.content.ContentValues;
import com.tencent.moai.database.sqlite.SQLiteDatabase;

class QMFolderSQLite$11
  implements Runnable
{
  QMFolderSQLite$11(QMFolderSQLite paramQMFolderSQLite, boolean paramBoolean, SQLiteDatabase paramSQLiteDatabase, int paramInt) {}
  
  public void run()
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("hasNewMail", Boolean.valueOf(this.val$hasNew));
    this.val$writableDb.update("QM_FOLDER", localContentValues, "accountId=?", new String[] { String.valueOf(this.val$accountId) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMFolderSQLite.11
 * JD-Core Version:    0.7.0.1
 */