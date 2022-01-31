package com.tencent.token.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class kf
  implements Animation.AnimationListener
{
  kf(FaceStartVryCameraActivity paramFaceStartVryCameraActivity) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    FaceStartVryCameraActivity.access$2700(this.a).setVisibility(8);
    FaceStartVryCameraActivity.access$2300(this.a).setVisibility(8);
    FaceStartVryCameraActivity.access$700(this.a).a(true, false, 0, 0);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    FaceStartVryCameraActivity.access$700(this.a).a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.kf
 * JD-Core Version:    0.7.0.1
 */