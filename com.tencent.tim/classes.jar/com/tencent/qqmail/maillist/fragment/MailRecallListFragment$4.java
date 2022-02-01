package com.tencent.qqmail.maillist.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MailRecallListFragment$4
  implements View.OnClickListener
{
  MailRecallListFragment$4(MailRecallListFragment paramMailRecallListFragment) {}
  
  public void onClick(View paramView)
  {
    MailRecallListFragment.access$1800(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.MailRecallListFragment.4
 * JD-Core Version:    0.7.0.1
 */