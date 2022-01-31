package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.global.h;

class ie
  implements View.OnClickListener
{
  ie(FaceRegCameraActivity paramFaceRegCameraActivity) {}
  
  public void onClick(View paramView)
  {
    h.c("onBackPressed");
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ie
 * JD-Core Version:    0.7.0.1
 */