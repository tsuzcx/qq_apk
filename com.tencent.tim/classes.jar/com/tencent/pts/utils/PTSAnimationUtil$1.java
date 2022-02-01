package com.tencent.pts.utils;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;

final class PTSAnimationUtil$1
  implements ValueAnimator.AnimatorUpdateListener
{
  PTSAnimationUtil$1(FrameLayout.LayoutParams paramLayoutParams, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.val$lp.height = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.val$view.setLayoutParams(this.val$lp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pts.utils.PTSAnimationUtil.1
 * JD-Core Version:    0.7.0.1
 */