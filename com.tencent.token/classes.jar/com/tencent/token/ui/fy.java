package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.global.e;

final class fy
  implements View.OnClickListener
{
  fy(FaceRecognitionCameraActivity paramFaceRecognitionCameraActivity) {}
  
  public final void onClick(View paramView)
  {
    e.c("onBackPressed");
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.fy
 * JD-Core Version:    0.7.0.1
 */