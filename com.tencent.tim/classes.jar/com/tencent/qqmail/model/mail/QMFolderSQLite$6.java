package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.cache.IQuery;
import com.tencent.qqmail.model.qmdomain.QMFolder;

class QMFolderSQLite$6
  implements IQuery<QMFolder>
{
  QMFolderSQLite$6(QMFolderSQLite paramQMFolderSQLite, int paramInt1, String paramString, int paramInt2) {}
  
  public boolean map(QMFolder paramQMFolder)
  {
    return (paramQMFolder.getRemoteId().equals(this.val$remoteId)) && (paramQMFolder.getAccountId() == this.val$accountId);
  }
  
  public void reduce(QMFolder paramQMFolder)
  {
    paramQMFolder.setType(this.val$type);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMFolderSQLite.6
 * JD-Core Version:    0.7.0.1
 */