package com.tencent.qqmail.calendar.model;

import com.tencent.qqmail.calendar.data.QMCalendarEvent;
import com.tencent.qqmail.model.MailManagerDelegate.MailErrorCallback;
import com.tencent.qqmail.utilities.log.QMLog;

class QMCalendarManager$34
  implements MailManagerDelegate.MailErrorCallback
{
  QMCalendarManager$34(QMCalendarManager paramQMCalendarManager, QMCalendarEvent paramQMCalendarEvent) {}
  
  public void run(Object paramObject)
  {
    QMLog.log(6, "QMCalendarManager", "doUpdateCalendarByProtocol error id:" + this.val$event.getId() + " subject:" + this.val$event.getSubject());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarManager.34
 * JD-Core Version:    0.7.0.1
 */