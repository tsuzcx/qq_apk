package com.tencent.qqmail.bottle.controller;

import java.util.Iterator;

class BottleListController$8
  implements Runnable
{
  BottleListController$8(BottleListController paramBottleListController) {}
  
  public void run()
  {
    Iterator localIterator = BottleListController.access$1000(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((BottleListController.UpdateUnreadStatusWatcher)localIterator.next()).onSuccessInMainThread(BottleListController.access$1100(this.this$0), BottleListController.access$100(this.this$0).mSettings.getUnreadCount(), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleListController.8
 * JD-Core Version:    0.7.0.1
 */