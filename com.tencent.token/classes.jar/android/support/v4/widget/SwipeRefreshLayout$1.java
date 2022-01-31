package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class SwipeRefreshLayout$1
  implements Animation.AnimationListener
{
  SwipeRefreshLayout$1(SwipeRefreshLayout paramSwipeRefreshLayout) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.this$0.mRefreshing)
    {
      this.this$0.mProgress.setAlpha(255);
      this.this$0.mProgress.start();
      if ((this.this$0.mNotify) && (this.this$0.mListener != null)) {
        this.this$0.mListener.onRefresh();
      }
      this.this$0.mCurrentTargetOffsetTop = this.this$0.mCircleView.getTop();
      return;
    }
    this.this$0.reset();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.widget.SwipeRefreshLayout.1
 * JD-Core Version:    0.7.0.1
 */