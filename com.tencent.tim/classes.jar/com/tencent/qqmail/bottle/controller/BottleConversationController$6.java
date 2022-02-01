package com.tencent.qqmail.bottle.controller;

import java.util.Iterator;

class BottleConversationController$6
  implements Runnable
{
  BottleConversationController$6(BottleConversationController paramBottleConversationController) {}
  
  public void run()
  {
    Iterator localIterator = BottleConversationController.access$600(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((BottleConversationController.ConversationSyncWatcher)localIterator.next()).onStartInMainThread();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleConversationController.6
 * JD-Core Version:    0.7.0.1
 */