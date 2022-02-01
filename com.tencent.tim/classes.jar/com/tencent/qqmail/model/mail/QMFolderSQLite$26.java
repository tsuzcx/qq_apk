package com.tencent.qqmail.model.mail;

import android.content.ContentValues;
import com.tencent.moai.database.sqlite.SQLiteDatabase;

class QMFolderSQLite$26
  implements Runnable
{
  QMFolderSQLite$26(QMFolderSQLite paramQMFolderSQLite, SQLiteDatabase paramSQLiteDatabase) {}
  
  public void run()
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("hasNewMail", Boolean.valueOf(false));
    this.val$writableDb.update("QM_FOLDER", localContentValues, "type=1", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMFolderSQLite.26
 * JD-Core Version:    0.7.0.1
 */