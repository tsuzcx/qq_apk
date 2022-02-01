package com.tencent.qqmail.maillist.fragment;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.nativepages.NativeAdsHelper;
import com.tencent.qqmail.utilities.ui.ItemScrollListView;

class MailListFragment$29
  implements AbsListView.OnScrollListener
{
  MailListFragment$29(MailListFragment paramMailListFragment) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 -= MailListFragment.access$000(this.this$0).getHeaderViewsCount();
    MailListFragment.access$7802(this.this$0, paramInt1 + paramInt2);
    MailListFragment.access$7902(this.this$0, NativeAdsHelper.getInstance().getIndexOfExposeAdsItemInMailList());
    if ((MailListFragment.access$7900(this.this$0) >= 0) && (paramInt1 < MailListFragment.access$7900(this.this$0)) && (MailListFragment.access$7900(this.this$0) < MailListFragment.access$7800(this.this$0) - 1))
    {
      if (MailListFragment.access$8000(this.this$0) < 0L) {
        MailListFragment.access$8002(this.this$0, System.currentTimeMillis());
      }
      return;
    }
    MailListFragment.access$8100(this.this$0);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    EventCollector.getInstance().onListScrollStateChanged(paramAbsListView, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.MailListFragment.29
 * JD-Core Version:    0.7.0.1
 */