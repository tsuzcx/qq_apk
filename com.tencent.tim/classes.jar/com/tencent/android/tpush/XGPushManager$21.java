package com.tencent.android.tpush;

import android.content.BroadcastReceiver;
import android.content.Context;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import com.tencent.tpns.baseapi.core.net.HttpRequestCallback;

final class XGPushManager$21
  implements Runnable
{
  XGPushManager$21(Context paramContext, HttpRequestCallback paramHttpRequestCallback, BroadcastReceiver paramBroadcastReceiver) {}
  
  public void run()
  {
    TLogger.ii("XGPushManager", "action - executeAtTime");
    TBaseLogger.uploadLogFile(this.a.getApplicationContext(), this.b);
    i.a(this.a, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.XGPushManager.21
 * JD-Core Version:    0.7.0.1
 */