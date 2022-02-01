package com.tencent.mobileqq.activity;

import arhz;
import com.tencent.mobileqq.widget.QQToast;

class Conversation$58
  implements Runnable
{
  Conversation$58(Conversation paramConversation) {}
  
  public void run()
  {
    if ((Conversation.a(this.this$0) != null) && (Conversation.a(this.this$0).isShowing()))
    {
      Conversation.a(this.this$0).dismiss();
      QQToast.a(this.this$0.a(), 2, this.this$0.getString(2131720590), 1).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.58
 * JD-Core Version:    0.7.0.1
 */