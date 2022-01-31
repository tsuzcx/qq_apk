package com.tencent.token.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

final class da
  implements Animation.AnimationListener
{
  da(cz paramcz) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    DetectIDPhotoActivity.access$1500(this.a.a).setVisibility(0);
    DetectIDPhotoActivity.access$1600(this.a.a).setVisibility(0);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.da
 * JD-Core Version:    0.7.0.1
 */