package com.tencent.qqmail.calendar.model;

import com.tencent.qqmail.calendar.data.QMCalendarEvent;
import com.tencent.qqmail.calendar.sqlite.QMCalendarSQLiteHelper;
import com.tencent.qqmail.model.MailManagerDelegate.DataCallback;
import com.tencent.qqmail.utilities.log.QMLog;

class QMCalendarManager$32
  implements MailManagerDelegate.DataCallback
{
  QMCalendarManager$32(QMCalendarManager paramQMCalendarManager, QMCalendarEvent paramQMCalendarEvent) {}
  
  public void run(Object paramObject1, Object paramObject2)
  {
    QMLog.log(4, "QMCalendarManager", "doRemoveCalendarByProtocol success id:" + this.val$event.getId() + " subject:" + this.val$event.getSubject());
    QMCalendarManager.access$1000(this.this$0).deleteEvent(QMCalendarManager.access$1000(this.this$0).getWritableDatabase(), this.val$event.getId());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarManager.32
 * JD-Core Version:    0.7.0.1
 */