package com.tencent.mobileqq.widget;

import android.content.res.Resources;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;

class ScrollerRunnable$3
  implements Runnable
{
  ScrollerRunnable$3(ScrollerRunnable paramScrollerRunnable, View paramView) {}
  
  public void run()
  {
    if (ScrollerRunnable.a(this.this$0) != null) {
      ScrollerRunnable.a(this.this$0).setBackgroundColor(0);
    }
    this.val$view.setBackgroundColor(BaseApplicationImpl.getContext().getResources().getColor(2131167329));
    ScrollerRunnable.a(this.this$0, this.val$view);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ScrollerRunnable.3
 * JD-Core Version:    0.7.0.1
 */