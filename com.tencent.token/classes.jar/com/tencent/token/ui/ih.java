package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.utils.i;

class ih
  implements View.OnClickListener
{
  ih(FaceRegConfirmActivity paramFaceRegConfirmActivity) {}
  
  public void onClick(View paramView)
  {
    i.b(FaceRegConfirmActivity.access$000(this.a));
    i.b(FaceRegConfirmActivity.access$100(this.a));
    this.a.setResult(10);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ih
 * JD-Core Version:    0.7.0.1
 */