package com.tencent.qqmail.model.mail;

import com.tencent.moai.database.sqlite.SQLiteDatabase;

class QMFolderSQLite$72
  implements Runnable
{
  QMFolderSQLite$72(QMFolderSQLite paramQMFolderSQLite, SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    this.val$writableDb.execSQL("UPDATE QM_FOLDER SET svrUnreadCount=(CASE WHEN svrUnreadCount < 0 THEN svrUnreadCount ELSE svrUnreadCount+? END),svrCount=(CASE WHEN svrCount < 0 THEN svrCount ELSE svrCount+? END) WHERE id = ?", new String[] { String.valueOf(this.val$deltaServerUnread), String.valueOf(this.val$deltaServerCount), String.valueOf(this.val$folderId) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMFolderSQLite.72
 * JD-Core Version:    0.7.0.1
 */