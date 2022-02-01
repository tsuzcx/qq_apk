package com.tencent.tpns.mqttchannel.core.b;

import java.util.Map;

class a$16
  implements Runnable
{
  a$16(a parama, com.tencent.tpns.mqttchannel.core.common.a.a parama1, com.tencent.tpns.mqttchannel.core.common.b.a parama2, String paramString) {}
  
  public void run()
  {
    a.o(this.d).remove(Long.valueOf(this.a.a()));
    this.a.d();
    if (this.a.e() <= 1)
    {
      com.tencent.tpns.mqttchannel.core.common.c.a.b("IMqttServiceImpl", "sendRealRequest timeout and retry, request:" + this.a);
      a.a(this.d, this.a, this.b, this.c);
      return;
    }
    if (this.a.b)
    {
      a.a(this.d, this.b, -2, "Waiting for server response timeout!");
      return;
    }
    a.a(this.d, this.b, -702, "sendRequest timeout!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.mqttchannel.core.b.a.16
 * JD-Core Version:    0.7.0.1
 */