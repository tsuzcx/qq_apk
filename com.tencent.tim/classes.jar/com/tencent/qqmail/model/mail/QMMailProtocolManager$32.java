package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.MailManagerDelegate.BeforeSendCallback;

class QMMailProtocolManager$32
  implements MailManagerDelegate.BeforeSendCallback
{
  QMMailProtocolManager$32(QMMailProtocolManager paramQMMailProtocolManager, MailManagerDelegate paramMailManagerDelegate) {}
  
  public void run(Object paramObject)
  {
    if (this.val$callback != null) {
      this.val$callback.handleBeforeSend(paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolManager.32
 * JD-Core Version:    0.7.0.1
 */