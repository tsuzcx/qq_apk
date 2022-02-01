package com.tencent.qqmail.utilities.services;

import android.os.Bundle;
import com.tencent.qqmail.utilities.schedule.QMScheduledJobs;

class QMNotifyService$1
  implements Runnable
{
  QMNotifyService$1(QMNotifyService paramQMNotifyService, Bundle paramBundle) {}
  
  public void run()
  {
    QMScheduledJobs.doJobs(this.val$extras);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.services.QMNotifyService.1
 * JD-Core Version:    0.7.0.1
 */