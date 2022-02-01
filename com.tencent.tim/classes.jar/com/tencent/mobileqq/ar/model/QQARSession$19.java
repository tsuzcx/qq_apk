package com.tencent.mobileqq.ar.model;

import adku;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;

public class QQARSession$19
  implements Runnable
{
  public void run()
  {
    if ((adku.a(this.this$0) != null) && (!adku.a(this.this$0).aei()))
    {
      if (adku.a(this.this$0).aeo()) {
        adku.d(this.this$0);
      }
      if (adku.a(this.this$0) != 1L) {
        break label78;
      }
      this.this$0.iN(1L);
      adku.c(this.this$0);
    }
    for (;;)
    {
      this.this$0.cSm();
      return;
      label78:
      if (adku.a(this.this$0) == 2L) {
        this.this$0.cSq();
      } else if (adku.a(this.this$0) == 2048L) {
        this.this$0.cSt();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.19
 * JD-Core Version:    0.7.0.1
 */