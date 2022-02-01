package com.tencent.qqmail.utilities.qmnetwork.service;

import com.tencent.qqmail.utilities.qmbroadcastreceiver.QMAlarmBroadCast;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;

class QMPushService$3
  implements Runnable
{
  QMPushService$3(QMPushService paramQMPushService) {}
  
  public void run()
  {
    QMPushService.access$200(this.this$0, new Exception("disconnect"));
    QMPushService.access$302(this.this$0, QMNetworkUtils.getActiveNetworkName());
    QMPushService.access$402(this.this$0, QMNetworkUtils.getActiveNetworkType());
    QMAlarmBroadCast.unregisterPushAlarm();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.service.QMPushService.3
 * JD-Core Version:    0.7.0.1
 */