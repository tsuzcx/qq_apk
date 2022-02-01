package com.tencent.qqmail.animation;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;

final class PopularizeCancelAnimator$2
  implements Animation.AnimationListener
{
  PopularizeCancelAnimator$2(int[] paramArrayOfInt, Runnable paramRunnable, LinearLayout paramLinearLayout) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = this.val$removedViewCount;
    int i = paramAnimation[0] - 1;
    paramAnimation[0] = i;
    if (i == 0)
    {
      if (this.val$animationEnd != null) {
        this.val$animationEnd.run();
      }
      this.val$layout.setEnabled(true);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.animation.PopularizeCancelAnimator.2
 * JD-Core Version:    0.7.0.1
 */