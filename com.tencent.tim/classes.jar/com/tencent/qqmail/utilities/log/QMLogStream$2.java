package com.tencent.qqmail.utilities.log;

import com.tencent.qqmail.utilities.thread.Threads;

final class QMLogStream$2
  implements Thread.UncaughtExceptionHandler
{
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    QMLog.log(5, "QMLogStream", "QMLogStream UncaughtException", paramThrowable);
    Threads.runOnMainThread(new QMLogStream.2.1(this, paramThrowable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.log.QMLogStream.2
 * JD-Core Version:    0.7.0.1
 */