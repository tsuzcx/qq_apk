package com.tencent.mobileqq.ocr;

import acfp;
import akmw;
import akoy;
import com.tencent.mobileqq.widget.QQToast;

public class OCRResultFragmentNew$7$3
  implements Runnable
{
  public OCRResultFragmentNew$7$3(akmw paramakmw) {}
  
  public void run()
  {
    OCRResultFragmentNew.a(this.a.a, false);
    OCRResultFragmentNew.a(this.a.a).dismiss();
    OCRResultFragmentNew.a(this.a.a).setProgress(0);
    QQToast.a(OCRResultFragmentNew.a(this.a.a), 1, acfp.m(2131709346), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultFragmentNew.7.3
 * JD-Core Version:    0.7.0.1
 */