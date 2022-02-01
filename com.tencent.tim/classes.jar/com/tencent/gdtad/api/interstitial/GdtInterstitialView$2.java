package com.tencent.gdtad.api.interstitial;

import android.text.TextUtils;
import java.lang.ref.WeakReference;
import tho;
import tkw;

public final class GdtInterstitialView$2
  implements Runnable
{
  public GdtInterstitialView$2(String paramString, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    boolean bool;
    if (TextUtils.isEmpty(this.aJp)) {
      bool = false;
    }
    for (;;)
    {
      tkw.i("GdtInterstitialView", String.format("close %b error:%d traceId:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.val$error), this.aJp }));
      return;
      WeakReference localWeakReference = tho.a().a(this.aJp);
      if (localWeakReference != null)
      {
        if (localWeakReference.get() == null)
        {
          bool = false;
        }
        else
        {
          ((GdtInterstitialFragment)localWeakReference.get()).b(4, this.val$error, this.bBp, -2147483648, -2147483648L);
          bool = true;
        }
      }
      else {
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialView.2
 * JD-Core Version:    0.7.0.1
 */