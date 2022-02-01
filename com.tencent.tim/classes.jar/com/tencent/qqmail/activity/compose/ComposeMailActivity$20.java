package com.tencent.qqmail.activity.compose;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class ComposeMailActivity$20
  implements View.OnTouchListener
{
  ComposeMailActivity$20(ComposeMailActivity paramComposeMailActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 2) || (paramMotionEvent.getAction() == 0)) {
      ((View)this.this$0.composeView).setVerticalScrollBarEnabled(true);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.20
 * JD-Core Version:    0.7.0.1
 */