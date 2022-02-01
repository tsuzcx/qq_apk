package com.tencent.qqmail.utilities.qmnetwork.service;

import com.tencent.qqmail.utilities.ui.QMNotificationConstructor;

class QMPushMailNotify$1
  implements Runnable
{
  QMPushMailNotify$1(QMPushMailNotify paramQMPushMailNotify, long paramLong, int paramInt) {}
  
  public void run()
  {
    QMNotificationConstructor.getInstance().clearNewMailNotify(QMPushMailNotify.access$700(this.this$0, this.val$mailId));
    QMPushMailNotify.access$900(this.this$0, this.val$accountId, this.val$mailId);
    QMPushMailNotify.access$500(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.service.QMPushMailNotify.1
 * JD-Core Version:    0.7.0.1
 */