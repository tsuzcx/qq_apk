package com.tencent.qqmail.maillist.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.model.mail.cursor.IMailListCursor;

class AggregateMailListFragment$21
  implements View.OnClickListener
{
  AggregateMailListFragment$21(AggregateMailListFragment paramAggregateMailListFragment) {}
  
  public void onClick(View paramView)
  {
    if (AggregateMailListFragment.access$500(this.this$0) != null)
    {
      AggregateMailListFragment.access$500(this.this$0).loadMore();
      AggregateMailListFragment.access$2700(this.this$0);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.AggregateMailListFragment.21
 * JD-Core Version:    0.7.0.1
 */