package com.tencent.token.ui;

import android.widget.TextView;
import com.tencent.token.global.h;

class hr
  implements pr
{
  hr(FaceRecognitionDefaultActivity paramFaceRecognitionDefaultActivity) {}
  
  public void a(int paramInt)
  {
    boolean bool2 = false;
    FaceRecognitionDefaultActivity localFaceRecognitionDefaultActivity = this.a;
    boolean bool1;
    if ((paramInt == 1) || (paramInt == 3))
    {
      bool1 = true;
      FaceRecognitionDefaultActivity.access$002(localFaceRecognitionDefaultActivity, bool1);
      localFaceRecognitionDefaultActivity = this.a;
      if (paramInt != 2)
      {
        bool1 = bool2;
        if (paramInt != 3) {}
      }
      else
      {
        bool1 = true;
      }
      FaceRecognitionDefaultActivity.access$102(localFaceRecognitionDefaultActivity, bool1);
      h.a("psw_open_switch" + FaceRecognitionDefaultActivity.access$000(this.a));
      if (!FaceRecognitionDefaultActivity.access$000(this.a)) {
        break label164;
      }
      FaceRecognitionDefaultActivity.access$300(this.a).setText(2131231443);
      FaceRecognitionDefaultActivity.access$300(this.a).setTextAppearance(this.a, 2131362196);
    }
    for (;;)
    {
      if (!FaceRecognitionDefaultActivity.access$100(this.a)) {
        break label195;
      }
      FaceRecognitionDefaultActivity.access$400(this.a).setText(2131231443);
      FaceRecognitionDefaultActivity.access$400(this.a).setTextAppearance(this.a, 2131362196);
      return;
      bool1 = false;
      break;
      label164:
      FaceRecognitionDefaultActivity.access$300(this.a).setText(2131231442);
      FaceRecognitionDefaultActivity.access$300(this.a).setTextAppearance(this.a, 2131362197);
    }
    label195:
    FaceRecognitionDefaultActivity.access$400(this.a).setText(2131231442);
    FaceRecognitionDefaultActivity.access$400(this.a).setTextAppearance(this.a, 2131362197);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.hr
 * JD-Core Version:    0.7.0.1
 */