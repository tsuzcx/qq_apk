package com.tencent.qqmail.calendar.model;

import com.tencent.qqmail.calendar.data.QMCalendarEvent;
import com.tencent.qqmail.model.MailManagerDelegate.MailErrorCallback;
import com.tencent.qqmail.utilities.log.QMLog;

class QMCalendarManager$29$1
  implements MailManagerDelegate.MailErrorCallback
{
  QMCalendarManager$29$1(QMCalendarManager.29 param29) {}
  
  public void run(Object paramObject)
  {
    QMLog.log(6, "QMCalendarManager", "addEventByProtocolMgr error id:" + this.this$1.val$event.getId() + " subject:" + this.this$1.val$event.getSubject());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarManager.29.1
 * JD-Core Version:    0.7.0.1
 */