package com.tencent.qqmail.fragment.base;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MailFragment$1
  implements View.OnClickListener
{
  MailFragment$1(MailFragment paramMailFragment) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.isAttachedToActivity()) {
      this.this$0.onButtonBackClick();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.fragment.base.MailFragment.1
 * JD-Core Version:    0.7.0.1
 */