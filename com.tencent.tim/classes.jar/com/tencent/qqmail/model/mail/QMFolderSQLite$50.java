package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.cache.IMapper;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.utilities.QMUtilities;

class QMFolderSQLite$50
  implements IMapper<QMFolder>
{
  QMFolderSQLite$50(QMFolderSQLite paramQMFolderSQLite, int[] paramArrayOfInt) {}
  
  public boolean map(QMFolder paramQMFolder)
  {
    return QMUtilities.contains(this.val$ids, paramQMFolder.getId());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMFolderSQLite.50
 * JD-Core Version:    0.7.0.1
 */