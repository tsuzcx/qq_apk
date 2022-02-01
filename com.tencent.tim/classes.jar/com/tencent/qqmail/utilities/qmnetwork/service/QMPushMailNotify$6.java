package com.tencent.qqmail.utilities.qmnetwork.service;

import com.tencent.qqmail.utilities.ui.QMNotificationConstructor;

class QMPushMailNotify$6
  implements Runnable
{
  QMPushMailNotify$6(QMPushMailNotify paramQMPushMailNotify) {}
  
  public void run()
  {
    QMNotificationConstructor.getInstance().clearAllNote();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.service.QMPushMailNotify.6
 * JD-Core Version:    0.7.0.1
 */