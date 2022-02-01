package com.tencent.qqmail.calendar.model;

import com.tencent.qqmail.calendar.data.QMCalendarEvent;
import com.tencent.qqmail.calendar.sqlite.QMCalendarSQLiteHelper;
import com.tencent.qqmail.model.MailManagerDelegate.DataCallback;

class QMCalendarManager$20$1
  implements MailManagerDelegate.DataCallback
{
  QMCalendarManager$20$1(QMCalendarManager.20 param20) {}
  
  public void run(Object paramObject1, Object paramObject2)
  {
    if (this.this$1.val$appointmentType != 4)
    {
      QMCalendarManager.access$1000(this.this$1.this$0).resetEventOffLineOptType(QMCalendarManager.access$1000(this.this$1.this$0).getWritableDatabase(), this.this$1.val$event.getId());
      paramObject1 = ((CalendarResult)paramObject1).activeSyncResult.meetingResponseResult.calendarId;
      this.this$1.val$event.setSvrId(paramObject1);
      QMCalendarManager.access$1000(this.this$1.this$0).updateEventSvrId(QMCalendarManager.access$1000(this.this$1.this$0).getWritableDatabase(), this.this$1.val$event);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarManager.20.1
 * JD-Core Version:    0.7.0.1
 */