package com.tencent.qqmail.folderlist;

import com.tencent.qqmail.folderlist.model.FolderData;
import com.tencent.qqmail.model.cache.IReducer;

class FolderDataSQLite$13
  implements IReducer<FolderData>
{
  FolderDataSQLite$13(FolderDataSQLite paramFolderDataSQLite, FolderData paramFolderData) {}
  
  public void reduce(FolderData paramFolderData)
  {
    paramFolderData.setSequence(this.val$folderData.getSequence());
    paramFolderData.setSection(this.val$folderData.getSection());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderDataSQLite.13
 * JD-Core Version:    0.7.0.1
 */