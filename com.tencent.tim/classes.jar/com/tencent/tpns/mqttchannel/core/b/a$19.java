package com.tencent.tpns.mqttchannel.core.b;

import com.tencent.android.tpns.mqtt.IMqttActionListener;
import com.tencent.android.tpns.mqtt.IMqttToken;

class a$19
  implements IMqttActionListener
{
  a$19(a parama, com.tencent.tpns.mqttchannel.core.common.a.a parama1, com.tencent.tpns.mqttchannel.core.common.b.a parama2) {}
  
  public void onFailure(IMqttToken paramIMqttToken, Throwable paramThrowable)
  {
    a.a(this.c, 1001, this.a);
    com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "sendPublishData -> callback onFailure:", paramThrowable);
    a.a(this.c, this.b, -8, "sendPublishData onFailure: " + paramThrowable.toString());
  }
  
  public void onSuccess(IMqttToken paramIMqttToken)
  {
    a.a(this.c, 1001, this.a);
    com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "sendPublishData success, body: " + this.a.c());
    a.a(this.c, this.b, 0, "success");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.mqttchannel.core.b.a.19
 * JD-Core Version:    0.7.0.1
 */