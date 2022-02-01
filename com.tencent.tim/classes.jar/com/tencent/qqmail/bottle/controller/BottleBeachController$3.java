package com.tencent.qqmail.bottle.controller;

import com.tencent.qqmail.bottle.model.BottleBeach;
import java.util.Iterator;

class BottleBeachController$3
  implements Runnable
{
  BottleBeachController$3(BottleBeachController paramBottleBeachController, BottleBeach[] paramArrayOfBottleBeach) {}
  
  public void run()
  {
    if (BottleBeachController.access$100(this.this$0).length() > 0)
    {
      Iterator localIterator = BottleBeachController.access$100(this.this$0).iterator();
      while (localIterator.hasNext()) {
        ((BottleBeachController.BottleLoadWatcher)localIterator.next()).onBottleLoadInMainThread(this.val$beachBottles);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleBeachController.3
 * JD-Core Version:    0.7.0.1
 */