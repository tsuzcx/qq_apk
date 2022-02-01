package com.tencent.qqmail.model.mail;

import com.tencent.moai.database.sqlite.SQLiteDatabase;

class QMFolderSQLite$9
  implements Runnable
{
  QMFolderSQLite$9(QMFolderSQLite paramQMFolderSQLite, SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    this.val$writableDb.execSQL("UPDATE QM_FOLDER SET cliUnreadCount=cliUnreadCount+?,svrUnreadCount=svrUnreadCount+?,cliConvUnreadCount=cliConvUnreadCount+?,svrCount=svrCount+? WHERE id=?", new Object[] { Integer.valueOf(this.val$deltaUnreadCount), Integer.valueOf(this.val$deltaUnreadCount), Integer.valueOf(this.val$deltaUnreadCount), Integer.valueOf(this.val$deltaCount), Integer.valueOf(this.val$folderId) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMFolderSQLite.9
 * JD-Core Version:    0.7.0.1
 */