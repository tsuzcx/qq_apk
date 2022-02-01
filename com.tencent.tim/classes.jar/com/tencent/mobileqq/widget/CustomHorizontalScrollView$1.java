package com.tencent.mobileqq.widget;

import android.os.Handler;

class CustomHorizontalScrollView$1
  implements Runnable
{
  CustomHorizontalScrollView$1(CustomHorizontalScrollView paramCustomHorizontalScrollView) {}
  
  public void run()
  {
    int i = this.this$0.getScrollX();
    if (i == this.this$0.mScrollX)
    {
      int j = i % (this.this$0.mItemWidth + this.this$0.mHorizontalSpacing);
      if (this.this$0.mScreenWidth + i >= this.this$0.efx) {
        return;
      }
      if (j < this.this$0.mItemWidth / 2) {
        this.this$0.smoothScrollBy(-j, 0);
      }
      for (;;)
      {
        this.this$0.mScrollX = i;
        return;
        if (j >= this.this$0.mItemWidth / 2)
        {
          int k = this.this$0.mItemWidth;
          int m = this.this$0.mHorizontalSpacing;
          this.this$0.smoothScrollBy(k + m - j, 0);
        }
      }
    }
    this.this$0.mScrollX = i;
    this.this$0.mHandler.postDelayed(this.this$0.mRunnable, 5L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CustomHorizontalScrollView.1
 * JD-Core Version:    0.7.0.1
 */