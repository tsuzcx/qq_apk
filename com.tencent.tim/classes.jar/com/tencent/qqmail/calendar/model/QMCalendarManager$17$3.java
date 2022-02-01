package com.tencent.qqmail.calendar.model;

import com.tencent.qqmail.calendar.data.QMCalendarFolder;
import com.tencent.qqmail.calendar.watcher.CalendarShareWXUrlWatcher;
import com.tencent.qqmail.model.MailManagerDelegate.MailErrorCallback;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import moai.core.watcher.Watchers;

class QMCalendarManager$17$3
  implements MailManagerDelegate.MailErrorCallback
{
  QMCalendarManager$17$3(QMCalendarManager.17 param17) {}
  
  public void run(Object paramObject)
  {
    QMLog.log(6, "QMCalendarManager", "getShareCalendarFolderWXUrl error folder:" + this.this$1.val$calendarFolder.getName());
    if ((paramObject instanceof QMNetworkError))
    {
      paramObject = (QMNetworkError)paramObject;
      ((CalendarShareWXUrlWatcher)Watchers.of(CalendarShareWXUrlWatcher.class)).onError(this.this$1.val$calendarFolder.getId(), paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarManager.17.3
 * JD-Core Version:    0.7.0.1
 */