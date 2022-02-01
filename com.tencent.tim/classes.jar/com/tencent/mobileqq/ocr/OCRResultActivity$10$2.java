package com.tencent.mobileqq.ocr;

import acfp;
import akmb;
import akoy;
import com.tencent.mobileqq.widget.QQToast;

public class OCRResultActivity$10$2
  implements Runnable
{
  public OCRResultActivity$10$2(akmb paramakmb, String paramString) {}
  
  public void run()
  {
    try
    {
      OCRResultActivity.a(this.a.a).dismiss();
      OCRResultActivity.a(this.a.a).setProgress(0);
      OCRResultActivity.d(this.a.a, false);
      QQToast.a(this.a.a, 2, acfp.m(2131709349), 1).show();
      if ((this.bOb != null) && (this.bOb.length() > 0))
      {
        this.a.a.ND(this.bOb);
        return;
      }
      QQToast.a(this.a.a, 1, acfp.m(2131709343), 0).show();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultActivity.10.2
 * JD-Core Version:    0.7.0.1
 */