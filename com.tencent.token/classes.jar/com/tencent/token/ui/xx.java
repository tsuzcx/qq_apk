package com.tencent.token.ui;

import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class xx
  implements Animation.AnimationListener
{
  xx(RealNameTakeIDPhotoActivity paramRealNameTakeIDPhotoActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    RealNameTakeIDPhotoActivity.access$300(this.a).sendEmptyMessage(4);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.xx
 * JD-Core Version:    0.7.0.1
 */