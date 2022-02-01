package com.tencent.qqmail.utilities.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.qqmail.view.QMRefreshingView;

class PtrListView$2
  implements ValueAnimator.AnimatorUpdateListener
{
  PtrListView$2(PtrListView paramPtrListView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    PtrListView.access$300(this.this$0).height = i;
    PtrListView.access$100(this.this$0).setLayoutParams(PtrListView.access$300(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.PtrListView.2
 * JD-Core Version:    0.7.0.1
 */