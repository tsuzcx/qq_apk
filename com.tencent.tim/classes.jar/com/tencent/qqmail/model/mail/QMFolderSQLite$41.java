package com.tencent.qqmail.model.mail;

import android.content.ContentValues;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.model.qmdomain.QMFolder;

class QMFolderSQLite$41
  implements Runnable
{
  QMFolderSQLite$41(QMFolderSQLite paramQMFolderSQLite, SQLiteDatabase paramSQLiteDatabase, QMFolder paramQMFolder) {}
  
  public void run()
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("hasNewMail", Boolean.valueOf(false));
    this.val$writableDb.update("QM_FOLDER", localContentValues, "id=?", new String[] { this.val$qmFolder.getId() + "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMFolderSQLite.41
 * JD-Core Version:    0.7.0.1
 */