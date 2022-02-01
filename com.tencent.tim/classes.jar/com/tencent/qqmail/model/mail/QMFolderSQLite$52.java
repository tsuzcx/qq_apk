package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.cache.IQuery;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.utilities.QMUtilities;
import java.util.HashSet;

class QMFolderSQLite$52
  implements IQuery<QMFolder>
{
  QMFolderSQLite$52(QMFolderSQLite paramQMFolderSQLite, int paramInt, int[] paramArrayOfInt, HashSet paramHashSet) {}
  
  public boolean map(QMFolder paramQMFolder)
  {
    return (!paramQMFolder.isVirtual()) && (paramQMFolder.getAccountId() == this.val$accountId) && (!QMUtilities.contains(this.val$newFolderIds, paramQMFolder.getId()));
  }
  
  public void reduce(QMFolder paramQMFolder)
  {
    this.val$folderIds.add(Integer.valueOf(paramQMFolder.getId()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMFolderSQLite.52
 * JD-Core Version:    0.7.0.1
 */