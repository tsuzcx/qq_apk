package com.tencent.token.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.token.ai;
import com.tencent.token.global.RqdApplication;

final class kl
  implements Animation.AnimationListener
{
  kl(kk paramkk, FaceStartVryCameraActivity paramFaceStartVryCameraActivity) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    kk.a(this.b).setVisibility(4);
    kk.b(this.b).startAnimation(FaceStartVryCameraActivity.access$2900(this.b.a));
    ai.a(RqdApplication.i()).a();
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.kl
 * JD-Core Version:    0.7.0.1
 */