package com.tencent.mobileqq.ocr;

import ahqt.a;
import ahqy;
import aklz;
import akmq;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

public class OCRResultFragmentNew$10$1
  implements Runnable
{
  public OCRResultFragmentNew$10$1(akmq paramakmq, boolean paramBoolean, ahqy paramahqy) {}
  
  public void run()
  {
    if ((this.val$isSuccess) && (this.c.wZ != null) && (!this.c.wZ.isEmpty()))
    {
      aklz.o(aklz.a(this.c.wZ));
      aklz.b(aklz.d.bLp, this.c.xa, this.c.lf);
      OCRResultFragmentNew.a(this.a.a, 0);
      return;
    }
    QQToast.a(OCRResultFragmentNew.a(this.a.a), 1, 2131701455, 0).show();
    aklz.cN("0X800AD1B", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultFragmentNew.10.1
 * JD-Core Version:    0.7.0.1
 */