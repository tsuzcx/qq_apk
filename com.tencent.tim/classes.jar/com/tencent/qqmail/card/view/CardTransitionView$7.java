package com.tencent.qqmail.card.view;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class CardTransitionView$7
  implements Animation.AnimationListener
{
  CardTransitionView$7(CardTransitionView paramCardTransitionView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (CardTransitionView.access$1000(this.this$0) != null)
    {
      CardTransitionView.access$1000(this.this$0).onTransitionComplete(true);
      CardTransitionView.access$1000(this.this$0).onViewRemoved(CardTransitionView.access$1400(this.this$0));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.view.CardTransitionView.7
 * JD-Core Version:    0.7.0.1
 */