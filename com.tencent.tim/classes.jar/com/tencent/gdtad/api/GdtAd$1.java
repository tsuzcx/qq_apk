package com.tencent.gdtad.api;

import java.lang.ref.WeakReference;
import tgk;
import tgl;
import tkw;

class GdtAd$1
  implements Runnable
{
  GdtAd$1(GdtAd paramGdtAd, WeakReference paramWeakReference, tgk paramtgk) {}
  
  public void run()
  {
    if ((this.val$weakThis == null) || (this.val$weakThis.get() == null) || (GdtAd.access$000((GdtAd)this.val$weakThis.get()) == null) || (GdtAd.access$000((GdtAd)this.val$weakThis.get()).get() == null))
    {
      tkw.e("GdtAd", "notifyFailedToLoad error");
      return;
    }
    ((tgl)GdtAd.access$000((GdtAd)this.val$weakThis.get()).get()).a((GdtAd)this.val$weakThis.get(), this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.GdtAd.1
 * JD-Core Version:    0.7.0.1
 */