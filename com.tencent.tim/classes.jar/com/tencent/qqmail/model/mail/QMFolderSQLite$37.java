package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.cache.IQuery;
import com.tencent.qqmail.model.qmdomain.QMFolder;

class QMFolderSQLite$37
  implements IQuery<QMFolder>
{
  QMFolderSQLite$37(QMFolderSQLite paramQMFolderSQLite, int paramInt, int[] paramArrayOfInt) {}
  
  public boolean map(QMFolder paramQMFolder)
  {
    return (paramQMFolder.getType() == 1) && (paramQMFolder.getAccountId() == this.val$accountId);
  }
  
  public void reduce(QMFolder paramQMFolder)
  {
    boolean bool = QMSettingManager.sharedInstance().getAggregateSubject(this.val$accountId);
    int[] arrayOfInt = this.val$ret;
    if (bool) {}
    for (int i = paramQMFolder.getCliConvUnreadCount();; i = paramQMFolder.getCliUnreadCount())
    {
      arrayOfInt[0] = i;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMFolderSQLite.37
 * JD-Core Version:    0.7.0.1
 */