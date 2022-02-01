package com.tencent.qqmail.model.mail;

import android.content.ContentValues;
import com.tencent.moai.database.sqlite.SQLiteDatabase;

class QMFolderSQLite$34
  implements Runnable
{
  QMFolderSQLite$34(QMFolderSQLite paramQMFolderSQLite, boolean paramBoolean, SQLiteDatabase paramSQLiteDatabase, int[] paramArrayOfInt) {}
  
  public void run()
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("overdue", Boolean.valueOf(this.val$overdue));
    this.val$writableDb.update("QM_FOLDER", localContentValues, "id IN" + QMMailSQLiteHelper.getInClause(this.val$folderId), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMFolderSQLite.34
 * JD-Core Version:    0.7.0.1
 */