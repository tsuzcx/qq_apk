package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.cache.IQuery;
import com.tencent.qqmail.model.qmdomain.QMFolder;

class QMFolderSQLite$25
  implements IQuery<QMFolder>
{
  QMFolderSQLite$25(QMFolderSQLite paramQMFolderSQLite) {}
  
  public boolean map(QMFolder paramQMFolder)
  {
    return paramQMFolder.getType() == 1;
  }
  
  public void reduce(QMFolder paramQMFolder)
  {
    paramQMFolder.setHasNewMail(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMFolderSQLite.25
 * JD-Core Version:    0.7.0.1
 */