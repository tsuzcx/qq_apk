package com.tencent.mobileqq.ar.view;

import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo.a;

class ScanEntryProviderContainerView$4
  implements Runnable
{
  ScanEntryProviderContainerView$4(ScanEntryProviderContainerView paramScanEntryProviderContainerView, PromotionConfigInfo.a parama) {}
  
  public void run()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (ScanEntryProviderContainerView.a(this.this$0) != null)
    {
      localObject1 = localObject2;
      if ((ScanEntryProviderContainerView.a(this.this$0) instanceof ARScanEntryView))
      {
        localObject1 = (ARScanEntryView)ScanEntryProviderContainerView.a(this.this$0);
        ((ARScanEntryView)localObject1).Gw(true);
      }
    }
    if (localObject1 != null) {
      ((ARScanEntryView)localObject1).a(this.b);
    }
    if (this.this$0.afk())
    {
      this.this$0.b("onTransferDoorAllReady", this.b, true);
      if (localObject1 != null) {
        ((ARScanEntryView)localObject1).a("onTransferDoorAllReady", this.b, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ScanEntryProviderContainerView.4
 * JD-Core Version:    0.7.0.1
 */