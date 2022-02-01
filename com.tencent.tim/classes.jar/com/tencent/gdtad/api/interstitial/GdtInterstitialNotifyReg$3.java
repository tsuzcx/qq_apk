package com.tencent.gdtad.api.interstitial;

import java.lang.ref.WeakReference;
import thp;

public class GdtInterstitialNotifyReg$3
  implements Runnable
{
  public GdtInterstitialNotifyReg$3(thp paramthp, WeakReference paramWeakReference) {}
  
  public void run()
  {
    if ((this.dw != null) && (this.dw.get() != null)) {
      ((GdtInterstitialFragment)this.dw.get()).onClick();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialNotifyReg.3
 * JD-Core Version:    0.7.0.1
 */