package com.tencent.qqmail.launcher.base;

import com.tencent.qqmail.utilities.qmnetwork.service.QMPushManager;
import java.util.concurrent.atomic.AtomicBoolean;

class BaseLauncherActivity$1
  implements Runnable
{
  BaseLauncherActivity$1(BaseLauncherActivity paramBaseLauncherActivity) {}
  
  public void run()
  {
    if (!BaseLauncherActivity.access$000().getAndSet(true)) {
      QMPushManager.register();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.launcher.base.BaseLauncherActivity.1
 * JD-Core Version:    0.7.0.1
 */