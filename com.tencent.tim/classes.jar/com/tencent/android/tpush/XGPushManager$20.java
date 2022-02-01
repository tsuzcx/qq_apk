package com.tencent.android.tpush;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.core.net.HttpRequestCallback;

final class XGPushManager$20
  extends BroadcastReceiver
{
  XGPushManager$20(HttpRequestCallback paramHttpRequestCallback) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    TLogger.ii("XGPushManager", "action - sendFlush onReceiver");
    i.a(paramContext, this);
    CommonWorkingThread.getInstance().remove(26);
    TBaseLogger.uploadLogFile(paramContext.getApplicationContext(), this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.XGPushManager.20
 * JD-Core Version:    0.7.0.1
 */