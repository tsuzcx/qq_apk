package com.tencent.qqmail.calendar.model;

import com.tencent.qqmail.calendar.data.QMCalendarFolder;
import com.tencent.qqmail.calendar.watcher.CalendarShareQRUrlWatcher;
import com.tencent.qqmail.model.MailManagerDelegate.BeforeSendCallback;
import moai.core.watcher.Watchers;

class QMCalendarManager$16$1
  implements MailManagerDelegate.BeforeSendCallback
{
  QMCalendarManager$16$1(QMCalendarManager.16 param16) {}
  
  public void run(Object paramObject)
  {
    ((CalendarShareQRUrlWatcher)Watchers.of(CalendarShareQRUrlWatcher.class)).onProcess(this.this$1.val$calendarFolder.getId());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarManager.16.1
 * JD-Core Version:    0.7.0.1
 */