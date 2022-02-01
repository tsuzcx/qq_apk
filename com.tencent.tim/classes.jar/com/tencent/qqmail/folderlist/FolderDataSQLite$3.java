package com.tencent.qqmail.folderlist;

import com.tencent.moai.database.sqlite.SQLiteDatabase;

class FolderDataSQLite$3
  implements Runnable
{
  FolderDataSQLite$3(FolderDataSQLite paramFolderDataSQLite, int paramInt, SQLiteDatabase paramSQLiteDatabase) {}
  
  public void run()
  {
    int i = this.val$accountId;
    this.val$writebaleDb.execSQL("DELETE FROM QM_FOLDERDATA WHERE type=3 AND accountId=?", new Object[] { Integer.valueOf(i) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderDataSQLite.3
 * JD-Core Version:    0.7.0.1
 */