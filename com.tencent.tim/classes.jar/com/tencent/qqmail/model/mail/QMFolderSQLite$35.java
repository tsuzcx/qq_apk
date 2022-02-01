package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.cache.IReducer;
import com.tencent.qqmail.model.qmdomain.QMFolder;

class QMFolderSQLite$35
  implements IReducer<QMFolder>
{
  QMFolderSQLite$35(QMFolderSQLite paramQMFolderSQLite, long paramLong) {}
  
  public void reduce(QMFolder paramQMFolder)
  {
    paramQMFolder.setFromTime(this.val$time);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMFolderSQLite.35
 * JD-Core Version:    0.7.0.1
 */