package com.tencent.qqmail.model.mail;

import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMGeneralCallback;

class QMOfflineOperationManager$1
  implements QMGeneralCallback
{
  QMOfflineOperationManager$1(QMOfflineOperationManager paramQMOfflineOperationManager) {}
  
  public void onError()
  {
    QMLog.log(6, "QMOfflineOperationManager", "handleUmaSetting1 err.");
  }
  
  public void onSuccess()
  {
    QMLog.log(4, "QMOfflineOperationManager", "handleUmaSetting1 success.");
    SQLiteDatabase localSQLiteDatabase = QMOfflineOperationManager.access$000(this.this$0).getWritableDatabase();
    QMOfflineOperationManager.access$000(this.this$0).offLine.delOffLineOpers(localSQLiteDatabase, new int[] { 3 });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMOfflineOperationManager.1
 * JD-Core Version:    0.7.0.1
 */