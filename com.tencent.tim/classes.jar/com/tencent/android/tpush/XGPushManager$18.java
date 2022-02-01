package com.tencent.android.tpush;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;

final class XGPushManager$18
  extends BroadcastReceiver
{
  XGPushManager$18(XGIOperateCallback paramXGIOperateCallback) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    TLogger.ii("XGPushManager", "Register call back to " + paramContext.getPackageName());
    try
    {
      CommonWorkingThread.getInstance().execute(new XGPushManager.a(this.a, paramContext, paramIntent, 1, 0));
      i.a(paramContext, this);
      return;
    }
    catch (Throwable paramIntent)
    {
      for (;;)
      {
        TLogger.e("XGPushManager", "register handle callback error " + paramIntent.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.XGPushManager.18
 * JD-Core Version:    0.7.0.1
 */