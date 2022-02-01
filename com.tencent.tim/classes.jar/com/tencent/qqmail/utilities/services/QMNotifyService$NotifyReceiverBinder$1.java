package com.tencent.qqmail.utilities.services;

import com.tencent.qqmail.utilities.qmnetwork.service.QMServiceManager;
import com.tencent.qqmail.utilities.qmnetwork.service.ReceivePacket;

class QMNotifyService$NotifyReceiverBinder$1
  implements Runnable
{
  QMNotifyService$NotifyReceiverBinder$1(QMNotifyService.NotifyReceiverBinder paramNotifyReceiverBinder, ReceivePacket paramReceivePacket) {}
  
  public void run()
  {
    QMServiceManager.sharedInstance().handleReceivePush(this.val$packet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.services.QMNotifyService.NotifyReceiverBinder.1
 * JD-Core Version:    0.7.0.1
 */