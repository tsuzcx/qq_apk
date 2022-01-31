package com.tencent.token.ui.base;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class ax
  implements Animation.AnimationListener
{
  ax(aw paramaw, GameLoginSndConfirmView paramGameLoginSndConfirmView) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    this.b.a.setVisibility(8);
    if (GameLoginSndConfirmView.a(this.b.a) != null) {
      GameLoginSndConfirmView.a(this.b.a).a();
    }
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.ax
 * JD-Core Version:    0.7.0.1
 */