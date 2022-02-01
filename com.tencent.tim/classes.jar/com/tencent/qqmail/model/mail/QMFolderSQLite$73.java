package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.cache.IQuery;
import com.tencent.qqmail.model.qmdomain.QMFolder;

class QMFolderSQLite$73
  implements IQuery<QMFolder>
{
  QMFolderSQLite$73(QMFolderSQLite paramQMFolderSQLite, int[] paramArrayOfInt, int paramInt) {}
  
  public boolean map(QMFolder paramQMFolder)
  {
    return paramQMFolder.getType() == this.val$type;
  }
  
  public void reduce(QMFolder paramQMFolder)
  {
    this.val$ret[0] = paramQMFolder.getCliUnreadCount();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMFolderSQLite.73
 * JD-Core Version:    0.7.0.1
 */