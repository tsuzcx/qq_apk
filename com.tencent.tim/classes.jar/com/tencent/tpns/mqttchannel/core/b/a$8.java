package com.tencent.tpns.mqttchannel.core.b;

import com.tencent.android.tpns.mqtt.IMqttActionListener;
import com.tencent.android.tpns.mqtt.IMqttToken;
import com.tencent.tpns.mqttchannel.api.MqttConnectState;

class a$8
  implements IMqttActionListener
{
  a$8(a parama) {}
  
  public void onFailure(IMqttToken paramIMqttToken, Throwable paramThrowable)
  {
    a.q(this.a);
    this.a.b(null);
    a.m(this.a);
    com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "subscribe INIT TOPIC error: ", paramThrowable);
  }
  
  public void onSuccess(IMqttToken paramIMqttToken)
  {
    com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "subscribe INIT TOPIC success");
    a.e(this.a, 0);
    a.a(this.a, MqttConnectState.SUBTOPICS);
    a.p(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.mqttchannel.core.b.a.8
 * JD-Core Version:    0.7.0.1
 */