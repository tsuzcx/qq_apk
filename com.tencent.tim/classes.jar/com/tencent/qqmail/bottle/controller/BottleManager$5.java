package com.tencent.qqmail.bottle.controller;

import com.tencent.qqmail.utilities.thread.Threads;

class BottleManager$5
  implements Runnable
{
  BottleManager$5(BottleManager paramBottleManager, String paramString1, String paramString2, OnActionCallback paramOnActionCallback) {}
  
  public void run()
  {
    if ((!BottleThrowController.isUnsendMsgId(this.val$msgId)) && (this.this$0.mBottleConversationController.isTopMessage(this.val$bottleId, this.val$msgId))) {}
    for (boolean bool = true;; bool = false)
    {
      BottleManager.access$100(this.this$0, this.val$bottleId, this.val$msgId);
      if (bool) {
        this.this$0.mSettings.setListOverdue(true);
      }
      this.this$0.mSettings.updateListDBChangedTimeStamp();
      Threads.runOnMainThread(new BottleManager.5.1(this));
      if (!BottleThrowController.isUnsendMsgId(this.val$bottleId))
      {
        String str = String.format("cmd=delsession&t=bottle_error_app&mailid=%s&msgid=%s", new Object[] { this.val$bottleId, this.val$msgId });
        this.this$0.httpPost("bottle_opr", str, new BottleManager.5.2(this, bool));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleManager.5
 * JD-Core Version:    0.7.0.1
 */