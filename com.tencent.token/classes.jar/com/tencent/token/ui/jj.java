package com.tencent.token.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.token.cz;
import com.tencent.token.global.RqdApplication;

class jj
  implements Animation.AnimationListener
{
  jj(ji paramji, FaceStartVryCameraActivity paramFaceStartVryCameraActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    ji.a(this.b).setVisibility(4);
    ji.b(this.b).startAnimation(FaceStartVryCameraActivity.access$3000(this.b.a));
    cz.a(RqdApplication.l()).a();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.jj
 * JD-Core Version:    0.7.0.1
 */