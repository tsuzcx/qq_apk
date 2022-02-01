package com.tencent.gdtad.api.interstitial;

import java.lang.ref.WeakReference;
import thj;
import thj.a;
import tkw;

public class GdtArkPreDownloadTask$2
  implements Runnable
{
  public GdtArkPreDownloadTask$2(thj paramthj) {}
  
  public void run()
  {
    boolean bool;
    if ((thj.a(this.this$0) != null) && (thj.a(this.this$0).get() != null))
    {
      bool = true;
      tkw.i("GdtArkPreDownloadTask", String.format("notifySuccess listener:%b status:%d notified:%b", new Object[] { Boolean.valueOf(bool), Integer.valueOf(thj.a(this.this$0)), Boolean.valueOf(thj.b(this.this$0)) }));
      if (!thj.b(this.this$0)) {
        break label88;
      }
    }
    label88:
    do
    {
      return;
      bool = false;
      break;
      thj.a(this.this$0, true);
    } while ((thj.a(this.this$0) == null) || (thj.a(this.this$0).get() == null));
    ((thj.a)thj.a(this.this$0).get()).a(thj.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.2
 * JD-Core Version:    0.7.0.1
 */