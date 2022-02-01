package com.tencent.mobileqq.ar.view;

import acfp;
import adaq;
import adkw;
import admh;
import akqx;
import anot;
import com.tencent.qphone.base.util.QLog;

class ARScanEntryView$38
  implements Runnable
{
  ARScanEntryView$38(ARScanEntryView paramARScanEntryView) {}
  
  public void run()
  {
    boolean bool2 = adaq.a().adl();
    boolean bool3 = adaq.a().adm();
    boolean bool4 = this.this$0.a.a().aeY();
    akqx localakqx = this.this$0.a.a();
    if ((ARScanEntryView.c(this.this$0)) && (localakqx != null)) {}
    for (boolean bool1 = localakqx.l(this.this$0.mAppInterface);; bool1 = true)
    {
      QLog.d("AREngine_ARScanEntryView", 1, "excute mTimeoutChecker runnable isAREnable:=" + bool2 + ",isSupportAr:=" + bool3 + ",isBaseSoReady:=" + bool4 + ",isPromotionResReady:=" + bool1);
      if ((bool2) && (bool3))
      {
        if ((!bool4) || (!bool1)) {
          break label274;
        }
        if (!ARScanEntryView.f(this.this$0)) {
          break label225;
        }
        QLog.d("AREngine_ARScanEntryView", 1, "ARLoadFailed. mIsArSoReady = " + bool4 + "mARStartFail = " + ARScanEntryView.f(this.this$0) + ",isPromotionResReady =" + bool1);
        this.this$0.showErrorTips(acfp.m(2131702879));
      }
      label274:
      for (;;)
      {
        ARScanEntryView.a(this.this$0, null);
        return;
        label225:
        if (!ARScanEntryView.c(this.this$0))
        {
          this.this$0.showErrorTips(acfp.m(2131702874));
          anot.a(null, "dc00898", "", "", "0X80085B3", "0X80085B3", 0, 0, "", "", "", "");
          continue;
          ARScanEntryView.d(this.this$0, true);
          this.this$0.cSI();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ARScanEntryView.38
 * JD-Core Version:    0.7.0.1
 */