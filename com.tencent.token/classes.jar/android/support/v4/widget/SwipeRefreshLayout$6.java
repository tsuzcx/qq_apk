package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class SwipeRefreshLayout$6
  extends Animation
{
  SwipeRefreshLayout$6(SwipeRefreshLayout paramSwipeRefreshLayout) {}
  
  public void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    if (!this.this$0.mUsingCustomStart) {}
    for (int i = this.this$0.mSpinnerOffsetEnd - Math.abs(this.this$0.mOriginalOffsetTop);; i = this.this$0.mSpinnerOffsetEnd)
    {
      int j = this.this$0.mFrom;
      i = (int)((i - this.this$0.mFrom) * paramFloat);
      int k = this.this$0.mCircleView.getTop();
      this.this$0.setTargetOffsetTopAndBottom(i + j - k);
      this.this$0.mProgress.setArrowScale(1.0F - paramFloat);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.widget.SwipeRefreshLayout.6
 * JD-Core Version:    0.7.0.1
 */