package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.cache.IQuery;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.utilities.QMUtilities;

class QMFolderSQLite$42
  implements IQuery<QMFolder>
{
  QMFolderSQLite$42(QMFolderSQLite paramQMFolderSQLite, boolean paramBoolean, int paramInt, boolean[] paramArrayOfBoolean) {}
  
  public boolean map(QMFolder paramQMFolder)
  {
    if (this.val$aggregateSubject) {}
    for (int i = paramQMFolder.getCliConvUnreadCount(); (i > 0) && (paramQMFolder.getAccountId() == this.val$accountId) && (!QMUtilities.contains(QMFolderSQLite.access$100(this.this$0), paramQMFolder.getType())); i = paramQMFolder.getCliUnreadCount()) {
      return true;
    }
    return false;
  }
  
  public void reduce(QMFolder paramQMFolder)
  {
    boolean[] arrayOfBoolean = this.val$ret;
    arrayOfBoolean[0] |= paramQMFolder.hasNewMail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMFolderSQLite.42
 * JD-Core Version:    0.7.0.1
 */