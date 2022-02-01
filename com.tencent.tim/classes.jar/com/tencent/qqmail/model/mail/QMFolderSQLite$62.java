package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.cache.IReducer;
import com.tencent.qqmail.model.qmdomain.QMFolder;

class QMFolderSQLite$62
  implements IReducer<QMFolder>
{
  QMFolderSQLite$62(QMFolderSQLite paramQMFolderSQLite, boolean paramBoolean) {}
  
  public void reduce(QMFolder paramQMFolder)
  {
    paramQMFolder.setPush(this.val$isPush);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMFolderSQLite.62
 * JD-Core Version:    0.7.0.1
 */