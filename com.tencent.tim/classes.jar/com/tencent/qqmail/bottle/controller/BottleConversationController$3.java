package com.tencent.qqmail.bottle.controller;

class BottleConversationController$3
  implements Runnable
{
  BottleConversationController$3(BottleConversationController paramBottleConversationController, String paramString) {}
  
  public void run()
  {
    BottleConversationCursor localBottleConversationCursor = this.this$0.readConversationFromDB(this.val$bottleId, false);
    BottleConversationController.access$400(this.this$0, this.val$bottleId, true, localBottleConversationCursor);
    localBottleConversationCursor.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleConversationController.3
 * JD-Core Version:    0.7.0.1
 */