package com.tencent.qqmail.model.mail;

import com.tencent.moai.database.sqlite.SQLiteDatabase;

class QMFolderSQLite$69
  implements Runnable
{
  QMFolderSQLite$69(QMFolderSQLite paramQMFolderSQLite, SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    this.val$writableDb.execSQL("UPDATE QM_FOLDER SET sequence=? WHERE id=?", new Object[] { Integer.valueOf(this.val$sequence), Integer.valueOf(this.val$folderId) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMFolderSQLite.69
 * JD-Core Version:    0.7.0.1
 */