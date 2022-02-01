package com.tencent.qqmail.bottle.controller;

import com.tencent.qqmail.bottle.model.BottleBeach;
import java.util.Iterator;

class BottleBeachController$1
  implements Runnable
{
  BottleBeachController$1(BottleBeachController paramBottleBeachController, int paramInt, BottleBeach[] paramArrayOfBottleBeach1, BottleBeach[] paramArrayOfBottleBeach2) {}
  
  public void run()
  {
    if (BottleBeachController.access$000(this.this$0).length() > 0)
    {
      Iterator localIterator = BottleBeachController.access$000(this.this$0).iterator();
      while (localIterator.hasNext()) {
        ((BottleBeachController.BottlePickupWatcher)localIterator.next()).onSuccessInMainThread(this.val$expectedCount, this.val$newBottles, this.val$allBottles);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleBeachController.1
 * JD-Core Version:    0.7.0.1
 */