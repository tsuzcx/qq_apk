package com.tencent.qqmail.bottle.controller;

import java.util.Iterator;

class BottleListController$1
  implements Runnable
{
  BottleListController$1(BottleListController paramBottleListController, BottleListCursor paramBottleListCursor) {}
  
  public void run()
  {
    if (BottleListController.access$000(this.this$0).length() > 0)
    {
      Iterator localIterator = BottleListController.access$000(this.this$0).iterator();
      while (localIterator.hasNext()) {
        ((BottleListController.UpdateListWatcher)localIterator.next()).onSuccessInMainThread(this.val$cursor);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleListController.1
 * JD-Core Version:    0.7.0.1
 */