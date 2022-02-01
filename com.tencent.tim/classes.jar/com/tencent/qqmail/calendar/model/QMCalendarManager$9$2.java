package com.tencent.qqmail.calendar.model;

import com.tencent.qqmail.calendar.data.QMCalendarFolder;
import com.tencent.qqmail.calendar.watcher.CalendarFolderCreateWatcher;
import com.tencent.qqmail.model.MailManagerDelegate.MailErrorCallback;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import moai.core.watcher.Watchers;

class QMCalendarManager$9$2
  implements MailManagerDelegate.MailErrorCallback
{
  QMCalendarManager$9$2(QMCalendarManager.9 param9) {}
  
  public void run(Object paramObject)
  {
    QMLog.log(6, "QMCalendarManager", "addCalendarFolderByProtocolMgr error id:" + this.this$1.val$calendarFolder.getId() + " name:" + this.this$1.val$calendarFolder.getName());
    if ((paramObject instanceof QMNetworkError))
    {
      paramObject = (QMNetworkError)paramObject;
      ((CalendarFolderCreateWatcher)Watchers.of(CalendarFolderCreateWatcher.class)).onError(this.this$1.val$calendarFolder.getId(), paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarManager.9.2
 * JD-Core Version:    0.7.0.1
 */