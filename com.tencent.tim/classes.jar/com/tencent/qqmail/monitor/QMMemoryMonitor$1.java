package com.tencent.qqmail.monitor;

import com.google.common.collect.EvictingQueue;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.log.QMLog;

class QMMemoryMonitor$1
  implements Runnable
{
  QMMemoryMonitor$1(QMMemoryMonitor paramQMMemoryMonitor, String paramString) {}
  
  public void run()
  {
    QMMemoryMonitor.MemInfo localMemInfo = new QMMemoryMonitor.MemInfo(QMApplicationContext.sharedInstance(), this.val$msg);
    try
    {
      QMMemoryMonitor.access$300(this.this$0).add(localMemInfo);
      QMLog.log(3, QMMemoryMonitor.access$200(), "memory: " + localMemInfo);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QMLog.log(5, QMMemoryMonitor.access$200(), "add mem info failed", localException);
        QMMemoryMonitor.access$300(this.this$0).clear();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.monitor.QMMemoryMonitor.1
 * JD-Core Version:    0.7.0.1
 */