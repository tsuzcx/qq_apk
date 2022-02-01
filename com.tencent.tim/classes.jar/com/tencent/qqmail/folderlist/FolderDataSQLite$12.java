package com.tencent.qqmail.folderlist;

import android.content.ContentValues;
import com.tencent.moai.database.sqlite.SQLiteDatabase;

class FolderDataSQLite$12
  implements Runnable
{
  FolderDataSQLite$12(FolderDataSQLite paramFolderDataSQLite, boolean paramBoolean, SQLiteDatabase paramSQLiteDatabase, int paramInt) {}
  
  public void run()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.val$processing) {}
    for (int i = 1;; i = 0)
    {
      localContentValues.put("processing", Integer.valueOf(i));
      this.val$writebleDb.update("QM_FOLDERDATA", localContentValues, "id=?", new String[] { String.valueOf(this.val$folderDataId) });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderDataSQLite.12
 * JD-Core Version:    0.7.0.1
 */