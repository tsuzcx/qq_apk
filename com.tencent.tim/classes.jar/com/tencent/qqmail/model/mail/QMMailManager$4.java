package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.callback.IListStatusCallback;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class QMMailManager$4
  implements IListStatusCallback
{
  QMMailManager$4(QMMailManager paramQMMailManager, QMFolder paramQMFolder, int paramInt, QMCallback paramQMCallback, Account paramAccount) {}
  
  public void error(QMNetworkError paramQMNetworkError)
  {
    DataCollector.logDetailEvent("DetailEvent_App_Background_Fetch", this.val$accountId, 1L, "accountName:" + this.val$account.getEmail());
    if (this.val$qmCallback != null) {
      this.val$qmCallback.handleError(null, null, paramQMNetworkError);
    }
  }
  
  public void process()
  {
    QMWatcherCenter.triggerLoadListProcess(this.val$folder.getId(), true);
  }
  
  public void success(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    DataCollector.logDetailEvent("DetailEvent_App_Background_Fetch", this.val$accountId, 0L, "");
    if (this.val$qmCallback != null) {
      this.val$qmCallback.handleSuccess(null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailManager.4
 * JD-Core Version:    0.7.0.1
 */