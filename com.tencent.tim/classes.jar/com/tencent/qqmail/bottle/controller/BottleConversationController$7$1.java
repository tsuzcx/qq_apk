package com.tencent.qqmail.bottle.controller;

import java.util.Iterator;

class BottleConversationController$7$1
  implements Runnable
{
  BottleConversationController$7$1(BottleConversationController.7 param7) {}
  
  public void run()
  {
    Iterator localIterator = BottleConversationController.access$600(this.this$1.this$0).iterator();
    while (localIterator.hasNext()) {
      ((BottleConversationController.ConversationSyncWatcher)localIterator.next()).onEndInMainThread();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleConversationController.7.1
 * JD-Core Version:    0.7.0.1
 */