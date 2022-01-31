package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

final class ir
  implements View.OnClickListener
{
  ir(FaceRecognitionDefaultActivity paramFaceRecognitionDefaultActivity) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.a, FaceRecognitionAddFaceActivity.class);
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ir
 * JD-Core Version:    0.7.0.1
 */