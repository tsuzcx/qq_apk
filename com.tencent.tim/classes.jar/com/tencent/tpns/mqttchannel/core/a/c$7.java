package com.tencent.tpns.mqttchannel.core.a;

import com.tencent.tpns.baseapi.base.util.Util;
import com.tencent.tpns.mqttchannel.api.OnMqttCallback;
import com.tencent.tpns.mqttchannel.core.common.c.a;

class c$7
  implements c.a
{
  c$7(c paramc, OnMqttCallback paramOnMqttCallback) {}
  
  public void a(com.tencent.tpns.mqttchannel.core.common.b.c paramc)
  {
    a.a("MqttChannelImpl", "ping doConnect action");
    if (paramc != null)
    {
      paramc.d(this.a);
      return;
    }
    Util.stopWakeCpu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.mqttchannel.core.a.c.7
 * JD-Core Version:    0.7.0.1
 */