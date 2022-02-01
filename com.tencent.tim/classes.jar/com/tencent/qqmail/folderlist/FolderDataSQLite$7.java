package com.tencent.qqmail.folderlist;

import com.tencent.qqmail.folderlist.model.FolderData;
import com.tencent.qqmail.model.cache.IQuery;
import java.util.ArrayList;

class FolderDataSQLite$7
  implements IQuery<FolderData>
{
  FolderDataSQLite$7(FolderDataSQLite paramFolderDataSQLite, int paramInt, ArrayList paramArrayList) {}
  
  public boolean map(FolderData paramFolderData)
  {
    return paramFolderData.getSection() == this.val$section;
  }
  
  public void reduce(FolderData paramFolderData)
  {
    this.val$folderDatas.add(paramFolderData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderDataSQLite.7
 * JD-Core Version:    0.7.0.1
 */