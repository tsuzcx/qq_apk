package com.tencent.qqmail.ftn.activity;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FtnSearchListActivity$14
  implements AbsListView.OnScrollListener
{
  FtnSearchListActivity$14(FtnSearchListActivity paramFtnSearchListActivity) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    EventCollector.getInstance().onListScrollStateChanged(paramAbsListView, paramInt);
    switch (paramInt)
    {
    case 0: 
    default: 
      return;
    }
    this.this$0.hideKeyBoard();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnSearchListActivity.14
 * JD-Core Version:    0.7.0.1
 */