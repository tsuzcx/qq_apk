package com.tencent.qqmail.fragment.base;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MailFragment$2
  implements View.OnClickListener
{
  MailFragment$2(MailFragment paramMailFragment) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.isAttachedToActivity()) {
      this.this$0.onTopBarCenterClick();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.fragment.base.MailFragment.2
 * JD-Core Version:    0.7.0.1
 */