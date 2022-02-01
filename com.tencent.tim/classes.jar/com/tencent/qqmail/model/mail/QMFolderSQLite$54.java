package com.tencent.qqmail.model.mail;

import com.tencent.moai.database.sqlite.SQLiteDatabase;

class QMFolderSQLite$54
  implements Runnable
{
  QMFolderSQLite$54(QMFolderSQLite paramQMFolderSQLite, SQLiteDatabase paramSQLiteDatabase, long paramLong, int paramInt) {}
  
  public void run()
  {
    this.val$writableDb.execSQL("UPDATE QM_FOLDER SET since =?  WHERE id=?", new Object[] { Long.valueOf(this.val$since), Integer.valueOf(this.val$folderId) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMFolderSQLite.54
 * JD-Core Version:    0.7.0.1
 */