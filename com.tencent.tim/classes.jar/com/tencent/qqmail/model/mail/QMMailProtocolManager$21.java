package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.MailManagerDelegate.SendDataCallback;

class QMMailProtocolManager$21
  implements MailManagerDelegate.SendDataCallback
{
  QMMailProtocolManager$21(QMMailProtocolManager paramQMMailProtocolManager, MailManagerDelegate paramMailManagerDelegate) {}
  
  public void run(Long paramLong1, Long paramLong2)
  {
    if (this.val$callback != null) {
      this.val$callback.handleSendData(paramLong1, paramLong2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolManager.21
 * JD-Core Version:    0.7.0.1
 */