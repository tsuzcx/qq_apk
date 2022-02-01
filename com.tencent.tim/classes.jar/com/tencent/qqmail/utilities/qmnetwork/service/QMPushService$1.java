package com.tencent.qqmail.utilities.qmnetwork.service;

import android.app.ActivityManager;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.report.QMPushReportManager;
import com.tencent.qqmail.utilities.thread.Threads;

class QMPushService$1
  implements Runnable
{
  QMPushService$1(QMPushService paramQMPushService) {}
  
  public void run()
  {
    try
    {
      Debug.MemoryInfo[] arrayOfMemoryInfo = ((ActivityManager)this.this$0.getSystemService("activity")).getProcessMemoryInfo(new int[] { Process.myPid() });
      QMPushReportManager.memory(arrayOfMemoryInfo[0].getTotalPrivateDirty(), arrayOfMemoryInfo[0].getTotalPss());
      Threads.runInBackground(QMPushService.access$000(this.this$0), 7200000L);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QMLog.log(5, "QMPushService", "report push memory failed!!", localThrowable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.service.QMPushService.1
 * JD-Core Version:    0.7.0.1
 */