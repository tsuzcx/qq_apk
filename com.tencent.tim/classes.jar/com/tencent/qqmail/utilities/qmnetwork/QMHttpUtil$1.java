package com.tencent.qqmail.utilities.qmnetwork;

import rx.Observable.OnSubscribe;
import rx.Subscriber;

final class QMHttpUtil$1
  implements Observable.OnSubscribe<QMNetworkResponse>
{
  QMHttpUtil$1(QMNetworkRequest paramQMNetworkRequest) {}
  
  public void call(Subscriber<? super QMNetworkResponse> paramSubscriber)
  {
    QMHttpUtil.access$000(this.val$request, paramSubscriber);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.QMHttpUtil.1
 * JD-Core Version:    0.7.0.1
 */