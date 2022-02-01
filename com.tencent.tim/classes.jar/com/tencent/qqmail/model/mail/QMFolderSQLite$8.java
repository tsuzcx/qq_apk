package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.cache.IReducer;
import com.tencent.qqmail.model.qmdomain.QMFolder;

class QMFolderSQLite$8
  implements IReducer<QMFolder>
{
  QMFolderSQLite$8(QMFolderSQLite paramQMFolderSQLite, int paramInt1, int paramInt2) {}
  
  public void reduce(QMFolder paramQMFolder)
  {
    paramQMFolder.setCliConvUnreadCount(paramQMFolder.getCliConvUnreadCount() + this.val$deltaUnreadCount);
    paramQMFolder.setCliUnreadCount(paramQMFolder.getCliUnreadCount() + this.val$deltaUnreadCount);
    paramQMFolder.setSvrUnreadCount(paramQMFolder.getSvrUnreadCount() + this.val$deltaUnreadCount);
    paramQMFolder.setSvrCount(paramQMFolder.getSvrCount() + this.val$deltaCount);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMFolderSQLite.8
 * JD-Core Version:    0.7.0.1
 */