package com.tencent.qqmail.maillist.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MailListFragment$22
  implements View.OnClickListener
{
  MailListFragment$22(MailListFragment paramMailListFragment) {}
  
  public void onClick(View paramView)
  {
    if (!MailListFragment.access$300(this.this$0))
    {
      this.this$0.onButtonBackClick();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    MailListFragment localMailListFragment = this.this$0;
    if (!MailListFragment.access$1900(this.this$0)) {}
    for (boolean bool = true;; bool = false)
    {
      MailListFragment.access$7200(localMailListFragment, bool);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.MailListFragment.22
 * JD-Core Version:    0.7.0.1
 */