package com.tencent.mobileqq.app;

import acgk;
import acgl;
import android.os.Handler;

public class HotchatSCHelper$1
  implements Runnable
{
  public HotchatSCHelper$1(acgk paramacgk, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    if (!this.this$0.bHP) {
      return;
    }
    this.this$0.a.qh();
    long l1 = System.currentTimeMillis();
    long l2 = this.val$delay - Math.abs(l1 - this.val$time);
    if (l2 < 0L) {
      l1 = 100L;
    }
    for (;;)
    {
      this.this$0.mHandler.removeMessages(0);
      this.this$0.mHandler.sendEmptyMessageDelayed(0, l1);
      return;
      l1 = l2;
      if (l2 > this.val$delay) {
        l1 = this.val$delay;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.HotchatSCHelper.1
 * JD-Core Version:    0.7.0.1
 */