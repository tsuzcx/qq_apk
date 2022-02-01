package com.tencent.qqmail.calendar.model;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.calendar.data.CalendarFolderSyncData;
import com.tencent.qqmail.calendar.watcher.LoadCalendarListWatcher;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.MailManagerDelegate.DataCallback;
import com.tencent.qqmail.network.filter.RequestFilter;
import com.tencent.qqmail.utilities.log.QMLog;
import moai.core.watcher.Watchers;

class QMCalendarManager$8
  implements MailManagerDelegate.DataCallback
{
  QMCalendarManager$8(QMCalendarManager paramQMCalendarManager, Account paramAccount, String paramString, MailManagerDelegate paramMailManagerDelegate) {}
  
  public void run(Object paramObject1, Object paramObject2)
  {
    QMLog.log(4, "QMCalendarManager", "loadCalendarFolders success account:" + this.val$account.getEmail());
    RequestFilter.resetRequestRunningState(this.val$req);
    CalendarInfo localCalendarInfo = (CalendarInfo)paramObject1;
    if ((paramObject2 != null) && ((paramObject2 instanceof CalendarFolderSyncData)))
    {
      CalendarFolderSyncData localCalendarFolderSyncData = (CalendarFolderSyncData)paramObject2;
      QMCalendarManager.access$600(this.this$0, localCalendarFolderSyncData, localCalendarInfo.accountType);
    }
    this.this$0.loadEventsByAccount(this.val$account);
    this.this$0.openDefaultAccount(this.val$account);
    QMCalendarManager.access$700(this.this$0);
    if (this.val$callback != null) {
      this.val$callback.handleSuccess(paramObject1, paramObject2);
    }
    ((LoadCalendarListWatcher)Watchers.of(LoadCalendarListWatcher.class)).onSuccess(this.val$account.getId());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarManager.8
 * JD-Core Version:    0.7.0.1
 */