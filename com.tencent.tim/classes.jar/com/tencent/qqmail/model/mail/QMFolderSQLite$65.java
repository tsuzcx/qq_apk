package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.cache.IMapper;
import com.tencent.qqmail.model.qmdomain.QMFolder;

class QMFolderSQLite$65
  implements IMapper<QMFolder>
{
  QMFolderSQLite$65(QMFolderSQLite paramQMFolderSQLite, int paramInt, boolean paramBoolean1, boolean paramBoolean2) {}
  
  private boolean isFolder(QMFolder paramQMFolder)
  {
    return (paramQMFolder.getType() != 14) && (paramQMFolder.getType() != 17) && (paramQMFolder.getType() != 18) && (paramQMFolder.getType() != 13);
  }
  
  public boolean map(QMFolder paramQMFolder)
  {
    int i;
    if (paramQMFolder.getAccountId() == this.val$accountId)
    {
      i = 1;
      if (!this.val$isTag) {
        break label42;
      }
      if ((i == 0) || (paramQMFolder.getType() != 14)) {
        break label40;
      }
    }
    label40:
    label42:
    label63:
    do
    {
      do
      {
        return true;
        i = 0;
        break;
        return false;
        if (!this.val$isQQMail) {
          break label63;
        }
      } while ((i != 0) && (isFolder(paramQMFolder)));
      return false;
    } while ((i != 0) && (paramQMFolder.getType() == 0));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMFolderSQLite.65
 * JD-Core Version:    0.7.0.1
 */