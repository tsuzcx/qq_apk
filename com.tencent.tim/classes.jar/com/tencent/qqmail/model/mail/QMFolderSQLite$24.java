package com.tencent.qqmail.model.mail;

import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.utilities.log.QMLog;

class QMFolderSQLite$24
  implements Runnable
{
  QMFolderSQLite$24(QMFolderSQLite paramQMFolderSQLite, int[] paramArrayOfInt, SQLiteDatabase paramSQLiteDatabase, int paramInt) {}
  
  public void run()
  {
    String str = QMMailSQLiteHelper.getInClause(this.val$excludeFolderIds);
    int i = this.val$writableDb.delete("QM_FOLDER", "accountId=? AND isVirtual=0 AND id NOT IN" + str, new String[] { String.valueOf(this.val$accountId) });
    if (i > 0)
    {
      QMLog.log(4, "sqlite", "resetFolders:" + i + " in " + this.val$accountId + " ex:" + str);
      QMLog.log(3, "sqlite", "resetFolders cause by:" + QMLog.getStackTrace(15));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMFolderSQLite.24
 * JD-Core Version:    0.7.0.1
 */