package com.tencent.qqmail.maillist.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MailListFragment$32
  implements View.OnClickListener
{
  MailListFragment$32(MailListFragment paramMailListFragment) {}
  
  public void onClick(View paramView)
  {
    MailListFragment.access$8300(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.MailListFragment.32
 * JD-Core Version:    0.7.0.1
 */