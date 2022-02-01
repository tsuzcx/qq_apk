package com.tencent.tpns.mqttchannel.core.b;

import com.tencent.android.tpns.mqtt.IMqttActionListener;
import com.tencent.android.tpns.mqtt.IMqttToken;

class a$20
  implements IMqttActionListener
{
  a$20(a parama, com.tencent.tpns.mqttchannel.core.common.b.a parama1, com.tencent.tpns.mqttchannel.core.common.a.a parama2) {}
  
  public void onFailure(IMqttToken paramIMqttToken, Throwable paramThrowable)
  {
    com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "subscrbie -> callback onFailure:", paramThrowable);
    a.a(this.c, this.a, -9, "subscribe onFailure: " + paramThrowable.toString());
    a.a(this.c, 1002, this.b);
  }
  
  public void onSuccess(IMqttToken paramIMqttToken)
  {
    a.a(this.c, this.a, 0, "success");
    a.a(this.c, 1002, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.mqttchannel.core.b.a.20
 * JD-Core Version:    0.7.0.1
 */