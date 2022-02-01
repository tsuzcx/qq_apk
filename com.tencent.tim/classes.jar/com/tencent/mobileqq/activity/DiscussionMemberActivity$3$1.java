package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import uvc;

public class DiscussionMemberActivity$3$1
  implements Runnable
{
  public DiscussionMemberActivity$3$1(uvc paramuvc) {}
  
  public void run()
  {
    this.a.a.mRootView.offsetTopAndBottom(-this.a.dS);
    DiscussionMemberActivity.a(this.a.a).setVisibility(0);
    this.a.a.mRootView.startAnimation(this.a.c);
    this.a.b.hideSoftInputFromWindow(this.a.a.getWindow().peekDecorView().getWindowToken(), 0);
    this.a.a.removeObserver(this.a.i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionMemberActivity.3.1
 * JD-Core Version:    0.7.0.1
 */