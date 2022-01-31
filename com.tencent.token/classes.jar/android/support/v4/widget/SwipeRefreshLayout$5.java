package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class SwipeRefreshLayout$5
  implements Animation.AnimationListener
{
  SwipeRefreshLayout$5(SwipeRefreshLayout paramSwipeRefreshLayout) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (!this.this$0.mScale) {
      this.this$0.startScaleDownAnimation(null);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.widget.SwipeRefreshLayout.5
 * JD-Core Version:    0.7.0.1
 */