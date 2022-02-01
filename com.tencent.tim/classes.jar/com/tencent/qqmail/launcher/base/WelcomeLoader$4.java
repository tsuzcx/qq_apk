package com.tencent.qqmail.launcher.base;

import android.os.Bundle;
import com.tencent.qqmail.utilities.schedule.QMScheduledJobs;
import com.tencent.qqmail.utilities.schedule.QMScheduledJobs.FromType;

class WelcomeLoader$4
  implements Runnable
{
  WelcomeLoader$4(WelcomeLoader paramWelcomeLoader) {}
  
  public void run()
  {
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("from", QMScheduledJobs.FromType.MAIN_START_UP);
    QMScheduledJobs.doJobs(localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.launcher.base.WelcomeLoader.4
 * JD-Core Version:    0.7.0.1
 */