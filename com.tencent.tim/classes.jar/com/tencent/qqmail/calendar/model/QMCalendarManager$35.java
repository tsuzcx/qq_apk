package com.tencent.qqmail.calendar.model;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.calendar.data.QMCalendarEvent;
import com.tencent.qqmail.calendar.data.QMCalendarFolder;
import com.tencent.qqmail.calendar.sqlite.QMCalendarSQLiteHelper;
import com.tencent.qqmail.model.MailManagerDelegate.DataCallback;
import com.tencent.qqmail.utilities.log.QMLog;

class QMCalendarManager$35
  implements MailManagerDelegate.DataCallback
{
  QMCalendarManager$35(QMCalendarManager paramQMCalendarManager, QMCalendarEvent paramQMCalendarEvent, QMCalendarFolder paramQMCalendarFolder, Account paramAccount) {}
  
  public void run(Object paramObject1, Object paramObject2)
  {
    QMLog.log(4, "QMCalendarManager", "doUpdateCalendarByProtocol success id:" + this.val$event.getId() + " subject:" + this.val$event.getSubject());
    QMCalendarManager.access$1000(this.this$0).resetEventOffLineOptType(QMCalendarManager.access$1000(this.this$0).getWritableDatabase(), this.val$event.getId());
    this.this$0.loadEventList(this.val$folder, this.val$account, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarManager.35
 * JD-Core Version:    0.7.0.1
 */