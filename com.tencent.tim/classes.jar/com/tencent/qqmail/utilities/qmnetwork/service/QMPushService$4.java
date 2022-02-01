package com.tencent.qqmail.utilities.qmnetwork.service;

import android.os.SystemClock;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmbroadcastreceiver.QMAlarmBroadCast;
import com.tencent.qqmail.utilities.thread.Threads;

class QMPushService$4
  implements Runnable
{
  QMPushService$4(QMPushService paramQMPushService) {}
  
  public void run()
  {
    Threads.removeCallbackOnMain(this);
    long l = QMPushService.access$700(this.this$0) - (SystemClock.elapsedRealtime() - QMPushService.access$800(this.this$0));
    QMLog.log(4, "QMPushService", "updateNextAlarmTime, next: " + l + "ms");
    if (l <= 0L)
    {
      QMPushService.access$100(this.this$0);
      return;
    }
    QMAlarmBroadCast.registerPushAlarm(l + 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.service.QMPushService.4
 * JD-Core Version:    0.7.0.1
 */