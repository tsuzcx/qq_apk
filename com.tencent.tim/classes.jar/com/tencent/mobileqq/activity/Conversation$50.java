package com.tencent.mobileqq.activity;

import anxk;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.app.FrameHelperActivity;

public class Conversation$50
  implements Runnable
{
  Conversation$50(Conversation paramConversation) {}
  
  public void run()
  {
    if ((Conversation.c(this.this$0)) && (this.this$0.a.b != null) && (!this.this$0.a.b.Wt()) && (anxk.S(this.this$0.app, "sub.uin.all"))) {
      this.this$0.runOnUiThread(new Conversation.50.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.50
 * JD-Core Version:    0.7.0.1
 */