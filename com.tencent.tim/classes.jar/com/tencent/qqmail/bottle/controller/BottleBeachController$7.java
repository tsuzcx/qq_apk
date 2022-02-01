package com.tencent.qqmail.bottle.controller;

import com.tencent.qqmail.bottle.model.BottleBeach;
import com.tencent.qqmail.utilities.log.QMLog;

class BottleBeachController$7
  implements Runnable
{
  BottleBeachController$7(BottleBeachController paramBottleBeachController) {}
  
  public void run()
  {
    if (BottleBeachController.access$500(this.this$0).mSettings.isBeachLoaded())
    {
      QMLog.log(4, "BottleBeachController", "loadBeachBottle from db");
      BottleBeach[] arrayOfBottleBeach = BottleBeachController.access$600(this.this$0);
      BottleBeachController.access$700(this.this$0, arrayOfBottleBeach);
      return;
    }
    QMLog.log(4, "BottleBeachController", "loadBeachBottle with 6");
    BottleBeachController.access$500(this.this$0).mSettings.getAndIncreaseBeachBottleNumber();
    BottleBeachController.access$400(this.this$0, 6, true, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleBeachController.7
 * JD-Core Version:    0.7.0.1
 */