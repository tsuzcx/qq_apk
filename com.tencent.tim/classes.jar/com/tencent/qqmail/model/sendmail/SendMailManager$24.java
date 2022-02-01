package com.tencent.qqmail.model.sendmail;

import com.tencent.qqmail.utilities.qmnetwork.QMCallback.IErrorCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import rx.Subscriber;

class SendMailManager$24
  implements QMCallback.IErrorCallback
{
  SendMailManager$24(SendMailManager paramSendMailManager, Subscriber paramSubscriber) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    paramQMNetworkRequest = paramQMNetworkError;
    if (paramQMNetworkError == null) {
      paramQMNetworkRequest = new QMNetworkError(3, -10000);
    }
    this.val$subscriber.onError(paramQMNetworkRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.sendmail.SendMailManager.24
 * JD-Core Version:    0.7.0.1
 */