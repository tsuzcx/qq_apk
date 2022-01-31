package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class hj
  implements View.OnClickListener
{
  hj(FaceRecognitionCreateActivity paramFaceRecognitionCreateActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, FaceRegCameraActivity.class);
    paramView.putExtra("scene", 1);
    paramView.putExtra("flag", 1);
    this.a.startActivity(paramView);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.hj
 * JD-Core Version:    0.7.0.1
 */