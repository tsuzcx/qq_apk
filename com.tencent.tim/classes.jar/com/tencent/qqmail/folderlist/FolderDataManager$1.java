package com.tencent.qqmail.folderlist;

import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import java.util.concurrent.Callable;

class FolderDataManager$1
  implements Callable<Void>
{
  FolderDataManager$1(FolderDataManager paramFolderDataManager, QMMailSQLiteHelper paramQMMailSQLiteHelper) {}
  
  public Void call()
  {
    this.val$sqliteHelper.folderData.initCache(this.val$sqliteHelper.getReadableDatabase());
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderDataManager.1
 * JD-Core Version:    0.7.0.1
 */