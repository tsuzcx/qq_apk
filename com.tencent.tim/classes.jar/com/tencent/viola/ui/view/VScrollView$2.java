package com.tencent.viola.ui.view;

import android.view.MotionEvent;
import com.tencent.viola.ui.view.refresh.VRefreshViewGroup.TouchLifeCycle;

class VScrollView$2
  implements VRefreshViewGroup.TouchLifeCycle
{
  VScrollView$2(VScrollView paramVScrollView) {}
  
  public void onTouch(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    float f;
    do
    {
      return;
      VScrollView.access$602(this.this$0, paramMotionEvent.getRawY());
      return;
      VScrollView.access$102(this.this$0, true);
      return;
      VScrollView.access$102(this.this$0, false);
      VScrollView.access$002(this.this$0, this.this$0.getScrollY());
      f = paramMotionEvent.getRawY();
    } while (VScrollView.access$600(this.this$0) - f < VScrollView.access$700(this.this$0));
    this.this$0.removeCallbacks(VScrollView.access$800(this.this$0));
    this.this$0.postDelayed(VScrollView.access$800(this.this$0), 20L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.ui.view.VScrollView.2
 * JD-Core Version:    0.7.0.1
 */