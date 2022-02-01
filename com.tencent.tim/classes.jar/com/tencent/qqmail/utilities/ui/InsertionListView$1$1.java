package com.tencent.qqmail.utilities.ui;

import android.graphics.Rect;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;

class InsertionListView$1$1
  implements ValueAnimator.AnimatorUpdateListener
{
  private Rect mCurrentBound = new Rect();
  private Rect mLastBound = null;
  
  InsertionListView$1$1(InsertionListView.1 param1) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Rect)paramValueAnimator.getAnimatedValue();
    this.mCurrentBound.set(paramValueAnimator);
    if (this.mLastBound != null) {
      this.mCurrentBound.union(this.mLastBound);
    }
    this.mLastBound = paramValueAnimator;
    this.this$1.this$0.invalidate(this.mCurrentBound);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.InsertionListView.1.1
 * JD-Core Version:    0.7.0.1
 */