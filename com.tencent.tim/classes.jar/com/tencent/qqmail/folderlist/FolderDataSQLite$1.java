package com.tencent.qqmail.folderlist;

import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.folderlist.model.FolderData;

class FolderDataSQLite$1
  implements Runnable
{
  FolderDataSQLite$1(FolderDataSQLite paramFolderDataSQLite, FolderData paramFolderData, SQLiteDatabase paramSQLiteDatabase) {}
  
  public void run()
  {
    int i = this.val$folderData.getId();
    int j = this.val$folderData.getFolderId();
    int k = this.val$folderData.getAccountId();
    String str = this.val$folderData.getName();
    int m = this.val$folderData.getSection();
    int n = this.val$folderData.getSequence();
    int i1 = this.val$folderData.getType();
    boolean bool1 = this.val$folderData.isShouldShow();
    boolean bool2 = this.val$folderData.isPersistence();
    boolean bool3 = this.val$folderData.isProcessing();
    this.val$writebaleDb.execSQL("REPLACE INTO QM_FOLDERDATA (id , folderId , accountId , name , section , sequence , type , shouldShow , persistence , processing ) VALUES (?,?,?,?,?,?,?,?,?,?)", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), str, Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderDataSQLite.1
 * JD-Core Version:    0.7.0.1
 */