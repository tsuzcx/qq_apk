package com.tencent.token.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class kh
  implements Animation.AnimationListener
{
  kh(kg paramkg, FaceStartVryCameraActivity paramFaceStartVryCameraActivity) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    kg.a(this.b).setVisibility(0);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    kg.a(this.b).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.kh
 * JD-Core Version:    0.7.0.1
 */