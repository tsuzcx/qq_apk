package com.tencent.token.ui.base;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class av
  implements Animation.AnimationListener
{
  av(au paramau, GameLoginSndConfirmView paramGameLoginSndConfirmView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.b.a.setVisibility(8);
    if (GameLoginSndConfirmView.a(this.b.a) != null) {
      GameLoginSndConfirmView.a(this.b.a).a();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.av
 * JD-Core Version:    0.7.0.1
 */