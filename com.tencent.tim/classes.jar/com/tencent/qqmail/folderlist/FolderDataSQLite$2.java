package com.tencent.qqmail.folderlist;

import com.tencent.qqmail.folderlist.model.FolderData;
import com.tencent.qqmail.model.cache.IMapper;

class FolderDataSQLite$2
  implements IMapper<FolderData>
{
  FolderDataSQLite$2(FolderDataSQLite paramFolderDataSQLite, int paramInt) {}
  
  public boolean map(FolderData paramFolderData)
  {
    return (paramFolderData.getAccountId() == this.val$accountId) && (paramFolderData.getType() == 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderDataSQLite.2
 * JD-Core Version:    0.7.0.1
 */