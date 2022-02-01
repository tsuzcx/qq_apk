package com.tencent.qqmail.bottle.controller;

import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCGIError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class BottleListController$4$1
  implements BottleListController.RequestListCallback
{
  BottleListController$4$1(BottleListController.4 param4, int paramInt) {}
  
  public void onError(QMNetworkError paramQMNetworkError)
  {
    BottleListController.access$800(this.this$1.this$0, paramQMNetworkError);
  }
  
  public void onSuccess()
  {
    BottleListCursor localBottleListCursor = BottleListController.access$400(this.this$1.this$0);
    if (this.val$mOriCurorCount == localBottleListCursor.getCount())
    {
      QMLog.log(6, "BottleListController", "loadMore no new item: " + this.val$mOriCurorCount + ", bottleId:" + localBottleListCursor.lastBottleId);
      BottleListController.access$800(this.this$1.this$0, new QMCGIError(9955));
      return;
    }
    BottleListController.access$500(this.this$1.this$0, localBottleListCursor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleListController.4.1
 * JD-Core Version:    0.7.0.1
 */