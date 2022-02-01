package com.tencent.qqmail.utilities.qmnetwork.service;

import com.tencent.qqmail.utilities.ui.QMNotificationConstructor;

class QMPushMailNotify$2
  implements Runnable
{
  QMPushMailNotify$2(QMPushMailNotify paramQMPushMailNotify, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    QMNotificationConstructor.getInstance().clearNewMailNotify(this.val$notificationId);
    QMPushMailNotify.access$1000(this.this$0, this.val$accountId, this.val$remoteId);
    QMPushMailNotify.access$500(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.service.QMPushMailNotify.2
 * JD-Core Version:    0.7.0.1
 */