package com.tencent.qqmail.utilities.qmnetwork;

import rx.Subscriber;

class CGIManager$3$3
  implements QMCallback.IErrorCallback
{
  CGIManager$3$3(CGIManager.3 param3, Subscriber paramSubscriber) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    this.val$subscriber.onError(paramQMNetworkError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.CGIManager.3.3
 * JD-Core Version:    0.7.0.1
 */