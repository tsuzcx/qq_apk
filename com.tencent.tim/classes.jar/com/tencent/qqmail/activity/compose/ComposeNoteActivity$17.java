package com.tencent.qqmail.activity.compose;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class ComposeNoteActivity$17
  implements View.OnTouchListener
{
  ComposeNoteActivity$17(ComposeNoteActivity paramComposeNoteActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 2) || (paramMotionEvent.getAction() == 0)) {
      ComposeNoteActivity.access$1400(this.this$0).setVerticalScrollBarEnabled(true);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeNoteActivity.17
 * JD-Core Version:    0.7.0.1
 */