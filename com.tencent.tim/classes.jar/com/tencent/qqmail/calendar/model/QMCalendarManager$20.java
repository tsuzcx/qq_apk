package com.tencent.qqmail.calendar.model;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.calendar.data.QMCalendarEvent;
import com.tencent.qqmail.calendar.data.QMCalendarFolder;
import com.tencent.qqmail.calendar.sqlite.QMCalendarSQLiteHelper;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.mail.QMMailManager;

class QMCalendarManager$20
  implements Runnable
{
  QMCalendarManager$20(QMCalendarManager paramQMCalendarManager, int paramInt, QMCalendarEvent paramQMCalendarEvent, Account paramAccount, QMCalendarFolder paramQMCalendarFolder) {}
  
  public void run()
  {
    int j = 2;
    int i = j;
    switch (this.val$appointmentType)
    {
    default: 
      i = j;
    }
    for (;;)
    {
      MailManagerDelegate localMailManagerDelegate = new MailManagerDelegate();
      localMailManagerDelegate.setOnSuccess(new QMCalendarManager.20.1(this));
      localMailManagerDelegate.setOnError(new QMCalendarManager.20.2(this));
      QMCalendarManager.access$1300(this.this$0).updateActiveSyncAppointmentStatus(this.val$account, this.val$folder, this.val$event, i, localMailManagerDelegate);
      if (this.val$appointmentType == 4)
      {
        QMCalendarManager.access$1000(this.this$0).deleteEvent(QMCalendarManager.access$1000(this.this$0).getWritableDatabase(), this.val$event.getId());
        QMMailManager.sharedInstance().updateIcsEventDecline(this.val$event.getUid(), this.val$event.getAccountId());
        this.this$0.resetScheduleCache();
        this.this$0.triggerUpdateSchedule(null, 0L);
      }
      return;
      i = 1;
      continue;
      i = 3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarManager.20
 * JD-Core Version:    0.7.0.1
 */