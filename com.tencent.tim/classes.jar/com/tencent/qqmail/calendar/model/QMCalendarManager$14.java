package com.tencent.qqmail.calendar.model;

import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.mail.QMMailManager;

class QMCalendarManager$14
  implements Runnable
{
  QMCalendarManager$14(QMCalendarManager paramQMCalendarManager, String paramString1, String paramString2, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    MailManagerDelegate localMailManagerDelegate = new MailManagerDelegate();
    localMailManagerDelegate.setOnBeforeSend(new QMCalendarManager.14.1(this));
    localMailManagerDelegate.setOnSuccess(new QMCalendarManager.14.2(this));
    localMailManagerDelegate.setOnError(new QMCalendarManager.14.3(this));
    QMMailManager.sharedInstance().followShareCalendar(this.val$accountId, this.val$isWxShare, this.val$code, this.val$email, localMailManagerDelegate);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarManager.14
 * JD-Core Version:    0.7.0.1
 */