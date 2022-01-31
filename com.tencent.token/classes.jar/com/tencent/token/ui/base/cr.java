package com.tencent.token.ui.base;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

final class cr
  implements AbsListView.OnScrollListener
{
  private cr(PullToRefreshListView paramPullToRefreshListView, byte paramByte) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    PullToRefreshListView.a(this.a, paramInt1);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.cr
 * JD-Core Version:    0.7.0.1
 */