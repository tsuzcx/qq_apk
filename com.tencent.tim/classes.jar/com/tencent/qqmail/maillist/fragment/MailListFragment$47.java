package com.tencent.qqmail.maillist.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MailListFragment$47
  implements View.OnClickListener
{
  MailListFragment$47(MailListFragment paramMailListFragment) {}
  
  public void onClick(View paramView)
  {
    if ((MailListFragment.access$9000(this.this$0)) || (!MailListFragment.access$300(this.this$0)) || (MailListFragment.access$2100(this.this$0))) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      MailListFragment.access$10200(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.MailListFragment.47
 * JD-Core Version:    0.7.0.1
 */