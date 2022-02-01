package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.mail.callback.IListCallback;
import com.tencent.qqmail.model.mail.callback.IListStatusCallback;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class QMMailProtocolManager$5
  implements IListCallback
{
  QMMailProtocolManager$5(QMMailProtocolManager paramQMMailProtocolManager, int paramInt, IListStatusCallback paramIListStatusCallback) {}
  
  public void error(QMNetworkError paramQMNetworkError)
  {
    QMWatcherCenter.triggerSyncError(this.val$accountId, paramQMNetworkError);
    if (this.val$callback != null) {
      this.val$callback.error(paramQMNetworkError);
    }
  }
  
  public void process()
  {
    QMWatcherCenter.triggerSyncBegin(this.val$accountId, true);
    if (this.val$callback != null) {
      this.val$callback.process();
    }
  }
  
  public void success(long[] paramArrayOfLong, boolean paramBoolean)
  {
    if (paramArrayOfLong != null) {}
    for (int i = paramArrayOfLong.length;; i = 0)
    {
      QMWatcherCenter.triggerSyncSuccess(this.val$accountId);
      if (this.val$callback != null) {
        this.val$callback.success(true, i, i);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolManager.5
 * JD-Core Version:    0.7.0.1
 */