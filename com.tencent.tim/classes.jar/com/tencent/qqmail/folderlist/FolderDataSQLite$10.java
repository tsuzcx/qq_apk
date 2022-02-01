package com.tencent.qqmail.folderlist;

import com.tencent.qqmail.folderlist.model.FolderData;
import com.tencent.qqmail.model.cache.IQuery;
import java.util.Set;

class FolderDataSQLite$10
  implements IQuery<FolderData>
{
  FolderDataSQLite$10(FolderDataSQLite paramFolderDataSQLite, int paramInt, Set paramSet) {}
  
  public boolean map(FolderData paramFolderData)
  {
    return (paramFolderData.getSection() == 0) && (!paramFolderData.isPersistence()) && (paramFolderData.getAccountId() == this.val$accountId);
  }
  
  public void reduce(FolderData paramFolderData)
  {
    this.val$activeFolderIds.add(Integer.valueOf(paramFolderData.getFolderId()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderDataSQLite.10
 * JD-Core Version:    0.7.0.1
 */