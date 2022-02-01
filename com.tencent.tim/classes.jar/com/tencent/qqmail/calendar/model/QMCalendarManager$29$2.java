package com.tencent.qqmail.calendar.model;

import com.tencent.qqmail.calendar.data.AddEventReturnData;
import com.tencent.qqmail.calendar.data.QMCalendarEvent;
import com.tencent.qqmail.calendar.sqlite.QMCalendarSQLiteHelper;
import com.tencent.qqmail.model.MailManagerDelegate.DataCallback;
import com.tencent.qqmail.utilities.log.QMLog;

class QMCalendarManager$29$2
  implements MailManagerDelegate.DataCallback
{
  QMCalendarManager$29$2(QMCalendarManager.29 param29) {}
  
  public void run(Object paramObject1, Object paramObject2)
  {
    QMLog.log(4, "QMCalendarManager", "addEventByProtocolMgr success id:" + this.this$1.val$event.getId() + " subject:" + this.this$1.val$event.getSubject());
    paramObject1 = (CalendarInfo)paramObject1;
    if ((paramObject2 != null) && ((paramObject2 instanceof AddEventReturnData)))
    {
      paramObject2 = (AddEventReturnData)paramObject2;
      if (paramObject1.accountType != 1) {
        break label206;
      }
      this.this$1.val$event.setSvrId(paramObject2.getEventSvrId());
      this.this$1.val$event.setUid(paramObject2.getEventUid());
      QMCalendarManager.access$1000(this.this$1.this$0).updateEventSvrId(QMCalendarManager.access$1000(this.this$1.this$0).getWritableDatabase(), this.this$1.val$event);
    }
    for (;;)
    {
      this.this$1.this$0.triggerUpdateSchedule(this.this$1.val$event, QMCalendarEvent.generateId(this.this$1.val$event));
      QMCalendarManager.access$1000(this.this$1.this$0).resetEventOffLineOptType(QMCalendarManager.access$1000(this.this$1.this$0).getWritableDatabase(), this.this$1.val$event.getId());
      return;
      label206:
      if (paramObject1.accountType == 2)
      {
        this.this$1.val$event.setPath(paramObject2.getEventPath());
        this.this$1.val$event.seteTag(paramObject2.geteTag());
        this.this$1.val$event.setUid(paramObject2.getEventUid());
        QMCalendarManager.access$1000(this.this$1.this$0).updateCalDavEventAfterCreate(QMCalendarManager.access$1000(this.this$1.this$0).getWritableDatabase(), this.this$1.val$event);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarManager.29.2
 * JD-Core Version:    0.7.0.1
 */