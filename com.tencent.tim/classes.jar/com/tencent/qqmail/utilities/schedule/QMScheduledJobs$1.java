package com.tencent.qqmail.utilities.schedule;

import android.os.Bundle;

final class QMScheduledJobs$1
  implements Runnable
{
  QMScheduledJobs$1(Bundle paramBundle) {}
  
  public void run()
  {
    QMScheduledJobs.doJobs(this.val$extras);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.schedule.QMScheduledJobs.1
 * JD-Core Version:    0.7.0.1
 */