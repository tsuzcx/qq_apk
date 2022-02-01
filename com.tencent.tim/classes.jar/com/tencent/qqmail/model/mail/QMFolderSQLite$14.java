package com.tencent.qqmail.model.mail;

import android.content.ContentValues;
import com.tencent.moai.database.sqlite.SQLiteDatabase;

class QMFolderSQLite$14
  implements Runnable
{
  QMFolderSQLite$14(QMFolderSQLite paramQMFolderSQLite, String paramString, SQLiteDatabase paramSQLiteDatabase, int paramInt) {}
  
  public void run()
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("syncKey", this.val$syncKey);
    this.val$writableDb.update("QM_FOLDER", localContentValues, "id=?", new String[] { String.valueOf(this.val$folderId) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMFolderSQLite.14
 * JD-Core Version:    0.7.0.1
 */