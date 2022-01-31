package com.tencent.token.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class ht
  implements Animation.AnimationListener
{
  ht(hr paramhr, FaceRecognitionCameraActivityOld paramFaceRecognitionCameraActivityOld) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    FaceRecognitionCameraActivityOld.access$2300(this.b.a).setVisibility(4);
    FaceRecognitionCameraActivityOld.access$3400(this.b.a).setVisibility(4);
    this.b.a.finish();
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ht
 * JD-Core Version:    0.7.0.1
 */