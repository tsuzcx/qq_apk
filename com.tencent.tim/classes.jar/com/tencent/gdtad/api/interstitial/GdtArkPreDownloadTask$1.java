package com.tencent.gdtad.api.interstitial;

import android.text.TextUtils;
import thj;
import thl;
import tkw;

public class GdtArkPreDownloadTask$1
  implements Runnable
{
  public GdtArkPreDownloadTask$1(thj paramthj) {}
  
  public void run()
  {
    tkw.i("GdtArkPreDownloadTask", String.format("run status:%d", new Object[] { Integer.valueOf(thj.a(this.this$0)) }));
    if (!thj.a(this.this$0))
    {
      thj.a(this.this$0, 1);
      thj.a(this.this$0, 4, -2147483648, 0L);
    }
    for (;;)
    {
      return;
      thj.a(this.this$0, 1);
      thl.init();
      if (TextUtils.isEmpty(thj.a(this.this$0)))
      {
        thj.a(this.this$0, 2);
        thj.a(this.this$0);
      }
      while (thj.a(this.this$0) >= 0L)
      {
        thj.a(this.this$0, 13, -2147483648, thj.a(this.this$0));
        return;
        thj.a(this.this$0, 3);
        thj.b(this.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.1
 * JD-Core Version:    0.7.0.1
 */