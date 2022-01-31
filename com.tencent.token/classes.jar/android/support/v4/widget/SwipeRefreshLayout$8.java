package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class SwipeRefreshLayout$8
  extends Animation
{
  SwipeRefreshLayout$8(SwipeRefreshLayout paramSwipeRefreshLayout) {}
  
  public void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    float f1 = this.this$0.mStartingScale;
    float f2 = -this.this$0.mStartingScale;
    this.this$0.setAnimationProgress(f1 + f2 * paramFloat);
    this.this$0.moveToStart(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.widget.SwipeRefreshLayout.8
 * JD-Core Version:    0.7.0.1
 */