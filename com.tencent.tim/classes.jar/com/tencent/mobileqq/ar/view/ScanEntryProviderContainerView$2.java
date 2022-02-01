package com.tencent.mobileqq.ar.view;

import acfp;
import android.app.Activity;
import com.tencent.mobileqq.widget.QQToast;

class ScanEntryProviderContainerView$2
  implements Runnable
{
  ScanEntryProviderContainerView$2(ScanEntryProviderContainerView paramScanEntryProviderContainerView) {}
  
  public void run()
  {
    QQToast localQQToast = QQToast.a(this.this$0.mContext, acfp.m(2131713998), 1);
    localQQToast.setAutoTextSize();
    localQQToast.show();
    ((Activity)this.this$0.mContext).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ScanEntryProviderContainerView.2
 * JD-Core Version:    0.7.0.1
 */