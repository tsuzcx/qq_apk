package com.tencent.qqmail.bottle.controller;

class BottleConversationController$8
  implements Runnable
{
  BottleConversationController$8(BottleConversationController paramBottleConversationController, String paramString1, String paramString2) {}
  
  public void run()
  {
    BottleConversationController_DraftDataORM.replace(BottleConversationController.access$100(this.this$0).mDBOpenHelper.getWritableDatabase(), new BottleConversationController.DraftData(this.val$bottleId, this.val$draft));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleConversationController.8
 * JD-Core Version:    0.7.0.1
 */