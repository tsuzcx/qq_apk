package com.tencent.token.ui;

import android.view.View;
import android.view.animation.AlphaAnimation;

final class ki
  implements Runnable
{
  private View b;
  
  public ki(FaceStartVryCameraActivity paramFaceStartVryCameraActivity, View paramView)
  {
    this.b = paramView;
    FaceStartVryCameraActivity.access$3302(paramFaceStartVryCameraActivity, new AlphaAnimation(1.0F, 0.0F));
    FaceStartVryCameraActivity.access$3300(paramFaceStartVryCameraActivity).setDuration(500L);
    FaceStartVryCameraActivity.access$3300(paramFaceStartVryCameraActivity).setAnimationListener(new kj(this, paramFaceStartVryCameraActivity));
  }
  
  public final void run()
  {
    this.b.startAnimation(FaceStartVryCameraActivity.access$3300(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ki
 * JD-Core Version:    0.7.0.1
 */