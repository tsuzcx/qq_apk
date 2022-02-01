package com.tencent.qqmail.calendar.model;

import com.tencent.qqmail.calendar.data.QMCalendarFolder;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.mail.QMMailManager;

class QMCalendarManager$17
  implements Runnable
{
  QMCalendarManager$17(QMCalendarManager paramQMCalendarManager, QMCalendarFolder paramQMCalendarFolder) {}
  
  public void run()
  {
    MailManagerDelegate localMailManagerDelegate = new MailManagerDelegate();
    localMailManagerDelegate.setOnBeforeSend(new QMCalendarManager.17.1(this));
    localMailManagerDelegate.setOnSuccess(new QMCalendarManager.17.2(this));
    localMailManagerDelegate.setOnError(new QMCalendarManager.17.3(this));
    QMMailManager.sharedInstance().getShareCalendarFolderWXUrl(this.val$calendarFolder.getAccountId(), this.val$calendarFolder.getCollectionId(), localMailManagerDelegate);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarManager.17
 * JD-Core Version:    0.7.0.1
 */