package com.tencent.android.tpush;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.d.d;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;

final class XGPushManager$19
  extends BroadcastReceiver
{
  XGPushManager$19(XGIOperateCallback paramXGIOperateCallback) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    i.a(paramContext, this);
    if ((XGPushConfig.isUsedOtherPush(paramContext)) && (d.a(paramContext).a())) {}
    try
    {
      CommonWorkingThread.getInstance().execute(new XGPushManager.19.1(this, paramContext));
      if (this.a == null) {}
    }
    catch (Throwable localThrowable)
    {
      try
      {
        CommonWorkingThread.getInstance().execute(new XGPushManager.a(this.a, paramContext, paramIntent, 1, 1));
        XGApiConfig.clearRegistered(paramContext);
        XGPushManager.enableService(paramContext, false);
        return;
        localThrowable = localThrowable;
        TLogger.e("XGPushManager", "unregister otherPush handle callback error " + localThrowable.toString());
      }
      catch (Throwable paramIntent)
      {
        for (;;)
        {
          TLogger.e("XGPushManager", "unregister handle callback error " + paramIntent.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.XGPushManager.19
 * JD-Core Version:    0.7.0.1
 */