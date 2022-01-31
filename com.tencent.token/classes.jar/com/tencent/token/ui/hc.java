package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.global.h;

class hc
  implements View.OnClickListener
{
  hc(FaceRecognitionComfirmActivity paramFaceRecognitionComfirmActivity) {}
  
  public void onClick(View paramView)
  {
    h.c("onBackPressed");
    this.a.setResult(10);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.hc
 * JD-Core Version:    0.7.0.1
 */