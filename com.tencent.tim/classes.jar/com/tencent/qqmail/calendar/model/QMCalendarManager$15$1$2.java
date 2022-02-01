package com.tencent.qqmail.calendar.model;

import com.tencent.qqmail.calendar.data.QMCalendarFolder;
import com.tencent.qqmail.calendar.watcher.CalendarStopShareWatcher;
import com.tencent.qqmail.model.MailManagerDelegate.MailErrorCallback;
import moai.core.watcher.Watchers;

class QMCalendarManager$15$1$2
  implements MailManagerDelegate.MailErrorCallback
{
  QMCalendarManager$15$1$2(QMCalendarManager.15.1 param1) {}
  
  public void run(Object paramObject)
  {
    ((CalendarStopShareWatcher)Watchers.of(CalendarStopShareWatcher.class)).onSuccess(this.this$2.this$1.val$calendarFolder.getId(), this.this$2.this$1.val$email);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarManager.15.1.2
 * JD-Core Version:    0.7.0.1
 */