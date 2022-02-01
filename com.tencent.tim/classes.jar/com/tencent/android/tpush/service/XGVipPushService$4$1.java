package com.tencent.android.tpush.service;

import android.os.Handler;
import com.tencent.android.tpush.a;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.dataacquisition.DeviceInfos;
import com.tencent.tpns.mqttchannel.core.common.config.MqttConfigImpl;

class XGVipPushService$4$1
  implements Runnable
{
  XGVipPushService$4$1(XGVipPushService.4 param4) {}
  
  public void run()
  {
    TLogger.d("XGVipPushService", "--CheckMessage--interval time:" + XGVipPushService.b());
    a.b(this.a.a);
    if (MqttConfigImpl.getKeepAliveInterval(this.a.a.getApplicationContext()) >= 285)
    {
      if (!DeviceInfos.isScreenOn(this.a.a.getApplicationContext())) {
        break label132;
      }
      XGVipPushService.a(120000L);
    }
    for (;;)
    {
      if ((XGVipPushService.a(this.a.a) != null) && (this.a.a.a != null)) {
        XGVipPushService.a(this.a.a).postDelayed(this.a.a.a, XGVipPushService.b());
      }
      return;
      label132:
      XGVipPushService.a(270000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.service.XGVipPushService.4.1
 * JD-Core Version:    0.7.0.1
 */