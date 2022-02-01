package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.MailManagerDelegate.SendDataCallback;

class QMMailManager$42
  implements MailManagerDelegate.SendDataCallback
{
  QMMailManager$42(QMMailManager paramQMMailManager, MailManagerDelegate paramMailManagerDelegate) {}
  
  public void run(Long paramLong1, Long paramLong2)
  {
    if (this.val$callback != null) {
      this.val$callback.handleSendData(paramLong1, paramLong2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailManager.42
 * JD-Core Version:    0.7.0.1
 */