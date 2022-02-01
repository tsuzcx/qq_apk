package com.tencent.tpns.mqttchannel.core.b;

import com.tencent.android.tpns.mqtt.IMqttActionListener;
import com.tencent.android.tpns.mqtt.IMqttToken;
import com.tencent.tpns.baseapi.base.util.Util;

class a$1
  implements IMqttActionListener
{
  a$1(a parama) {}
  
  public void onFailure(IMqttToken paramIMqttToken, Throwable paramThrowable)
  {
    com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "Ping onFailure", paramThrowable);
    a.a(this.a);
    a.b(this.a);
  }
  
  public void onSuccess(IMqttToken paramIMqttToken)
  {
    a.a(this.a);
    com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "Ping succeed");
    a.a(this.a, System.currentTimeMillis());
    Util.stopWakeCpu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.mqttchannel.core.b.a.1
 * JD-Core Version:    0.7.0.1
 */