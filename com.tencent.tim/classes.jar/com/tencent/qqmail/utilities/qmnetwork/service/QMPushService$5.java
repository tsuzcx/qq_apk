package com.tencent.qqmail.utilities.qmnetwork.service;

import com.tencent.qqmail.utilities.AppStatusUtil;
import com.tencent.qqmail.utilities.keepalive.KeepAliveManager;

class QMPushService$5
  implements Runnable
{
  QMPushService$5(QMPushService paramQMPushService) {}
  
  public void run()
  {
    if ((!AppStatusUtil.isScreenOn()) && (!AppStatusUtil.isApplicationActive())) {
      KeepAliveManager.startInvisibleActivity();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.service.QMPushService.5
 * JD-Core Version:    0.7.0.1
 */