package com.tencent.token.ui;

import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class cy
  implements Animation.AnimationListener
{
  cy(DetectIDPhotoActivity paramDetectIDPhotoActivity) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    DetectIDPhotoActivity.access$000(this.a).sendEmptyMessage(4);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.cy
 * JD-Core Version:    0.7.0.1
 */