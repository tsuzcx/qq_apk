package com.tencent.qqmail.bottle.controller;

import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import java.util.Iterator;

class BottleThrowController$2
  implements Runnable
{
  BottleThrowController$2(BottleThrowController paramBottleThrowController, QMNetworkError paramQMNetworkError) {}
  
  public void run()
  {
    if (BottleThrowController.access$000(this.this$0).length() > 0)
    {
      Iterator localIterator = BottleThrowController.access$000(this.this$0).iterator();
      while (localIterator.hasNext()) {
        ((BottleThrowController.BottleLocationWatcher)localIterator.next()).onErrorInMainThread(this.val$error);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleThrowController.2
 * JD-Core Version:    0.7.0.1
 */