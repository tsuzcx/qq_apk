package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.cache.IReducer;
import com.tencent.qqmail.model.qmdomain.QMFolder;

class QMFolderSQLite$2
  implements IReducer<QMFolder>
{
  QMFolderSQLite$2(QMFolderSQLite paramQMFolderSQLite, String paramString) {}
  
  public void reduce(QMFolder paramQMFolder)
  {
    paramQMFolder.setName(this.val$folderName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMFolderSQLite.2
 * JD-Core Version:    0.7.0.1
 */