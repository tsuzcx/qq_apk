package com.tencent.qqmail.bottle.controller;

import java.util.Iterator;

class BottleConversationController$4
  implements Runnable
{
  BottleConversationController$4(BottleConversationController paramBottleConversationController, BottleConversationCursor paramBottleConversationCursor) {}
  
  public void run()
  {
    if (BottleConversationController.access$500(this.this$0).length() > 0)
    {
      Iterator localIterator = BottleConversationController.access$500(this.this$0).iterator();
      while (localIterator.hasNext()) {
        ((BottleConversationController.UpdateConversationWatcher)localIterator.next()).onSuccessInMainThread(this.val$cursor);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleConversationController.4
 * JD-Core Version:    0.7.0.1
 */