package com.tencent.token.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;

final class dh
  implements Animation.AnimationListener
{
  dh(EmbedWebBaseActivity paramEmbedWebBaseActivity) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    if (EmbedWebBaseActivity.access$200(this.a) != null)
    {
      EmbedWebBaseActivity.access$300(this.a).removeView(EmbedWebBaseActivity.access$200(this.a));
      EmbedWebBaseActivity.access$202(this.a, null);
    }
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.dh
 * JD-Core Version:    0.7.0.1
 */