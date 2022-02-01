package com.tencent.tpns.mqttchannel.core.b;

import com.tencent.android.tpns.mqtt.IMqttActionListener;
import com.tencent.android.tpns.mqtt.IMqttToken;
import com.tencent.tpns.mqttchannel.api.MqttConnectState;

class a$14
  implements IMqttActionListener
{
  a$14(a parama, com.tencent.tpns.mqttchannel.core.common.b.a parama1) {}
  
  public void onFailure(IMqttToken paramIMqttToken, Throwable paramThrowable)
  {
    com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "stopConnect -> callback onFailure:", paramThrowable);
    a.a(this.b, MqttConnectState.DISCONNECTED);
    a.n(this.b);
    a.a(this.b, this.a, -6, "stopConnect onFailure: " + paramThrowable.toString());
  }
  
  public void onSuccess(IMqttToken paramIMqttToken)
  {
    a.a(this.b, MqttConnectState.DISCONNECTED);
    com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "disconnect success");
    a.n(this.b);
    a.a(this.b, this.a, 0, "success");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.mqttchannel.core.b.a.14
 * JD-Core Version:    0.7.0.1
 */