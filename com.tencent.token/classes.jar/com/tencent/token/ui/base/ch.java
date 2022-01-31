package com.tencent.token.ui.base;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

class ch
  implements AbsListView.OnScrollListener
{
  private ch(PullToRefreshListView paramPullToRefreshListView) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    PullToRefreshListView.a(this.a, paramInt1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.ch
 * JD-Core Version:    0.7.0.1
 */