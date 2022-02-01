package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.cache.IQuery;
import com.tencent.qqmail.model.qmdomain.QMFolder;

class QMFolderSQLite$60
  implements IQuery<QMFolder>
{
  QMFolderSQLite$60(QMFolderSQLite paramQMFolderSQLite, int paramInt1, int paramInt2, int[] paramArrayOfInt) {}
  
  public boolean map(QMFolder paramQMFolder)
  {
    return (paramQMFolder.getAccountId() == this.val$accountId) && (paramQMFolder.getType() == this.val$type);
  }
  
  public void reduce(QMFolder paramQMFolder)
  {
    paramQMFolder = this.val$ret;
    paramQMFolder[0] += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMFolderSQLite.60
 * JD-Core Version:    0.7.0.1
 */