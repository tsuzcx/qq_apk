package com.tencent.token.ui;

import android.view.View;
import android.view.animation.AlphaAnimation;

final class kg
  implements Runnable
{
  private View b;
  
  public kg(FaceStartVryCameraActivity paramFaceStartVryCameraActivity, View paramView)
  {
    this.b = paramView;
    FaceStartVryCameraActivity.access$3302(paramFaceStartVryCameraActivity, new AlphaAnimation(0.0F, 1.0F));
    FaceStartVryCameraActivity.access$3300(paramFaceStartVryCameraActivity).setDuration(500L);
    FaceStartVryCameraActivity.access$3300(paramFaceStartVryCameraActivity).setAnimationListener(new kh(this, paramFaceStartVryCameraActivity));
  }
  
  public final void run()
  {
    this.b.startAnimation(FaceStartVryCameraActivity.access$3300(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.kg
 * JD-Core Version:    0.7.0.1
 */