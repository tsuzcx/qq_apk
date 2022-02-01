package com.tencent.av.utils;

import android.os.Handler;
import igd;
import jle;
import jle.a;

public class SignalStrengthReport$2
  implements Runnable
{
  public SignalStrengthReport$2(jle paramjle) {}
  
  public void run()
  {
    this.this$0.aAX = 0;
    if ((this.this$0.aAW == -1) || (jle.access$000() == 1)) {}
    try
    {
      String str = jle.a(this.this$0);
      this.this$0.aAX = jle.a.ay("http://" + str);
      if (this.this$0.aAX < 0) {
        this.this$0.aAX = 0;
      }
      igd.aJ("SignalStrengthReport", "mPingTask gatewayIP:" + str + " | avgRtt:" + this.this$0.aAX);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        igd.aJ("SignalStrengthReport", "mPingTask e:" + localException);
      }
    }
    if (this.this$0.mHandler != null) {
      this.this$0.mHandler.postDelayed(this, this.this$0.aAW);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.utils.SignalStrengthReport.2
 * JD-Core Version:    0.7.0.1
 */