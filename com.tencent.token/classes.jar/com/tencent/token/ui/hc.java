package com.tencent.token.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class hc
  implements Animation.AnimationListener
{
  hc(FaceRecognitionCameraActivityOld paramFaceRecognitionCameraActivityOld) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    FaceRecognitionCameraActivityOld.access$2900(this.a).setVisibility(8);
    FaceRecognitionCameraActivityOld.access$2500(this.a).setVisibility(8);
    FaceRecognitionCameraActivityOld.access$1000(this.a).b(FaceRecognitionCameraActivityOld.access$400(this.a));
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    FaceRecognitionCameraActivityOld.access$1000(this.a).d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.hc
 * JD-Core Version:    0.7.0.1
 */