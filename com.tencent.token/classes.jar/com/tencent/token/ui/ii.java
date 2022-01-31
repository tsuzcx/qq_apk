package com.tencent.token.ui;

import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

final class ii
  implements CompoundButton.OnCheckedChangeListener
{
  ii(FaceRecognitionCreateActivity paramFaceRecognitionCreateActivity) {}
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      FaceRecognitionCreateActivity.access$000(this.a).setTextAppearance(this.a, 2131427381);
      FaceRecognitionCreateActivity.access$000(this.a).setBackgroundResource(2130837549);
      FaceRecognitionCreateActivity.access$000(this.a).setEnabled(true);
      return;
    }
    FaceRecognitionCreateActivity.access$000(this.a).setTextAppearance(this.a, 2131427335);
    FaceRecognitionCreateActivity.access$000(this.a).setBackgroundResource(2130837636);
    FaceRecognitionCreateActivity.access$000(this.a).setEnabled(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ii
 * JD-Core Version:    0.7.0.1
 */