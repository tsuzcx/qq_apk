package com.tencent.qqmail.bottle.controller;

import com.tencent.qqmail.utilities.thread.Threads;

class BottleManager$6
  implements Runnable
{
  BottleManager$6(BottleManager paramBottleManager, String paramString, OnActionCallback paramOnActionCallback) {}
  
  public void run()
  {
    Object localObject = new String[1];
    localObject[0] = this.val$bottleId;
    if ((this.this$0.mBottleListController.deleteBottle((String[])localObject)) || (this.this$0.mBottleBeachController.deleteBottle((String[])localObject)))
    {
      this.this$0.mSettings.setListTotal(this.this$0.mSettings.getListTotal() - 1);
      Threads.runOnMainThread(new BottleManager.6.1(this));
      if (!BottleThrowController.isUnsendBottleId(this.val$bottleId))
      {
        localObject = String.format("t=bottle_error_app&cmd=del&mailid=%s", new Object[] { this.val$bottleId });
        this.this$0.httpPost("bottle_opr", (String)localObject, new BottleManager.6.2(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleManager.6
 * JD-Core Version:    0.7.0.1
 */