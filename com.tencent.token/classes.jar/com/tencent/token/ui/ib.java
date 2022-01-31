package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.global.e;

final class ib
  implements View.OnClickListener
{
  ib(FaceRecognitionComfirmActivity paramFaceRecognitionComfirmActivity) {}
  
  public final void onClick(View paramView)
  {
    e.c("onBackPressed");
    this.a.setResult(10);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ib
 * JD-Core Version:    0.7.0.1
 */