package com.tencent.qqmail.model.mail;

import android.content.ContentValues;
import com.tencent.moai.database.sqlite.SQLiteDatabase;

class QMFolderSQLite$28
  implements Runnable
{
  QMFolderSQLite$28(QMFolderSQLite paramQMFolderSQLite, SQLiteDatabase paramSQLiteDatabase, int paramInt) {}
  
  public void run()
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("hasNewMail", Boolean.valueOf(true));
    this.val$writableDb.update("QM_FOLDER", localContentValues, "id=" + this.val$folderId, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMFolderSQLite.28
 * JD-Core Version:    0.7.0.1
 */