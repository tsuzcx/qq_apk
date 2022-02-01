package com.tencent.qqmail.calendar.model;

import com.tencent.qqmail.calendar.data.QMCalendarFolder;
import com.tencent.qqmail.model.MailManagerDelegate.EventCallback;
import com.tencent.qqmail.network.filter.RequestFilter;
import com.tencent.qqmail.utilities.log.QMLog;

class QMCalendarManager$24
  implements MailManagerDelegate.EventCallback
{
  QMCalendarManager$24(QMCalendarManager paramQMCalendarManager, QMCalendarFolder paramQMCalendarFolder, String paramString) {}
  
  public void run(Object paramObject)
  {
    QMLog.log(4, "QMCalendarManager", "loadEventList complete folderId:" + this.val$folder.getId() + " name:" + this.val$folder.getName());
    RequestFilter.resetRequestRunningState(this.val$req);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarManager.24
 * JD-Core Version:    0.7.0.1
 */