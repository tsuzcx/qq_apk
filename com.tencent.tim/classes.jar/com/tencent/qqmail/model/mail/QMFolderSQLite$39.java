package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.cache.IQuery;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.utilities.QMUtilities;

class QMFolderSQLite$39
  implements IQuery<QMFolder>
{
  QMFolderSQLite$39(QMFolderSQLite paramQMFolderSQLite, int paramInt, int[] paramArrayOfInt) {}
  
  public boolean map(QMFolder paramQMFolder)
  {
    return (paramQMFolder.getAccountId() == this.val$accountId) && (!QMUtilities.contains(QMFolderSQLite.access$000(this.this$0), paramQMFolder.getType()));
  }
  
  public void reduce(QMFolder paramQMFolder)
  {
    if (QMSettingManager.sharedInstance().getAggregateSubject(this.val$accountId)) {}
    for (int i = paramQMFolder.getCliConvUnreadCount();; i = paramQMFolder.getCliUnreadCount())
    {
      if (i > 0)
      {
        paramQMFolder = this.val$ret;
        paramQMFolder[0] = (i + paramQMFolder[0]);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMFolderSQLite.39
 * JD-Core Version:    0.7.0.1
 */