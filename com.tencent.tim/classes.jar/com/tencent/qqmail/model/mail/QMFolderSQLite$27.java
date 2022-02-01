package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.cache.IReducer;
import com.tencent.qqmail.model.qmdomain.QMFolder;

class QMFolderSQLite$27
  implements IReducer<QMFolder>
{
  QMFolderSQLite$27(QMFolderSQLite paramQMFolderSQLite) {}
  
  public void reduce(QMFolder paramQMFolder)
  {
    paramQMFolder.setHasNewMail(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMFolderSQLite.27
 * JD-Core Version:    0.7.0.1
 */