package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.cache.IReducer;
import com.tencent.qqmail.model.qmdomain.QMFolder;

class QMFolderSQLite$31
  implements IReducer<QMFolder>
{
  QMFolderSQLite$31(QMFolderSQLite paramQMFolderSQLite, boolean paramBoolean) {}
  
  public void reduce(QMFolder paramQMFolder)
  {
    paramQMFolder.setDisplay(this.val$isDisplay);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMFolderSQLite.31
 * JD-Core Version:    0.7.0.1
 */