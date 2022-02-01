package com.tencent.qqmail;

import com.tencent.qqmail.permission.PermissionUtils.CancelPermissionWarinCallback;
import com.tencent.qqmail.utilities.thread.Threads;
import moai.oss.KvHelper;

class WelcomeActivity$11
  implements PermissionUtils.CancelPermissionWarinCallback
{
  WelcomeActivity$11(WelcomeActivity paramWelcomeActivity) {}
  
  public void cancel()
  {
    QMActivityManager.shareInstance().finishAllActivity();
    KvHelper.eventPermissionKillApp(new double[0]);
    Threads.runInBackground(new WelcomeActivity.11.1(this), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.WelcomeActivity.11
 * JD-Core Version:    0.7.0.1
 */