package com.tencent.qqmail.model.cache;

import com.tencent.qqmail.folderlist.model.FolderData;

public class FolderDataCache
  extends QMReadWriteCache<Integer, FolderData>
{
  public Integer getKeyByItem(FolderData paramFolderData)
  {
    return Integer.valueOf(paramFolderData.getId());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.cache.FolderDataCache
 * JD-Core Version:    0.7.0.1
 */