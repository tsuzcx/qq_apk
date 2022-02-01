package com.tencent.tpns.mqttchannel.core.b;

import com.tencent.android.tpns.mqtt.IMqttActionListener;
import com.tencent.android.tpns.mqtt.IMqttToken;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import com.tencent.tpns.mqttchannel.api.MqttConnectState;

class a$c$1
  implements IMqttActionListener
{
  a$c$1(a.c paramc) {}
  
  public void onFailure(IMqttToken paramIMqttToken, Throwable paramThrowable)
  {
    a.a(this.a.b, false);
    this.a.b.b(null);
    a.a(this.a.b, MqttConnectState.CONNECTFAIL);
    com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "doMqttConnect -> callback onFailure:", paramThrowable);
    GuidInfoManager.forceExpired(a.g(this.a.b));
    com.tencent.tpns.mqttchannel.core.common.c.a.d("IMqttServiceImpl", "Set guid to expired");
    a.a(this.a.b, this.a.a, -11, "connect onFailure: " + paramThrowable.toString());
    a.m(this.a.b);
    a.c(this.a.b, this.a.a);
  }
  
  public void onSuccess(IMqttToken paramIMqttToken)
  {
    com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "doMqttConnect -> callback onSuccess");
    a.a(this.a.b, MqttConnectState.CONNECTED);
    a.a(this.a.b, false);
    a.l(this.a.b);
    a.c(this.a.b, 0);
    a.a(this.a.b, this.a.a, 0, "success");
    a.c(this.a.b, this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.mqttchannel.core.b.a.c.1
 * JD-Core Version:    0.7.0.1
 */