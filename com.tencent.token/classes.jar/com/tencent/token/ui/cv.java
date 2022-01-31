package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class cv
  implements View.OnClickListener
{
  cv(CopyFaceToOtherUinActivity paramCopyFaceToOtherUinActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, FaceRecognitionDefaultActivity.class);
    paramView.addFlags(67108864);
    this.a.startActivity(paramView);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.cv
 * JD-Core Version:    0.7.0.1
 */