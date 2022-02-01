package com.tencent.qqmail.calendar.model;

import com.tencent.qqmail.calendar.watcher.CalendarFollowWatcher;
import com.tencent.qqmail.model.MailManagerDelegate.DataCallback;
import moai.core.watcher.Watchers;

class QMCalendarManager$14$2$1
  implements MailManagerDelegate.DataCallback
{
  QMCalendarManager$14$2$1(QMCalendarManager.14.2 param2) {}
  
  public void run(Object paramObject1, Object paramObject2)
  {
    ((CalendarFollowWatcher)Watchers.of(CalendarFollowWatcher.class)).onSuccess(this.this$2.this$1.val$code, this.this$2.this$1.val$email);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarManager.14.2.1
 * JD-Core Version:    0.7.0.1
 */