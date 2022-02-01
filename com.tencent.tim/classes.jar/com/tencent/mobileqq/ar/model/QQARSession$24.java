package com.tencent.mobileqq.ar.model;

import adec;
import adib;
import adku;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;

public class QQARSession$24
  implements Runnable
{
  public QQARSession$24(adku paramadku, int paramInt) {}
  
  public void run()
  {
    if (!adku.a(this.this$0).aei())
    {
      if (adku.a(this.this$0).aeo()) {
        adku.d(this.this$0);
      }
      if (adku.a(this.this$0) != 1L) {
        break label132;
      }
      this.this$0.iN(1L);
      adku.c(this.this$0);
    }
    for (;;)
    {
      this.this$0.cSm();
      if ((adku.b(this.this$0)) && (this.this$0.cHX == 2) && (adku.a(this.this$0) != null))
      {
        adec localadec = new adec(adku.a(this.this$0));
        adku.a(this.this$0).a(3, localadec, this.cIv);
      }
      return;
      label132:
      if (adku.a(this.this$0) == 2L) {
        this.this$0.cSq();
      } else if (adku.a(this.this$0) == 2048L) {
        this.this$0.cSt();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.24
 * JD-Core Version:    0.7.0.1
 */