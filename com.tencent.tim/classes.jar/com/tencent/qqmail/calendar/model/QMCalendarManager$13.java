package com.tencent.qqmail.calendar.model;

import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.mail.QMMailManager;

class QMCalendarManager$13
  implements Runnable
{
  QMCalendarManager$13(QMCalendarManager paramQMCalendarManager, int paramInt1, String paramString, int paramInt2) {}
  
  public void run()
  {
    MailManagerDelegate localMailManagerDelegate = new MailManagerDelegate();
    localMailManagerDelegate.setOnBeforeSend(new QMCalendarManager.13.1(this));
    localMailManagerDelegate.setOnSuccess(new QMCalendarManager.13.2(this));
    localMailManagerDelegate.setOnError(new QMCalendarManager.13.3(this));
    QMMailManager.sharedInstance().getVerifyImage(this.val$accountId, this.val$verifyKey, localMailManagerDelegate);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarManager.13
 * JD-Core Version:    0.7.0.1
 */