package com.tencent.qqmail.utilities.qmnetwork.service;

import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.QMNotificationConstructor;
import moai.oss.KvHelper;

class QMPushMailNotify$4
  implements Runnable
{
  QMPushMailNotify$4(QMPushMailNotify paramQMPushMailNotify) {}
  
  public void run()
  {
    QMLog.log(4, "QMPushMailNotify", "cancelAllNotifyNewMail");
    QMPushMailNotify.access$1200(this.this$0);
    QMNotificationConstructor.getInstance().clearAllPushNewMail();
    QMPushMailNotify.access$500(this.this$0);
    KvHelper.eventClearAllNewMailNotificationByApp(new double[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.service.QMPushMailNotify.4
 * JD-Core Version:    0.7.0.1
 */