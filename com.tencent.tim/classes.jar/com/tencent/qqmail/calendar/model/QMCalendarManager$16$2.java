package com.tencent.qqmail.calendar.model;

import com.tencent.qqmail.calendar.data.QMCalendarFolder;
import com.tencent.qqmail.calendar.watcher.CalendarShareQRUrlWatcher;
import com.tencent.qqmail.model.MailManagerDelegate.DataCallback;
import com.tencent.qqmail.utilities.log.QMLog;
import moai.core.watcher.Watchers;

class QMCalendarManager$16$2
  implements MailManagerDelegate.DataCallback
{
  QMCalendarManager$16$2(QMCalendarManager.16 param16) {}
  
  public void run(Object paramObject1, Object paramObject2)
  {
    QMLog.log(4, "QMCalendarManager", "getShareCalendarFolderQRUrl success folder:" + this.this$1.val$calendarFolder.getName() + " url:" + paramObject2);
    ((CalendarShareQRUrlWatcher)Watchers.of(CalendarShareQRUrlWatcher.class)).onSuccess(this.this$1.val$calendarFolder.getId(), (String)paramObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarManager.16.2
 * JD-Core Version:    0.7.0.1
 */