package com.tencent.qqmail.bottle.controller;

import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import java.util.Iterator;

class BottleListController$2
  implements Runnable
{
  BottleListController$2(BottleListController paramBottleListController, QMNetworkError paramQMNetworkError) {}
  
  public void run()
  {
    if (BottleListController.access$000(this.this$0).length() > 0)
    {
      Iterator localIterator = BottleListController.access$000(this.this$0).iterator();
      while (localIterator.hasNext()) {
        ((BottleListController.UpdateListWatcher)localIterator.next()).onErrorInMainThread(this.val$error);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleListController.2
 * JD-Core Version:    0.7.0.1
 */