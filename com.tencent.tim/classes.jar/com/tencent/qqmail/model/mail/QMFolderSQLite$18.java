package com.tencent.qqmail.model.mail;

import android.content.ContentValues;
import com.tencent.moai.database.sqlite.SQLiteDatabase;

class QMFolderSQLite$18
  implements Runnable
{
  QMFolderSQLite$18(QMFolderSQLite paramQMFolderSQLite, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, SQLiteDatabase paramSQLiteDatabase, int paramInt3) {}
  
  public void run()
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("overdue", Boolean.valueOf(this.val$overdue));
    if (this.val$hasNewMail) {
      localContentValues.put("hasNewMail", Boolean.valueOf(this.val$hasNewMail));
    }
    if (this.val$unreadCount != -1)
    {
      localContentValues.put("cliUnreadCount", Integer.valueOf(this.val$unreadCount));
      localContentValues.put("svrUnreadCount", Integer.valueOf(this.val$unreadCount));
      localContentValues.put("cliConvUnreadCount", Integer.valueOf(this.val$unreadCount));
    }
    if (this.val$count != -1) {
      localContentValues.put("svrCount", Integer.valueOf(this.val$count));
    }
    this.val$writableDb.update("QM_FOLDER", localContentValues, "id=?", new String[] { String.valueOf(this.val$folderId) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMFolderSQLite.18
 * JD-Core Version:    0.7.0.1
 */