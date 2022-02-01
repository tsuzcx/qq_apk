package com.tencent.qqmail.model.mail;

import android.content.ContentValues;
import com.tencent.moai.database.sqlite.SQLiteDatabase;

class QMFolderSQLite$7
  implements Runnable
{
  QMFolderSQLite$7(QMFolderSQLite paramQMFolderSQLite, int paramInt1, SQLiteDatabase paramSQLiteDatabase, String paramString, int paramInt2) {}
  
  public void run()
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("type", Integer.valueOf(this.val$type));
    this.val$writableDb.update("QM_FOLDER", localContentValues, "remoteId=? AND accountId=?", new String[] { this.val$remoteId, String.valueOf(this.val$accountId) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMFolderSQLite.7
 * JD-Core Version:    0.7.0.1
 */