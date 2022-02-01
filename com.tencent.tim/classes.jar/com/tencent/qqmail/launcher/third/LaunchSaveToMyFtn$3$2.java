package com.tencent.qqmail.launcher.third;

import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;

class LaunchSaveToMyFtn$3$2
  implements Runnable
{
  LaunchSaveToMyFtn$3$2(LaunchSaveToMyFtn.3 param3, int paramInt) {}
  
  public void run()
  {
    QMWatcherCenter.triggerWtchatFtnError(this.val$errcode);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.launcher.third.LaunchSaveToMyFtn.3.2
 * JD-Core Version:    0.7.0.1
 */