package com.tencent.qqmail.calendar.model;

import com.tencent.qqmail.calendar.data.QMCalendarFolder;
import com.tencent.qqmail.calendar.watcher.CalendarShareWatcher;
import com.tencent.qqmail.model.MailManagerDelegate.BeforeSendCallback;
import moai.core.watcher.Watchers;

class QMCalendarManager$12$1
  implements MailManagerDelegate.BeforeSendCallback
{
  QMCalendarManager$12$1(QMCalendarManager.12 param12) {}
  
  public void run(Object paramObject)
  {
    ((CalendarShareWatcher)Watchers.of(CalendarShareWatcher.class)).onProcess(this.this$1.val$calendarFolder.getId(), this.this$1.val$emails);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarManager.12.1
 * JD-Core Version:    0.7.0.1
 */