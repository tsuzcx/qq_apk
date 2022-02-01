package com.tencent.mobileqq.ar.view;

import android.widget.LinearLayout;

class ScanEntryProviderContainerView$7
  implements Runnable
{
  ScanEntryProviderContainerView$7(ScanEntryProviderContainerView paramScanEntryProviderContainerView, boolean paramBoolean) {}
  
  public void run()
  {
    LinearLayout localLinearLayout;
    if (this.this$0.iq != null)
    {
      localLinearLayout = this.this$0.iq;
      if (!this.val$enable) {
        break label33;
      }
    }
    label33:
    for (int i = 0;; i = 8)
    {
      localLinearLayout.setVisibility(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ScanEntryProviderContainerView.7
 * JD-Core Version:    0.7.0.1
 */