package com.tencent.qqmail.calendar.model;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.calendar.data.QMCalendarFolder;
import com.tencent.qqmail.model.MailManagerDelegate.MailErrorCallback;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.network.filter.RequestFilter;
import com.tencent.qqmail.utilities.log.QMLog;

class QMCalendarManager$25
  implements MailManagerDelegate.MailErrorCallback
{
  QMCalendarManager$25(QMCalendarManager paramQMCalendarManager, QMCalendarFolder paramQMCalendarFolder, String paramString, Account paramAccount, QMCalendarManager.ILoadEventListCallback paramILoadEventListCallback) {}
  
  public void run(Object paramObject)
  {
    QMLog.log(6, "QMCalendarManager", "loadEventList error folderId:" + this.val$folder.getId() + " name:" + this.val$folder.getName());
    RequestFilter.resetRequestRunningState(this.val$req);
    QMWatcherCenter.triggerCalendarLoadEventError(this.val$account.getId(), this.val$folder.getId());
    if (this.val$callback != null) {
      this.val$callback.onComplete(this.val$folder.getId());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarManager.25
 * JD-Core Version:    0.7.0.1
 */