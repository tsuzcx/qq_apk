package com.tencent.mobileqq.ar.view;

import acfp;
import adkw;
import admh;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class ARScanEntryView$37
  implements Runnable
{
  ARScanEntryView$37(ARScanEntryView paramARScanEntryView) {}
  
  public void run()
  {
    adkw localadkw = this.this$0.a.a();
    boolean bool1 = localadkw.afa();
    boolean bool2 = localadkw.afb();
    QLog.d("AREngine_ARScanEntryView", 1, "startDownloadTimeoutCheck, AR组件加载超, mIsDownloadTimeout[" + ARScanEntryView.e(this.this$0) + "],isBaseSoReady:=" + bool1 + ",isFaceSoReady:=" + bool2);
    ARScanEntryView.c(this.this$0, true);
    if (!bool1) {
      this.this$0.showErrorTips(acfp.m(2131702880));
    }
    do
    {
      return;
      this.this$0.hideTips();
    } while (ARScanEntryView.c(this.this$0));
    QQToast.a(BaseApplicationImpl.getContext(), 2131690450, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ARScanEntryView.37
 * JD-Core Version:    0.7.0.1
 */