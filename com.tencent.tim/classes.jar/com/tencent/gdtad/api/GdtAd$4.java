package com.tencent.gdtad.api;

import java.lang.ref.WeakReference;
import tgl;
import tkw;

class GdtAd$4
  implements Runnable
{
  GdtAd$4(GdtAd paramGdtAd, WeakReference paramWeakReference) {}
  
  public void run()
  {
    if ((this.val$weakThis == null) || (this.val$weakThis.get() == null) || (GdtAd.access$000((GdtAd)this.val$weakThis.get()) == null) || (GdtAd.access$000((GdtAd)this.val$weakThis.get()).get() == null))
    {
      tkw.e("GdtAd", "notifyClicked error");
      return;
    }
    tkw.i("GdtAd", "notifyClicked");
    ((tgl)GdtAd.access$000((GdtAd)this.val$weakThis.get()).get()).c((GdtAd)this.val$weakThis.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.GdtAd.4
 * JD-Core Version:    0.7.0.1
 */