package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class hl
  implements View.OnClickListener
{
  hl(FaceRecognitionDefaultActivity paramFaceRecognitionDefaultActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, FaceChangePwdIndexActivity.class);
    paramView.putExtra("open_switch", FaceRecognitionDefaultActivity.access$000(this.a));
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.hl
 * JD-Core Version:    0.7.0.1
 */