package com.tencent.mobileqq.ar.view;

import adkt;
import ahbj;
import android.app.Activity;
import anot;
import com.tencent.mobileqq.ocr.OCRPerformFragment;

class OCRScanEntryView$1
  implements Runnable
{
  OCRScanEntryView$1(OCRScanEntryView paramOCRScanEntryView) {}
  
  public void run()
  {
    String str = adkt.a().sF();
    if (ahbj.isFileExists(str))
    {
      OCRPerformFragment.b((Activity)this.this$0.mContext, str, 0, -1008, null);
      anot.a(null, "dc00898", "", "", "0X800AE06", "0X800AE06", 1, 0, "", "0", "0", "");
    }
    OCRScanEntryView.a(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.OCRScanEntryView.1
 * JD-Core Version:    0.7.0.1
 */