package com.tencent.gdtad.api.interstitial;

import java.lang.ref.WeakReference;
import thj;
import thj.a;
import tkw;

public class GdtArkPreDownloadTask$4
  implements Runnable
{
  public GdtArkPreDownloadTask$4(thj paramthj, int paramInt) {}
  
  public void run()
  {
    if ((thj.a(this.this$0) != null) && (thj.a(this.this$0).get() != null)) {}
    for (boolean bool = true;; bool = false)
    {
      tkw.i("GdtArkPreDownloadTask", String.format("notifyStatusChanged listener:%b status:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.Is) }));
      if ((thj.a(this.this$0) != null) && (thj.a(this.this$0).get() != null)) {
        ((thj.a)thj.a(this.this$0).get()).a(thj.a(this.this$0), this.Is);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.4
 * JD-Core Version:    0.7.0.1
 */