package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.cache.IQuery;
import com.tencent.qqmail.model.qmdomain.QMFolder;

class QMFolderSQLite$71
  implements IQuery<QMFolder>
{
  QMFolderSQLite$71(QMFolderSQLite paramQMFolderSQLite, int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean map(QMFolder paramQMFolder)
  {
    return paramQMFolder.getId() == this.val$folderId;
  }
  
  public void reduce(QMFolder paramQMFolder)
  {
    if (paramQMFolder.getSvrCount() < 0) {
      paramQMFolder.setSvrCount(this.val$deltaServerCount);
    }
    while (paramQMFolder.getSvrUnreadCount() < 0)
    {
      paramQMFolder.setSvrUnreadCount(this.val$deltaServerUnread);
      return;
      paramQMFolder.setSvrCount(paramQMFolder.getSvrCount() + this.val$deltaServerCount);
    }
    paramQMFolder.setSvrUnreadCount(paramQMFolder.getSvrUnreadCount() + this.val$deltaServerUnread);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMFolderSQLite.71
 * JD-Core Version:    0.7.0.1
 */