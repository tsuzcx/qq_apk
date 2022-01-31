package com.tencent.token.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class km
  implements Animation.AnimationListener
{
  km(kk paramkk, FaceStartVryCameraActivity paramFaceStartVryCameraActivity) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    FaceStartVryCameraActivity.access$2100(this.b.a).setVisibility(4);
    FaceStartVryCameraActivity.access$3200(this.b.a).setVisibility(4);
    this.b.a.finish();
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.km
 * JD-Core Version:    0.7.0.1
 */