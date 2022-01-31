package com.tencent.token.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.token.ai;
import com.tencent.token.global.RqdApplication;

final class hs
  implements Animation.AnimationListener
{
  hs(hr paramhr, FaceRecognitionCameraActivityOld paramFaceRecognitionCameraActivityOld) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    hr.a(this.b).setVisibility(4);
    hr.b(this.b).startAnimation(FaceRecognitionCameraActivityOld.access$3100(this.b.a));
    ai.a(RqdApplication.i()).a();
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.hs
 * JD-Core Version:    0.7.0.1
 */