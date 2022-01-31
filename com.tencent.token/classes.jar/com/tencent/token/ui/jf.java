package com.tencent.token.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class jf
  implements Animation.AnimationListener
{
  jf(je paramje, FaceStartVryCameraActivity paramFaceStartVryCameraActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    je.a(this.b).setVisibility(0);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    je.a(this.b).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.jf
 * JD-Core Version:    0.7.0.1
 */