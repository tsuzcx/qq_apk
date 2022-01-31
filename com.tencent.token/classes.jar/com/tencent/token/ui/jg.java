package com.tencent.token.ui;

import android.view.View;
import android.view.animation.AlphaAnimation;

class jg
  implements Runnable
{
  private View b;
  
  public jg(FaceStartVryCameraActivity paramFaceStartVryCameraActivity, View paramView)
  {
    this.b = paramView;
    FaceStartVryCameraActivity.access$3402(paramFaceStartVryCameraActivity, new AlphaAnimation(1.0F, 0.0F));
    FaceStartVryCameraActivity.access$3400(paramFaceStartVryCameraActivity).setDuration(500L);
    FaceStartVryCameraActivity.access$3400(paramFaceStartVryCameraActivity).setAnimationListener(new jh(this, paramFaceStartVryCameraActivity));
  }
  
  public void run()
  {
    this.b.startAnimation(FaceStartVryCameraActivity.access$3400(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.jg
 * JD-Core Version:    0.7.0.1
 */