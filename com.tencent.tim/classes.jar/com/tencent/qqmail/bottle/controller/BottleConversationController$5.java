package com.tencent.qqmail.bottle.controller;

import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import java.util.Iterator;

class BottleConversationController$5
  implements Runnable
{
  BottleConversationController$5(BottleConversationController paramBottleConversationController, QMNetworkError paramQMNetworkError) {}
  
  public void run()
  {
    if (BottleConversationController.access$500(this.this$0).length() > 0)
    {
      Iterator localIterator = BottleConversationController.access$500(this.this$0).iterator();
      while (localIterator.hasNext()) {
        ((BottleConversationController.UpdateConversationWatcher)localIterator.next()).onErrorInMainThread(this.val$error);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleConversationController.5
 * JD-Core Version:    0.7.0.1
 */