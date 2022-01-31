package com.tencent.token.ui;

import android.view.View;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;

class ji
  implements Runnable
{
  private View b;
  private View c;
  
  public ji(FaceStartVryCameraActivity paramFaceStartVryCameraActivity, View paramView1, View paramView2)
  {
    this.b = paramView1;
    this.c = paramView2;
    FaceStartVryCameraActivity.access$2902(paramFaceStartVryCameraActivity, new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F));
    FaceStartVryCameraActivity.access$2900(paramFaceStartVryCameraActivity).setDuration(250L);
    FaceStartVryCameraActivity.access$3002(paramFaceStartVryCameraActivity, new TranslateAnimation(0.0F, 0.0F, 0.0F, -FaceStartVryCameraActivity.access$2000(paramFaceStartVryCameraActivity)));
    FaceStartVryCameraActivity.access$3000(paramFaceStartVryCameraActivity).setDuration(500L);
    FaceStartVryCameraActivity.access$2900(paramFaceStartVryCameraActivity).setAnimationListener(new jj(this, paramFaceStartVryCameraActivity));
    FaceStartVryCameraActivity.access$3000(paramFaceStartVryCameraActivity).setAnimationListener(new jk(this, paramFaceStartVryCameraActivity));
  }
  
  public void run()
  {
    this.c.startAnimation(FaceStartVryCameraActivity.access$2900(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ji
 * JD-Core Version:    0.7.0.1
 */