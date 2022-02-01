package com.tencent.qqmail.utilities.syncadapter;

import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;

final class QMSyncAdapterManager$1
  implements Thread.UncaughtExceptionHandler
{
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    QMLog.log(5, "QMSyncAdapterManager", "SyncAdapter UncaughtException", paramThrowable);
    Threads.runOnMainThread(new QMSyncAdapterManager.1.1(this, paramThrowable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.syncadapter.QMSyncAdapterManager.1
 * JD-Core Version:    0.7.0.1
 */