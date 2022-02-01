package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.cache.IQuery;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.utilities.QMUtilities;

class QMFolderSQLite$33
  implements IQuery<QMFolder>
{
  QMFolderSQLite$33(QMFolderSQLite paramQMFolderSQLite, boolean paramBoolean, int[] paramArrayOfInt) {}
  
  public boolean map(QMFolder paramQMFolder)
  {
    return QMUtilities.contains(this.val$folderId, paramQMFolder.getId());
  }
  
  public void reduce(QMFolder paramQMFolder)
  {
    paramQMFolder.setOverdue(this.val$overdue);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMFolderSQLite.33
 * JD-Core Version:    0.7.0.1
 */