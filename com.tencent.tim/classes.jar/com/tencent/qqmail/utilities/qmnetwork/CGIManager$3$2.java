package com.tencent.qqmail.utilities.qmnetwork;

import rx.Subscriber;

class CGIManager$3$2
  implements QMCallback.ISuccessCallback
{
  CGIManager$3$2(CGIManager.3 param3, Subscriber paramSubscriber) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    this.val$subscriber.onNext(paramQMNetworkResponse);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.CGIManager.3.2
 * JD-Core Version:    0.7.0.1
 */