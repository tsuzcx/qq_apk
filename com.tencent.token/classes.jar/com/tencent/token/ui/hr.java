package com.tencent.token.ui;

import android.view.View;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;

final class hr
  implements Runnable
{
  private View b;
  private View c;
  private View d;
  
  public hr(FaceRecognitionCameraActivityOld paramFaceRecognitionCameraActivityOld, View paramView1, View paramView2)
  {
    this.b = paramView1;
    this.c = null;
    this.d = paramView2;
    FaceRecognitionCameraActivityOld.access$3002(paramFaceRecognitionCameraActivityOld, new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F));
    FaceRecognitionCameraActivityOld.access$3000(paramFaceRecognitionCameraActivityOld).setDuration(250L);
    FaceRecognitionCameraActivityOld.access$3102(paramFaceRecognitionCameraActivityOld, new TranslateAnimation(0.0F, 0.0F, 0.0F, -FaceRecognitionCameraActivityOld.access$2200(paramFaceRecognitionCameraActivityOld)));
    FaceRecognitionCameraActivityOld.access$3100(paramFaceRecognitionCameraActivityOld).setDuration(500L);
    FaceRecognitionCameraActivityOld.access$3000(paramFaceRecognitionCameraActivityOld).setAnimationListener(new hs(this, paramFaceRecognitionCameraActivityOld));
    FaceRecognitionCameraActivityOld.access$3100(paramFaceRecognitionCameraActivityOld).setAnimationListener(new ht(this, paramFaceRecognitionCameraActivityOld));
  }
  
  public final void run()
  {
    this.d.startAnimation(FaceRecognitionCameraActivityOld.access$3000(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.hr
 * JD-Core Version:    0.7.0.1
 */