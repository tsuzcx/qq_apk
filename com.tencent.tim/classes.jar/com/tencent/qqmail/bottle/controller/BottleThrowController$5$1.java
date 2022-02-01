package com.tencent.qqmail.bottle.controller;

import rx.functions.Action1;

class BottleThrowController$5$1
  implements Action1<BottleManager.Coordinate>
{
  BottleThrowController$5$1(BottleThrowController.5 param5) {}
  
  public void call(BottleManager.Coordinate paramCoordinate)
  {
    if (paramCoordinate == null)
    {
      BottleThrowController.access$400(this.this$1.this$0, new BottleThrowController.LocationError(-20003));
      return;
    }
    BottleThrowController.access$500(this.this$1.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleThrowController.5.1
 * JD-Core Version:    0.7.0.1
 */