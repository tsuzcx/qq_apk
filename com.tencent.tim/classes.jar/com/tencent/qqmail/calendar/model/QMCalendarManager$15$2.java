package com.tencent.qqmail.calendar.model;

import com.tencent.qqmail.calendar.data.QMCalendarFolder;
import com.tencent.qqmail.calendar.watcher.CalendarStopShareWatcher;
import com.tencent.qqmail.model.MailManagerDelegate.MailErrorCallback;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import moai.core.watcher.Watchers;

class QMCalendarManager$15$2
  implements MailManagerDelegate.MailErrorCallback
{
  QMCalendarManager$15$2(QMCalendarManager.15 param15) {}
  
  public void run(Object paramObject)
  {
    QMLog.log(6, "QMCalendarManager", "stopShareCalendarFolder error folder:" + this.this$1.val$calendarFolder.getName() + " email:" + this.this$1.val$email);
    if ((paramObject instanceof QMNetworkError))
    {
      paramObject = (QMNetworkError)paramObject;
      ((CalendarStopShareWatcher)Watchers.of(CalendarStopShareWatcher.class)).onError(this.this$1.val$calendarFolder.getId(), this.this$1.val$email, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarManager.15.2
 * JD-Core Version:    0.7.0.1
 */