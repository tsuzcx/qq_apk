package com.tencent.mobileqq.activity;

import android.content.Intent;
import com.tencent.widget.XPanelContainer;
import mqq.os.MqqHandler;

class BaseChatPie$23
  implements Runnable
{
  BaseChatPie$23(BaseChatPie paramBaseChatPie, Intent paramIntent) {}
  
  public void run()
  {
    if (this.this$0.b.vm() != 1)
    {
      this.this$0.aey();
      this.this$0.uiHandler.postDelayed(this, 100L);
      return;
    }
    this.val$intent.removeExtra("KEY_SHOULD_SHOW_KEYBOARD");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.23
 * JD-Core Version:    0.7.0.1
 */