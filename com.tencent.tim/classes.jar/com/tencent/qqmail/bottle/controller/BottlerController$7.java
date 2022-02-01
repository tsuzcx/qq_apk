package com.tencent.qqmail.bottle.controller;

import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import java.util.Iterator;

class BottlerController$7
  implements Runnable
{
  BottlerController$7(BottlerController paramBottlerController, QMNetworkError paramQMNetworkError) {}
  
  public void run()
  {
    if (BottlerController.access$800(this.this$0).length() > 0)
    {
      Iterator localIterator = BottlerController.access$800(this.this$0).iterator();
      while (localIterator.hasNext()) {
        ((BottlerController.MyInformationUpdatedWatcher)localIterator.next()).onErrorInMainThread(this.val$error);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottlerController.7
 * JD-Core Version:    0.7.0.1
 */