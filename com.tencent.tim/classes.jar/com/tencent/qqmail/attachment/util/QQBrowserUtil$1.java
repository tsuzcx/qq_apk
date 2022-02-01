package com.tencent.qqmail.attachment.util;

import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.smtt.sdk.QbSdk.PreInitCallback;

final class QQBrowserUtil$1
  implements QbSdk.PreInitCallback
{
  public void onCoreInitFinished()
  {
    QMLog.log(4, QQBrowserUtil.access$000(), "onCoreInitFinished");
  }
  
  public void onViewInitFinished(boolean paramBoolean)
  {
    QMLog.log(4, QQBrowserUtil.access$000(), "onViewInitFinished:" + paramBoolean + ", timeMill:" + System.currentTimeMillis());
    SharedPreferenceUtil.setX5CoreInitThreeCrashLog(SharedPreferenceUtil.getX5CoreInitThreeCrashLog() + "onViewInitFinished:" + paramBoolean + ",timeMill:" + System.currentTimeMillis() + ";");
    SharedPreferenceUtil.setX5CoreInitFinished(paramBoolean);
    SharedPreferenceUtil.setX5CoreInitCount(0);
    SharedPreferenceUtil.setX5CoreInitThreeCrashLog("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.util.QQBrowserUtil.1
 * JD-Core Version:    0.7.0.1
 */