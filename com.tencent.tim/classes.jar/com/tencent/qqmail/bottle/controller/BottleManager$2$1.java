package com.tencent.qqmail.bottle.controller;

import android.location.Location;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

class BottleManager$2$1
  implements Observable.OnSubscribe<BottleManager.Coordinate>
{
  BottleManager$2$1(BottleManager.2 param2, Location paramLocation) {}
  
  public void call(Subscriber<? super BottleManager.Coordinate> paramSubscriber)
  {
    paramSubscriber.onNext(BottleManager.access$000(this.this$1.this$0, this.val$location));
    paramSubscriber.onCompleted();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleManager.2.1
 * JD-Core Version:    0.7.0.1
 */