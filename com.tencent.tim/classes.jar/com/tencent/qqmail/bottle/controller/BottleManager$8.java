package com.tencent.qqmail.bottle.controller;

import com.tencent.qqmail.utilities.thread.Threads;

class BottleManager$8
  implements Runnable
{
  BottleManager$8(BottleManager paramBottleManager, String paramString, OnActionCallback paramOnActionCallback) {}
  
  public void run()
  {
    Object localObject = new String[1];
    localObject[0] = this.val$bottleId;
    if ((this.this$0.mBottleListController.deleteBottle((String[])localObject)) || (this.this$0.mBottleBeachController.deleteBottle((String[])localObject)))
    {
      Threads.runOnMainThread(new BottleManager.8.1(this));
      if (!BottleThrowController.isUnsendBottleId(this.val$bottleId))
      {
        localObject = String.format("&mailid=%s&s=readmail_spam&Fun=Del&isspam=true&mailaction=mail_spam&resp_charset=UTF8&t=bottle_error_app", new Object[] { this.val$bottleId });
        this.this$0.httpPost("mail_mgr", (String)localObject, new BottleManager.8.2(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleManager.8
 * JD-Core Version:    0.7.0.1
 */