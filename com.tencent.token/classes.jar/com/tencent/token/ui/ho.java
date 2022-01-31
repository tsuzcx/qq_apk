package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class ho
  implements View.OnClickListener
{
  ho(FaceRecognitionDefaultActivity paramFaceRecognitionDefaultActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, FaceRecognitionCameraActivity.class);
    paramView.putExtra("flag", 2);
    paramView.putExtra("istry", 1);
    paramView.putExtra("scene", 6);
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ho
 * JD-Core Version:    0.7.0.1
 */