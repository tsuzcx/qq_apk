package com.tencent.android.tpush;

import android.content.Context;
import android.content.Intent;
import com.tencent.android.tpush.logging.TLogger;

class XGPushBaseReceiver$1
  implements Runnable
{
  XGPushBaseReceiver$1(XGPushBaseReceiver paramXGPushBaseReceiver, Context paramContext, Intent paramIntent) {}
  
  public void run()
  {
    try
    {
      XGPushBaseReceiver.a(this.c, this.a, this.b);
      return;
    }
    catch (Throwable localThrowable)
    {
      TLogger.w("XGPushBaseReceiver", "feedbackHandler error", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.XGPushBaseReceiver.1
 * JD-Core Version:    0.7.0.1
 */