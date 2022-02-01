package com.tencent.qqmail.model.mail;

import android.content.ContentValues;
import com.tencent.moai.database.sqlite.SQLiteDatabase;

class QMFolderSQLite$5
  implements Runnable
{
  QMFolderSQLite$5(QMFolderSQLite paramQMFolderSQLite, String paramString1, SQLiteDatabase paramSQLiteDatabase, String paramString2, int paramInt) {}
  
  public void run()
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("name", this.val$folderName);
    this.val$writableDb.update("QM_FOLDER", localContentValues, "remoteId=? AND accountId=?", new String[] { this.val$remoteId, String.valueOf(this.val$accountId) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMFolderSQLite.5
 * JD-Core Version:    0.7.0.1
 */