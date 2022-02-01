package com.tencent.qqmail.monitor;

import android.os.Debug.MemoryInfo;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.utilities.observer.QMNotification;

class QMMemoryMonitor$2
  implements Runnable
{
  QMMemoryMonitor$2(QMMemoryMonitor paramQMMemoryMonitor, Debug.MemoryInfo[] paramArrayOfMemoryInfo) {}
  
  public void run()
  {
    String str = "pss:" + this.val$self_mi[0].getTotalPss() + " obs:" + QMNotification.getTotalObserver() + " act:" + QMActivityManager.shareInstance().getActivitySize() + " gc:" + QMMemoryMonitor.access$000(this.this$0);
    QMMemoryMonitor.access$400(this.this$0, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.monitor.QMMemoryMonitor.2
 * JD-Core Version:    0.7.0.1
 */