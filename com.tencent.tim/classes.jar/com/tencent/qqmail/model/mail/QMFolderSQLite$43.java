package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.cache.IQuery;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.utilities.QMUtilities;
import java.util.ArrayList;

class QMFolderSQLite$43
  implements IQuery<QMFolder>
{
  QMFolderSQLite$43(QMFolderSQLite paramQMFolderSQLite, int[] paramArrayOfInt, ArrayList paramArrayList) {}
  
  public boolean map(QMFolder paramQMFolder)
  {
    return (!paramQMFolder.isVirtual()) && (QMUtilities.contains(this.val$accountIds, paramQMFolder.getAccountId()));
  }
  
  public void reduce(QMFolder paramQMFolder)
  {
    this.val$folders.add(paramQMFolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMFolderSQLite.43
 * JD-Core Version:    0.7.0.1
 */