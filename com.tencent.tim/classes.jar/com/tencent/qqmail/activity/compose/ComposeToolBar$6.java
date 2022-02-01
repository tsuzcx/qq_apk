package com.tencent.qqmail.activity.compose;

import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;

class ComposeToolBar$6
  implements ValueAnimator.AnimatorUpdateListener
{
  ComposeToolBar$6(ComposeToolBar paramComposeToolBar) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    ComposeToolBar.access$1200(this.this$0, f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeToolBar.6
 * JD-Core Version:    0.7.0.1
 */