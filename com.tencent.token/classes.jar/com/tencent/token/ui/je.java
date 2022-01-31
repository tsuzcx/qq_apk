package com.tencent.token.ui;

import android.view.View;
import android.view.animation.AlphaAnimation;

class je
  implements Runnable
{
  private View b;
  
  public je(FaceStartVryCameraActivity paramFaceStartVryCameraActivity, View paramView)
  {
    this.b = paramView;
    FaceStartVryCameraActivity.access$3402(paramFaceStartVryCameraActivity, new AlphaAnimation(0.0F, 1.0F));
    FaceStartVryCameraActivity.access$3400(paramFaceStartVryCameraActivity).setDuration(500L);
    FaceStartVryCameraActivity.access$3400(paramFaceStartVryCameraActivity).setAnimationListener(new jf(this, paramFaceStartVryCameraActivity));
  }
  
  public void run()
  {
    this.b.startAnimation(FaceStartVryCameraActivity.access$3400(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.je
 * JD-Core Version:    0.7.0.1
 */