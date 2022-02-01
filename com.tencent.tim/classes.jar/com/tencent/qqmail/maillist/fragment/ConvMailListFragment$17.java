package com.tencent.qqmail.maillist.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.model.mail.cursor.IMailListCursor;

class ConvMailListFragment$17
  implements View.OnClickListener
{
  ConvMailListFragment$17(ConvMailListFragment paramConvMailListFragment) {}
  
  public void onClick(View paramView)
  {
    if (ConvMailListFragment.access$500(this.this$0) != null)
    {
      ConvMailListFragment.access$500(this.this$0).loadMore();
      ConvMailListFragment.access$2600(this.this$0);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.ConvMailListFragment.17
 * JD-Core Version:    0.7.0.1
 */