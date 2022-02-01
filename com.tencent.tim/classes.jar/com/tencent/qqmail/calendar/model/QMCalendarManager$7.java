package com.tencent.qqmail.calendar.model;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.calendar.watcher.LoadCalendarListWatcher;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.MailManagerDelegate.MailErrorCallback;
import com.tencent.qqmail.network.filter.RequestFilter;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import moai.core.watcher.Watchers;

class QMCalendarManager$7
  implements MailManagerDelegate.MailErrorCallback
{
  QMCalendarManager$7(QMCalendarManager paramQMCalendarManager, Account paramAccount, String paramString, MailManagerDelegate paramMailManagerDelegate) {}
  
  public void run(Object paramObject)
  {
    QMLog.log(6, "QMCalendarManager", "loadCalendarFolders error account:" + this.val$account.getEmail());
    RequestFilter.resetRequestRunningState(this.val$req);
    if (this.val$callback != null) {
      this.val$callback.handleError(paramObject);
    }
    if ((paramObject instanceof QMNetworkError))
    {
      paramObject = (QMNetworkError)paramObject;
      ((LoadCalendarListWatcher)Watchers.of(LoadCalendarListWatcher.class)).onError(this.val$account.getId(), paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarManager.7
 * JD-Core Version:    0.7.0.1
 */