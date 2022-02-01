package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.cache.IMapper;
import com.tencent.qqmail.model.qmdomain.QMFolder;

class QMFolderSQLite$44
  implements IMapper<QMFolder>
{
  QMFolderSQLite$44(QMFolderSQLite paramQMFolderSQLite, String paramString, int paramInt, boolean paramBoolean) {}
  
  public boolean map(QMFolder paramQMFolder)
  {
    if ((paramQMFolder.getName().equals(this.val$foldername)) && (paramQMFolder.getAccountId() == this.val$accountId))
    {
      if (paramQMFolder.getType() == 14) {}
      for (int i = 1; i == this.val$isTag; i = 0) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMFolderSQLite.44
 * JD-Core Version:    0.7.0.1
 */