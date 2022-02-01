package com.tencent.qqmail.folderlist;

import com.tencent.qqmail.folderlist.model.FolderData;
import com.tencent.qqmail.model.cache.IQuery;
import java.util.ArrayList;

class FolderDataSQLite$9
  implements IQuery<FolderData>
{
  FolderDataSQLite$9(FolderDataSQLite paramFolderDataSQLite, ArrayList paramArrayList) {}
  
  public boolean map(FolderData paramFolderData)
  {
    return (paramFolderData.getSection() == 0) && (!paramFolderData.isPersistence());
  }
  
  public void reduce(FolderData paramFolderData)
  {
    this.val$folderDatas.add(paramFolderData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderDataSQLite.9
 * JD-Core Version:    0.7.0.1
 */