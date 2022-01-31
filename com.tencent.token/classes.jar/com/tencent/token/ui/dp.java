package com.tencent.token.ui;

import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class dp
  implements Animation.AnimationListener
{
  dp(DetectIDPhotoActivity paramDetectIDPhotoActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    DetectIDPhotoActivity.access$000(this.a).sendEmptyMessage(4);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.dp
 * JD-Core Version:    0.7.0.1
 */