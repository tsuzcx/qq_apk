package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.cache.IMapper;
import com.tencent.qqmail.model.qmdomain.QMFolder;

class QMFolderSQLite$46
  implements IMapper<QMFolder>
{
  QMFolderSQLite$46(QMFolderSQLite paramQMFolderSQLite, int paramInt1, int paramInt2) {}
  
  public boolean map(QMFolder paramQMFolder)
  {
    return (paramQMFolder.getType() == this.val$type) && (paramQMFolder.getAccountId() == this.val$accountId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMFolderSQLite.46
 * JD-Core Version:    0.7.0.1
 */