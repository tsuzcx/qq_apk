package com.tencent.token.ui;

import android.widget.TextView;
import com.tencent.token.global.e;

final class iu
  implements qe
{
  iu(FaceRecognitionDefaultActivity paramFaceRecognitionDefaultActivity) {}
  
  public final void a(boolean paramBoolean)
  {
    FaceRecognitionDefaultActivity.access$002(this.a, paramBoolean);
    e.a("open_switch" + FaceRecognitionDefaultActivity.access$000(this.a));
    if (paramBoolean)
    {
      FaceRecognitionDefaultActivity.access$200(this.a).setText(2131362380);
      FaceRecognitionDefaultActivity.access$200(this.a).setTextAppearance(this.a, 2131427368);
      return;
    }
    FaceRecognitionDefaultActivity.access$200(this.a).setText(2131362381);
    FaceRecognitionDefaultActivity.access$200(this.a).setTextAppearance(this.a, 2131427367);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.iu
 * JD-Core Version:    0.7.0.1
 */