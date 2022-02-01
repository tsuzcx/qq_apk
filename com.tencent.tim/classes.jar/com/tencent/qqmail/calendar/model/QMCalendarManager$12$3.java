package com.tencent.qqmail.calendar.model;

import com.tencent.qqmail.calendar.data.CalendarShareError;
import com.tencent.qqmail.calendar.data.QMCalendarFolder;
import com.tencent.qqmail.calendar.watcher.CalendarShareWatcher;
import com.tencent.qqmail.model.MailManagerDelegate.MailErrorCallback;
import com.tencent.qqmail.utilities.log.QMLog;
import moai.core.watcher.Watchers;
import org.apache.commons.lang3.StringUtils;

class QMCalendarManager$12$3
  implements MailManagerDelegate.MailErrorCallback
{
  QMCalendarManager$12$3(QMCalendarManager.12 param12) {}
  
  public void run(Object paramObject)
  {
    QMLog.log(6, "QMCalendarManager", "shareCalendarFolder error folder:" + this.this$1.val$calendarFolder.getName() + " email:" + StringUtils.join(this.this$1.val$emails, "^"));
    paramObject = (CalendarShareError)paramObject;
    ((CalendarShareWatcher)Watchers.of(CalendarShareWatcher.class)).onError(this.this$1.val$calendarFolder.getId(), this.this$1.val$emails, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarManager.12.3
 * JD-Core Version:    0.7.0.1
 */