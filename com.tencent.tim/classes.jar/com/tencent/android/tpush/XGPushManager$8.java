package com.tencent.android.tpush;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;

final class XGPushManager$8
  extends BroadcastReceiver
{
  XGPushManager$8(XGIOperateCallback paramXGIOperateCallback) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    TLogger.ii("XGPushManager", "Tag call back to " + paramContext.getPackageName());
    try
    {
      CommonWorkingThread.getInstance().execute(new XGPushManager.8.1(this, paramIntent));
      i.a(paramContext, this);
      return;
    }
    catch (Throwable paramIntent)
    {
      for (;;)
      {
        TLogger.e("XGPushManager", "tagManager handle callback error " + paramIntent.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.XGPushManager.8
 * JD-Core Version:    0.7.0.1
 */