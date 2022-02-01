package com.tencent.qqmail.maillist;

import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.utilities.ui.PtrListView;

final class ListViewHelper$1
  implements AbsListView.OnScrollListener
{
  private boolean isFlingScrollSpeed;
  private int markOffsetStep = 0;
  private long markTime;
  
  ListViewHelper$1(ListViewHelper.OnHandleListScroll paramOnHandleListScroll) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 0;
    float f2 = 0.0F;
    int j = paramAbsListView.getChildCount();
    float f1 = f2;
    paramInt2 = i;
    if (paramInt1 >= 0)
    {
      f1 = f2;
      paramInt2 = i;
      if (j > 0)
      {
        View localView = paramAbsListView.getChildAt(0);
        int m = localView.getTop();
        int k = localView.getHeight();
        f1 = f2;
        paramInt2 = i;
        if (k > 0)
        {
          paramInt2 = Math.max(paramInt1 * 100 - m * 100 / k + (int)(paramAbsListView.getScrollY() / paramAbsListView.getHeight() * paramInt3 * 100.0F), 0);
          f1 = k / 100;
        }
      }
    }
    paramInt3 = Math.abs(this.markOffsetStep - paramInt2);
    long l1 = System.nanoTime();
    long l2 = (l1 - this.markTime) / 1000000L;
    if ((13L <= l2) && (l2 <= 19L))
    {
      f1 = f1 * paramInt3 / (float)l2;
      if (!this.isFlingScrollSpeed) {
        break label220;
      }
      if ((this.val$scrollCallback != null) && (f1 != 0.0F)) {
        this.val$scrollCallback.onScrollFlingSpeed(f1, paramInt1, j);
      }
    }
    for (;;)
    {
      this.markOffsetStep = paramInt2;
      this.markTime = l1;
      return;
      label220:
      if ((this.val$scrollCallback != null) && (f1 != 0.0F)) {
        this.val$scrollCallback.onTouchScrollSpeed(f1, paramInt1, j);
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    EventCollector.getInstance().onListScrollStateChanged(paramAbsListView, paramInt);
    switch (paramInt)
    {
    default: 
    case 0: 
      do
      {
        do
        {
          return;
          Log.i("wuziyi", "OnScrollListener.SCROLL_STATE_IDLE");
          this.isFlingScrollSpeed = false;
        } while (this.val$scrollCallback == null);
        this.val$scrollCallback.onScrollFlingSpeed(0.0F, paramAbsListView.getFirstVisiblePosition(), paramAbsListView.getChildCount());
        this.val$scrollCallback.onScrollIdle(paramAbsListView.getFirstVisiblePosition(), paramAbsListView.getChildCount());
      } while (!ListViewHelper.isEndOfList((PtrListView)paramAbsListView));
      this.val$scrollCallback.onScrollToEnd((ListView)paramAbsListView);
      return;
    case 2: 
      Log.i("wuziyi", "OnScrollListener.SCROLL_STATE_FLING");
      this.markTime = System.nanoTime();
      this.isFlingScrollSpeed = true;
      return;
    }
    Log.i("wuziyi", "OnScrollListener.SCROLL_STATE_TOUCH_SCROLL");
    this.isFlingScrollSpeed = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.ListViewHelper.1
 * JD-Core Version:    0.7.0.1
 */