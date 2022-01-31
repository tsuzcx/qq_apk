package com.tencent.token.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class iu
  implements Animation.AnimationListener
{
  iu(FaceStartVryCameraActivity paramFaceStartVryCameraActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    FaceStartVryCameraActivity.access$2700(this.a).setVisibility(8);
    FaceStartVryCameraActivity.access$2300(this.a).setVisibility(8);
    FaceStartVryCameraActivity.access$300(this.a).a(true, false, 0, 0);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    FaceStartVryCameraActivity.access$300(this.a).setStop(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.iu
 * JD-Core Version:    0.7.0.1
 */