package com.tencent.mobileqq.activity;

import aamm;
import android.view.View;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;

class Conversation$54
  implements Runnable
{
  Conversation$54(Conversation paramConversation, int paramInt) {}
  
  public void run()
  {
    View localView = Conversation.a(this.this$0).getChildAt(this.bGk - Conversation.a(this.this$0).getFirstVisiblePosition());
    if (localView != null)
    {
      localView = localView.findViewById(2131377096);
      this.this$0.a.a(this.this$0.app, localView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.54
 * JD-Core Version:    0.7.0.1
 */