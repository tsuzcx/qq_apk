package com.tencent.mobileqq.ar.model;

import adec;
import adib;
import adku;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.qphone.base.util.QLog;

public class QQARSession$22
  implements Runnable
{
  public QQARSession$22(adku paramadku, int paramInt) {}
  
  public void run()
  {
    if (adku.a(this.this$0) == null) {
      QLog.d("AREngine_QQARSession", 1, "onARAnimationComplete mCurARResourceInfo is null!");
    }
    for (;;)
    {
      return;
      if (this.cIv == 0)
      {
        if (adku.a(this.this$0).aei()) {
          break label289;
        }
        if ((!adku.a(this.this$0).aem()) && (!adku.a(this.this$0).ael()) && (!adku.a(this.this$0).aep())) {
          break label191;
        }
        if ((!adku.a(this.this$0).aeo()) || ((adku.a(this.this$0).ael()) && (adku.a(this.this$0).aeo()))) {
          adku.c(this.this$0, true);
        }
      }
      label289:
      while ((adku.b(this.this$0)) && (this.this$0.cHX == 2) && (adku.a(this.this$0) != null))
      {
        adec localadec = new adec(adku.a(this.this$0));
        adku.a(this.this$0).a(1, localadec, this.cIv);
        return;
        label191:
        if (!adku.a(this.this$0).aeo())
        {
          if (adku.a(this.this$0) == 1L)
          {
            this.this$0.iN(1L);
            adku.c(this.this$0);
          }
          for (;;)
          {
            this.this$0.cSm();
            break;
            if (adku.a(this.this$0) == 2L) {
              this.this$0.cSq();
            } else if (adku.a(this.this$0) == 2048L) {
              this.this$0.cSt();
            }
          }
          if ((adku.a(this.this$0).ael()) && (adku.a(this.this$0).aeo())) {
            adku.c(this.this$0, true);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.22
 * JD-Core Version:    0.7.0.1
 */