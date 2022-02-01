package com.tencent.mobileqq.ocr;

import akmc;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import anot;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ocr.data.OcrRecogResult;
import com.tencent.mobileqq.widget.QQToast;

public class OCRResultActivity$11$1
  implements Runnable
{
  public OCRResultActivity$11$1(akmc paramakmc, int paramInt, OcrRecogResult paramOcrRecogResult) {}
  
  public void run()
  {
    OCRResultActivity.e(this.a.a, false);
    OCRResultActivity.e(this.a.a);
    OCRResultActivity.f(this.a.a);
    if ((this.val$errCode == 0) && (this.b != null) && (!this.b.isEmpty()))
    {
      OCRResultActivity.a(this.a.a, this.b);
      if (OCRResultActivity.b(this.a.a))
      {
        Animation localAnimation = AnimationUtils.loadAnimation(this.a.a, 2130772009);
        this.a.a.mRootView.startAnimation(localAnimation);
      }
      if ((OCRResultActivity.c(this.a.a) == 0) || (OCRResultActivity.c(this.a.a) == 6)) {
        anot.a(null, "dc00898", "", "", "0X800A9CF", "0X800A9CF", 0, 0, "", "0", "0", "");
      }
    }
    for (;;)
    {
      OCRResultActivity.c(this.a.a, false);
      return;
      QQToast.a(BaseApplicationImpl.getContext(), 1, 2131701455, 0).show();
      if (OCRResultActivity.b(this.a.a)) {
        this.a.a.finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultActivity.11.1
 * JD-Core Version:    0.7.0.1
 */