package com.tencent.qqmail.card.view;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class CardTransitionView$6
  implements Animation.AnimationListener
{
  CardTransitionView$6(CardTransitionView paramCardTransitionView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (CardTransitionView.access$1000(this.this$0) != null) {
      CardTransitionView.access$1000(this.this$0).onTransitionComplete(false);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.view.CardTransitionView.6
 * JD-Core Version:    0.7.0.1
 */