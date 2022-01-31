package com.tencent.token.ui;

import android.view.View;
import android.view.animation.AlphaAnimation;

final class hp
  implements Runnable
{
  private View b;
  
  public hp(FaceRecognitionCameraActivityOld paramFaceRecognitionCameraActivityOld, View paramView)
  {
    this.b = paramView;
    FaceRecognitionCameraActivityOld.access$3502(paramFaceRecognitionCameraActivityOld, new AlphaAnimation(1.0F, 0.0F));
    FaceRecognitionCameraActivityOld.access$3500(paramFaceRecognitionCameraActivityOld).setDuration(500L);
    FaceRecognitionCameraActivityOld.access$3500(paramFaceRecognitionCameraActivityOld).setAnimationListener(new hq(this, paramFaceRecognitionCameraActivityOld));
  }
  
  public final void run()
  {
    this.b.startAnimation(FaceRecognitionCameraActivityOld.access$3500(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.hp
 * JD-Core Version:    0.7.0.1
 */