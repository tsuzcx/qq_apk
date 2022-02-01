package com.tencent.qqmail.sendmaillist;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class SendMailListFragment$6
  implements View.OnTouchListener
{
  SendMailListFragment$6(SendMailListFragment paramSendMailListFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      SendMailListFragment.access$1102(this.this$0, paramMotionEvent.getX());
      SendMailListFragment.access$1202(this.this$0, paramMotionEvent.getY());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.sendmaillist.SendMailListFragment.6
 * JD-Core Version:    0.7.0.1
 */