package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.mail.callback.FolderOperationCallback;
import com.tencent.qqmail.network.filter.RequestFilter;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ICompleteCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class QMMailCGIManager$15
  implements QMCallback.ICompleteCallback
{
  QMMailCGIManager$15(QMMailCGIManager paramQMMailCGIManager, String paramString, FolderOperationCallback paramFolderOperationCallback) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    RequestFilter.resetRequestRunningState(this.val$req);
    if (this.val$callback != null) {
      this.val$callback.onComplete(null, paramQMNetworkError);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailCGIManager.15
 * JD-Core Version:    0.7.0.1
 */