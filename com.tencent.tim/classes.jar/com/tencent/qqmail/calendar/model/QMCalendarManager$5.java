package com.tencent.qqmail.calendar.model;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.calendar.watcher.LoadCalendarListWatcher;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.mail.callback.FolderListCallback;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.network.filter.RequestFilter;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMProtocolError;
import moai.core.watcher.Watchers;

class QMCalendarManager$5
  implements FolderListCallback
{
  QMCalendarManager$5(QMCalendarManager paramQMCalendarManager, Account paramAccount, String paramString, MailManagerDelegate paramMailManagerDelegate) {}
  
  public void onError(QMProtocolError paramQMProtocolError)
  {
    QMLog.log(6, "QMCalendarManager", "loadMailFolders error account:" + this.val$account.getEmail());
    RequestFilter.resetRequestRunningState(this.val$req);
    if (this.val$callback != null) {
      this.val$callback.handleError(paramQMProtocolError);
    }
    ((LoadCalendarListWatcher)Watchers.of(LoadCalendarListWatcher.class)).onError(this.val$account.getId(), paramQMProtocolError);
  }
  
  public void onSuccess(QMFolder[] paramArrayOfQMFolder1, QMFolder[] paramArrayOfQMFolder2, QMFolder[] paramArrayOfQMFolder3)
  {
    QMLog.log(4, "QMCalendarManager", "loadMailFolders success account:" + this.val$account.getEmail());
    RequestFilter.resetRequestRunningState(this.val$req);
    this.this$0.loadEventsByAccount(this.val$account);
    if (this.val$callback != null) {
      this.val$callback.handleSuccess(null, null);
    }
    ((LoadCalendarListWatcher)Watchers.of(LoadCalendarListWatcher.class)).onSuccess(this.val$account.getId());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarManager.5
 * JD-Core Version:    0.7.0.1
 */