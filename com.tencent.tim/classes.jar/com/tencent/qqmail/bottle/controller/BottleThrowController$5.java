package com.tencent.qqmail.bottle.controller;

import android.location.Location;
import rx.Observable;

class BottleThrowController$5
  implements QMLocation.LocationListener
{
  BottleThrowController$5(BottleThrowController paramBottleThrowController) {}
  
  public void onError()
  {
    BottleThrowController.access$200(this.this$0).getCoordinateObservable().subscribe(new BottleThrowController.5.1(this));
  }
  
  public void onLocationChanged(Location paramLocation)
  {
    BottleThrowController.access$500(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleThrowController.5
 * JD-Core Version:    0.7.0.1
 */