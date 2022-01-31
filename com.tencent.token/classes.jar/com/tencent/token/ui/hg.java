package com.tencent.token.ui;

import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class hg
  implements CompoundButton.OnCheckedChangeListener
{
  hg(FaceRecognitionCreateActivity paramFaceRecognitionCreateActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      FaceRecognitionCreateActivity.access$000(this.a).setTextAppearance(this.a, 2131362228);
      FaceRecognitionCreateActivity.access$000(this.a).setBackgroundResource(2130837632);
      FaceRecognitionCreateActivity.access$000(this.a).setEnabled(true);
      return;
    }
    FaceRecognitionCreateActivity.access$000(this.a).setTextAppearance(this.a, 2131362186);
    FaceRecognitionCreateActivity.access$000(this.a).setBackgroundResource(2130837728);
    FaceRecognitionCreateActivity.access$000(this.a).setEnabled(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.hg
 * JD-Core Version:    0.7.0.1
 */