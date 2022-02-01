package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.cache.IReducer;
import com.tencent.qqmail.model.qmdomain.QMFolder;

class QMFolderSQLite$17
  implements IReducer<QMFolder>
{
  QMFolderSQLite$17(QMFolderSQLite paramQMFolderSQLite, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2) {}
  
  public void reduce(QMFolder paramQMFolder)
  {
    if (this.val$hasNewMail) {
      paramQMFolder.setHasNewMail(this.val$hasNewMail);
    }
    paramQMFolder.setOverdue(this.val$overdue);
    if (this.val$unreadCount != -1)
    {
      paramQMFolder.setCliUnreadCount(this.val$unreadCount);
      paramQMFolder.setSvrUnreadCount(this.val$unreadCount);
      paramQMFolder.setCliConvUnreadCount(this.val$unreadCount);
    }
    if (this.val$count != -1) {
      paramQMFolder.setSvrCount(this.val$count);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMFolderSQLite.17
 * JD-Core Version:    0.7.0.1
 */