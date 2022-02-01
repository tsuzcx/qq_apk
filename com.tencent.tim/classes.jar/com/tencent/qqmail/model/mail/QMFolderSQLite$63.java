package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.cache.IQuery;
import com.tencent.qqmail.model.qmdomain.QMFolder;

class QMFolderSQLite$63
  implements IQuery<QMFolder>
{
  QMFolderSQLite$63(QMFolderSQLite paramQMFolderSQLite, int paramInt1, int paramInt2) {}
  
  public boolean map(QMFolder paramQMFolder)
  {
    return (paramQMFolder.getAccountId() == this.val$accountId) && (paramQMFolder.getSequence() >= this.val$seq);
  }
  
  public void reduce(QMFolder paramQMFolder)
  {
    paramQMFolder.setSequence(paramQMFolder.getSequence() + 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMFolderSQLite.63
 * JD-Core Version:    0.7.0.1
 */