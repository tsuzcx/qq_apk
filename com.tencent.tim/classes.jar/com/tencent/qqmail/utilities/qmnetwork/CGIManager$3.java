package com.tencent.qqmail.utilities.qmnetwork;

import rx.Observable.OnSubscribe;
import rx.Subscriber;

final class CGIManager$3
  implements Observable.OnSubscribe<QMNetworkResponse>
{
  CGIManager$3(int paramInt, String paramString1, String paramString2) {}
  
  public void call(Subscriber<? super QMNetworkResponse> paramSubscriber)
  {
    QMCallback localQMCallback = new QMCallback();
    localQMCallback.setOnBeforeSend(new CGIManager.3.1(this, paramSubscriber));
    localQMCallback.setOnSuccess(new CGIManager.3.2(this, paramSubscriber));
    localQMCallback.setOnError(new CGIManager.3.3(this, paramSubscriber));
    localQMCallback.setOnComplete(new CGIManager.3.4(this, paramSubscriber));
    CGIManager.httpGet(this.val$accountId, this.val$cgiString, this.val$dataString, localQMCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.CGIManager.3
 * JD-Core Version:    0.7.0.1
 */