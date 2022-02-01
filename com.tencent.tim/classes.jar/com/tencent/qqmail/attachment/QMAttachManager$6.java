package com.tencent.qqmail.attachment;

import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.network.filter.RequestFilter;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.IErrorCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class QMAttachManager$6
  implements QMCallback.IErrorCallback
{
  QMAttachManager$6(QMAttachManager paramQMAttachManager, String paramString, Runnable paramRunnable, int paramInt, boolean paramBoolean) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    RequestFilter.resetRequestRunningState(this.val$req);
    if (this.val$onComplete != null) {
      this.val$onComplete.run();
    }
    QMWatcherCenter.triggerLoadAttachFolderListError(this.val$accountId, this.val$checkUpdate, paramQMNetworkError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.QMAttachManager.6
 * JD-Core Version:    0.7.0.1
 */