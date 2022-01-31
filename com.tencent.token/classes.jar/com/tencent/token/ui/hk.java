package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class hk
  implements View.OnClickListener
{
  hk(FaceRecognitionDefaultActivity paramFaceRecognitionDefaultActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, FacePwdIndexActivity.class);
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.hk
 * JD-Core Version:    0.7.0.1
 */