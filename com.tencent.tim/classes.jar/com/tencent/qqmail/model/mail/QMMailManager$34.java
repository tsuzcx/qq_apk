package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.MailManagerDelegate.MailErrorCallback;

class QMMailManager$34
  implements MailManagerDelegate.MailErrorCallback
{
  QMMailManager$34(QMMailManager paramQMMailManager, MailManagerDelegate paramMailManagerDelegate) {}
  
  public void run(Object paramObject)
  {
    this.val$callback.handleError(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailManager.34
 * JD-Core Version:    0.7.0.1
 */