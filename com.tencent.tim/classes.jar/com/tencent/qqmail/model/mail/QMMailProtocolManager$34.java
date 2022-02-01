package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.MailManagerDelegate.MailErrorCallback;

class QMMailProtocolManager$34
  implements MailManagerDelegate.MailErrorCallback
{
  QMMailProtocolManager$34(QMMailProtocolManager paramQMMailProtocolManager, MailManagerDelegate paramMailManagerDelegate) {}
  
  public void run(Object paramObject)
  {
    if (this.val$callback != null) {
      this.val$callback.handleError(paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolManager.34
 * JD-Core Version:    0.7.0.1
 */