package com.tencent.qqmail.calendar.model;

import com.tencent.qqmail.calendar.watcher.CalendarFollowWatcher;
import com.tencent.qqmail.model.MailManagerDelegate.MailErrorCallback;
import com.tencent.qqmail.utilities.log.QMLog;
import moai.core.watcher.Watchers;

class QMCalendarManager$14$3
  implements MailManagerDelegate.MailErrorCallback
{
  QMCalendarManager$14$3(QMCalendarManager.14 param14) {}
  
  public void run(Object paramObject)
  {
    QMLog.log(6, "QMCalendarManager", "followShareCalendarFolder error accountId:" + this.this$1.val$accountId + " code:" + this.this$1.val$code + " email:" + this.this$1.val$email);
    if ((paramObject instanceof String)) {
      ((CalendarFollowWatcher)Watchers.of(CalendarFollowWatcher.class)).onError(this.this$1.val$code, this.this$1.val$email, (String)paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarManager.14.3
 * JD-Core Version:    0.7.0.1
 */