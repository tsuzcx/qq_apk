package com.tencent.mobileqq.ocr;

import acfp;
import akmb;
import akoy;
import com.tencent.mobileqq.widget.QQToast;

public class OCRResultActivity$10$3
  implements Runnable
{
  public OCRResultActivity$10$3(akmb paramakmb) {}
  
  public void run()
  {
    OCRResultActivity.a(this.a.a).dismiss();
    OCRResultActivity.a(this.a.a).setProgress(0);
    OCRResultActivity.d(this.a.a, false);
    QQToast.a(this.a.a, 1, acfp.m(2131709346), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultActivity.10.3
 * JD-Core Version:    0.7.0.1
 */