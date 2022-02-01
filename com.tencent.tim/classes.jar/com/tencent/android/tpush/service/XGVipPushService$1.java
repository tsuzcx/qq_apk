package com.tencent.android.tpush.service;

import android.content.Context;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;

class XGVipPushService$1
  implements Runnable
{
  XGVipPushService$1(XGVipPushService paramXGVipPushService) {}
  
  public void run()
  {
    boolean bool = false;
    if (PushPreferences.getInt(this.a.getApplicationContext(), "com.tencent.android.tpush.debug," + this.a.getApplicationContext().getPackageName(), 0) == 1) {
      bool = true;
    }
    com.tencent.android.tpush.XGPushConfig.enableDebug = true;
    TLogger.enableDebug(this.a.getApplicationContext(), bool);
    TBaseLogger.setDebugLevel(PushPreferences.getInt(this.a.getApplicationContext(), "com.tencent.android.tpush.log_level," + this.a.getApplicationContext().getPackageName(), -1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.service.XGVipPushService.1
 * JD-Core Version:    0.7.0.1
 */