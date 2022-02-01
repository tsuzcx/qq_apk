package com.tencent.qqmail.launcher.desktop;

import android.os.Bundle;
import com.tencent.qqmail.utilities.qmnetwork.service.QMPushManager;
import com.tencent.qqmail.utilities.qmnetwork.service.QMServiceManager;
import com.tencent.qqmail.utilities.schedule.QMScheduledJobs;
import com.tencent.qqmail.utilities.schedule.QMScheduledJobs.FromType;

class LauncherActivity$2
  implements Runnable
{
  LauncherActivity$2(LauncherActivity paramLauncherActivity) {}
  
  public void run()
  {
    QMServiceManager.setEnablePush(true);
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("from", QMScheduledJobs.FromType.CLICK);
    QMScheduledJobs.doJobs(localBundle);
    QMPushManager.register();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.launcher.desktop.LauncherActivity.2
 * JD-Core Version:    0.7.0.1
 */