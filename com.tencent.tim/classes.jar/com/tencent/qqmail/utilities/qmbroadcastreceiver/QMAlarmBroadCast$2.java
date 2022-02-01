package com.tencent.qqmail.utilities.qmbroadcastreceiver;

import android.os.Bundle;
import com.tencent.qqmail.utilities.schedule.QMScheduledJobs;
import com.tencent.qqmail.utilities.schedule.QMScheduledJobs.FromType;

class QMAlarmBroadCast$2
  implements Runnable
{
  QMAlarmBroadCast$2(QMAlarmBroadCast paramQMAlarmBroadCast) {}
  
  public void run()
  {
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("from", QMScheduledJobs.FromType.SCREEN_ON);
    QMScheduledJobs.doJobs(localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmbroadcastreceiver.QMAlarmBroadCast.2
 * JD-Core Version:    0.7.0.1
 */