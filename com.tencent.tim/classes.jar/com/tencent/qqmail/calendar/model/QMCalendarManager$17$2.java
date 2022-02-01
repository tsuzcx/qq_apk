package com.tencent.qqmail.calendar.model;

import com.tencent.qqmail.calendar.data.QMCalendarFolder;
import com.tencent.qqmail.calendar.watcher.CalendarShareWXUrlWatcher;
import com.tencent.qqmail.model.MailManagerDelegate.DataCallback;
import com.tencent.qqmail.utilities.log.QMLog;
import moai.core.watcher.Watchers;

class QMCalendarManager$17$2
  implements MailManagerDelegate.DataCallback
{
  QMCalendarManager$17$2(QMCalendarManager.17 param17) {}
  
  public void run(Object paramObject1, Object paramObject2)
  {
    QMLog.log(4, "QMCalendarManager", "getShareCalendarFolderWXUrl success folder:" + this.this$1.val$calendarFolder.getName() + " url:" + paramObject2);
    ((CalendarShareWXUrlWatcher)Watchers.of(CalendarShareWXUrlWatcher.class)).onSuccess(this.this$1.val$calendarFolder.getId(), (String)paramObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarManager.17.2
 * JD-Core Version:    0.7.0.1
 */