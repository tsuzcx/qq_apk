package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.cache.IQuery;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import java.util.HashSet;
import java.util.List;

class QMFolderSQLite$51
  implements IQuery<QMFolder>
{
  QMFolderSQLite$51(QMFolderSQLite paramQMFolderSQLite, int paramInt, List paramList, HashSet paramHashSet) {}
  
  public boolean map(QMFolder paramQMFolder)
  {
    return (paramQMFolder.getAccountId() == this.val$accountId) && (this.val$remoteIdList.contains(paramQMFolder.getRemoteId()));
  }
  
  public void reduce(QMFolder paramQMFolder)
  {
    this.val$folderIds.add(Integer.valueOf(paramQMFolder.getId()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMFolderSQLite.51
 * JD-Core Version:    0.7.0.1
 */