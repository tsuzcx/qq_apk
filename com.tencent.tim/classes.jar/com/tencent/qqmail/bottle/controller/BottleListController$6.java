package com.tencent.qqmail.bottle.controller;

import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class BottleListController$6
  implements BottleListController.RequestListCallback
{
  BottleListController$6(BottleListController paramBottleListController) {}
  
  public void onError(QMNetworkError paramQMNetworkError)
  {
    BottleListController.access$800(this.this$0, paramQMNetworkError);
  }
  
  public void onSuccess()
  {
    BottleListCursor localBottleListCursor = BottleListController.access$400(this.this$0);
    BottleListController.access$500(this.this$0, localBottleListCursor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleListController.6
 * JD-Core Version:    0.7.0.1
 */