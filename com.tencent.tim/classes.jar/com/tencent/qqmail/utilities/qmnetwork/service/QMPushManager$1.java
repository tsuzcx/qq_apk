package com.tencent.qqmail.utilities.qmnetwork.service;

import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;

final class QMPushManager$1
  implements Runnable
{
  QMPushManager$1(int paramInt) {}
  
  public void run()
  {
    QMPrivateProtocolManager.sharedInstance().umaLogin(new QMPushManager.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.service.QMPushManager.1
 * JD-Core Version:    0.7.0.1
 */