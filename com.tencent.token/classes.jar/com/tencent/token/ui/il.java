package com.tencent.token.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

final class il
  implements CompoundButton.OnCheckedChangeListener
{
  il(FaceRecognitionCreateActivity paramFaceRecognitionCreateActivity) {}
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean) {
      FaceRecognitionCreateActivity.saveFlag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.il
 * JD-Core Version:    0.7.0.1
 */