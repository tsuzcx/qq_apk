package com.tencent.qqmail.folderlist;

import android.content.ContentValues;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.folderlist.model.FolderData;

class FolderDataSQLite$14
  implements Runnable
{
  FolderDataSQLite$14(FolderDataSQLite paramFolderDataSQLite, FolderData paramFolderData, SQLiteDatabase paramSQLiteDatabase) {}
  
  public void run()
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("section", Integer.valueOf(this.val$folderData.getSection()));
    localContentValues.put("sequence", Integer.valueOf(this.val$folderData.getSequence()));
    this.val$writebleDb.update("QM_FOLDERDATA", localContentValues, "id=?", new String[] { String.valueOf(this.val$folderData.getId()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderDataSQLite.14
 * JD-Core Version:    0.7.0.1
 */