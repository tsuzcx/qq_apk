package com.tencent.qqmail.bottle.controller;

import com.tencent.qqmail.utilities.log.QMLog;

class BottleConversationController$1
  implements Runnable
{
  BottleConversationController$1(BottleConversationController paramBottleConversationController, BottleConversationCursor paramBottleConversationCursor, String paramString) {}
  
  public void run()
  {
    QMLog.log(4, "BottleConversationController", "requestConversation: run");
    BottleConversationCursor localBottleConversationCursor;
    if (this.val$cursor == null)
    {
      QMLog.log(4, "BottleConversationController", "requestConversation: cursor is null");
      localBottleConversationCursor = this.this$0.readConversationFromDB(this.val$bottleId, true);
      if (localBottleConversationCursor == null) {
        if (BottleThrowController.isUnsendBottleId(this.val$bottleId)) {
          BottleConversationController.access$000(this.this$0, new BottleConversationController.LoadConversationError(-20001));
        }
      }
    }
    do
    {
      do
      {
        return;
        BottleConversationController.access$100(this.this$0).mBottleListController.refreshList(new BottleConversationController.1.1(this));
        return;
        if (BottleThrowController.isUnsendBottleId(this.val$bottleId))
        {
          QMLog.log(4, "BottleConversationController", "requestConversation: unsend");
          BottleConversationController.access$200(this.this$0, localBottleConversationCursor);
          return;
        }
        if (localBottleConversationCursor.getCount() != 0)
        {
          QMLog.log(4, "BottleConversationController", "requestConversation: show old data");
          BottleConversationController.access$200(this.this$0, localBottleConversationCursor);
        }
        if (BottleConversationController.access$300(this.this$0, localBottleConversationCursor))
        {
          QMLog.log(4, "BottleConversationController", "requestConversation: request new data");
          BottleConversationController.access$400(this.this$0, this.val$bottleId, true, localBottleConversationCursor);
        }
      } while (localBottleConversationCursor.getCount() != 0);
      localBottleConversationCursor.close();
      return;
      QMLog.log(4, "BottleConversationController", "requestConversation: cursor not null");
      localBottleConversationCursor = this.this$0.readConversationFromDB(this.val$bottleId, false);
      if (!localBottleConversationCursor.equals(this.val$cursor)) {
        BottleConversationController.access$200(this.this$0, localBottleConversationCursor);
      }
    } while (!BottleConversationController.access$300(this.this$0, localBottleConversationCursor));
    BottleConversationController.access$400(this.this$0, this.val$bottleId, true, localBottleConversationCursor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleConversationController.1
 * JD-Core Version:    0.7.0.1
 */