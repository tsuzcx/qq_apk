package com.tencent.android.tpush;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;

final class XGPushManager$3
  extends BroadcastReceiver
{
  XGPushManager$3(XGIOperateCallback paramXGIOperateCallback) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    TLogger.ii("XGPushManager", "attributes call back to " + paramContext.getPackageName());
    try
    {
      CommonWorkingThread.getInstance().execute(new XGPushManager.3.1(this, paramIntent));
      label43:
      i.a(paramContext, this);
      return;
    }
    catch (Throwable paramIntent)
    {
      break label43;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.XGPushManager.3
 * JD-Core Version:    0.7.0.1
 */