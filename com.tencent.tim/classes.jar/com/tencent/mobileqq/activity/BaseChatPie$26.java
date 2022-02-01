package com.tencent.mobileqq.activity;

import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.widget.ScrollerRunnable;

class BaseChatPie$26
  implements Runnable
{
  BaseChatPie$26(BaseChatPie paramBaseChatPie, int paramInt) {}
  
  public void run()
  {
    int i = this.this$0.b.getHeaderViewsCount();
    this.this$0.b.setSelectionFromTop(i + this.bEF, this.this$0.mActivity.getTitleBarHeight());
    this.this$0.a.ax(this.bEF, 250L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.26
 * JD-Core Version:    0.7.0.1
 */