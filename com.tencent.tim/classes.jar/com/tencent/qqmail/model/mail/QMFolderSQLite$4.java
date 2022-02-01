package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.cache.IQuery;
import com.tencent.qqmail.model.qmdomain.QMFolder;

class QMFolderSQLite$4
  implements IQuery<QMFolder>
{
  QMFolderSQLite$4(QMFolderSQLite paramQMFolderSQLite, String paramString1, String paramString2, int paramInt) {}
  
  public boolean map(QMFolder paramQMFolder)
  {
    return (paramQMFolder.getRemoteId().equals(this.val$remoteId)) && (paramQMFolder.getAccountId() == this.val$accountId);
  }
  
  public void reduce(QMFolder paramQMFolder)
  {
    paramQMFolder.setName(this.val$folderName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMFolderSQLite.4
 * JD-Core Version:    0.7.0.1
 */