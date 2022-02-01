package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.cache.IReducer;
import com.tencent.qqmail.model.qmdomain.QMFolder;

class QMFolderSQLite$66
  implements IReducer<QMFolder>
{
  QMFolderSQLite$66(QMFolderSQLite paramQMFolderSQLite, int paramInt) {}
  
  public void reduce(QMFolder paramQMFolder)
  {
    paramQMFolder.setSequence(this.val$s);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMFolderSQLite.66
 * JD-Core Version:    0.7.0.1
 */