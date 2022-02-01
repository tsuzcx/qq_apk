package com.tencent.qqmail.maillist.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.model.mail.QMMailListCursor;
import com.tencent.qqmail.search.fragment.SearchListFragment;

class MailListFragment$33
  implements View.OnClickListener
{
  MailListFragment$33(MailListFragment paramMailListFragment) {}
  
  public void onClick(View paramView)
  {
    SearchListFragment localSearchListFragment = new SearchListFragment(MailListFragment.access$2200(this.this$0), MailListFragment.access$2400(this.this$0), MailListFragment.access$200(this.this$0).getItemIds());
    this.this$0.startFragment(localSearchListFragment);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.MailListFragment.33
 * JD-Core Version:    0.7.0.1
 */