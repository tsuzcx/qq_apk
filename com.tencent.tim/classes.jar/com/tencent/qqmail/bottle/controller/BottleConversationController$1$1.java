package com.tencent.qqmail.bottle.controller;

import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class BottleConversationController$1$1
  implements BottleListController.RequestListCallback
{
  BottleConversationController$1$1(BottleConversationController.1 param1) {}
  
  public void onError(QMNetworkError paramQMNetworkError)
  {
    BottleConversationController.access$000(this.this$1.this$0, new BottleConversationController.LoadConversationError(-20003));
  }
  
  public void onSuccess()
  {
    BottleConversationCursor localBottleConversationCursor = this.this$1.this$0.readConversationFromDB(this.this$1.val$bottleId, false);
    this.this$1.this$0.loadConversation(this.this$1.val$bottleId, localBottleConversationCursor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleConversationController.1.1
 * JD-Core Version:    0.7.0.1
 */