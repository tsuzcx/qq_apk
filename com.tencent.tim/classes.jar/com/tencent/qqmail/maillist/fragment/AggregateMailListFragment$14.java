package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.maillist.ListViewHelper.OnHandleNextUnread;
import com.tencent.qqmail.view.QMBaseView;

class AggregateMailListFragment$14
  implements ListViewHelper.OnHandleNextUnread
{
  AggregateMailListFragment$14(AggregateMailListFragment paramAggregateMailListFragment) {}
  
  public void onFoundUnread(int paramInt1, int paramInt2)
  {
    if (paramInt1 == -1)
    {
      AggregateMailListFragment.access$2300(this.this$0).scrollToTop();
      return;
    }
    AggregateMailListFragment.access$2300(this.this$0).scrollToPosition(paramInt1);
  }
  
  public boolean onReachEnd(int paramInt)
  {
    AggregateMailListFragment.access$2300(this.this$0).scrollToTop();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.AggregateMailListFragment.14
 * JD-Core Version:    0.7.0.1
 */