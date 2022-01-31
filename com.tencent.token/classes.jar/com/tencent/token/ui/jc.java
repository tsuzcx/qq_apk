package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.global.h;

class jc
  implements View.OnClickListener
{
  jc(FaceStartVryCameraActivity paramFaceStartVryCameraActivity) {}
  
  public void onClick(View paramView)
  {
    h.c("onBackPressed");
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.jc
 * JD-Core Version:    0.7.0.1
 */