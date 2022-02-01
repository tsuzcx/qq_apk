package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.cache.IQuery;
import com.tencent.qqmail.model.qmdomain.QMFolder;

class QMFolderSQLite$38
  implements IQuery<QMFolder>
{
  QMFolderSQLite$38(QMFolderSQLite paramQMFolderSQLite, int paramInt, boolean[] paramArrayOfBoolean) {}
  
  public boolean map(QMFolder paramQMFolder)
  {
    return (paramQMFolder.getType() == 1) && (paramQMFolder.getAccountId() == this.val$accountId);
  }
  
  public void reduce(QMFolder paramQMFolder)
  {
    this.val$ret[0] = paramQMFolder.hasNewMail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMFolderSQLite.38
 * JD-Core Version:    0.7.0.1
 */