package com.tencent.qqmail.bottle.controller;

import com.tencent.qqmail.bottle.model.BottleConversation;
import com.tencent.qqmail.utilities.ui.QMNotificationConstructor;
import java.util.Iterator;

class BottleThrowController$6
  implements Runnable
{
  BottleThrowController$6(BottleThrowController paramBottleThrowController, boolean paramBoolean, BottleConversation paramBottleConversation, BottleConversationCursor paramBottleConversationCursor) {}
  
  public void run()
  {
    if (BottleThrowController.access$600(this.this$0).length() > 0)
    {
      Iterator localIterator = BottleThrowController.access$600(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        BottleThrowController.OnBottleThrowWatcher localOnBottleThrowWatcher = (BottleThrowController.OnBottleThrowWatcher)localIterator.next();
        if (this.val$writeToDB) {
          localOnBottleThrowWatcher.onSuccessToWriteDBInMainThread(this.val$thrownBottle, this.val$cursor);
        } else {
          localOnBottleThrowWatcher.onSuccessInMainThread(this.val$thrownBottle, this.val$cursor);
        }
      }
    }
    QMNotificationConstructor.getInstance().clearBottleSendNotify();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleThrowController.6
 * JD-Core Version:    0.7.0.1
 */