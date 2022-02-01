package com.tencent.qqmail.utilities.patch;

import android.os.Process;
import com.tencent.qqmail.utilities.log.QMLog;

class QMPatchManagerService$2
  implements Runnable
{
  QMPatchManagerService$2(QMPatchManagerService paramQMPatchManagerService) {}
  
  public void run()
  {
    QMLog.log(4, "QMPatchManagerService", "stop");
    this.this$0.stopSelf();
    Process.killProcess(Process.myPid());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.patch.QMPatchManagerService.2
 * JD-Core Version:    0.7.0.1
 */