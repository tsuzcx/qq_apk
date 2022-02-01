package com.tencent.qqmail.card.view;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class CardTransitionView$5
  implements Animation.AnimationListener
{
  CardTransitionView$5(CardTransitionView paramCardTransitionView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    CardTransitionView.access$800(this.this$0).offsetTopAndBottom(-CardTransitionView.access$1200(this.this$0));
    CardTransitionView.access$1300(this.this$0);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.view.CardTransitionView.5
 * JD-Core Version:    0.7.0.1
 */