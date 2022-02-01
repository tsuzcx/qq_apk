package com.tencent.qqmail.bottle.fragment;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.qqmail.bottle.controller.BottleManager;

class BottleConversationFragment$27
  implements View.OnTouchListener
{
  private boolean oldReplying;
  
  BottleConversationFragment$27(BottleConversationFragment paramBottleConversationFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    BottleManager.log("conversationFragment.listView.touch:" + BottleConversationFragment.access$2400(this.this$0));
    if (paramMotionEvent.getAction() == 0) {
      this.oldReplying = BottleConversationFragment.access$2400(this.this$0);
    }
    BottleConversationFragment.access$200(this.this$0, true);
    return this.oldReplying;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleConversationFragment.27
 * JD-Core Version:    0.7.0.1
 */