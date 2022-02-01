package com.tencent.mobileqq.ocr;

import akmz;
import akmz.a;
import akng;

public class OcrCamera$8
  implements Runnable
{
  public OcrCamera$8(akmz paramakmz, boolean paramBoolean, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    this.this$0.ctb = false;
    this.this$0.ctc = true;
    if (this.this$0.a != null) {
      this.this$0.a.dCj();
    }
    if (this.ctd) {}
    for (String str = akng.a(this.eX, akmz.a(this.this$0), akmz.b(this.this$0), akmz.c(this.this$0), this.this$0.mCameraId, this.this$0.cjn, this.this$0.aF, true);; str = akng.a(this.eX, akmz.d(this.this$0), akmz.e(this.this$0), akmz.c(this.this$0), this.this$0.mCameraId, this.this$0.cjn))
    {
      if (this.this$0.a != null) {
        this.this$0.a.NG(str);
      }
      akmz.a(this.this$0, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrCamera.8
 * JD-Core Version:    0.7.0.1
 */