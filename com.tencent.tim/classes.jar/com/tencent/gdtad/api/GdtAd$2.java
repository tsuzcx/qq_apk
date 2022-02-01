package com.tencent.gdtad.api;

import java.lang.ref.WeakReference;
import tgl;
import tkw;

class GdtAd$2
  implements Runnable
{
  GdtAd$2(GdtAd paramGdtAd, WeakReference paramWeakReference) {}
  
  public void run()
  {
    if ((this.val$weakThis == null) || (this.val$weakThis.get() == null) || (GdtAd.access$000((GdtAd)this.val$weakThis.get()) == null) || (GdtAd.access$000((GdtAd)this.val$weakThis.get()).get() == null))
    {
      tkw.e("GdtAd", "notifyLoaded error");
      return;
    }
    tkw.i("GdtAd", "notifyLoaded");
    ((tgl)GdtAd.access$000((GdtAd)this.val$weakThis.get()).get()).a((GdtAd)this.val$weakThis.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.GdtAd.2
 * JD-Core Version:    0.7.0.1
 */