package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.cache.IReducer;
import com.tencent.qqmail.model.qmdomain.QMFolder;

class QMFolderSQLite$19
  implements IReducer<QMFolder>
{
  QMFolderSQLite$19(QMFolderSQLite paramQMFolderSQLite, int paramInt) {}
  
  public void reduce(QMFolder paramQMFolder)
  {
    if (this.val$count != -1) {
      paramQMFolder.setSvrCount(this.val$count);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMFolderSQLite.19
 * JD-Core Version:    0.7.0.1
 */