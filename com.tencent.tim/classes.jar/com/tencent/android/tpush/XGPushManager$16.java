package com.tencent.android.tpush;

import android.content.Context;
import com.tencent.android.tpush.logging.TLogger;

final class XGPushManager$16
  implements Runnable
{
  XGPushManager$16(long paramLong1, Context paramContext, String paramString1, int paramInt, String paramString2, long paramLong2, String paramString3, String paramString4, String paramString5, String paramString6) {}
  
  public void run()
  {
    try
    {
      XGPushManager.16.1 local1 = new XGPushManager.16.1(this);
      TLogger.d("XGPushManager", "registerRunnable4NewDevice, delayMillis:" + this.a + ",registerRunnable4NewDevice:" + XGPushManager.a());
      XGPushManager.c(this.b, this.c, this.d, this.e, local1, this.f, this.g, this.h, this.i, this.j);
      return;
    }
    catch (Throwable localThrowable)
    {
      TLogger.e("XGPushManager", "doDumpRegister4NewDevice run error", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.XGPushManager.16
 * JD-Core Version:    0.7.0.1
 */