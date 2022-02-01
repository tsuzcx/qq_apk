package com.tencent.mobileqq.ocr;

import akmo;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import anot;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class OCRResultActivity$9$1
  implements Runnable
{
  public OCRResultActivity$9$1(akmo paramakmo, boolean paramBoolean, int paramInt, TranslateResult paramTranslateResult) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("OCRResultActivity", 2, String.format("onGetTranslateResult isSuccess:%s, type:%s, result:%s", new Object[] { Boolean.valueOf(this.val$isSuccess), Integer.valueOf(this.val$type), this.c }));
    }
    if ((this.val$type == 2) && (this.c != null) && (!this.c.nK(OCRResultActivity.a(this.a.a)))) {
      return;
    }
    OCRResultActivity.e(this.a.a);
    OCRResultActivity.f(this.a.a);
    OCRResultActivity.b(this.a.a, false);
    OCRResultActivity.b(this.a.a);
    if ((this.val$isSuccess) && (this.c != null) && (this.c.isSuccess()) && (!this.c.isEmpty()))
    {
      OCRResultActivity.a(this.a.a, this.c);
      if (OCRResultActivity.b(this.a.a))
      {
        localObject = AnimationUtils.loadAnimation(this.a.a, 2130772009);
        this.a.a.mRootView.startAnimation((Animation)localObject);
      }
      if (OCRResultActivity.b(this.a.a) == 1) {
        anot.a(null, "dc00898", "", "", "0X8009C81", "0X8009C81", 0, 0, "", "0", "0", "");
      }
      for (;;)
      {
        OCRResultActivity.c(this.a.a, false);
        return;
        anot.a(null, "dc00898", "", "", "0X8009C8A", "0X8009C8A", 0, 0, "", "0", "0", "");
      }
    }
    String str = this.a.a.getResources().getString(2131701476);
    Object localObject = str;
    if (this.c != null)
    {
      if (TextUtils.isEmpty(this.c.errMsg)) {
        break label381;
      }
      localObject = this.c.errMsg;
    }
    for (;;)
    {
      QQToast.a(this.a.a, 1, (CharSequence)localObject, 0).show();
      if (!OCRResultActivity.b(this.a.a)) {
        break;
      }
      this.a.a.finish();
      break;
      label381:
      localObject = str;
      if (this.c.isEmpty()) {
        localObject = this.a.a.getResources().getString(2131701455);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultActivity.9.1
 * JD-Core Version:    0.7.0.1
 */