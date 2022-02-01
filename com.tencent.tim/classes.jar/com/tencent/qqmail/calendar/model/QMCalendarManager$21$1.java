package com.tencent.qqmail.calendar.model;

import com.tencent.qqmail.calendar.data.QMCalendarEvent;
import com.tencent.qqmail.calendar.sqlite.QMCalendarSQLiteHelper;
import com.tencent.qqmail.model.MailManagerDelegate.DataCallback;

class QMCalendarManager$21$1
  implements MailManagerDelegate.DataCallback
{
  QMCalendarManager$21$1(QMCalendarManager.21 param21) {}
  
  public void run(Object paramObject1, Object paramObject2)
  {
    QMCalendarManager.access$1000(this.this$1.this$0).resetEventOffLineOptType(QMCalendarManager.access$1000(this.this$1.this$0).getWritableDatabase(), this.this$1.val$event.getId());
    this.this$1.this$0.loadEventList(this.this$1.val$folder, this.this$1.val$account, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarManager.21.1
 * JD-Core Version:    0.7.0.1
 */