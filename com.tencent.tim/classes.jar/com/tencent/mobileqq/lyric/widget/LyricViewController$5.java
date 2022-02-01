package com.tencent.mobileqq.lyric.widget;

import aiwn;
import aixd;
import android.os.SystemClock;
import android.util.Log;

public class LyricViewController$5
  implements Runnable
{
  public LyricViewController$5(aixd paramaixd, int paramInt) {}
  
  public void run()
  {
    if (this.this$0.a != null) {
      this.this$0.a.dvg();
    }
    if ((this.this$0.b == null) || (this.this$0.b.isEmpty()))
    {
      Log.w("ModuleController", "seek before set lyric");
      return;
    }
    this.this$0.abR = (SystemClock.elapsedRealtime() - this.val$position);
    if ((this.this$0.cmo) && (this.this$0.dfN > 0))
    {
      aixd localaixd = this.this$0;
      localaixd.abR -= this.this$0.dfN;
    }
    aixd.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.lyric.widget.LyricViewController.5
 * JD-Core Version:    0.7.0.1
 */