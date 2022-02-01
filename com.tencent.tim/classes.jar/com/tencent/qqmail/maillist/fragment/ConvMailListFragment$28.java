package com.tencent.qqmail.maillist.fragment;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class ConvMailListFragment$28
  implements View.OnTouchListener
{
  ConvMailListFragment$28(ConvMailListFragment paramConvMailListFragment, boolean[] paramArrayOfBoolean) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() & 0xFF) == 0) {
      this.val$hasLongClick[0] = false;
    }
    return ((paramMotionEvent.getAction() & 0xFF) == 1) && (this.val$hasLongClick[0] != 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.ConvMailListFragment.28
 * JD-Core Version:    0.7.0.1
 */