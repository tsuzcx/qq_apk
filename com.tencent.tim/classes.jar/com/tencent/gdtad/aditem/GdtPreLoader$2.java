package com.tencent.gdtad.aditem;

import com.tencent.ad.tangram.offline.AdOffline;
import tgh;
import tkw;

public class GdtPreLoader$2
  implements Runnable
{
  public GdtPreLoader$2(tgh paramtgh, GdtAd paramGdtAd) {}
  
  public void run()
  {
    String str = this.b.getBusinessIdForXiJingOffline();
    tkw.i("GdtPreLoader", String.format("preLoadXiJingOfflineJsonAfterAdLoaded businessId:%s version:%s", new Object[] { str, AdOffline.INSTANCE.getVersionIfExists(str) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtPreLoader.2
 * JD-Core Version:    0.7.0.1
 */