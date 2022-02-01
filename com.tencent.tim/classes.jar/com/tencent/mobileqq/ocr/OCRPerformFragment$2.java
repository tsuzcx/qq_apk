package com.tencent.mobileqq.ocr;

import aklz;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Message;
import auru;

class OCRPerformFragment$2
  implements Runnable
{
  OCRPerformFragment$2(OCRPerformFragment paramOCRPerformFragment) {}
  
  public void run()
  {
    Bitmap localBitmap = aklz.a(OCRPerformFragment.a(this.this$0), this.this$0.getResources().getDisplayMetrics());
    this.this$0.e.obtainMessage(100, localBitmap).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRPerformFragment.2
 * JD-Core Version:    0.7.0.1
 */