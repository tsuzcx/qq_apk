package com.tencent.qqmail.model.mail;

import android.content.ContentValues;
import com.tencent.moai.database.sqlite.SQLiteDatabase;

class QMFolderSQLite$32
  implements Runnable
{
  QMFolderSQLite$32(QMFolderSQLite paramQMFolderSQLite, boolean paramBoolean, SQLiteDatabase paramSQLiteDatabase, int paramInt) {}
  
  public void run()
  {
    ContentValues localContentValues = new ContentValues();
    if (!this.val$isDisplay) {}
    for (int i = 0;; i = 1)
    {
      localContentValues.put("isDisplay", Integer.valueOf(i));
      this.val$writableDb.update("QM_FOLDER", localContentValues, "id=?", new String[] { String.valueOf(this.val$folderId) });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMFolderSQLite.32
 * JD-Core Version:    0.7.0.1
 */