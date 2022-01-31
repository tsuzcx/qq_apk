package com.tencent.token.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

class dr
  implements Animation.AnimationListener
{
  dr(dq paramdq) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    DetectIDPhotoActivity.access$1500(this.a.a).setVisibility(0);
    DetectIDPhotoActivity.access$1600(this.a.a).setVisibility(0);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.dr
 * JD-Core Version:    0.7.0.1
 */