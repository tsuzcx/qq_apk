package com.tencent.qqmail.bottle.controller;

import android.location.Location;
import rx.Observable;
import rx.functions.Func1;

class BottleManager$2
  implements Func1<Location, Observable<BottleManager.Coordinate>>
{
  BottleManager$2(BottleManager paramBottleManager) {}
  
  public Observable<BottleManager.Coordinate> call(Location paramLocation)
  {
    return Observable.create(new BottleManager.2.1(this, paramLocation));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleManager.2
 * JD-Core Version:    0.7.0.1
 */