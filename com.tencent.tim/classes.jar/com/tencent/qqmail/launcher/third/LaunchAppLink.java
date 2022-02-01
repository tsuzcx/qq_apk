package com.tencent.qqmail.launcher.third;

import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.launcher.base.LauncherUtils;
import com.tencent.qqmail.utilities.log.QMLog;
import moai.oss.KvHelper;

public class LaunchAppLink
  extends ThirdLauncherActivity
{
  public static final String TAG = "LaunchAppLink";
  
  protected void route()
  {
    QMLog.log(4, "LaunchAppLink", "route " + QMActivityManager.shareInstance().getActivitySize());
    KvHelper.eventAppLink(new double[0]);
    if (QMActivityManager.shareInstance().getActivitySize() == 1) {
      LauncherUtils.gotoMainPage(this);
    }
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.launcher.third.LaunchAppLink
 * JD-Core Version:    0.7.0.1
 */