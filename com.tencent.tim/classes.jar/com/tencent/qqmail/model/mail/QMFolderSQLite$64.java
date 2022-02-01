package com.tencent.qqmail.model.mail;

import com.tencent.moai.database.sqlite.SQLiteDatabase;

class QMFolderSQLite$64
  implements Runnable
{
  QMFolderSQLite$64(QMFolderSQLite paramQMFolderSQLite, SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    this.val$writableDb.execSQL("UPDATE QM_FOLDER SET sequence = sequence + 1 WHERE sequence >= ? AND accountId=?", new String[] { String.valueOf(this.val$seq), String.valueOf(this.val$accountId) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMFolderSQLite.64
 * JD-Core Version:    0.7.0.1
 */