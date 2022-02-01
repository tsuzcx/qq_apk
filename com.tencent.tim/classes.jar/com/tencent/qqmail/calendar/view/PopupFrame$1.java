package com.tencent.qqmail.calendar.view;

import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class PopupFrame$1
  implements Animation.AnimationListener
{
  PopupFrame$1(PopupFrame paramPopupFrame) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    PopupFrame.access$000(this.this$0).removeView(this.this$0);
    this.this$0.setVisibility(8);
    PopupFrame.access$102(this.this$0, true);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.view.PopupFrame.1
 * JD-Core Version:    0.7.0.1
 */