package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.network.filter.RequestFilter;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ICompleteCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class QMMailCGIManager$61
  implements QMCallback.ICompleteCallback
{
  QMMailCGIManager$61(QMMailCGIManager paramQMMailCGIManager, MailManagerDelegate paramMailManagerDelegate, String paramString) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    if (this.val$callback != null) {
      this.val$callback.handleComplete(paramQMNetworkError);
    }
    RequestFilter.resetRequestRunningState(this.val$req);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailCGIManager.61
 * JD-Core Version:    0.7.0.1
 */