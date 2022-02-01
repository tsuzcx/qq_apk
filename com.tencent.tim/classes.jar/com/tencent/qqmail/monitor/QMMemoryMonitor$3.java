package com.tencent.qqmail.monitor;

import com.tencent.qqmail.utilities.thread.Threads;

class QMMemoryMonitor$3
  implements Runnable
{
  QMMemoryMonitor$3(QMMemoryMonitor paramQMMemoryMonitor) {}
  
  public void run()
  {
    if (!QMMemoryMonitor.access$500(this.this$0)) {
      return;
    }
    QMMemoryMonitor.access$600(this.this$0);
    Threads.runInBackground(this, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.monitor.QMMemoryMonitor.3
 * JD-Core Version:    0.7.0.1
 */