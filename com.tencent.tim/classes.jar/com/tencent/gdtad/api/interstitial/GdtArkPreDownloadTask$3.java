package com.tencent.gdtad.api.interstitial;

import java.lang.ref.WeakReference;
import thj;
import thj.a;
import tkw;

public class GdtArkPreDownloadTask$3
  implements Runnable
{
  public GdtArkPreDownloadTask$3(thj paramthj, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    boolean bool;
    if ((thj.a(this.this$0) != null) && (thj.a(this.this$0).get() != null))
    {
      bool = true;
      tkw.i("GdtArkPreDownloadTask", String.format("notifyFailed listener:%b status:%d notified:%b error:%d arkError:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(thj.a(this.this$0)), Boolean.valueOf(thj.b(this.this$0)), Integer.valueOf(this.val$error), Integer.valueOf(this.bBp) }));
      if (!thj.b(this.this$0)) {
        break label108;
      }
    }
    label108:
    do
    {
      return;
      bool = false;
      break;
      thj.a(this.this$0, true);
    } while ((thj.a(this.this$0) == null) || (thj.a(this.this$0).get() == null));
    ((thj.a)thj.a(this.this$0).get()).a(thj.a(this.this$0), this.val$error, this.bBp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.3
 * JD-Core Version:    0.7.0.1
 */