package com.tencent.mobileqq.activity.contacts.pullrefresh;

import android.widget.Scroller;

public class AutoScroller
  implements Runnable
{
  private a a;
  private CommonRefreshLayout c;
  private int ccC;
  private boolean mAbort;
  private boolean mRunning;
  private Scroller mScroller;
  
  public AutoScroller(CommonRefreshLayout paramCommonRefreshLayout)
  {
    this.c = paramCommonRefreshLayout;
    this.mScroller = new Scroller(paramCommonRefreshLayout.getContext());
  }
  
  private void finish()
  {
    this.ccC = 0;
    this.mRunning = false;
    this.c.removeCallbacks(this);
    if ((!this.mAbort) && (this.a != null)) {
      this.a.cnG();
    }
  }
  
  public void a(a parama)
  {
    this.a = parama;
  }
  
  public void cnF()
  {
    if (this.mRunning)
    {
      if (!this.mScroller.isFinished())
      {
        this.mAbort = true;
        this.mScroller.forceFinished(true);
      }
      finish();
      this.mAbort = false;
    }
  }
  
  public void gb(int paramInt1, int paramInt2)
  {
    this.c.removeCallbacks(this);
    this.ccC = 0;
    if (!this.mScroller.isFinished()) {
      this.mScroller.forceFinished(true);
    }
    this.mScroller.startScroll(0, 0, 0, paramInt1, paramInt2);
    this.c.post(this);
    this.mRunning = true;
  }
  
  public boolean isFinished()
  {
    return this.mScroller.isFinished();
  }
  
  public void run()
  {
    if ((!this.mScroller.computeScrollOffset()) || (this.mScroller.isFinished())) {}
    int j;
    int k;
    for (int i = 1;; i = 0)
    {
      j = this.mScroller.getCurrY();
      k = this.ccC;
      if (i == 0) {
        break;
      }
      finish();
      return;
    }
    this.ccC = j;
    if (this.a != null) {
      this.a.at(j - k);
    }
    this.c.post(this);
  }
  
  public static abstract interface a
  {
    public abstract void at(float paramFloat);
    
    public abstract void cnG();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.pullrefresh.AutoScroller
 * JD-Core Version:    0.7.0.1
 */