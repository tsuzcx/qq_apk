package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.cache.IMapper;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import java.util.Arrays;

class QMFolderSQLite$47
  implements IMapper<QMFolder>
{
  QMFolderSQLite$47(QMFolderSQLite paramQMFolderSQLite, int paramInt, int[] paramArrayOfInt) {}
  
  public boolean map(QMFolder paramQMFolder)
  {
    return (paramQMFolder.getAccountId() == this.val$accountId) && (Arrays.binarySearch(this.val$types, paramQMFolder.getType()) > 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMFolderSQLite.47
 * JD-Core Version:    0.7.0.1
 */