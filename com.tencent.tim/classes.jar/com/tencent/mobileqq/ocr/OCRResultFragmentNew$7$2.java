package com.tencent.mobileqq.ocr;

import acfp;
import akmw;
import akoy;
import com.tencent.mobileqq.widget.QQToast;

public class OCRResultFragmentNew$7$2
  implements Runnable
{
  public OCRResultFragmentNew$7$2(akmw paramakmw, String paramString) {}
  
  public void run()
  {
    try
    {
      OCRResultFragmentNew.a(this.a.a).dismiss();
      OCRResultFragmentNew.a(this.a.a).setProgress(0);
      OCRResultFragmentNew.a(this.a.a, true);
      QQToast.a(OCRResultFragmentNew.a(this.a.a), 2, acfp.m(2131709349), 1).show();
      if ((this.bOb != null) && (this.bOb.length() > 0))
      {
        this.a.a.ND(this.bOb);
        return;
      }
      QQToast.a(OCRResultFragmentNew.a(this.a.a), 1, acfp.m(2131709343), 0).show();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultFragmentNew.7.2
 * JD-Core Version:    0.7.0.1
 */