package com.tencent.qqmail.calendar.model;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.calendar.data.QMCalendarEvent;
import com.tencent.qqmail.calendar.data.QMCalendarFolder;
import com.tencent.qqmail.model.MailManagerDelegate;

class QMCalendarManager$21
  implements Runnable
{
  QMCalendarManager$21(QMCalendarManager paramQMCalendarManager, QMCalendarEvent paramQMCalendarEvent, QMCalendarFolder paramQMCalendarFolder, Account paramAccount) {}
  
  public void run()
  {
    MailManagerDelegate localMailManagerDelegate = new MailManagerDelegate();
    localMailManagerDelegate.setOnSuccess(new QMCalendarManager.21.1(this));
    localMailManagerDelegate.setOnError(new QMCalendarManager.21.2(this));
    QMCalendarManager.access$1300(this.this$0).updateCalendar(this.val$account, this.val$folder, this.val$event, localMailManagerDelegate);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarManager.21
 * JD-Core Version:    0.7.0.1
 */