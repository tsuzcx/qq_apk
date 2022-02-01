package com.tencent.qqmail.calendar.model;

import com.tencent.qqmail.calendar.data.QMCalendarFolder;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.verify.QMVerify;

class QMCalendarManager$12
  implements Runnable
{
  QMCalendarManager$12(QMCalendarManager paramQMCalendarManager, QMCalendarFolder paramQMCalendarFolder, String[] paramArrayOfString, QMVerify paramQMVerify) {}
  
  public void run()
  {
    MailManagerDelegate localMailManagerDelegate = new MailManagerDelegate();
    localMailManagerDelegate.setOnBeforeSend(new QMCalendarManager.12.1(this));
    localMailManagerDelegate.setOnSuccess(new QMCalendarManager.12.2(this));
    localMailManagerDelegate.setOnError(new QMCalendarManager.12.3(this));
    QMMailManager.sharedInstance().shareCalendarFolder(this.val$calendarFolder.getAccountId(), this.val$calendarFolder.getCollectionId(), this.val$emails, this.val$shareVerify, localMailManagerDelegate);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarManager.12
 * JD-Core Version:    0.7.0.1
 */