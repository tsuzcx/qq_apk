package com.tencent.qqmail.folderlist;

import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;

class QMFolderManager$2
  extends QMFolderManager.HybirdFolderCallback
{
  QMFolderManager$2(QMFolderManager paramQMFolderManager, QMMailSQLiteHelper paramQMMailSQLiteHelper)
  {
    super(paramQMMailSQLiteHelper);
  }
  
  public boolean hasNewMail()
  {
    return QMFolderManager.access$100(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.QMFolderManager.2
 * JD-Core Version:    0.7.0.1
 */