package com.tencent.qqmail.model.mail;

import android.content.ContentValues;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.utilities.log.QMLog;

class QMFolderSQLite$12
  implements Runnable
{
  QMFolderSQLite$12(QMFolderSQLite paramQMFolderSQLite, SQLiteDatabase paramSQLiteDatabase, String paramString, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    this.val$writableDb.beginTransactionNonExclusive();
    try
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("remoteId", this.val$remoteId);
      localContentValues.put("id", String.valueOf(this.val$newId));
      this.val$writableDb.update("QM_FOLDER", localContentValues, "id=?", new String[] { String.valueOf(this.val$folderId) });
      localContentValues.clear();
      localContentValues.put("folderId", String.valueOf(this.val$newId));
      this.val$writableDb.update("QM_MAIL_INFO", localContentValues, "folderId=?", new String[] { String.valueOf(this.val$folderId) });
      this.val$writableDb.setTransactionSuccessful();
      return;
    }
    catch (Exception localException)
    {
      QMLog.log(6, "QMMailSQLite", "update folder remote id: " + localException.toString());
      return;
    }
    finally
    {
      this.val$writableDb.endTransaction();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMFolderSQLite.12
 * JD-Core Version:    0.7.0.1
 */