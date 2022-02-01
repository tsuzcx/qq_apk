package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.cache.IMapper;
import com.tencent.qqmail.model.qmdomain.QMFolder;

class QMFolderSQLite$59
  implements IMapper<QMFolder>
{
  QMFolderSQLite$59(QMFolderSQLite paramQMFolderSQLite, int paramInt) {}
  
  public boolean map(QMFolder paramQMFolder)
  {
    return paramQMFolder.getAccountId() == this.val$accountId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMFolderSQLite.59
 * JD-Core Version:    0.7.0.1
 */