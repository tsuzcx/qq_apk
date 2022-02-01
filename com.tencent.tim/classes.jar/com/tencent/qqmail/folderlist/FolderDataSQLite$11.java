package com.tencent.qqmail.folderlist;

import com.tencent.qqmail.folderlist.model.FolderData;
import com.tencent.qqmail.model.cache.IReducer;

class FolderDataSQLite$11
  implements IReducer<FolderData>
{
  FolderDataSQLite$11(FolderDataSQLite paramFolderDataSQLite, boolean paramBoolean) {}
  
  public void reduce(FolderData paramFolderData)
  {
    paramFolderData.setProcessing(this.val$processing);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderDataSQLite.11
 * JD-Core Version:    0.7.0.1
 */