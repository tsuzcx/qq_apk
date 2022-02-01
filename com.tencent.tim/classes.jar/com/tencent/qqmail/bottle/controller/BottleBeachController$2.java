package com.tencent.qqmail.bottle.controller;

import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import java.util.Iterator;

class BottleBeachController$2
  implements Runnable
{
  BottleBeachController$2(BottleBeachController paramBottleBeachController, QMNetworkError paramQMNetworkError) {}
  
  public void run()
  {
    if (BottleBeachController.access$000(this.this$0).length() > 0)
    {
      Iterator localIterator = BottleBeachController.access$000(this.this$0).iterator();
      while (localIterator.hasNext()) {
        ((BottleBeachController.BottlePickupWatcher)localIterator.next()).onErrorInMainThread(this.val$error);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleBeachController.2
 * JD-Core Version:    0.7.0.1
 */