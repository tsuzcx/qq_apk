package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.network.filter.RequestFilter;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ICompleteCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class QMMailCGIManager$19$4
  implements QMCallback.ICompleteCallback
{
  QMMailCGIManager$19$4(QMMailCGIManager.19 param19) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    RequestFilter.resetRequestRunningState(this.this$1.val$req);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailCGIManager.19.4
 * JD-Core Version:    0.7.0.1
 */