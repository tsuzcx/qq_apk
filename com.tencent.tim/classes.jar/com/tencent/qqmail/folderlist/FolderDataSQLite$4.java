package com.tencent.qqmail.folderlist;

import com.tencent.qqmail.folderlist.model.FolderData;
import com.tencent.qqmail.model.cache.IMapper;

class FolderDataSQLite$4
  implements IMapper<FolderData>
{
  FolderDataSQLite$4(FolderDataSQLite paramFolderDataSQLite, FolderData paramFolderData) {}
  
  public boolean map(FolderData paramFolderData)
  {
    return paramFolderData.getId() == this.val$folderData.getId();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderDataSQLite.4
 * JD-Core Version:    0.7.0.1
 */