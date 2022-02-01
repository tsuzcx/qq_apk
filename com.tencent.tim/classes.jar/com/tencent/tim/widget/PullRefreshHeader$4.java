package com.tencent.tim.widget;

import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import com.tencent.widget.ListView;

class PullRefreshHeader$4
  implements Runnable
{
  PullRefreshHeader$4(PullRefreshHeader paramPullRefreshHeader) {}
  
  public void run()
  {
    if ((PullRefreshHeader.b(this.this$0)) || (PullRefreshHeader.c(this.this$0))) {}
    int i;
    do
    {
      do
      {
        return;
        if (PullRefreshHeader.a(this.this$0) == null) {
          PullRefreshHeader.a(this.this$0);
        }
      } while (PullRefreshHeader.a(this.this$0) == null);
      i = -PullRefreshHeader.a(this.this$0).getScrollY();
    } while (i <= 0);
    if (PullRefreshHeader.a(this.this$0) != null)
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)PullRefreshHeader.a(this.this$0).getLayoutParams();
      if (localMarginLayoutParams.topMargin < PullRefreshHeader.b(this.this$0)) {
        i = localMarginLayoutParams.topMargin;
      }
    }
    for (;;)
    {
      PullRefreshHeader.a(this.this$0, i);
      this.this$0.postDelayed(this, 20L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.widget.PullRefreshHeader.4
 * JD-Core Version:    0.7.0.1
 */