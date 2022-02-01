package com.tencent.mobileqq.intervideo.huayang;

import acfp;
import aido;
import android.os.Handler;
import android.os.Message;

public class HuayangPluginLauncher$2
  implements Runnable
{
  public HuayangPluginLauncher$2(aido paramaido, boolean paramBoolean) {}
  
  public void run()
  {
    long l;
    if (aido.a(this.this$0) == null)
    {
      aido.a(this.this$0, aido.b(this.this$0));
      if (this.cjX)
      {
        l = 1000L - (System.currentTimeMillis() - aido.a(this.this$0));
        if (l > 0L) {
          aido.a(this.this$0, "HuayangPluginLauncher", acfp.m(2131707308) + l);
        }
      }
    }
    try
    {
      Thread.sleep(l);
      if ((aido.a(this.this$0) != null) && (aido.a(this.this$0)))
      {
        if (this.cjX)
        {
          Message localMessage = Message.obtain(aido.a(this.this$0), 2);
          aido.a(this.this$0).sendMessage(localMessage);
          aido.a(this.this$0, aido.a(this.this$0));
          this.this$0.cjY = true;
        }
      }
      else
      {
        aido.a(this.this$0, false);
        return;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
        continue;
        aido.b(this.this$0, aido.a(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.HuayangPluginLauncher.2
 * JD-Core Version:    0.7.0.1
 */