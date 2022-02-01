package com.tencent.gdtad.api.interstitial;

import java.lang.ref.WeakReference;
import thm.a;
import tho;
import tkw;

public class GdtInterstitialAd$IPCHandlerForClose$1
  implements Runnable
{
  public GdtInterstitialAd$IPCHandlerForClose$1(thm.a parama, String paramString) {}
  
  public void run()
  {
    WeakReference localWeakReference = tho.a().a(this.aJp);
    if ((localWeakReference == null) || (localWeakReference.get() == null)) {
      return;
    }
    tkw.e("GdtInterstitialAd", "IPCHandlerForClose.handle timeout");
    ((GdtInterstitialFragment)localWeakReference.get()).b(4, 13, -2147483648, -2147483648, -2147483648L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialAd.IPCHandlerForClose.1
 * JD-Core Version:    0.7.0.1
 */