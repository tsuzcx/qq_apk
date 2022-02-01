package com.tencent.android.tpush;

import android.content.Context;
import com.tencent.android.tpush.d.d;
import com.tencent.android.tpush.logging.TLogger;

class XGPushManager$19$1
  implements Runnable
{
  XGPushManager$19$1(XGPushManager.19 param19, Context paramContext) {}
  
  public void run()
  {
    try
    {
      d.a(this.a).d();
      return;
    }
    catch (Throwable localThrowable)
    {
      TLogger.e("XGPushManager", "unregister otherPush error " + localThrowable.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.XGPushManager.19.1
 * JD-Core Version:    0.7.0.1
 */