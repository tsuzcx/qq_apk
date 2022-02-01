package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.network.filter.RequestFilter;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ICompleteCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class QMMailCGIManager$4
  implements QMCallback.ICompleteCallback
{
  QMMailCGIManager$4(QMMailCGIManager paramQMMailCGIManager, String paramString, int paramInt, Runnable paramRunnable) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    RequestFilter.resetRequestRunningState(this.val$req);
    if (paramQMNetworkError != null)
    {
      QMWatcherCenter.triggerSyncError(this.val$accountId, paramQMNetworkError);
      QMWatcherCenter.triggerSyncEnd(this.val$accountId, false);
    }
    if (this.val$onComplete != null) {
      this.val$onComplete.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailCGIManager.4
 * JD-Core Version:    0.7.0.1
 */