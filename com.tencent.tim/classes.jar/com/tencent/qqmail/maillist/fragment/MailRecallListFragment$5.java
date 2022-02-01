package com.tencent.qqmail.maillist.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MailRecallListFragment$5
  implements View.OnClickListener
{
  MailRecallListFragment$5(MailRecallListFragment paramMailRecallListFragment) {}
  
  public void onClick(View paramView)
  {
    MailRecallListFragment.access$400(this.this$0);
    MailRecallListFragment.access$1900(this.this$0);
    MailRecallListFragment.access$500(this.this$0, 1);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.MailRecallListFragment.5
 * JD-Core Version:    0.7.0.1
 */