package com.tencent.token.ui;

import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class yh
  implements Animation.AnimationListener
{
  yh(RealNameTakeIDPhotoActivity paramRealNameTakeIDPhotoActivity) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    RealNameTakeIDPhotoActivity.access$300(this.a).sendEmptyMessage(4);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.yh
 * JD-Core Version:    0.7.0.1
 */