package com.tencent.qqmail.utilities.qmnetwork.service;

import com.tencent.qqmail.utilities.log.QMLog;

public class QMGuardPushService
  extends BaseService
{
  public void onCreate()
  {
    QMLog.log(4, "webpush", "QMGuardPushService onCreate");
    super.onCreate();
    try
    {
      startForeground(QMPushService.getForegroundId(), QMPushService.getForegroundNotification());
      label22:
      stopForeground(true);
      stopSelf();
      return;
    }
    catch (Throwable localThrowable)
    {
      break label22;
    }
  }
  
  public void onDestroy()
  {
    QMLog.log(4, "webpush", "QMGuardPushService onDestroy");
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.service.QMGuardPushService
 * JD-Core Version:    0.7.0.1
 */