package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class at
  implements View.OnClickListener
{
  at(AddFaceResultActivity paramAddFaceResultActivity) {}
  
  public void onClick(View paramView)
  {
    if (AddFaceResultActivity.access$200(this.a))
    {
      paramView = new Intent(this.a, FaceRecognitionDefaultActivity.class);
      paramView.addFlags(67108864);
      this.a.startActivity(paramView);
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.at
 * JD-Core Version:    0.7.0.1
 */