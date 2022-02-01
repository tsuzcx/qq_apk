package com.tencent.qqmail.folderlist;

import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.folderlist.model.FolderData;

class FolderDataSQLite$5
  implements Runnable
{
  FolderDataSQLite$5(FolderDataSQLite paramFolderDataSQLite, FolderData paramFolderData, SQLiteDatabase paramSQLiteDatabase) {}
  
  public void run()
  {
    int i = this.val$folderData.getId();
    this.val$writebaleDb.execSQL("DELETE FROM QM_FOLDERDATA WHERE id=?", new Object[] { Integer.valueOf(i) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderDataSQLite.5
 * JD-Core Version:    0.7.0.1
 */