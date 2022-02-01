package com.tencent.qqmail.model.mail;

import android.content.ContentValues;
import com.tencent.moai.database.sqlite.SQLiteDatabase;

class QMFolderSQLite$22
  implements Runnable
{
  QMFolderSQLite$22(QMFolderSQLite paramQMFolderSQLite, int paramInt1, SQLiteDatabase paramSQLiteDatabase, int paramInt2) {}
  
  public void run()
  {
    if (this.val$personalCnt != -1)
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("personalCount", Integer.valueOf(this.val$personalCnt));
      this.val$writableDb.update("QM_FOLDER", localContentValues, "id=?", new String[] { String.valueOf(this.val$folderId) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMFolderSQLite.22
 * JD-Core Version:    0.7.0.1
 */