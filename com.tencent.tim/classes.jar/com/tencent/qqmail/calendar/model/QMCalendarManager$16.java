package com.tencent.qqmail.calendar.model;

import com.tencent.qqmail.calendar.data.QMCalendarFolder;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.mail.QMMailManager;

class QMCalendarManager$16
  implements Runnable
{
  QMCalendarManager$16(QMCalendarManager paramQMCalendarManager, QMCalendarFolder paramQMCalendarFolder) {}
  
  public void run()
  {
    MailManagerDelegate localMailManagerDelegate = new MailManagerDelegate();
    localMailManagerDelegate.setOnBeforeSend(new QMCalendarManager.16.1(this));
    localMailManagerDelegate.setOnSuccess(new QMCalendarManager.16.2(this));
    localMailManagerDelegate.setOnError(new QMCalendarManager.16.3(this));
    QMMailManager.sharedInstance().getShareCalendarFolderQRUrl(this.val$calendarFolder.getAccountId(), this.val$calendarFolder.getCollectionId(), localMailManagerDelegate);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarManager.16
 * JD-Core Version:    0.7.0.1
 */