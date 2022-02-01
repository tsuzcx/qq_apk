package com.tencent.gdtad.api;

import java.lang.ref.WeakReference;
import tgl;
import tkw;

class GdtAd$3
  implements Runnable
{
  GdtAd$3(GdtAd paramGdtAd, WeakReference paramWeakReference) {}
  
  public void run()
  {
    if ((this.val$weakThis == null) || (this.val$weakThis.get() == null) || (GdtAd.access$000((GdtAd)this.val$weakThis.get()) == null) || (GdtAd.access$000((GdtAd)this.val$weakThis.get()).get() == null))
    {
      tkw.e("GdtAd", "notifyImpression error");
      return;
    }
    tkw.i("GdtAd", "notifyImpression");
    ((tgl)GdtAd.access$000((GdtAd)this.val$weakThis.get()).get()).b((GdtAd)this.val$weakThis.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.GdtAd.3
 * JD-Core Version:    0.7.0.1
 */