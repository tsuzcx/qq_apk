package com.tencent.mobileqq.emosm.view;

import android.os.SystemClock;
import android.view.View;

class DragSortListView$DragScroller
  implements Runnable
{
  public static final int DOWN = 1;
  public static final int STOP = -1;
  public static final int UP = 0;
  private float dt;
  private int dy;
  private boolean mAbort;
  private long mCurrTime;
  private int mFirstFooter;
  private int mLastHeader;
  private long mPrevTime;
  private float mScrollSpeed;
  private boolean mScrolling = false;
  private int scrollDir;
  private long tStart;
  
  public DragSortListView$DragScroller(DragSortListView paramDragSortListView) {}
  
  public int getScrollDir()
  {
    if (this.mScrolling) {
      return this.scrollDir;
    }
    return -1;
  }
  
  public boolean isScrolling()
  {
    return this.mScrolling;
  }
  
  public void run()
  {
    if (this.mAbort)
    {
      this.mScrolling = false;
      return;
    }
    int j = this.this$0.getFirstVisiblePosition();
    int i = this.this$0.getLastVisiblePosition();
    int m = this.this$0.getCount();
    int k = this.this$0.getPaddingTop();
    int n = this.this$0.getHeight() - k - this.this$0.getPaddingBottom();
    int i1 = Math.min(this.this$0.mY, this.this$0.mFloatViewMid + this.this$0.mFloatViewHeightHalf);
    int i2 = Math.max(this.this$0.mY, this.this$0.mFloatViewMid - this.this$0.mFloatViewHeightHalf);
    View localView;
    if (this.scrollDir == 0)
    {
      localView = this.this$0.getChildAt(0);
      if (localView == null)
      {
        this.mScrolling = false;
        return;
      }
      if ((j == 0) && (localView.getTop() == k))
      {
        this.mScrolling = false;
        return;
      }
      this.mScrollSpeed = this.this$0.mScrollProfile.getSpeed((this.this$0.mUpScrollStartYF - i2) / this.this$0.mDragUpScrollHeight, this.mPrevTime);
      this.mCurrTime = SystemClock.uptimeMillis();
      this.dt = ((float)(this.mCurrTime - this.mPrevTime));
      this.dy = Math.round(this.mScrollSpeed * this.dt);
      if (this.dy < 0) {
        break label470;
      }
      this.dy = Math.min(n, this.dy);
      i = j;
    }
    for (;;)
    {
      localView = this.this$0.getChildAt(i - j);
      m = localView.getTop() + this.dy;
      j = m;
      if (i == 0)
      {
        j = m;
        if (m > k) {
          j = k;
        }
      }
      DragSortListView.access$402(this.this$0, true);
      this.this$0.setSelectionFromTop(i, j - k);
      this.this$0.layoutChildren();
      this.this$0.invalidate();
      DragSortListView.access$402(this.this$0, false);
      this.this$0.doDragFloatView(i, localView, false);
      this.mPrevTime = this.mCurrTime;
      this.this$0.post(this);
      return;
      localView = this.this$0.getChildAt(i - j);
      if (localView == null)
      {
        this.mScrolling = false;
        return;
      }
      if ((i == m - 1) && (localView.getBottom() <= n + k))
      {
        this.mScrolling = false;
        return;
      }
      this.mScrollSpeed = (-this.this$0.mScrollProfile.getSpeed((i1 - this.this$0.mDownScrollStartYF) / this.this$0.mDragDownScrollHeight, this.mPrevTime));
      break;
      label470:
      this.dy = Math.max(-n, this.dy);
    }
  }
  
  public void startScrolling(int paramInt)
  {
    if (!this.mScrolling)
    {
      this.mAbort = false;
      this.mScrolling = true;
      this.tStart = SystemClock.uptimeMillis();
      this.mPrevTime = this.tStart;
      this.scrollDir = paramInt;
      this.this$0.post(this);
    }
  }
  
  public void stopScrolling(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.this$0.removeCallbacks(this);
      this.mScrolling = false;
      return;
    }
    this.mAbort = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.DragSortListView.DragScroller
 * JD-Core Version:    0.7.0.1
 */