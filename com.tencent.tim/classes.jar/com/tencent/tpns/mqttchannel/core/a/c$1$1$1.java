package com.tencent.tpns.mqttchannel.core.a;

import com.tencent.tpns.mqttchannel.core.common.c.a;

class c$1$1$1
  implements Runnable
{
  c$1$1$1(c.1.1 param1) {}
  
  public void run()
  {
    try
    {
      this.a.a.b.a(this.a.a.a);
      return;
    }
    catch (Throwable localThrowable)
    {
      a.a("MqttChannelImpl", this.a.a.c + "connectAction.action error:", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.mqttchannel.core.a.c.1.1.1
 * JD-Core Version:    0.7.0.1
 */