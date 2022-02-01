package com.tencent.qqmail.utilities.qmnetwork.service;

import com.tencent.qqmail.utilities.ui.QMNotificationConstructor;
import moai.oss.KvHelper;

class QMPushMailNotify$3
  implements Runnable
{
  QMPushMailNotify$3(QMPushMailNotify paramQMPushMailNotify, int paramInt) {}
  
  public void run()
  {
    QMNotificationConstructor.getInstance().clearNewMailNotify(15000000 + this.val$accountId);
    QMPushMailNotify.access$1100(this.this$0, this.val$accountId);
    QMPushMailNotify.access$500(this.this$0);
    KvHelper.eventClearAllNewMailNotificationOfOneaccountByApp(new double[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.service.QMPushMailNotify.3
 * JD-Core Version:    0.7.0.1
 */