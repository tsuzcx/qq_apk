package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.cache.IReducer;
import com.tencent.qqmail.model.qmdomain.QMFolder;

class QMFolderSQLite$21
  implements IReducer<QMFolder>
{
  QMFolderSQLite$21(QMFolderSQLite paramQMFolderSQLite, int paramInt) {}
  
  public void reduce(QMFolder paramQMFolder)
  {
    if (this.val$personalCnt != -1) {
      paramQMFolder.setPersonalCount(this.val$personalCnt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMFolderSQLite.21
 * JD-Core Version:    0.7.0.1
 */