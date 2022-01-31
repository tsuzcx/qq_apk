package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.utils.i;

class hd
  implements View.OnClickListener
{
  hd(FaceRecognitionComfirmActivity paramFaceRecognitionComfirmActivity) {}
  
  public void onClick(View paramView)
  {
    i.b(FaceRecognitionComfirmActivity.access$200(this.a));
    this.a.setResult(10);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.hd
 * JD-Core Version:    0.7.0.1
 */