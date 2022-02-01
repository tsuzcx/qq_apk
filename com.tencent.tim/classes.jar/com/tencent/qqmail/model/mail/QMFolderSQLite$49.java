package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.cache.IMapper;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.utilities.QMUtilities;

class QMFolderSQLite$49
  implements IMapper<QMFolder>
{
  QMFolderSQLite$49(QMFolderSQLite paramQMFolderSQLite, int paramInt, int[] paramArrayOfInt, boolean paramBoolean) {}
  
  public boolean map(QMFolder paramQMFolder)
  {
    boolean bool2 = true;
    boolean bool4;
    boolean bool3;
    if (paramQMFolder.getAccountId() == this.val$accountId)
    {
      bool4 = true;
      bool3 = bool4;
      if (this.val$excludeTypes != null)
      {
        if (QMUtilities.contains(this.val$excludeTypes, paramQMFolder.getType())) {
          break label84;
        }
        bool1 = true;
        label43:
        bool3 = bool4 & bool1;
      }
      bool4 = bool3;
      if (this.val$excludeVirtual) {
        if (paramQMFolder.isVirtual()) {
          break label89;
        }
      }
    }
    label84:
    label89:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      bool4 = bool3 & bool1;
      return bool4;
      bool4 = false;
      break;
      bool1 = false;
      break label43;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMFolderSQLite.49
 * JD-Core Version:    0.7.0.1
 */