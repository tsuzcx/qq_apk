package com.tencent.qqmail.bottle.controller;

import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCGIError;

class BottleListController$4
  implements Runnable
{
  BottleListController$4(BottleListController paramBottleListController, BottleListCursor paramBottleListCursor) {}
  
  public void run()
  {
    BottleListCursor localBottleListCursor3 = this.val$fCursor;
    BottleListCursor localBottleListCursor2 = BottleListController.access$400(this.this$0);
    BottleListCursor localBottleListCursor1 = localBottleListCursor3;
    if (BottleListController.access$600(this.this$0, localBottleListCursor2, localBottleListCursor3)) {
      localBottleListCursor1 = localBottleListCursor2;
    }
    if (localBottleListCursor1.total > localBottleListCursor1.getCount()) {
      if (localBottleListCursor1.lastBottleId != null)
      {
        int i = localBottleListCursor1.getCount();
        BottleListController.access$300(this.this$0, localBottleListCursor1, false, new BottleListController.4.1(this, i));
      }
    }
    for (;;)
    {
      localBottleListCursor2.close();
      return;
      BottleListController.access$300(this.this$0, null, true, BottleListController.access$200(this.this$0));
      continue;
      QMLog.log(5, "BottleListController", "loadMore");
      BottleListController.access$800(this.this$0, new QMCGIError(9955));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleListController.4
 * JD-Core Version:    0.7.0.1
 */