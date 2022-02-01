package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.cache.IQuery;
import com.tencent.qqmail.model.qmdomain.QMFolder;

class QMFolderSQLite$57
  implements IQuery<QMFolder>
{
  QMFolderSQLite$57(QMFolderSQLite paramQMFolderSQLite, long paramLong, int paramInt) {}
  
  public boolean map(QMFolder paramQMFolder)
  {
    return paramQMFolder.getAccountId() == this.val$accountId;
  }
  
  public void reduce(QMFolder paramQMFolder)
  {
    paramQMFolder.setSince(this.val$since);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMFolderSQLite.57
 * JD-Core Version:    0.7.0.1
 */