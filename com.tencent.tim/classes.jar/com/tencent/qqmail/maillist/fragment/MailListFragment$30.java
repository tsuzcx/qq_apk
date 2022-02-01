package com.tencent.qqmail.maillist.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.model.mail.QMMailListCursor;

class MailListFragment$30
  implements View.OnClickListener
{
  MailListFragment$30(MailListFragment paramMailListFragment) {}
  
  public void onClick(View paramView)
  {
    if (MailListFragment.access$200(this.this$0) != null)
    {
      MailListFragment.access$200(this.this$0).loadMore();
      MailListFragment.access$8200(this.this$0);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.MailListFragment.30
 * JD-Core Version:    0.7.0.1
 */