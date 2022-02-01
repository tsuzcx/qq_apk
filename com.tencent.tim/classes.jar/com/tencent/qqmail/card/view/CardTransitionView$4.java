package com.tencent.qqmail.card.view;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout.LayoutParams;

class CardTransitionView$4
  implements Animation.AnimationListener
{
  CardTransitionView$4(CardTransitionView paramCardTransitionView, View paramView, float paramFloat, int paramInt1, int paramInt2) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    float f1 = this.val$c.getWidth();
    f1 = this.val$scale * f1;
    float f2 = this.val$c.getHeight();
    f2 = this.val$scale * f2;
    int i = (int)(this.val$centerX - f1 / 2.0F);
    int j = (int)(this.val$centerY - f2 / 2.0F);
    paramAnimation = (FrameLayout.LayoutParams)this.val$c.getLayoutParams();
    paramAnimation.width = ((int)f1);
    paramAnimation.height = ((int)f2);
    paramAnimation.leftMargin = i;
    paramAnimation.topMargin = j;
    this.val$c.clearAnimation();
    this.val$c.setLayoutParams(paramAnimation);
    CardTransitionView.access$702(this.this$0, true);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.view.CardTransitionView.4
 * JD-Core Version:    0.7.0.1
 */