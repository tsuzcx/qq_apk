package com.tencent.qqmail.activity.vipcontacts;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VIPContactsFragment$10
  implements AbsListView.OnScrollListener
{
  VIPContactsFragment$10(VIPContactsFragment paramVIPContactsFragment) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    EventCollector.getInstance().onListScrollStateChanged(paramAbsListView, paramInt);
    if ((paramInt == 1) && (VIPContactsFragment.access$2100(this.this$0))) {
      this.this$0.hideKeyBoard();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.vipcontacts.VIPContactsFragment.10
 * JD-Core Version:    0.7.0.1
 */