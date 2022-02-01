package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.MailManagerDelegate.EventCallback;

class QMMailManager$40
  implements MailManagerDelegate.EventCallback
{
  QMMailManager$40(QMMailManager paramQMMailManager, MailManagerDelegate paramMailManagerDelegate) {}
  
  public void run(Object paramObject)
  {
    if (this.val$callback != null) {
      this.val$callback.handleComplete(paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailManager.40
 * JD-Core Version:    0.7.0.1
 */