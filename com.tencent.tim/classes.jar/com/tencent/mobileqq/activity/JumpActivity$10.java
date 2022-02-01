package com.tencent.mobileqq.activity;

import ahwm;
import android.content.Intent;
import android.os.Message;
import mqq.os.MqqHandler;

class JumpActivity$10
  implements Runnable
{
  JumpActivity$10(JumpActivity paramJumpActivity, ahwm paramahwm, Intent paramIntent, int paramInt) {}
  
  public void run()
  {
    if (!this.a.b(this.val$data, this.val$data.getAction()))
    {
      Message localMessage = Message.obtain();
      localMessage.what = 2;
      localMessage.arg1 = this.bHP;
      localMessage.obj = this.val$data;
      this.this$0.uiHandler.sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.JumpActivity.10
 * JD-Core Version:    0.7.0.1
 */