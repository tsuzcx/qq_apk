package com.tencent.gdtad.api.interstitial;

import java.lang.ref.WeakReference;
import thp;

public class GdtInterstitialNotifyReg$4
  implements Runnable
{
  public GdtInterstitialNotifyReg$4(thp paramthp, WeakReference paramWeakReference, int paramInt, long paramLong) {}
  
  public void run()
  {
    if ((this.dw != null) && (this.dw.get() != null)) {
      ((GdtInterstitialFragment)this.dw.get()).b(this.val$reason, 0, -2147483648, -2147483648, this.El);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialNotifyReg.4
 * JD-Core Version:    0.7.0.1
 */