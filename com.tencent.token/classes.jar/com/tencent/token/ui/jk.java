package com.tencent.token.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class jk
  implements Animation.AnimationListener
{
  jk(ji paramji, FaceStartVryCameraActivity paramFaceStartVryCameraActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    FaceStartVryCameraActivity.access$2100(this.b.a).setVisibility(4);
    FaceStartVryCameraActivity.access$3300(this.b.a).setVisibility(4);
    IndexActivity.need_query_dual_msg = true;
    this.b.a.finish();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.jk
 * JD-Core Version:    0.7.0.1
 */