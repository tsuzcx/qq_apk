package com.tencent.qqmail;

import java.util.concurrent.atomic.AtomicBoolean;

class QMBaseSQLiteOpenHelper$QMDatabaseErrorHandler$1
  implements Runnable
{
  QMBaseSQLiteOpenHelper$QMDatabaseErrorHandler$1(QMBaseSQLiteOpenHelper.QMDatabaseErrorHandler paramQMDatabaseErrorHandler) {}
  
  public void run()
  {
    this.this$0.repaired.getAndSet(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.QMBaseSQLiteOpenHelper.QMDatabaseErrorHandler.1
 * JD-Core Version:    0.7.0.1
 */