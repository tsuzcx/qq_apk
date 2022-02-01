package com.tencent.mobileqq.ocr;

import adhu;
import adhv;
import akne;
import akne.a;

public class OcrControl$3
  implements Runnable
{
  public OcrControl$3(akne paramakne, String paramString, adhu paramadhu) {}
  
  public void run()
  {
    adhv localadhv = akne.a(this.this$0, this.val$sessionId);
    if ((localadhv != null) && (akne.a(this.this$0) != null))
    {
      long l1 = System.currentTimeMillis();
      long l2 = localadhv.Tb;
      akne.a(this.this$0).a(4, null, this.b.bsZ, l1 - l2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrControl.3
 * JD-Core Version:    0.7.0.1
 */