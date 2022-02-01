package com.tencent.qqmail.bottle.controller;

import com.tencent.qqmail.utilities.log.QMLog;

class BottleConversationController$2
  implements Runnable
{
  BottleConversationController$2(BottleConversationController paramBottleConversationController, BottleConversationCursor paramBottleConversationCursor, String paramString) {}
  
  public void run()
  {
    if ((this.val$cursor.getCount() < this.val$cursor.totalInConversation) && (this.val$cursor.lastMsgId != null))
    {
      BottleConversationController.access$400(this.this$0, this.val$bottleId, false, this.val$cursor);
      return;
    }
    QMLog.log(5, "BottleConversationController", "loadMore: " + this.val$cursor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleConversationController.2
 * JD-Core Version:    0.7.0.1
 */