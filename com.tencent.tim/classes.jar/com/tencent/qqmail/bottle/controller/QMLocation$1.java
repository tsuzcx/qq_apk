package com.tencent.qqmail.bottle.controller;

import android.location.Location;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

class QMLocation$1
  implements Observable.OnSubscribe<Location>
{
  QMLocation$1(QMLocation paramQMLocation) {}
  
  public void call(Subscriber<? super Location> paramSubscriber)
  {
    paramSubscriber.onNext(QMLocation.access$000(this.this$0));
    paramSubscriber.onCompleted();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.QMLocation.1
 * JD-Core Version:    0.7.0.1
 */