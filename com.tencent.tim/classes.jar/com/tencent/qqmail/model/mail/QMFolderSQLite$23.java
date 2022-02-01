package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.cache.IMapper;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.utilities.QMUtilities;

class QMFolderSQLite$23
  implements IMapper<QMFolder>
{
  QMFolderSQLite$23(QMFolderSQLite paramQMFolderSQLite, int paramInt, int[] paramArrayOfInt) {}
  
  public boolean map(QMFolder paramQMFolder)
  {
    return (paramQMFolder.getAccountId() == this.val$accountId) && (!QMUtilities.contains(this.val$excludeFolderIds, paramQMFolder.getId()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMFolderSQLite.23
 * JD-Core Version:    0.7.0.1
 */