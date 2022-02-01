package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.callback.IListCallback;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class QMMailManager$5
  implements IListCallback
{
  QMMailManager$5(QMMailManager paramQMMailManager, QMFolder paramQMFolder, int paramInt, QMCallback paramQMCallback, Account paramAccount) {}
  
  public void error(QMNetworkError paramQMNetworkError)
  {
    QMWatcherCenter.triggerLoadListError(this.val$folder.getId(), paramQMNetworkError);
    DataCollector.logDetailEvent("DetailEvent_App_Background_Fetch", this.val$accountId, 1L, "accountName:" + this.val$account.getEmail());
    if (this.val$qmCallback != null) {
      this.val$qmCallback.handleError(null, null, paramQMNetworkError);
    }
  }
  
  public void process()
  {
    QMWatcherCenter.triggerLoadListProcess(this.val$folder.getId(), true);
  }
  
  public void success(long[] paramArrayOfLong, boolean paramBoolean)
  {
    DataCollector.logDetailEvent("DetailEvent_App_Background_Fetch", this.val$accountId, 0L, "");
    int j = this.val$folder.getId();
    QMMailManager.LoadListType localLoadListType = QMMailManager.LoadListType.UPDATE_LIST;
    if (paramArrayOfLong != null) {}
    for (int i = paramArrayOfLong.length;; i = 0)
    {
      QMWatcherCenter.triggerLoadListSuccess(j, localLoadListType, i, false);
      if (this.val$qmCallback != null) {
        this.val$qmCallback.handleSuccess(null, null);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailManager.5
 * JD-Core Version:    0.7.0.1
 */